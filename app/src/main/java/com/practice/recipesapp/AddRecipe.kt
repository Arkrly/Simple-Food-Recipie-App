package com.practice.recipesapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddRecipe : AppCompatActivity() {

    private lateinit var etTitle: EditText
    private lateinit var etDescription: EditText
    private lateinit var etIngredients: EditText
    private lateinit var etImageUrl: EditText
    private lateinit var etCategory: EditText
    private lateinit var btnAddRecipe: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        etTitle = findViewById(R.id.etTitle)
        etDescription = findViewById(R.id.etDescription)
        etIngredients = findViewById(R.id.etIngredients)
        etImageUrl = findViewById(R.id.etImageUrl)
        etCategory = findViewById(R.id.etCategory)
        btnAddRecipe = findViewById(R.id.btnAddRecipe)

        btnAddRecipe.setOnClickListener {
            val title = etTitle.text.toString()
            val description = etDescription.text.toString()
            val ingredients = etIngredients.text.toString()
            val imageUrl = etImageUrl.text.toString()
            val category = etCategory.text.toString()

            val recipe = Recipe(title, description, ingredients, imageUrl, category)

            lifecycleScope.launch(Dispatchers.IO) {
                AppDatabase.getInstance(applicationContext).getDao().insert(recipe)
                finish()
            }
        }
    }
}