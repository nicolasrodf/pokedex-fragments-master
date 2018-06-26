package com.almaralengineering.pokedex;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class DetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String POKEMON_IMAGE_URL = "pokemon_image_url";
    private static final String POKEMON_SOUND_ID = "pokemon_sound_id";

    private ImageView detailImageView; //global pq se usa en mas de un metodo

    private OnFragmentInteractionListener mListener;

    public DetailFragment() {
        // Required empty public constructor
    }


    //pasamos el url del pokemon y el sonido a traves del newInstance.
    public static DetailFragment newInstance(String pokemonImageUrl, int pokemonSoundId) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        //no es necesario parcer. ver motivo en StatsFragment.
        args.putString(POKEMON_IMAGE_URL, pokemonImageUrl);
        args.putInt(POKEMON_SOUND_ID, pokemonSoundId);
        fragment.setArguments(args);
        return fragment;
    }

    /*Importante: cuando se pasa info a traves del newInstance, onCreate() lo borramos. Usamos onCreateView!*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //hacemos lo mimos q en StatsFragment para setear los datos de url y sonido a los views
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        detailImageView = (ImageView) view.findViewById(R.id.pokemon_detail_imageView);

        //si los argumentos tienen datos
        if(getArguments() != null){
            //obtener url y sonido
            String pokemonImageUrl = getArguments().getString(POKEMON_IMAGE_URL);
            int pokemonSoundId = getArguments().getInt(POKEMON_SOUND_ID);

            //llamar al metodo correspondiente para ejecutar sonido y cargar imagen.
            setPokemonImage(pokemonImageUrl);
            playPokemonSound(pokemonSoundId);
        }

        return view;
    }

    /*ESTOS METODOS SE PASAN A PRIVADOS PQ AHORA SE LLAMAN DESDE EL ONCREATEVIEW, NO DESDE EL MAINACTIVITY*/
    private void setPokemonImage (String pokemonImageUrl){
//        detailImageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), pokemonImageId));
        Picasso.with(getActivity()).load(pokemonImageUrl).into(detailImageView);

    }

    private void playPokemonSound(int pokemonSoundId){
        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), pokemonSoundId); //getAciivity es el contexto!
        mediaPlayer.start();
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
