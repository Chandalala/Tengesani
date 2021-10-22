package com.tengesani.purchases.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tengesani.R
import com.tengesani.purchases.model.Purchase

class PurchasesAdapter(private val purchases: List<Purchase>):
    RecyclerView.Adapter<PurchasesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.purchase_item,parent,
            false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(purchases[position])


    }

    override fun getItemCount(): Int {
        return purchases.size
    }

    class ViewHolder (view: View):RecyclerView.ViewHolder(view){

        private val productTextView: TextView = view.findViewById(R.id.product)
        private val priceTextView: TextView = view.findViewById(R.id.price)
        private val qtyTextView: TextView = view.findViewById(R.id.qty)
        private val categoryTextView: TextView = view.findViewById(R.id.category)
        private val dateTextView: TextView = view.findViewById(R.id.date)

        private var currentPurchase: Purchase? = null





        fun bind(purchase: Purchase) {
            currentPurchase = purchase

            productTextView.text = purchase.product_name
            priceTextView.text = purchase.purchase_price.toString()
            qtyTextView.text = purchase.quantity.toString()
            categoryTextView.text = purchase.category
            dateTextView.text = purchase.purchase_date




        }



    }





}