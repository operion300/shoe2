package com.example.shoestore.ui.fragment.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.shoestore.R
import com.example.shoestore.databinding.DetailFragmentBinding
import com.example.shoestore.ui.fragment.additem.SharedListViewModel


class ShoeDetailFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val binding:DetailFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment,container,false)

        val viewModel = ViewModelProvider(requireActivity()).get(SharedListViewModel::class.java)

        //passing viewModel to xml variable
        binding.shoeInfor = viewModel

        binding.detailBackBtn.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )

        /**
         * When add a item (fragment) in navigation xml file using design editor, the bar title label attribute
         * is added automatically; as xml loads faster then one of the method below, just one way needed
         * to be used for bar title: or using the label in fragment item in navigation xml or remove
         * label from item and use one of the method below; not use both;
         */
        //(activity as AppCompatActivity).supportActionBar?.title = getString(R.string.detail_bar_txt)
        //(activity as AppCompatActivity).supportActionBar?.setTitle(R.string.detail_bar_txt)

        return binding.root
    }
}