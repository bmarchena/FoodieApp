package com.example.bryanmarchena.foodieapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MealItemAdapter extends RecyclerView.Adapter<MealItemAdapter.ViewHolder> {
    private ArrayList<MealItem> mealItems;
    private Context context;

    public MealItemAdapter(Context context, ArrayList<MealItem> mealItems) {
        this.mealItems = mealItems;
        this.context = context;

    }


    @Override
    public MealItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.meal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final MealItemAdapter.ViewHolder holder, final int position) {
        final MealItem currentMealItem = mealItems.get(position);
        Glide.with(context).load(currentMealItem.getMealImage()).into(holder.mealImage);
        holder.bindTo(currentMealItem);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent expandMeal = new Intent(context, DisplayItemInfo.class);
                expandMeal.putExtra("MealImage", currentMealItem.getMealImage());
                expandMeal.putExtra("MealTitle", currentMealItem.getMealTitle());
                expandMeal.putExtra("MealDesc", currentMealItem.getMealDesc());
                expandMeal.putExtra("MealIndex", position);


                expandMeal.putExtra("MealIng", currentMealItem.getMealIng());
                expandMeal.putExtra("MealCal",currentMealItem.getMealCal());
                expandMeal.putExtra("MealRec",currentMealItem.getMealRec());

                context.startActivity(expandMeal);

            }
        });

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(R.string.alertDialog_title);
                builder.setMessage(R.string.alertDialog_message);
                builder.setNegativeButton(R.string.alertDialog_neg, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton(R.string.alertDialog_pos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mealItems.remove(holder.getAdapterPosition());
                        MealItemAdapter.this.notifyItemRemoved(holder.getAdapterPosition());
                    }
                });
                AlertDialog warning = builder.create();
                warning.show();
                return false;
            }
        });



    }



    @Override
    public int getItemCount() {
        return mealItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mealTitleText;
        private TextView mealDescText;
        private ImageView mealImage;
        private CardView cardView;

        ViewHolder(View itemView) {
            super(itemView);

            mealTitleText = (TextView) itemView.findViewById(R.id.meal_title);
            mealDescText = (TextView) itemView.findViewById(R.id.meal_desc);
            mealImage = (ImageView) itemView.findViewById(R.id.meal_image);
            cardView = (CardView) itemView.findViewById(R.id.card_view);

        }



        void bindTo(MealItem currentMeal) {
            mealTitleText.setText(currentMeal.getMealTitle());
            mealDescText.setText(currentMeal.getMealDesc());
        }

    }

}
