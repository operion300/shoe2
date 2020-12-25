package com.example.shoestore.ui.fragment.instructions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter (
    fragManager: FragmentManager,
    lifeCycle: Lifecycle,
): FragmentStateAdapter(fragManager,lifeCycle ){

    private val fragmentList = arrayListOf(
    PageOne(),
    PageTwo(),
    PageThree()
    )


    override fun getItemCount(): Int {
        return fragmentList.count()
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}