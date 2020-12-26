package com.example.shoestore.ui.fragment.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.model.User

class LoginViewModel:ViewModel() {
    val liveUser:LiveData<User>
    get() = _liveUser
    private val _liveUser:MutableLiveData<User> = MutableLiveData()


    fun getUser(){
        _liveUser.value = User("Alan","alan@gmail.com","123")
    }


}