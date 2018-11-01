package com.periferia.metas_amway.Goals.Lectures.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.periferia.metas_amway.R
import com.periferia.metas_amway.persistence.Entities.DetailBook
import kotlinx.android.synthetic.main.item_lecture_history.view.*

class ListGoalsHistoryAdapter(val items: MutableList<DetailBook>):RecyclerView.Adapter<ListGoalsHistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lecture_history, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return  items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(items)
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(data: MutableList<DetailBook>){
            val dataItem = data[adapterPosition]

            itemView.txv_last_page.setText(dataItem.lastPageRead.toString())
            itemView.txv_date.setText(dataItem.created)

        }

    }
}