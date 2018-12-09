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
        private val mewsList: List<News>,
        private val onClickNewsListener: NewsRecyclerViewAdapter.OnClickNewsListener?)
    : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {

    private var onClickListener: View.OnClickListener = View.OnClickListener { v ->
        val news = v.tag as News
        onClickNewsListener?.onClickNews(news)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = mewsList[position]
        holder.newsTitleView.text = news.title

        with(holder.view) {
            tag = news
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount(): Int = mewsList.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val newsTitleView: TextView = view.news_title
    }

    interface OnClickNewsListener {
        fun onClickNews(news: News)
    }
}