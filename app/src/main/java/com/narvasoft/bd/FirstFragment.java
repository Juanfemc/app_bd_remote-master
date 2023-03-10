package com.narvasoft.bd;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class FirstFragment extends Fragment {
    private RecyclerView recyclerViewHotel;
    private Adapter adapterHotel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FirstFragment() {
        // Required empty public constructor
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_first, container, false);
        recyclerViewHotel=(RecyclerView)root.findViewById(R.id.reciclerHotel);
        recyclerViewHotel.setLayoutManager(new LinearLayoutManager(getContext()));

        adapterHotel=new Adapter(obtenerHoteles());
        recyclerViewHotel.setAdapter(adapterHotel);
        return root;
    }

    public List<Hoteles> obtenerHoteles(){
        List<Hoteles> hotel=new ArrayList<>();
        hotel.add(new Hoteles("Casa Verde", "Viaducto al Morro", R.drawable.casa_verde));
        hotel.add(new Hoteles("Colon Plaza", "El parque Col??n", R.drawable.colon));
        hotel.add(new Hoteles("La Red", "Viaducto al Morro", R.drawable.la_red));
        hotel.add(new Hoteles("Los Corales", "Viaducto al Morro", R.drawable.los_corales));
        hotel.add(new Hoteles("Villa del Sol", "Viaducto al Morro", R.drawable.casa_verde));

        return hotel;

    }
}