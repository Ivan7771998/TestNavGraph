package com.example.testnavgraph.ui.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testnavgraph.api.GithubService
import com.example.testnavgraph.data.RepositoryModel
import com.example.testnavgraph.repository.MainRepository
import com.example.testnavgraph.repository.NetworkState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val repoList = MutableLiveData<List<RepositoryModel>?>()
    val repositoryMain = MainRepository(GithubService.getInstance())

    fun getUserRepos(userName: String) {
        Log.d("Thread Outside", Thread.currentThread().name)

        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Thread Inside", Thread.currentThread().name)

            when (val response = repositoryMain.getUserRepos(userName)) {
                is NetworkState.Success -> {
                    repoList.postValue(response.data)
                }
                is NetworkState.Error -> {
                    //movieList.postValue(NetworkState.Error())
                }
            }
        }
    }
}