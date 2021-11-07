package com.tengesani.sales.ui

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.fragment.app.viewModels
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.tengesani.R
import com.tengesani.TengesaniApp
import com.tengesani.category.ui.AddCategoryActivity
import com.tengesani.category.ui.CategoryViewModel
import com.tengesani.category.ui.CategoryViewModelFactory
import com.tengesani.databinding.ActivityAddSaleBinding
import com.tengesani.product.ui.AddProductActivity
import com.tengesani.product.ui.ProductViewModel
import com.tengesani.product.ui.ProductViewModelFactory
import com.tengesani.purchases.model.Purchase
import com.tengesani.purchases.ui.PurchasesViewModel
import com.tengesani.purchases.ui.PurchasesViewModelFactory
import com.tengesani.sales.model.Sale
import dmax.dialog.SpotsDialog
import java.time.LocalDate

private lateinit var binding: ActivityAddSaleBinding
private var stockQuantity: Int =0
private lateinit var purchase: Purchase

class AddSaleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddSaleBinding.inflate(layoutInflater)
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
        val textInputLayoutCategory: TextInputLayout = binding.textInputLayoutCategory


        val productTextView: AppCompatAutoCompleteTextView = binding.productTextView





        val purchasesViewModel: PurchasesViewModel by viewModels {
            PurchasesViewModelFactory((applicationContext as TengesaniApp).purchasesRepository)
        }




        purchasesViewModel.getAllPurchases()?.observe(this,{ it ->

            val productAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                it.map { it.product_name }
            )

            productTextView.setAdapter(productAdapter)

            productTextView.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {

                    val pos = productAdapter.getPosition(s.toString())

                    if (pos != -1){
                        stockQuantity = it[pos].quantity

                        textInputLayoutCategory.editText?.setText(it[pos].category)

                        purchase = Purchase(
                            it[pos].product_name,
                            it[pos].purchase_price,
                            it[pos].category,
                            it[pos].quantity,
                            it[pos].purchase_date
                        )
                    }
                    else{
                        Toast.makeText(this@AddSaleActivity, "Product not found", Toast.LENGTH_SHORT).show()

                    }




                }
                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence, start: Int,
                    before: Int, count: Int
                ) {
                }
            })

            val salesViewModel: SalesViewModel by viewModels {
                SalesViewModelFactory((applicationContext as TengesaniApp).salesRepository)
            }


            val dialog: AlertDialog = SpotsDialog.Builder()
                .setContext(this)
                .setMessage("Saving Your Sale Order")
                .setCancelable(false)
                .build()


            btnSave.setOnClickListener {


                val saleQuantity = textInputLayoutQTY.editText?.text.toString().toInt()

                val sale = Sale(
                    productTextView.text.toString(),
                    textInputLayoutPrice.editText?.text.toString().toDouble(),
                    textInputLayoutCategory.editText?.text.toString(),
                    saleQuantity,
                    LocalDate.now().toString()
                )



                if (saleQuantity > stockQuantity){
                    Toast.makeText(
                        this,
                        "Sale exceeding current stock holding",
                        Toast.LENGTH_LONG
                    ).show()


                }
                else if (saleQuantity <= stockQuantity){

                    purchase.quantity = stockQuantity - saleQuantity


                    dialog.show()

                    salesViewModel.recordSale(sale)

                    //Todo purchase not updating
                    purchasesViewModel.updatePurchase(purchase)

                    salesViewModel.sl.observe(this,{

                        if (it.product_name == sale.product_name){

                            dialog.dismiss()
                            Toast.makeText(this, "Sale Order Saved", Toast.LENGTH_LONG).show()

                            //todo clear fields




                        }
                        else{
                            dialog.dismiss()
                            Toast.makeText(this, "Sale Order Not Saved, Try Again", Toast.LENGTH_LONG).show()

                        }
                    })

                }




            }




        })






        
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