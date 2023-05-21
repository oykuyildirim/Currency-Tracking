package com.kotlinegitim.hw5_kotlin.CustomAdaptors

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.kotlinegitim.hw5_kotlin.R
import com.kotlinegitim.hw5_kotlin.models.Currency

class DropDownAdaptor(private val list_images: Array<String>,private val context: Activity, private val list: List<Currency>) :ArrayAdapter<Currency>(context,
    R.layout.dropdown_layout,list)  {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {




        return DropdownView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {



        return DropdownView(position,convertView,parent)
    }


    fun DropdownView (position: Int, convertView: View?, parent: ViewGroup) : View{
        val dropdownLayout = context.layoutInflater.inflate(R.layout.dropdown_layout,null,true)

        val list_obj = list.get(position)
        val list_image = list_images.get(position)


        val Image = dropdownLayout.findViewById<ImageView>(R.id.imageView)
        val text = dropdownLayout.findViewById<TextView>(R.id.myText)



        val resId = context.resources.getIdentifier(
            list_image,
            "drawable",
            context.packageName
        )

        Image.setImageResource(resId)
        text.text = list[position].Isim

        return dropdownLayout

    }



}