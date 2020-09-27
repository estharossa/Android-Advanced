package com.example.mvvmapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmapplication.data.model.Article
import com.example.mvvmapplication.databinding.FragmentArticleDetailsBinding
import com.example.mvvmapplication.databinding.FragmentRepoListBinding
import com.example.mvvmapplication.ui.adapter.RepoListAdapter
import com.example.mvvmapplication.viewmodel.RepoListViewModel
import kotlinx.android.synthetic.main.fragment_repo_list.*

class ArticleDetailsFragment : Fragment() {

    companion object{
        private const val ARG_ARTICLE = "article"

        fun newInstance(article: Article) = ArticleDetailsFragment().apply {
            arguments = bundleOf(ARG_ARTICLE to article)
        }
    }

    private lateinit var viewDataBinding: FragmentArticleDetailsBinding

    private var article: Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        article = arguments?.getParcelable(ARG_ARTICLE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDataBinding = FragmentArticleDetailsBinding.inflate(inflater)
        return viewDataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Article", article.toString())
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.article = article!!
    }
}