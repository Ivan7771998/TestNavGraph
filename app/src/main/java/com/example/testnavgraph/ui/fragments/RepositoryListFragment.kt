package com.example.testnavgraph.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.testnavgraph.data.RepositoryModel
import com.example.testnavgraph.ui.adapters.RepoListAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testnavgraph.api.GithubService
import com.example.testnavgraph.ui.vm.MainViewModel
import com.example.testnavgraph.databinding.FragmentRepositoryListBinding
import com.example.testnavgraph.repository.MainRepository

private const val ARG_PARAM1 = "Username"

class RepositoryListFragment : Fragment() {
    private var userName: String? = null

    lateinit var binding: FragmentRepositoryListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepositoryListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repoList: List<RepositoryModel>
        val adapter: RepoListAdapter

        binding.repositoryList.layoutManager = LinearLayoutManager(requireContext())

        val reposViewModel = ViewModelProvider(this)[MainViewModel()::class.java]
        userName?.let {
            reposViewModel.getUserRepos(it)
        }
        reposViewModel.repoList.observe(viewLifecycleOwner, Observer { repoList ->
            repoList?.let {
                binding.repositoryList.adapter = RepoListAdapter(it)
            }

        })

    }
}