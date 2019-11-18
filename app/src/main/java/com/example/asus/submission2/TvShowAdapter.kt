package com.example.asus.submission2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_tv_show.view.*

class TvShowAdapter (private val listTvShow: ArrayList<TvShowClass>) : RecyclerView.Adapter<TvShowAdapter.GridViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tv: TvShowClass) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(tv.img)
                    .apply(RequestOptions().override(400, 400))
                    .into(img_photo_tv_show)
                title_tv_show.text = tv.title
                desc_tv_show.text = tv.desc

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(tv) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tv_show, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int = listTvShow.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(listTvShow[position])
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TvShowClass)
    }
}