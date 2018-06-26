package com.almaralengineering.pokedex;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PokemonListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PokemonListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

/*UN FRAGMENT SE CREA DESDE EL PAQUETE, TAL COMO UNA CLASE, PERO ES UN FRAGMENT (NEW --> FRAMENT-->BLANK FRAGMENT */
/*EL FRAGMENT CONTIENE EL LIST VIEW, EN VEZ DEL ACITITYV MAIN*/
public class PokemonListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PokemonListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PokemonListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PokemonListFragment newInstance(String param1, String param2) {
        PokemonListFragment fragment = new PokemonListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //AL IGUAL Q EN LOS ADAPTERS, EN LOS FRAGMENTS ES NECESARIO INFLAR LIST VIEW CON UN VIEW
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);

        //se crea el listview , (el q antes e creaba en el main)
        ListView pokemonListView = (ListView) view.findViewById(R.id.pokemon_listView);


        //se crea arrylist de pokemon de tipos Pokemon.
        ArrayList<Pokemon> pokemonList = new ArrayList<>();

        //crear stats de c/pokemon
        Stats bulbasaurStats = new Stats("45", "49", "49", "65");
        Stats ivysaurStats = new Stats("60", "62", "63", "80");
        Stats venusaurStats = new Stats("80", "82", "83", "100");
        Stats charmanderStats = new Stats("39", "52", "43", "50");
        Stats charmeleonStats = new Stats("58", "64", "58", "65");
        Stats charizardStats = new Stats("78", "84", "78", "85");
        Stats squirtleStats = new Stats("44", "48", "65", "64");
        Stats wartortleStats = new Stats("59", "63", "80", "80");
        Stats blastoiseStats = new Stats("79", "83", "100", "105");
        Stats pikachuStats = new Stats("35", "55", "40", "50");
        Stats raichuStats = new Stats("60", "85", "50", "85");

        //agrergar datos manualmente. Los stats lo hemos podido agregar pq hemops modificado el constructor de clase Pokemon!
        pokemonList.add(new Pokemon("1", "Bulbasaur",
                "http://cdn.bulbagarden.net/upload/thumb/1/19/Ash_Bulbasaur.png/245px-Ash_Bulbasaur.png", R.raw.bulbasaur,
                Pokemon.Type.PLANT, bulbasaurStats));
        pokemonList.add(new Pokemon("2", "Ivysaur",
                "http://vignette1.wikia.nocookie.net/es.pokemon/images/3/3a/EP893_Ivysaur_de_Xana_(2).png", R.raw.ivysaur,
                Pokemon.Type.PLANT, ivysaurStats));
        pokemonList.add(new Pokemon("3", "Venusaur",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLSs5Ea4g_Yi2UjsdB18KWWa1PN-DGIOrnKvNloqPG4wZq01hc", R.raw.venusaur,
                Pokemon.Type.PLANT, venusaurStats));
        pokemonList.add(new Pokemon("4", "Charmander",
                "http://cdn.bulbagarden.net/upload/thumb/7/75/Red_Charmander_PO.png/250px-Red_Charmander_PO.png", R.raw.charmander,
                Pokemon.Type.FIRE, charmanderStats));
        pokemonList.add(new Pokemon("5", "Charmeleon",
                "http://vignette2.wikia.nocookie.net/es.pokemon/images/6/66/EP778_Charmeleon_de_Ash.png", R.raw.charmeleon,
                Pokemon.Type.FIRE, charmeleonStats));
        pokemonList.add(new Pokemon("6", "Charizard",
                "http://vignette2.wikia.nocookie.net/es.pokemon/images/e/e7/SME02_Charizard_de_Alain.png", R.raw.charizard,
                Pokemon.Type.FIRE, charizardStats));
        pokemonList.add(new Pokemon("7", "Squirtle",
                "http://cdn.bulbagarden.net/upload/thumb/8/8c/Tierno_Squirtle.png/250px-Tierno_Squirtle.png", R.raw.squirtle,
                Pokemon.Type.WATER, squirtleStats));
        pokemonList.add(new Pokemon("8", "Wartortle",
                "http://vignette1.wikia.nocookie.net/es.pokemon/images/c/c1/EP869_Wartortle_de_Benigno.png", R.raw.wartortle,
                Pokemon.Type.WATER, wartortleStats));
        pokemonList.add(new Pokemon("9", "Blastoise",
                "http://cdn.bulbagarden.net/upload/thumb/0/05/Siebold_Mega_Blastoise.png/250px-Siebold_Mega_Blastoise.png", R.raw.blastoise,
                Pokemon.Type.WATER, blastoiseStats));
        pokemonList.add(new Pokemon("25", "Pikachu",
                "http://cdn.bulbagarden.net/upload/thumb/f/fd/Red_Pikachu_PO.png/220px-Red_Pikachu_PO.png", R.raw.pikachu,
                Pokemon.Type.ELECTRIC, pikachuStats));
        pokemonList.add(new Pokemon("26", "Raichu",
                "http://cdn.bulbagarden.net/upload/thumb/4/49/Tierno_Raichu.png/250px-Tierno_Raichu.png", R.raw.raichu,
                Pokemon.Type.ELECTRIC, raichuStats));

        /*Importante: para poder descargar imagnes desde Urls, se usa Piccaso el cual se agrefo en GradleScripts->buidl.grade
        ->despues de pegado link: Sync"*/

        //Pasar los datos del arraylist al adapter el cual los va a adaptar a la pantalla.
        /*getActivity() es el contexto. Recordar que siempre se usaba this en un activity
        * pero en este caso un fragment hace referencia al activity que depende el mismo, el cual no es el mismo en todos.. */
        final PokemonListAdapter adapter = new PokemonListAdapter(getActivity(), R.layout.pokemon_list_item,
                pokemonList);
        pokemonListView.setAdapter(adapter);

        pokemonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Pokemon selectedPokemon = adapter.getItem(position); //va almacenando el pokemon

                if (selectedPokemon != null) {
                    mListener.onPokemonSelected(selectedPokemon); //si hay info en la lista, mostrar el pokemon.
                }                                                    //El metodo esta en el Main (mListener permite hacer esto)
            }
        });

        return view;
    }

    //ESTE METODO ES AUTOGENERADO Y SE GENERA CUANDO EL FRAGMENT SE ASOCIA CON EL ACTIVITY
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context; //EN un fragment mListener es el q nos permite llamar metodos
                                                                    // de interfaces (el metodo fue creado en el mainactivity)
                                                                    //obviamente esta asociado al contexto (en este caso Mainactivyty)
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    //Este Metodo onPokemonSelected de esta interfaz OnFragmentInteractionListener debe implementarse en el Main
    // //para poder usar este fragment.
    public interface OnFragmentInteractionListener {
        void onPokemonSelected(Pokemon pokemon); //este metodo se creo por nosotrosy reemplazo al autogenerado.
    }
}
