package com.tengesani.ui.expenses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tengesani.databinding.FragmentExpensesBinding

class ExpensesFragment : Fragment() {

    private lateinit var expensesViewModel: ExpensesViewModel
    private var _binding: FragmentExpensesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        expensesViewModel =
                ViewModelProvider(this).get(ExpensesViewModel::class.java)

        _binding = FragmentExpensesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textExpenses
        expensesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}