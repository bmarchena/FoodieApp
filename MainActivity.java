package com.example.bryanmarchena.foodieapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MealItem> mealItems;
    private TypedArray mealImageResources;
    private MealItemAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        mealItems = new ArrayList<>();


        adapter = new MealItemAdapter(this, mealItems);
        recyclerView.setAdapter(adapter);


        initializeList();


    }


    private void initializeList(){
        String[] mealList = getResources().getStringArray(R.array.meal_titles);
        String[] mealDesc = getResources().getStringArray(R.array.meal_desc);


        mealImageResources = getResources().obtainTypedArray(R.array.meal_images);


        mealItems.clear();

        for(int i=0;i<mealList.length;i++){
            mealItems.add(new MealItem(mealList[i],mealDesc[i],mealImageResources.getResourceId(i,0)));
        }

        adapter.notifyDataSetChanged();

    }

    public void launchAddItem(View view) {
        Intent launchAddItem = new Intent(this, AddItemActivity.class);
        startActivityForResult(launchAddItem, 99);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==99 && resultCode == RESULT_OK){
            //Intent intent = getIntent();
            String foodTitle = data.getExtras().getString("foodName");
            String foodDesc = data.getExtras().getString("foodDesc");
            String ingredients = data.getExtras().getString("ingredients");
            int calories = data.getExtras().getInt("calories");
            String recipe = data.getExtras().getString("recipeUrl");

            int def_Image = 7;
            int imageID = mealImageResources.getResourceId(def_Image, 0);
            MealItem customItem = new MealItem(foodTitle, foodDesc, imageID, ingredients, calories, recipe);

            mealItems.add(customItem);

            adapter.notifyDataSetChanged();

        }
    }
}



