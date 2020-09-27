package com.example.mvvmapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmapplication.R
import com.example.mvvmapplication.data.model.Article
import com.example.mvvmapplication.databinding.FragmentRepoListBinding
import com.example.mvvmapplication.ui.adapter.RepoListAdapter
import com.example.mvvmapplication.viewmodel.RepoListViewModel
import kotlinx.android.synthetic.main.fragment_repo_list.*

class RepoListFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentRepoListBinding
    private lateinit var adapter: RepoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDataBinding = FragmentRepoListBinding.inflate(inflater, container, false).apply {
            viewmodel =
                ViewModelProviders.of(this@RepoListFragment).get(RepoListViewModel::class.java)
            lifecycleOwner = viewLifecycleOwner
        }
        return viewDataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchRepoList()

        setupAdapter()
        setObservers()
    }


    private fun setObservers() {
        viewDataBinding.viewmodel?.repoListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateRepoList(it)
        })
    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = RepoListAdapter(
                articleClickListener = {
                    Log.d("ArticleFromFragment", it.toString())
                    showArticleDetails(it)
                }
            )
            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager
            repo_list_rv.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            repo_list_rv.adapter = adapter
        }
    }

    private fun showArticleDetails(article: Article){
        val fragment = ArticleDetailsFragment.newInstance(article)
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.main_nav_fragment, fragment)
            ?.commitAllowingStateLoss()

    }
}