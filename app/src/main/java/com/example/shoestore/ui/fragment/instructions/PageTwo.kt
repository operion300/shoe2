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
import com.example.shoestore.databinding.PageTwoBinding

class PageTwo:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val binding:PageTwoBinding = DataBindingUtil.inflate(inflater,R.layout.page_two,container,false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)

        binding.pageTowBtn.setOnClickListener {
            viewPager?.currentItem = 2
        }

        binding.pageTwoBackBtn.setOnClickListener {
            viewPager?.currentItem = 0
        }

        return  binding.root
    }

}