package com.architecture.clean.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.architecture.clean.R
import com.architecture.clean.domain.News
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * The News Recycle View Adapter.
 */
class NewsRecyclerViewAdapter(
        private val mewsList: List<News>)
    : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = mewsList[position]
        holder.newsTitleView.text = news.title
    }

    override fun getItemCount(): Int = mewsList.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val newsTitleView: TextView = view.news_title
    }
}