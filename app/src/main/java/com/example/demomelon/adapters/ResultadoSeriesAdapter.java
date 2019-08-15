package com.example.demomelon.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demomelon.R;
import com.example.demomelon.model.entity.Series;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ResultadoSeriesAdapter extends RecyclerView.Adapter<ResultadoSeriesAdapter.ViewHolder>  {
    private List<Series> seriesList;
    private int layout;
    private OnItemClicListener listener;


    public ResultadoSeriesAdapter(List<Series> seriesList, int layout, OnItemClicListener listener) {
        this.seriesList = seriesList;
        this.layout = layout;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ResultadoSeriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(layout,viewGroup,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ResultadoSeriesAdapter.ViewHolder viewHolder, int i) {
        Series series=seriesList.get(i);

       viewHolder.name.setText(series.getSeriesName());

        Picasso.get().load("https://www.thetvdb.com/banners/"+series.getBanner()).
                error(R.drawable.mediomelon_banner).fit().centerInside()
                .into(viewHolder.banner);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(String.valueOf(viewHolder.name),viewHolder.getAdapterPosition());
            }
        });

    }
    @Override
    public int getItemCount() {
        return seriesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageView banner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name=(TextView) itemView.findViewById(R.id.tituloSerie);
            this.banner=(ImageView)itemView.findViewById(R.id.imgBanner);
        }
    }

    public interface OnItemClicListener{
        void onItemClick(String name,int position);
    }
}
