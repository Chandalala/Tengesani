package com.tengesani.category.ui

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.tengesani.R
import com.tengesani.TengesaniApp
import com.tengesani.category.model.Category
import com.tengesani.databinding.ActivityAddCategoryBinding
import com.tengesani.databinding.ActivityMainBinding
import com.tengesani.databinding.FragmentPurchasesBinding
import dmax.dialog.SpotsDialog
import java.time.LocalDate

private lateinit var binding: ActivityAddCategoryBinding



class AddCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddCategoryBinding.inflate(layoutInflater)
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
        val textInputLayoutCategory: TextInputLayout = binding.textInputLayoutCategory

        val categoryViewModel: CategoryViewModel by viewModels {
            CategoryViewModelFactory((applicationContext as TengesaniApp).categoryRepository)
        }


        btnSave.setOnClickListener {
            if (textInputLayoutCategory.editText?.text.toString() != ""){
                val category = Category(
                    textInputLayoutCategory.editText?.text.toString(),
                    LocalDate.now().toString()
                )
                val dialog: AlertDialog = SpotsDialog.Builder().setContext(application).build()

                dialog.show()

                categoryViewModel.recordCategory(category)
                //Todo show saving dialog and finish activity
            }
            else{
                textInputLayoutCategory.editText?.error = "Category cannot be blank!"
            }
        }
    }
}