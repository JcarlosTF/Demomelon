package com.example.demomelon.adapters;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demomelon.R;

import java.util.List;

public class TemporadasAdapter extends RecyclerView.Adapter<TemporadasAdapter.ViewHolder>  {
        private int layout;
        private OnItemClicListener listener;
        int row_index=-1;
        int valor;
        private List<Item>items;

    public TemporadasAdapter(List<Item>items, int layout, OnItemClicListener listener) {
            this.items = items;
            this.layout = layout;
            this.listener = listener;
        }

        @NonNull
        @Override
        public TemporadasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v= LayoutInflater.from(viewGroup.getContext()).inflate(layout,viewGroup,false);
            TemporadasAdapter.ViewHolder vh=new TemporadasAdapter.ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull final TemporadasAdapter.ViewHolder viewHolder, int i) {
            viewHolder.name.setText(items.get(i).getName());

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(String.valueOf(viewHolder.name),viewHolder.getAdapterPosition());
                    row_index=viewHolder.getAdapterPosition();
                    valor=viewHolder.getAdapterPosition();
                    notifyDataSetChanged();
                }
            });

            int index=row_index;
            int position= viewHolder.getAdapterPosition();

            if (index==position){
                viewHolder.cardView.setCardBackgroundColor(Color.GREEN);
            } else{
                viewHolder.cardView.setCardBackgroundColor(Color.RED);
            }
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder{
            private TextView name;
            private CardView cardView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                this.name= itemView.findViewById(R.id.textViewBotones);
                this.cardView= itemView.findViewById(R.id.cardView3);

            }
        }

        public interface OnItemClicListener{
            void onItemClick(String name,int position);
        }
    }
