package com.tengesani.repository.fin.statements.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tengesani.databinding.FragmentFinStatementsBinding

class FInStatementsFragment : Fragment() {

    private lateinit var finStatementsViewModel: FinStatementsViewModel
    private var _binding: FragmentFinStatementsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        finStatementsViewModel =
                ViewModelProvider(this).get(FinStatementsViewModel::class.java)

        _binding = FragmentFinStatementsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textFinStatements
        finStatementsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}