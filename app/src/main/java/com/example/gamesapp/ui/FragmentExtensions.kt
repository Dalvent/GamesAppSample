package com.example.gamesapp.ui

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.example.gamesapp.MainActivity

fun Fragment.getMainNavController(): NavController {
    return (this.activity as MainActivity).navController!!
}