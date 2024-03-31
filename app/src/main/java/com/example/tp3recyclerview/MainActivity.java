package com.example.tp3recyclerview;

import android.os.Bundle;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp3recyclerview.databinding.ActivityMainBinding;

import java.util.List;

import kotlinx.coroutines.MainCoroutineDispatcher;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainAcitivityViewModel vmMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vmMain= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainAcitivityViewModel.class);
        vmMain.getMutableLista().observe(this, new Observer<List<Pelicula>>() {
            @Override
            public void onChanged(List<Pelicula> peliculas) {
                PeliculaAdapter peliAdapter = new PeliculaAdapter(peliculas, MainActivity.this, getLayoutInflater());
                GridLayoutManager gridLayout = new GridLayoutManager(MainActivity.this,2, GridLayoutManager.VERTICAL, false);
                RecyclerView rc = binding.miLista;
                rc.setLayoutManager(gridLayout);
                rc.setAdapter(peliAdapter);
            }
        });
        vmMain.crearLista();

    }
}