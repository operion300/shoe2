package com.example.shoestore.ui.fragment.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.shoestore.R
import com.example.shoestore.databinding.InstructionFragmentBinding
import com.example.shoestore.databinding.PageThreeBinding

class PageThree:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding:PageThreeBinding = DataBindingUtil.inflate(inflater,R.layout.page_three,container,false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)

        binding.pageThreeBtn.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_instructionsFragment_to_shoeListFragment)
        )

        binding.pageThreeBackBtn.setOnClickListener {
            viewPager?.currentItem = 1
        }

        return binding.root
    }

}