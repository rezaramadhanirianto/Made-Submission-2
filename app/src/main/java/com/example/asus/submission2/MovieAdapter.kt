package com.example.asus.submission2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row.view.*
import java.util.ArrayList

class MovieAdapter(private val listMovie: ArrayList<MovieClass>) : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieClass) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(movie.img)
                    .apply(RequestOptions().override(150, 150))
                    .into(img_item)
                title.text = movie.title
                desc.text = movie.desc

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(movie) }
            }
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row, viewGroup, false)
        return ListViewHolder(view)//To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int = listMovie.size //To change body of created functions use File | Settings | File Templates.


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: MovieClass)
    }
}