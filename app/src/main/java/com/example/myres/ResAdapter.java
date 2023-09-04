package com.example.myres;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ResAdapter extends RecyclerView.Adapter<ResAdapter.ViewHolder> {

    ArrayList<Res> allRes;

    public ResAdapter(ArrayList<Res> allRes) {
        this.allRes = allRes;
    }

    @NonNull
    @Override
    public ResAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.res_view_mini, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResAdapter.ViewHolder holder, int position) {
        Res res = allRes.get(position);

        holder.resName.setText(res.getResName());
        holder.resRating.setText(String.valueOf(res.getResRating()));
        holder.resLocation.setText(res.getResLocation());
        int dist= res.getResDistance()/100;
        String distance = String.valueOf(dist) + "kms from University";
        holder.resDistance.setText(distance);
        String rent = "R" + String.valueOf(res.getMonthlyRent());
        holder.monthlyRent.setText(rent);

        holder.resType.setText(String.valueOf(res.getAmenities().get(0)));
        holder.resAmenity2.setText(String.valueOf(res.getAmenities().get(1)));
        holder.resAmenity3.setText(String.valueOf(res.getAmenities().get(2)));

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(String.valueOf(res.getResImages().get(1)), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.resImage);

        holder.resViewMini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toResViewFull = new Intent(holder.itemView.getContext(), resFullViewActivity.class);
                view.getContext().startActivity(toResViewFull);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allRes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView resName, resRating, resLocation, resType, resAmenity2, resDistance, monthlyRent, resAmenity3;
        ImageView resImage;

        CardView resViewMini;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            resName = itemView.findViewById(R.id.resName);
            resImage = itemView.findViewById(R.id.resImage);
            resRating = itemView.findViewById(R.id.resRating);
            resLocation = itemView.findViewById(R.id.resLocation);
            monthlyRent = itemView.findViewById(R.id.monthlyRent);
//            amenity list
            resType = itemView.findViewById(R.id.resType);
            resDistance = itemView.findViewById(R.id.resDistance);
            resAmenity2 = itemView.findViewById(R.id.resAmenity2);
            resAmenity3 = itemView.findViewById(R.id.resAmenity3);

            resViewMini = itemView.findViewById(R.id.resViewMini);
        }
    }
}
