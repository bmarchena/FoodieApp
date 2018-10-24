package com.example.bryanmarchena.foodieapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DisplayItemInfo extends AppCompatActivity {

    private TextView mealTitle;
    private ImageView mealImage;
    private TextView mealDesc;
    private int index;
    private TextView mealCalories;
    private TextView mealIngredients;
    private TextView mealRecipes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item_info);

        mealTitle = (TextView)findViewById(R.id.expandMeal_title);
        mealImage = (ImageView)findViewById(R.id.expandMeal_image);
        mealDesc = (TextView)findViewById(R.id.expandMeal_desc);
        mealCalories = (TextView)findViewById(R.id.expandMeal_calories);
        mealIngredients = (TextView)findViewById(R.id.expandMeal_ingredients);
        mealRecipes = (TextView)findViewById(R.id.expandMeal_recipe);


        Intent intent = getIntent();
        String meal_Title = intent.getExtras().getString("MealTitle");
        String meal_Desc = intent.getExtras().getString("MealDesc");
        //pass
        String meal_Ing = intent.getExtras().getString("MealIng");
        String meal_cal = String.valueOf(intent.getExtras().getInt("MealCal")) + " cal.";
        String meal_rec = intent.getExtras().getString("MealRec");

        int meal_Image = intent.getExtras().getInt("MealImage");
        index = intent.getExtras().getInt("MealIndex");

        if(meal_Ing==null){addExtraData(index);}

        else{
            mealCalories.setText(meal_cal);
            mealRecipes.setText(meal_rec);
            mealIngredients.setText(meal_Ing);}

        mealTitle.setText(meal_Title);
        Glide.with(this).load(meal_Image).into(mealImage);
        mealDesc.setText(meal_Desc);

    }

    public void addExtraData(int index){
        String[] mealCalList = getResources().getStringArray(R.array.meal_calories);
        String[] mealRecList = getResources().getStringArray(R.array.meal_recipes);
        String[] mealIngList = getResources().getStringArray(R.array.meal_ingredients);


        mealCalories.setText(mealCalList[index]);
        mealRecipes.setText(mealRecList[index]);
        mealIngredients.setText(mealIngList[index]);


    }

    public void openRecipe(View view) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW);
        webIntent.setData(Uri.parse(mealRecipes.getText().toString()));
        startActivity(webIntent);

    }
}
