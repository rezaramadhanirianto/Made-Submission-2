package com.example.asus.submission2

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SectionPageAdapter (private val mContext: Context, fm:FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val TABTITLES = intArrayOf(R.string.movie, R.string.tv_show)
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0-> fragment = Movie()
            1 -> fragment = TvShow()
        }
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TABTITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}