package com.example.shoestore.ui.fragment.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.shoestore.R
import com.example.shoestore.databinding.InstructionFragmentBinding
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle


class InstructionsFragment:Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding:InstructionFragmentBinding =
            DataBindingUtil.inflate(inflater,R.layout.instruction_fragment,container,false)

        val viewPager = binding.viewPager

        val mAdapter = PageAdapter(this.childFragmentManager,lifecycle)
        viewPager.adapter = mAdapter

        val indicator = binding.indicator2
        indicator.apply {
            setSliderColor(resources.getColor(R.color.startColor,null),resources.getColor(R.color.teal_700,null))
            setSliderWidth(40F)
            setSliderHeight(40F)
            setSlideMode(IndicatorSlideMode.NORMAL)
            setIndicatorStyle(IndicatorStyle.CIRCLE)
            setupWithViewPager(viewPager)
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.inst_bar_txt)

        return binding.root
    }


}