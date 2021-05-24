package com.app.demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.demo.R
import com.app.demo.data.Value
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.details_row_item.view.*


class ListAdapter(val context: Context, private val repositoryList: List<Value>): RecyclerView.Adapter<ListViewHolder>() {

    lateinit var listener: OnItemClickListener
    var mCounter = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val inflator = LayoutInflater.from(viewGroup.context)
        val view = inflator.inflate(R.layout.details_row_item, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ListViewHolder, position: Int) {
        val listItem = repositoryList[position]
        viewHolder.tvName.text = "Name: "+listItem.name.capitalize()
        viewHolder.tvType.text = "Type: "+listItem.type.capitalize()
        viewHolder.tvDate.text = "Date: "+getFormattedDate(listItem.createdOn)
        Glide.with(context)
                .load(listItem.owner.links.avatar)
                .placeholder(R.drawable.default_image)
                .error(R.drawable.image_not_found)
                .into(viewHolder.ivAvatar)

        viewHolder.layout.setOnClickListener {
            listener.onClick(it, listItem)
        }

    }

    override fun getItemCount(): Int {
        return repositoryList.size
    }

    interface OnItemClickListener {
        fun onClick(view: View, data: Value)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    private fun getFormattedDate(dateStr: String): String {
       val str = dateStr.split("T")
       return str[0]
    }


}

class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val ivAvatar = itemView.ivAvatar
    var tvName = itemView.tvName
    val tvType = itemView.tvType
    val tvDate = itemView.tvDate
    val layout = itemView.listView

}