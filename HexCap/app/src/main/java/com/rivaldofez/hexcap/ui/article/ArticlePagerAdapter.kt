package com.rivaldofez.hexcap.ui.article

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class ArticlePagerAdapter (activity: AppCompatActivity): FragmentStateAdapter(activity) {
    companion object {
        const val mFunfact = "funfact"
        const val mTips = "tipsandtrick"
        const val mHistory = "history"
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null

        when (position) {
            0 -> {
                val fragmentFunFact = ArticleFragment()
                fragmentFunFact.option = mFunfact
                fragment = fragmentFunFact
            }

            1 -> {
                val fragmentTips = ArticleFragment()
                fragmentTips.option = mTips
                fragment = fragmentTips
            }

            2 -> {
                val fragmentHistory = ArticleFragment()
                fragmentHistory.option = mHistory
                fragment = fragmentHistory
            }
        }
        return fragment!!
    }
}