package com.example.demomelon.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demomelon.R;
import com.example.demomelon.model.entity.Actores;
import com.example.demomelon.view.fragments.ActoresFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ActoresAdaptador extends RecyclerView.Adapter<ActoresAdaptador.myViewHolder>  {
    private ActoresFragment actoresFragment;
    private  List<Actores> actoresList;

    public ActoresAdaptador(ActoresFragment actoresFragment, List<Actores> actoresList) {
        this.actoresFragment = actoresFragment;
        this.actoresList = actoresList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_actores,viewGroup,false);

        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int i) {
        Actores actores=actoresList.get(i);

        holder.nombre.setText(actores.getName());
        holder.rol.setText(actores.getRole());

        Picasso.get().load("https://www.thetvdb.com/banners/"+actores.getImage()).
                error(R.drawable.mediomelon_banner).fit().centerInside()
                .into(holder.imagebanner);
    }

    @Override
    public int getItemCount() {
        return actoresList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView imagebanner;

        TextView nombre;

        TextView rol;

        public myViewHolder(View itemView) {
            super(itemView);
            imagebanner = itemView.findViewById(R.id.imgActores);
            nombre = itemView.findViewById(R.id.textViewActores);
            rol = itemView.findViewById(R.id.roles);

        }
    }
}
