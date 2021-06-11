package com.example.bookmovie.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmovie.R
import com.example.bookmovie.data.Model.PizzaItem

class PizzaAdapter(private val context: Context): ListAdapter<PizzaItem, PizzaAdapter.PizzaHolder>(DIFF_ITEM_CALLBACK) {

    companion object {
        val DIFF_ITEM_CALLBACK = object : DiffUtil.ItemCallback<PizzaItem>() {
            override fun areItemsTheSame(oldItem: PizzaItem, newItem: PizzaItem): Boolean {
                return oldItem.Order_ID == newItem.Order_ID
            }

            override fun areContentsTheSame(oldItem: PizzaItem, newItem: PizzaItem): Boolean {
                return oldItem == newItem
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaHolder {
        val v: View = LayoutInflater.from(context).inflate(R.layout.items, parent, false)
        return PizzaHolder(v)
    }

    override fun onBindViewHolder(holder: PizzaHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PizzaHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val flavor: AppCompatTextView = itemView.findViewById(R.id.flavor)
        private val crust: AppCompatTextView = itemView.findViewById(R.id.crust)
        private val size: AppCompatTextView = itemView.findViewById(R.id.size)
        private val table: AppCompatTextView = itemView.findViewById(R.id.table)
        private val order: AppCompatTextView = itemView.findViewById(R.id.order)

        fun bind(pizzaItem: PizzaItem) {
            flavor.text = pizzaItem.Flavor
            crust.text = pizzaItem.Crust
            size.text = pizzaItem.Size
            table.text = pizzaItem.Table_No.toString()
            order.text = pizzaItem.Order_ID.toString()
        }

    }

}