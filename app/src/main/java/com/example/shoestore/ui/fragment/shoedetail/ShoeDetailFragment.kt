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

        /*val args = ShoeDetailFragmentArgs.fromBundle(requireArguments())

        binding.detailName.text = args.shoeData.name
        binding.detailSize.text = args.shoeData.size.toString()
        binding.detailCompany.text = args.shoeData.company
        binding.detailDescription.text = args.shoeData.description
        */
        val viewModel = ViewModelProvider(requireActivity()).get(SharedListViewModel::class.java)
        binding.detailName.text = viewModel.shoeListItem.name
        binding.detailSize.text = viewModel.shoeListItem.size.toString()
        binding.detailCompany.text = viewModel.shoeListItem.company
        binding.detailDescription.text = viewModel.shoeListItem.description

        binding.detailBackBtn.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.detail_bar_txt)

        return binding.root
    }
}