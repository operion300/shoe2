package com.example.shoestore.ui.fragment.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.shoestore.R
import com.example.shoestore.databinding.InstructionFragmentBinding
import com.example.shoestore.databinding.PageOneBinding

class PageOne:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding:PageOneBinding = DataBindingUtil.inflate(inflater,R.layout.page_one,container,false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)

        binding.pageOneBtn.setOnClickListener {
            viewPager?.currentItem = 1
        }

        return binding.root
    }
}