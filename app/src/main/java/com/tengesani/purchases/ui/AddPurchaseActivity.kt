package com.tengesani.purchases.ui

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.tengesani.R
import com.tengesani.SwipeToDeleteCallback
import com.tengesani.SwipeToEditCallback
import com.tengesani.TengesaniApp
import com.tengesani.category.ui.AddCategoryActivity
import com.tengesani.category.ui.CategoryViewModel
import com.tengesani.category.ui.CategoryViewModelFactory
import com.tengesani.databinding.ActivityAddProductBinding
import com.tengesani.databinding.ActivityAddPurchaseBinding
import com.tengesani.product.ui.AddProductActivity
import com.tengesani.product.ui.ProductViewModel
import com.tengesani.product.ui.ProductViewModelFactory
import com.tengesani.purchases.adapter.PurchasesAdapter
import com.tengesani.purchases.model.Purchase
import dmax.dialog.SpotsDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.time.LocalDate

private lateinit var binding: ActivityAddPurchaseBinding

class AddPurchaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddPurchaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_outline_arrow_back_ios)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val textViewDate: TextView = binding.date

        val date:String="${LocalDate.now().dayOfWeek} " +
                "${LocalDate.now().dayOfMonth} " +
                "${LocalDate.now().month} " +
                "${LocalDate.now().year} "

        textViewDate.text=date

        val btnSave: MaterialButton = binding.btnSave
        val textInputLayoutPrice: TextInputLayout = binding.textInputLayoutPrice
        val textInputLayoutQTY: TextInputLayout = binding.textInputLayoutQTY

        val productTextView: AppCompatAutoCompleteTextView = binding.productTextView
        val categoryTextView: AppCompatAutoCompleteTextView = binding.categoryTextView



        val productViewModel: ProductViewModel by viewModels {
            ProductViewModelFactory((applicationContext as TengesaniApp).productRepository)
        }

        productViewModel.products.observe(this,{ it ->

            val productAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                it.map { it.product_name }
            )

            productTextView.setAdapter(productAdapter)

        })



        val categoryViewModel: CategoryViewModel by viewModels {
            CategoryViewModelFactory((applicationContext as TengesaniApp).categoryRepository)
        }


        categoryViewModel.categories.observe(this,{ it ->

            val categoryAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                it.map { it.category_name }
            )

            categoryTextView.setAdapter(categoryAdapter)

        })


        val purchasesViewModel: PurchasesViewModel by viewModels {
            PurchasesViewModelFactory((applicationContext as TengesaniApp).purchasesRepository)
        }




        val dialog: AlertDialog = SpotsDialog.Builder()
            .setContext(this)
            .setMessage("Saving Your Purchase Order")
            .setCancelable(false)
            .build()



        btnSave.setOnClickListener {

            dialog.show()



            val purchase = Purchase(
                productTextView.text.toString(),
                textInputLayoutPrice.editText?.text.toString().toDouble(),
                categoryTextView.text.toString(),
                textInputLayoutQTY.editText?.text.toString().toInt(),
                LocalDate.now().toString()
            )

            purchasesViewModel.recordPurchase(purchase)

            purchasesViewModel.pr.observe(this,{

                if (it.product_name != ""){

                    println(it.product_name)
             /*       dialog.dismiss()
                    finish()*/




                }
                else{
                    dialog.dismiss()

                    println("Not Saved")

                }
            })


        }




        
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.category_configuration -> {
                startActivity(Intent(this, AddCategoryActivity::class.java))
                true
            }
            R.id.product_configuration -> {
                startActivity(Intent(this, AddProductActivity::class.java))

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}