package com.tengesani.sales.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tengesani.R
import com.tengesani.sales.model.Sale
import java.text.DecimalFormat

class SalesAdapter(private val sales: List<Sale>, private val context:Context):
    RecyclerView.Adapter<SalesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.purchase_sale_item,parent,
            false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sales[position], context)


    }

    override fun getItemCount(): Int {
        return sales.size
    }

    class ViewHolder (view: View):RecyclerView.ViewHolder(view){

        private val productTextView: TextView = view.findViewById(R.id.product)
        private val priceTextView: TextView = view.findViewById(R.id.price)
        private val qtyTextView: TextView = view.findViewById(R.id.qty)
        private val categoryTextView: TextView = view.findViewById(R.id.category)
        private val dateTextView: TextView = view.findViewById(R.id.date)

        private val saleItem: LinearLayout = view.findViewById(R.id.purchaseSaleItem)


        private var currentSale: Sale? = null




        fun bind(sale: Sale, context: Context) {

            val dec = DecimalFormat("#,###.##")

            currentSale = sale

            productTextView.text = sale.product_name
            priceTextView.text =  dec.format(sale.sale_price).toString()
            qtyTextView.text = dec.format(sale.quantity_sold).toString()
            categoryTextView.text = sale.category
            dateTextView.text = sale.sale_date

            saleItem.setOnClickListener {
                




            }


        }



    }





}