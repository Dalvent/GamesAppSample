package com.example.gamesapp.ui.catalog.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gamesapp.databinding.GameFragmentBinding
import com.example.gamesapp.ui.catalog.TagsAdapter
import com.google.android.flexbox.FlexDirection.ROW
import com.google.android.flexbox.FlexboxLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel

const val GAME_ID_KEY = "GAME_ID_KEY"

class GameFragment : Fragment() {
    private val viewModel: GameViewModel by viewModel()
    private var _binding: GameFragmentBinding? = null

    private val binding get() = _binding!!
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initialize(requireArguments().getInt(GAME_ID_KEY))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GameFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        //requireActivity().actionBar!!.title = viewModel.model.value!!.name

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

