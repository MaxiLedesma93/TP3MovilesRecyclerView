package com.example.tp3recyclerview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainAcitivityViewModel extends AndroidViewModel {
    private MutableLiveData<List<Pelicula>> mutableLista;
    public MainAcitivityViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<List<Pelicula>> getMutableLista(){
        if (mutableLista == null) {
            mutableLista = new MutableLiveData<>();
        }
        return mutableLista;
    }

    public void crearLista(){
        ArrayList<Pelicula> lista= new ArrayList<>();
        lista.add(new Pelicula("Godzilla y Kong: el nuevo imperio","Una aventura cinematográfica completamente nueva,"+
                " que enfrentará al todopoderoso Kongy al temible Godzilla contra una colosal " +
                "amenaza desconocida escondida dentro de nuestro mundo. La nueva y épica película " +
                "profundizará en las historias de estos titanes, sus orígenes y los misterios de " +
                "Isla Calavera y más allá, mientras descubre la batalla mítica que ayudó a forjar" +
                "a estos seres extraordinarios y los unió a la humanidad para siempre.",R.drawable.gozillakong,
                "Adam Wingard", " Dan Stevens, Rebecca Hall, Brian Tyree Henry, Kaylee Hottle, Fala Chen," +
                " Alex Ferns y Rachel House"));
        lista.add(new Pelicula("Kung fu Panda 4","Po se está preparando para convertirse en el líder" +
                " espiritual de su Valle de la Paz pero también necesita a alguien que ocupe su lugar" +
                " como Guerrero Dragón. Como tal, entrenará a un nuevo practicante de kung fu para " +
                "el lugar y se encontrará con un villano llamado Camaleón que evoca villanos del " +
                "pasado.",R.drawable.kungfupanda,"Mike Mitchell"," Jack Black, Awkwafina, Viola Davis, Dustin Hoffman" +
                " James Hong, Bryan Cranston, Ian McShane, Ke Huy Quan, Angelina Jolie"));
        lista.add(new Pelicula("Oppenheimer","Película sobre el físico J. Robert Oppenheimer y su " +
                "papel como desarrollador de la bomba atómica.",R.drawable.oppenheimer,"Christopher Nolan",
                "Cillian Murphy, Emily Blunt, Matt Damon"));
        lista.add(new Pelicula("Gotti","Biopic del famoso mafioso estadounidense John Gotti," +
                " jefe de la familia Gambino, una de las más importantes del crimen organizado " +
                "en la Norteamérica del siglo XX.",R.drawable.gotti,"Kevin Connolly","John Travolta,"+
                "Kelly Preston, Pruitt Taylor Vince"));
        lista.add(new Pelicula("Avengers: La era de Ultron","Los Vengadores se reúnen de nuevo y " +
                "juntan sus fuerzas con las de los recién llegados Quicksilver y Bruja Escarlata " +
                "para luchar contra un robot maquiavélico llamado Ultrón, el cual Tony Stark creó " +
                "con el fin de defender la paz, pero resultó defectuoso y ahora pretende exterminar" +
                " a toda la humanidad.",R.drawable.avengersultron,"Joss Whedon"," Robert Downey Jr.," +
                "Chris Evans, Mark Ruffalo, Chris Hemsworth, Scarlett Johansson"));
        lista.add(new Pelicula("Avengers: Endgame","Los Vengadores restantes deben encontrar una " +
                "manera de recuperar a sus aliados para un enfrentamiento épico con Thanos, el " +
                "malvado que diezmó el planeta y el universo.",R.drawable.avengersendgame,"Anthony " +
                "Russo Y Joe Russo "," Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth" +
                ", Scarlett Johansson"));
        mutableLista.setValue(lista);



    }
}

