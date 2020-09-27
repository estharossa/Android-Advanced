package com.example.mvvmapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapplication.R
import com.example.mvvmapplication.data.model.Article
import com.example.mvvmapplication.databinding.ViewRepoListItemBinding
import com.example.mvvmapplication.viewmodel.RepoListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_repo_list_item.view.*

class RepoListAdapter(private val articleClickListener: (article: Article) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var repoList: List<Article> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewRepoListItemBinding.inflate(inflater)
        return RepoListViewHolder(binding)
    }

    override fun getItemCount() = repoList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RepoListViewHolder).setup(repoList[position], articleClickListener)
    }

    fun updateRepoList(repoList: List<Article>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }

    inner class RepoListViewHolder(private val binding: ViewRepoListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val avatarImage: ImageView = itemView.item_avatar

        fun setup(article: Article, articleClickListener: (article: Article) -> Unit) {
            binding.itemData = article
            Picasso.get().load(article.urlToImage).into(avatarImage)
            binding.itemContainer.setOnClickListener{
                articleClickListener(article)
            }
        }
    }
}