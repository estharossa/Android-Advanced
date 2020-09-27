package com.example.mvvmapplication.data.repository

import com.example.mvvmapplication.data.api.ApiClient
import com.example.mvvmapplication.data.model.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoListRepository {

    // GET repo list
    fun getRepoList(onResult: (isSuccess: Boolean, response: Data?) -> Unit) {

        ApiClient.instance.getRepo().enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>?, response: Response<Data>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<Data>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

    companion object {
        private var INSTANCE: RepoListRepository? = null
        fun getInstance() = INSTANCE
            ?: RepoListRepository().also {
                INSTANCE = it
            }
    }
}