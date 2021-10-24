package com.tengesani.product.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.tengesani.R
import com.tengesani.TengesaniApp
import com.tengesani.category.model.Category
import com.tengesani.category.ui.CategoryViewModel
import com.tengesani.category.ui.CategoryViewModelFactory
import com.tengesani.databinding.ActivityAddCategoryBinding
import com.tengesani.databinding.ActivityAddProductBinding
import com.tengesani.product.model.Product
import java.time.LocalDate
import com.tengesani.MainActivity

import android.widget.ArrayAdapter
import android.widget.TextView


private lateinit var binding: ActivityAddProductBinding



class AddProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductBinding.inflate(layoutInflater)
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
        val textInputLayoutProduct: TextInputLayout = binding.textInputLayoutProduct
        val categoryTextView: AppCompatAutoCompleteTextView = binding.categoryTextView


        val productViewModel: ProductViewModel by viewModels {
            ProductViewModelFactory((applicationContext as TengesaniApp).productRepository)
        }


        val categoryViewModel: CategoryViewModel by viewModels {
            CategoryViewModelFactory((applicationContext as TengesaniApp).categoryRepository)
        }




        categoryViewModel.categories.observe(this,{ it ->


            val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                it.map { it.category_name }
            )

            categoryTextView.setAdapter(adapter)

            btnSave.setOnClickListener {
                if (textInputLayoutProduct.editText?.text.toString() != ""){
                    val product = Product(
                        textInputLayoutProduct.editText?.text.toString(),
                        categoryTextView.text.toString(),
                        LocalDate.now().toString()
                    )
                    productViewModel.recordProduct(product)
                    //Todo show saving dialog and finish activity

                }
                else{
                    textInputLayoutProduct.editText?.error = "Category cannot be blank!"
                }
            }

        })








    }
}