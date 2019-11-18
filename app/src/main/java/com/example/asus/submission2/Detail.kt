package com.example.asus.submission2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_tv_show.*

class Detail : AppCompatActivity() {

    companion object{
        const val EXTRA_FILM_TV = "extra_film_tv"
        const val EXTRA_FILM = "extra_film"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        try {
            val movie = intent.getParcelableExtra(EXTRA_FILM_TV) as MovieClass
            detail_desc.text = movie.desc.toString()
            detail_title.text = movie.title.toString()
            Glide.with(this).load(movie.img).into(detail_photo);
        }catch (e: Exception) {
            val movie = intent.getParcelableExtra(EXTRA_FILM) as TvShowClass
            detail_desc.text = movie.desc.toString()
            detail_title.text = movie.title.toString()
            Glide.with(this).load(movie.img).into(detail_photo);
        }


    }
}
