package com.example.bryanmarchena.foodieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {


    private EditText foodName_view;
    private EditText foodDesc_view;
    private EditText ingredients_view;
    private EditText calories_view;
    private EditText recipeUrl_view;


    private String foodName;
    private String foodDesc;
    private String ingredients;
    private int calories;
    private String recipeUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        foodName_view = (EditText) findViewById(R.id.foodName_editText);
        foodDesc_view = (EditText) findViewById(R.id.foodDesc_editText);
        ingredients_view = (EditText) findViewById(R.id.ingredients_editText);
        calories_view = (EditText) findViewById(R.id.calories_editText);
        recipeUrl_view = (EditText) findViewById(R.id.recipe_editText);


    }


    public void createNewItem(View view) {
        foodName = foodName_view.getText().toString();
        foodDesc = foodDesc_view.getText().toString();
        ingredients = ingredients_view.getText().toString();
        calories = Integer.parseInt(calories_view.getText().toString());
        recipeUrl = recipeUrl_view.getText().toString();

        Intent passBack = new Intent();
        passBack.putExtra("foodName", foodName);
        passBack.putExtra("foodDesc", foodDesc);
        passBack.putExtra("ingredients", ingredients);
        passBack.putExtra("calories",calories);
        passBack.putExtra("recipeUrl", recipeUrl);

        setResult(RESULT_OK, passBack);
        finish();

    }





}