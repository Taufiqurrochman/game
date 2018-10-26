package com.example.seven.utsandro;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<Game> dataGlobal;

    public Adapter(Context context, List<Game> data) {
        this.context = context;
        dataGlobal = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(mview);
        //untuk mengeset layout yang digunakan
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //mengeset masing views
        Game game = dataGlobal.get(position);
        final int id = game.getID();
        holder.textNama.setText(game.getNama());
        holder.textGenre.setText(game.getGenre());
        holder.textRating.setText(game.getRating());
        holder.textDeveloper.setText(game.getDeveloper());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context.getApplicationContext(), ViewGame.class);
                i.putExtra("id",id);
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataGlobal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView textNama, textGenre, textRating, textDeveloper;
        RelativeLayout relativeLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image);
            textNama = itemView.findViewById(R.id.namagame);
            textGenre = itemView.findViewById(R.id.genregame);
            textRating = itemView.findViewById(R.id.rating);
            textDeveloper = itemView.findViewById(R.id.developer);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
        }
    }
}