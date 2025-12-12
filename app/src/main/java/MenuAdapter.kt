package com.example.menuproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MenuAdapter(private val context: Context, private val list: List<MenuItem>) : BaseAdapter() {

    override fun getCount() = list.size

    override fun getItem(position: Int) = list[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.menu_item_row, parent, false)

        val image = view.findViewById<ImageView>(R.id.row_image)
        val text = view.findViewById<TextView>(R.id.row_text)
        val description = view.findViewById<TextView>(R.id.row_description)

        val item = list[position]

        image.setImageResource(item.image)
        text.text = item.name
        description.text = item.description
        return view
    }
}