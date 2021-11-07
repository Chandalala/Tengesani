package com.tengesani.purchases.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tengesani.R
import com.tengesani.purchases.model.Purchase
import java.text.DecimalFormat

class PurchasesAdapter(private val purchases: List<Purchase>, private val context:Context):
    RecyclerView.Adapter<PurchasesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.purchase_sale_item,parent,
            false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(purchases[position], context)


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

        private val purchaseItem: LinearLayout = view.findViewById(R.id.purchaseSaleItem)


        private var currentPurchase: Purchase? = null







        fun bind(purchase: Purchase, context: Context) {

            val dec = DecimalFormat("#,###.##")

            currentPurchase = purchase

            productTextView.text = purchase.product_name
            priceTextView.text =  dec.format(purchase.purchase_price).toString()
            qtyTextView.text = dec.format(purchase.quantity).toString()
            categoryTextView.text = purchase.category
            dateTextView.text = purchase.purchase_date

            purchaseItem.setOnClickListener {
                




            }


        }



    }





}