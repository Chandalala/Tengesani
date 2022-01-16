package com.tengesani.expenses.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.github.clans.fab.FloatingActionButton
import com.tengesani.SwipeToDeleteCallback
import com.tengesani.TengesaniApp
import com.tengesani.databinding.FragmentExpensesBinding
import com.tengesani.expenses.adapter.ExpensesAdapter

class ExpensesFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentExpensesBinding? = null




    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val expensesViewModel: ExpensesViewModel by viewModels {
            ExpensesViewModelFactory((activity?.applicationContext as TengesaniApp).expenseRepository)
        }

        _binding = FragmentExpensesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnManualAdd: FloatingActionButton = binding.btnManualAdd

        btnManualAdd.setOnClickListener(this)



        val recyclerView: RecyclerView = binding.recyclerView



        expensesViewModel.getAllExpenses()?.observe(viewLifecycleOwner, {

            recyclerView.adapter = ExpensesAdapter(it, requireContext())

            val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val pos = viewHolder.adapterPosition
                    expensesViewModel.cancelExpense(it[pos])

                    it.removeAt(pos)
                    ExpensesAdapter(it, requireContext()).notifyItemRemoved(pos)

                }
            }

            val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
            itemTouchHelper.attachToRecyclerView(recyclerView)


        })



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {


        if (p0 == binding.btnManualAdd){

            //todo bottom sheet

        }
    }
}