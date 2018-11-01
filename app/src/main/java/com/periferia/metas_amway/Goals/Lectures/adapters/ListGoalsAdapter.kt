package com.periferia.metas_amway.Goals.Lectures.adapters


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.periferia.metas_amway.R
import com.periferia.metas_amway.persistence.Entities.Book
import kotlinx.android.synthetic.main.item_lectureplan_list.view.*

class ListGoalsAdapter(val items: ArrayList<Book>,
                       val listener: ContentListener): RecyclerView.Adapter<ListGoalsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lectureplan_list,parent,false)
        return ViewHolder(v)
    }



    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items, listener)
    }


    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {


        fun bind(listOfData:ArrayList<Book>, listener:ContentListener) {

            val dataListin2 = listOfData[adapterPosition]

            itemView.txv_book_title.text = dataListin2.name
            itemView.txv_description.text = "Faltan ${dataListin2.finished} dias para finalizar"
            itemView.progressBar.max = dataListin2.totalPages!!
            itemView.progressBar.progress = dataListin2.currentPage
            itemView.txv_max.text = dataListin2.totalPages.toString()
            itemView.txv_min.text = dataListin2.currentPage.toString()

            itemView.setOnClickListener {
                listener.onItemClicked(listOfData.get(adapterPosition))
            }


        }
    }

    interface ContentListener {
        fun onItemClicked(item: Book)
    }
}