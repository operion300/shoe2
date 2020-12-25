package com.example.shoestore.ui.fragment.shoelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import com.example.shoestore.R
import com.example.shoestore.databinding.ListItemBinding
import com.example.shoestore.model.Shoe
import com.example.shoestore.model.User


class ListAdapter(context:Context,shoeList:ArrayList<Shoe>):BaseAdapter() {

    private val mContext:Context = context
    private val mShoeList:ArrayList<Shoe> = shoeList

    override fun getCount(): Int {
        return mShoeList.count()
    }

    override fun getItem(position: Int): Any {
        return mShoeList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layout = LayoutInflater.from(mContext)

        val binding:ListItemBinding = DataBindingUtil.inflate(layout,R.layout.list_item,parent,false)

        val shoe:Shoe = getItem(position) as Shoe

        binding.shoeName.text = shoe.name

        binding.shoeCompany.text = shoe.company

        return binding.root
    }

}
/*class ListAdapter(context: Context, shoe: ArrayList<Shoe>) :
    ArrayAdapter<Shoe>(context, R.layout.list_item, shoe) {

    var mContext = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val shoe:Shoe? = getItem(position)
        val convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false)

        val title = convertView.findViewById<AppCompatTextView>(R.id.shoe_name)
        val subTitle = convertView.findViewById<AppCompatTextView>(R.id.shoe_company)

        title.text = shoe?.name
        subTitle.text = shoe?.company

        return convertView
    }

}*/

