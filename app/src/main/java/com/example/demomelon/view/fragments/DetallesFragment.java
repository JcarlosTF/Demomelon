package com.example.demomelon.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.demomelon.interfaces.IDetalles;
import com.example.demomelon.R;
import com.example.demomelon.presenter.DetatailsPresenter;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetallesFragment extends Fragment implements IDetalles.DetallesView{
   private IDetalles.DetallesPresenter presenter;
    TextView Genero,PrimeraEdicion,Horario,Temporadas,Calificacion,Descripcion,dia;
    ImageView imageView;
    private ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_detalles, container, false);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBarDetalles);

        Genero=(TextView)view.findViewById(R.id.Genero);
        PrimeraEdicion=(TextView)view.findViewById(R.id.PrimeraEdicion);
        Horario=(TextView)view.findViewById(R.id.Horario);
        Temporadas=(TextView)view.findViewById(R.id.Temporadas);
        Calificacion=(TextView)view.findViewById(R.id.Calificacion);
        Descripcion=(TextView)view.findViewById(R.id.Descripcion);
        dia=(TextView)view.findViewById(R.id.Dia);
        imageView=(ImageView)view.findViewById(R.id.imageView2);

        presenter=new DetatailsPresenter(this);

        presenter.getDetalles(getContext());
        return view;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showDetalles(String getAirsDayOfWeek, String getAirsTime, String getFirstAired, String getOverview) {
        PrimeraEdicion.setText(getFirstAired);
        Horario.setText(getAirsTime);
        dia.setText(getAirsDayOfWeek);
        Descripcion.setText(getOverview);
    }

    @Override
    public void showDetallesDos(String getGenre, String getImdbRating, String getPoster, String getTotalSeasons) {
        Genero.setText(getGenre);
        Calificacion.setText(getImdbRating);
        Temporadas.setText(getTotalSeasons);
        Picasso.get().load(getPoster).
                error(R.drawable.mediomelon_banner).fit().centerInside()
                .into(imageView);
    }
}
