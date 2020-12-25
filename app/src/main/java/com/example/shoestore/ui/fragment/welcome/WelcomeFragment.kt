package com.example.shoestore.ui.fragment.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val binding:WelcomeFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.welcome_fragment,container,false)

        val args =  WelcomeFragmentArgs.fromBundle(requireArguments())

        binding.nameWelcome.text = args.userName

        binding.instBtn.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_instructionsFragment)
                //Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_shoeListFragment)
        )

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.welcome_bar_txt)

        return binding.root
    }

}