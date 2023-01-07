package com.example.testnavgraph.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testnavgraph.databinding.FragmentSearchUserBinding
import com.example.testnavgraph.ui.Navigation

class SearchUserFragment : Fragment() {
    lateinit var binding: FragmentSearchUserBinding
    lateinit var navigation: Navigation

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Navigation) {
            navigation = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchUserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        buttonSearch.setOnClickListener {
            if (userEditText.text.isNotEmpty()) {

                val bundle = Bundle()
                bundle.putString("Username", userEditText.text.toString())

                navigation.openListRepo(bundle)
                // FIXME fragment can't launch
            }
        }
    }
}