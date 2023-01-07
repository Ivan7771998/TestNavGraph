package com.example.testnavgraph.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.testnavgraph.R
import com.example.testnavgraph.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Navigation {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun openListRepo(bundle: Bundle) {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.action_searchUserFragment_to_repositoryListFragment, bundle)
    }
}

interface Navigation {
    fun openListRepo(bundle: Bundle)
}