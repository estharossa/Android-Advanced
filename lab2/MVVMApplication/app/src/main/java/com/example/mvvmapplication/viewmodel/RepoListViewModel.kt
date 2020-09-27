package com.example.mvvmapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.mvvmapplication.data.model.Article
import com.example.mvvmapplication.data.repository.RepoListRepository

class RepoListViewModel : BaseViewModel() {
    val repoListLive = MutableLiveData<List<Article>>()

    fun fetchRepoList() {
        dataLoading.value = true
        RepoListRepository.getInstance().getRepoList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                repoListLive.value = response?.articles
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}