package com.example.shoestore.ui.fragment.additem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.AddItemBinding
import com.example.shoestore.model.Shoe

class AddItemFragment:Fragment() {

    lateinit var viewModel:SharedListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding:AddItemBinding =
                DataBindingUtil.inflate(inflater,R.layout.add_item,container,false)

        //hide keyboard when enter text in edit
        val keyBoard: InputMethodManager = context?.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager

        viewModel = ViewModelProvider(requireActivity()).get(SharedListViewModel::class.java)

        binding.productRegister.setOnClickListener {
            val name = binding.editProdName.text.toString()
            val size = binding.editProdSize.text.toString()
            val company = binding.editProdCompany.text.toString()
            val desc = binding.editProdDesc.text.toString()
            if (name.isEmpty()||size.isEmpty()||company.isEmpty()||desc.isEmpty()){
                Toast.makeText(requireContext(), "Provide full information", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.setShoe(Shoe(name,size.toDouble(),company,desc))
                keyBoard.hideSoftInputFromWindow(view?.windowToken,0)
                findNavController().navigate(R.id.action_addItemFragment_to_shoeListFragment)
            }
        }

        binding.productRegisterCancel.setOnClickListener {
            findNavController().navigate(R.id.action_addItemFragment_to_shoeListFragment)
            keyBoard.hideSoftInputFromWindow(view?.windowToken,0)
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.add_bar_txt)

        return binding.root
    }


}