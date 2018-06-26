package com.almaralengineering.pokedex;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StatsFragment extends Fragment {

    private static final String POKEMON_STATS = "pokemon_stats";

    private OnFragmentInteractionListener mListener;

    public StatsFragment() {
        // Required empty public constructor
    }

    // le vamos a psar las estadisticas del pokemon al StatsFragment usando el newInstance.
    public static StatsFragment newInstance(Stats pokemonStats) {
        StatsFragment fragment = new StatsFragment();
        Bundle args = new Bundle(); //bundle creado por newInstance. Funciona similar al bundle de los Intents.
        //*Acordarse: para poner datos en un bundle o un intent, si es un objeto o clase que se esta pasando debe estar parceado (en este caso Stats).
        //si se esta pasando datos primitivos, no es necesario q se parcee (como es el caso de FragmentDetail!).
        args.putParcelable(POKEMON_STATS, pokemonStats);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflar el layout de este fragment
        View view =  inflater.inflate(R.layout.fragment_stats, container, false);

        //crear views para este Fragment (StatsFragment)
        TextView hpTextView = (TextView) view.findViewById(R.id.fragment_stats_hp);
        TextView attackTextView = (TextView) view.findViewById(R.id.fragment_stats_attack);
        TextView defenseTextView = (TextView) view.findViewById(R.id.fragment_stats_defense);
        TextView speedTextView = (TextView) view.findViewById(R.id.fragment_stats_speed);

        //si los argumentos tienen datos
        if(getArguments() != null){
            Stats pokemonStats = getArguments().getParcelable(POKEMON_STATS); //obtener los datos de los stats

            //asignar datos de los stats a los view!
            hpTextView.setText(pokemonStats.getHp());
            attackTextView.setText(pokemonStats.getAttack());
            defenseTextView.setText(pokemonStats.getDefense());
            speedTextView.setText(pokemonStats.getSpeed());
        }

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
