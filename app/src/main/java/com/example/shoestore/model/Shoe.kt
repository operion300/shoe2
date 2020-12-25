package com.example.shoestore.model

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class Shoe (var name:String,var size:Double,var company:String,var description:String):Parcelable