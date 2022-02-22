package com.example.gamesapp.ui.catalog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gamesapp.R
import com.example.gamesapp.databinding.CatalogFragmentBinding
import com.example.gamesapp.ui.catalog.game.GAME_ID_KEY
import com.example.gamesapp.ui.catalog.game.GameFragment
import com.example.gamesapp.ui.getMainNavController
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatalogFragment : Fragment(), CatalogNavigator {
    private val viewModel: CatalogViewModel by viewModel()
    private var _binding: CatalogFragmentBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initialize(this)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(_binding != null)
            return _binding!!.root
        
        _binding = CatalogFragmentBinding.inflate(inflater, container, false)
        _binding!!.viewModel = viewModel
        _binding!!.lifecycleOwner = this

        val catalogAdapter = CatalogGamesAdapter { viewModel.gameClick(it) }
        _binding!!.gamesRecyclerView.adapter = catalogAdapter

        viewModel.games.observe(viewLifecycleOwner) {
            catalogAdapter.updateItems(it)
        }

        return _binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun navigateToGameDetails(gameId: Int) {
        val bundle = Bundle()
        bundle.putInt(GAME_ID_KEY, gameId)

        getMainNavController().navigate(R.id.action_navigation_catalog_to_gameFragment, bundle)
    }
}