package com.example.tp3recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolderPeli> {
    private List<Pelicula> listaDePeliculas;
    private Context context;

    private LayoutInflater li;

    public PeliculaAdapter(List<Pelicula> listaDePeliculas, Context context, LayoutInflater li) {
        this.listaDePeliculas = listaDePeliculas;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderPeli onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=li.inflate(R.layout.item,parent,false);
        return new ViewHolderPeli(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPeli holder, int position) {

        Pelicula pelicula=listaDePeliculas.get(position);
        holder.titulo.setText(pelicula.getTitulo());
        holder.descripcion.setText(pelicula.getDescripcion());
        holder.foto.setImageResource(pelicula.getFoto());

        holder.btnDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Segunda_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("pelicula", pelicula);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listaDePeliculas.size();
    }

    public class ViewHolderPeli extends RecyclerView.ViewHolder{

        TextView titulo, actores, director, descripcion;
        ImageView foto;

        Button btnDetalles;

        public ViewHolderPeli(@NonNull View itemView) {
            super(itemView);
            titulo  =itemView.findViewById(R.id.titulo);
            descripcion=itemView.findViewById(R.id.descripcion);
            foto=itemView.findViewById(R.id.foto);
            btnDetalles= itemView.findViewById(R.id.detalles);

        }
    }
}
