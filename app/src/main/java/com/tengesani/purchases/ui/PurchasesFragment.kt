package com.tengesani.purchases.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.github.clans.fab.FloatingActionButton
import com.tengesani.SwipeToDeleteCallback
import com.tengesani.SwipeToEditCallback
import com.tengesani.TengesaniApp
import com.tengesani.databinding.FragmentPurchasesBinding
import com.tengesani.purchases.adapter.PurchasesAdapter

class PurchasesFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPurchasesBinding? = null




    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {


        val purchasesViewModel: PurchasesViewModel by viewModels {
            PurchasesViewModelFactory((activity?.applicationContext as TengesaniApp).repository)
        }

        _binding = FragmentPurchasesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnScan: FloatingActionButton = binding.btnScan
        val btnManualAdd: FloatingActionButton = binding.btnManualAdd

        btnScan.setOnClickListener(this)
        btnManualAdd.setOnClickListener(this)



        val recyclerView: RecyclerView = binding.recyclerView

       // purchasesViewModel.recordPurchase()



        purchasesViewModel.purchases.observe(viewLifecycleOwner, {
          //  textView.text = it.get(0).category
            recyclerView.adapter = PurchasesAdapter(it)

            val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val pos = viewHolder.adapterPosition
                    purchasesViewModel.cancelPurchase(it[pos])

                    it.removeAt(pos)
                    PurchasesAdapter(it).notifyItemRemoved(pos)

                }
            }

            val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
            itemTouchHelper.attachToRecyclerView(recyclerView)



            val swipeToEditCallback = object : SwipeToEditCallback() {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val pos = viewHolder.adapterPosition


                    Toast.makeText(activity, it[pos].product_name, Toast.LENGTH_SHORT).show()
                    PurchasesAdapter(it).notifyItemRemoved(pos)

                }
            }

            val itemTouchHelper2 = ItemTouchHelper(swipeToEditCallback)
            itemTouchHelper2.attachToRecyclerView(recyclerView)

        })



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {
        if (p0 == binding.btnScan){
            Toast.makeText(activity, "Fuck", Toast.LENGTH_SHORT).show()
        }

        if (p0 == binding.btnManualAdd){
            val intent =Intent(activity, AddPurchaseActivity::class.java)
            startActivity(intent)
            Toast.makeText(activity, "Fuck2", Toast.LENGTH_SHORT).show()
        }
    }
}