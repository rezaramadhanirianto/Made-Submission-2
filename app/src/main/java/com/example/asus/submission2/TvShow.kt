package com.example.asus.submission2


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_tv_show.*

/**
 * A simple [Fragment] subclass.
 */
class TvShow : Fragment() {

    private val list = ArrayList<TvShowClass>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.addAll(getGridMovie())
        showRecyclerGrid()
    }

    fun getGridMovie() : ArrayList<TvShowClass> {
        val title = resources.getStringArray(R.array.tv_title)
        val desc= resources.getStringArray(R.array.tv_desc)
        val img= resources.obtainTypedArray(R.array.tv_photo)

        val listTv = ArrayList<TvShowClass>()
        for (position in title.indices){
            val tv = TvShowClass(
                title[position],
                img.getResourceId(position, -1),
                desc[position]
            )
            listTv.add(tv)
        }
        return listTv

    }

    private fun showRecyclerGrid() {
        listTv.layoutManager = GridLayoutManager(this.context, 2)
        val gridTvAdapter = TvShowAdapter(list)
        listTv.adapter = gridTvAdapter
        gridTvAdapter.setOnItemClickCallback(object : TvShowAdapter.OnItemClickCallback{
            override fun onItemClicked(data: TvShowClass) {
                showSelectedTV(data)
            }
        })
    }

    private fun showSelectedTV(tv: TvShowClass) {

        val moveWithObjectIntent = Intent(context, Detail::class.java)
        moveWithObjectIntent.putExtra(Detail.EXTRA_FILM, tv)
        startActivity(moveWithObjectIntent)

    }


}
