package com.example.tp3recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.tp3recyclerview.databinding.SegundaActivityBinding;


public class Segunda_Activity extends AppCompatActivity {
    private SegundaActivityBinding segundabinding;
    private SegundaActivityViewModel vmSegunda;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        segundabinding = SegundaActivityBinding.inflate(getLayoutInflater());
        setContentView(segundabinding.getRoot());
        vmSegunda = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create
                (SegundaActivityViewModel.class);
        vmSegunda.getMutablePeli().observe(this, new Observer<Pelicula>() {
            @Override
            public void onChanged(Pelicula pelicula) {
                TextView titulo = segundabinding.tituloSegunda;
                TextView descripcion = segundabinding.descripcionSegunda;
                TextView director = segundabinding.directorSegunda;
                TextView actores = segundabinding.actoresSegunda;
                ImageView imgSegunda = segundabinding.imgSegunda;


                titulo.setText(pelicula.getTitulo());
                descripcion.setText(pelicula.getDescripcion());
                director.setText(pelicula.getDirector());
                actores.setText(pelicula.getActores());
                imgSegunda.setImageResource(pelicula.getFoto());
            }
        });
        vmSegunda.recuperarPelicula(getIntent());
        Button btnVolver = segundabinding.btnVolver;
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Segunda_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
