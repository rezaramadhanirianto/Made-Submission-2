package com.example.asus.submission2


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Constraints
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.list.*

/**
 * A simple [Fragment] subclass.
 */
class Movie : Fragment() {

    private val list = ArrayList<MovieClass>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            list.addAll(getListMovie())
            showRecyclerList()

    }


    fun getListMovie() : ArrayList<MovieClass>{
        val title = resources.getStringArray(R.array.movie_title)
        val desc= resources.getStringArray(R.array.movie_desc)
        val img= resources.obtainTypedArray(R.array.movie_photo)

        val listMovie = ArrayList<MovieClass>()
        for (position in title.indices){
            val movie = MovieClass(
                title[position],
                img.getResourceId(position, -1),
                desc[position]
            )
            listMovie.add(movie)
        }
        return listMovie
    }
    private fun showRecyclerList() {


        listMovie.layoutManager = LinearLayoutManager(this.context)
        val listMovieAdapter = MovieAdapter(list)
        listMovie.adapter = listMovieAdapter

        listMovieAdapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback{
            override fun onItemClicked(data: MovieClass) {

                showSelectedMovie(data)
            }
        })
    }

    private fun showSelectedMovie(movie: MovieClass) {

        val moveWithObjectIntent = Intent(context, Detail::class.java)
            moveWithObjectIntent.putExtra(Detail.EXTRA_FILM_TV, movie)
            startActivity(moveWithObjectIntent)

    }





}
