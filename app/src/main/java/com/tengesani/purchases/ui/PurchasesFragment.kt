package com.tengesani.purchases.ui

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tengesani.TengesaniApp
import com.tengesani.databinding.FragmentPurchasesBinding

class PurchasesFragment : Fragment() {

    private var _binding: FragmentPurchasesBinding? = null




    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        val purchasesViewModel: PurchasesViewModel by viewModels {
            PurchasesViewModelFactory((activity?.applicationContext as TengesaniApp).repository)
        }

        _binding = FragmentPurchasesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textPurchases
        purchasesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

 /*       purchasesViewModel.purchases.observe(viewLifecycleOwner, Observer {
          //  textView.text = it.get(0).category
        })*/



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}