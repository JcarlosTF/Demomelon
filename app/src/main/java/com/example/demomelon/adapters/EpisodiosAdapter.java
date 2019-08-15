package com.example.demomelon.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demomelon.model.entity.Episodios;
import com.example.demomelon.R;
import com.example.demomelon.view.fragments.EpisodiosFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EpisodiosAdapter extends RecyclerView.Adapter<EpisodiosAdapter.myViewHolder>  {
    private EpisodiosFragment episodiosFragment;
    private  List<Episodios> episodiosList;

    public EpisodiosAdapter(EpisodiosFragment episodiosFragment, List<Episodios> episodiosList) {
        this.episodiosFragment = episodiosFragment;
        this.episodiosList = episodiosList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_episodios,viewGroup,false);

        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int i) {
        Episodios episodios=episodiosList.get(i);

        holder.titulo.setText(episodios.getEpisodeName());
        holder.descripcion.setText(episodios.getOverview());
        holder.calificacion.setText(episodios.getSiteRating());
        holder.fecha.setText(episodios.getFirstAired());

        Picasso.get().load("https://www.thetvdb.com/banners/"+episodios.getFilename()).
                error(R.drawable.mediomelon_banner).fit().centerInside()
                .into(holder.imagebanner);
    }

    @Override
    public int getItemCount() {
        return episodiosList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView imagebanner;

        TextView titulo;

        TextView descripcion;

        TextView fecha;

        TextView calificacion;

        public myViewHolder(View itemView) {
            super(itemView);
            imagebanner = itemView.findViewById(R.id.imageViewEpisodios);
            titulo = itemView.findViewById(R.id.Titulo);
            descripcion = itemView.findViewById(R.id.Descripcion);
            fecha = itemView.findViewById(R.id.fecha1);
            calificacion = itemView.findViewById(R.id.Calificacionum);
        }
    }
}
