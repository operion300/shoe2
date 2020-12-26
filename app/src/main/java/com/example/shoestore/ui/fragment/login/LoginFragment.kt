package com.example.shoestore.ui.fragment.login


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
import androidx.navigation.fragment.NavHostFragment
import com.example.shoestore.R
import com.example.shoestore.databinding.LoginFragmentBinding

class LoginFragment:Fragment() {


    lateinit var binding:LoginFragmentBinding
    lateinit var viewModel:LoginViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.hide()

        binding = DataBindingUtil.inflate(inflater,R.layout.login_fragment,container,false)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginBtn.setOnClickListener {

            viewModel.liveUser.observe(viewLifecycleOwner, { user ->

                if (binding.userEmail.text?.trim().toString().isEmpty() || binding.password.text?.trim()
                        .toString().isEmpty()
                ) {
                    Toast.makeText(context, "Provide all information", Toast.LENGTH_SHORT).show()
                }else if (binding.userEmail.text?.trim()
                        .toString() != user.email || binding.password.text?.trim()
                        .toString() != user.pass
                ) {
                    Toast.makeText(context, "Wrong credentials", Toast.LENGTH_SHORT).show()
                } else {

                        val action =
                            LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(user.name)
                        NavHostFragment.findNavController(this).navigate(action)

                        val keyBoard: InputMethodManager =
                            context?.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
                        keyBoard.hideSoftInputFromWindow(view?.windowToken, 0)

               }
            })

        }

        viewModel.getUser()



        return binding.root
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }

}