package com.example.tp3recyclerview;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class SegundaActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Pelicula> mutablePeli;

    public LiveData<Pelicula> getMutablePeli() {
        if(mutablePeli==null){
            mutablePeli = new MutableLiveData<>();
        }
        return mutablePeli;
    }

    public SegundaActivityViewModel(@NonNull Application application) {
        super(application);
    }
    public void recuperarPelicula(Intent intent){
        Pelicula pelicula  = (Pelicula)intent.getSerializableExtra("pelicula", Pelicula.class);
        if(pelicula != null){
            mutablePeli.setValue(pelicula);


        }
    }
}
