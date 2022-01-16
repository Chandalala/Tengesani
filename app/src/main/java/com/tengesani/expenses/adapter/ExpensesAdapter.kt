package com.tengesani.expenses.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tengesani.R
import com.tengesani.expenses.model.Expense
import java.text.DecimalFormat

class ExpensesAdapter(private val expenses: List<Expense>, private val context:Context):
    RecyclerView.Adapter<ExpensesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.expense_item,parent,
            false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(expenses[position], context)


    }

    override fun getItemCount(): Int {
        return expenses.size
    }

    class ViewHolder (view: View):RecyclerView.ViewHolder(view){

        private val expenseTextView: TextView = view.findViewById(R.id.expense)
        private val amountTextView: TextView = view.findViewById(R.id.amount)
        private val dateTextView: TextView = view.findViewById(R.id.date)

        private val expenseItem: LinearLayout = view.findViewById(R.id.expenseItem)


        private var currentExpense: Expense? = null







        fun bind(expense: Expense, context: Context) {

            val dec = DecimalFormat("#,###.##")

            currentExpense = expense

            expenseTextView.text = expense.expense_name
            amountTextView.text =  dec.format(expense.amount).toString()
            dateTextView.text = expense.date_incurred

            expenseItem.setOnClickListener {
                




            }


        }



    }





}