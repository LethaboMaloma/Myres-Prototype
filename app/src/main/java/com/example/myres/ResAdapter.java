package com.example.myres;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.resDistance.setText(res.getResDistance());
    }

    @Override
    public int getItemCount() {
        return allRes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView resName, resRating, resLocation, resType, resWifi, resDistance, monthlyRent;
        ImageView resImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            resName = itemView.findViewById(R.id.resName);
            resImage = itemView.findViewById(R.id.resImage);
            resRating = itemView.findViewById(R.id.resRating);
            resLocation = itemView.findViewById(R.id.resLocation);
            resType = itemView.findViewById(R.id.resType);
            resWifi = itemView.findViewById(R.id.resWifi);
            resDistance = itemView.findViewById(R.id.resDistance);
            monthlyRent = itemView.findViewById(R.id.monthlyRent);
        }
    }
}
