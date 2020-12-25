package com.example.shoestore.ui.fragment.additem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.model.Shoe

class  SharedListViewModel:ViewModel() {

    val list:ArrayList<Shoe> = ArrayList()
    lateinit var shoeListItem:Shoe

    val liveShoe:LiveData<Shoe>
    get() = _liveShoe
    private val _liveShoe = MutableLiveData<Shoe>()

    fun setShoe(shoe:Shoe){
        _liveShoe.value = shoe
        list.add(shoe)
    }

    fun itemList(){
        list.forEach {
            shoeListItem = it
        }
    }

}