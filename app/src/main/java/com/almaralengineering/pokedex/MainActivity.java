package com.almaralengineering.pokedex;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//estamos implementar el metodo de la interfaz del fragment q nos pide android.
//implements.. OnFrag... -> click derecho "implements methods"
public class MainActivity extends AppCompatActivity implements PokemonListFragment.OnFragmentInteractionListener,
        DetailFragment.OnFragmentInteractionListener, StatsFragment.OnFragmentInteractionListener,
        View.OnClickListener {

    private static final int OPTION_DETAIL = 0;
    private static final int OPTION_STATS = 1;

    private TextView imageTextView;
    private TextView statsTextView;

    private Pokemon selectedPokemon; //para establecer pokemon seleccionado en onPokemonSelected
    private int selectedOption; //apra cambiar su valor en onClick
    private Fragment currentFragment; //para asignar el fragment elegido en el setFragmentAndContent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageTextView = (TextView) findViewById(R.id.activity_main_imagen_option_textView);
        statsTextView = (TextView) findViewById(R.id.activity_main_stats_option_textView);

        imageTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.display_option_selected));
        statsTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.display_option_not_selected));

        //hacerlos actuar como un boton.
        imageTextView.setOnClickListener(this);
        statsTextView.setOnClickListener(this);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //esta funcion no se usa pero debemos dejarla. Se creó implementando desde la clase main.
    }

    //funciona trayendo los datos desed el fragment al mainactivity
    //este sirve para el OnCreateView del PokemonListFragment.
    @Override
    public void onPokemonSelected(Pokemon pokemon) {

        selectedPokemon = pokemon; //segun PokekmonListFragment variable pokemon contiene el pokemon presionado de la lista.

        setFragmentAndContent(); //setear el fragment de acuerdo al pokemon elegido.

//        //creamos el detailfragment (es casi lo mismo para un view normal)
//        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
//
//        detailFragment.setPokemonImage(pokemon.getImageUrl());
//        detailFragment.playPokemonSound(pokemon.getSoundId());
    }


    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        //segun se presione cual boton, se asigna un color de fondo.
        switch (viewId){
            case R.id.activity_main_imagen_option_textView:
                imageTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.display_option_selected));
                statsTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.display_option_not_selected));
                selectedOption = OPTION_DETAIL;
                break;
            case R.id.activity_main_stats_option_textView:
                imageTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.display_option_not_selected));
                statsTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.display_option_selected));
                selectedOption = OPTION_STATS;
                break;
        }

        setFragmentAndContent();
    }

    //analizar bien esta parte!!!!

    //setear el tipo de fragment (DetailFragment o StatsFragment) al container (framelayout del activitymain)
    private void setFragmentAndContent(){
        if (selectedPokemon != null){
            if (selectedOption == OPTION_DETAIL){
                currentFragment = DetailFragment.newInstance(selectedPokemon.getImageUrl(), selectedPokemon.getSoundId());
            } else if (selectedOption == OPTION_STATS){
                currentFragment = StatsFragment.newInstance(selectedPokemon.getStats());
            }

            //reemplazar fragments en el contenedor
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.detail_fragment_container, currentFragment);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "Debes seleccionar un pokemon primero", Toast.LENGTH_SHORT).show();
        }
    }
}
