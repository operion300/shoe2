package com.example.shoestore.ui.fragment.shoelist

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.ShoelistFragmentBinding
import com.example.shoestore.ui.fragment.additem.SharedListViewModel

class ShoeListFragment:Fragment() {


    lateinit var viewModel:SharedListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View {

        val binding:ShoelistFragmentBinding =
                DataBindingUtil.inflate(inflater, R.layout.shoelist_fragment, container, false)

        setHasOptionsMenu(true)

        viewModel = ViewModelProvider(requireActivity()).get(SharedListViewModel::class.java)

        viewModel.liveShoe.observe(viewLifecycleOwner, { shoe ->

            val mAdapter = ListAdapter(requireContext(),viewModel.list)

            binding.listView.adapter = mAdapter

            binding.listView.setOnItemClickListener { parent, view, position, id ->

                findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
                viewModel.itemList()



            }

        })

        binding.floatBtn.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_addItemFragment)
        )

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.list_bar_txt)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout -> findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        }
        return super.onOptionsItemSelected(item)
    }


}