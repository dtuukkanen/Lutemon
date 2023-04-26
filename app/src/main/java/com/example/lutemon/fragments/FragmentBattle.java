package com.example.lutemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.lutemon.CheckboxAdapter;
import com.example.lutemon.CheckboxHolder;
import com.example.lutemon.Lutemons.KRK;
import com.example.lutemon.Lutemons.Lutemon;
import com.example.lutemon.R;
import com.example.lutemon.Storage;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentBattle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBattle extends Fragment {
    RecyclerView recyclerView;
    private RadioButton moveToHome, moveToTrain;
    private CheckboxAdapter checkboxAdapter;
    private Button moveLutemons;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentBattle() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBattle.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBattle newInstance(String param1, String param2) {
        FragmentBattle fragment = new FragmentBattle();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        moveToHome = view.findViewById(R.id.rbHome);
        moveToTrain = view.findViewById(R.id.rbBattle);
        moveLutemons = view.findViewById(R.id.btnMove);


        recyclerView = view.findViewById(R.id.rvHome);
        checkboxAdapter = new CheckboxAdapter(getContext(), Storage.getInstance().getBattlefield().getLutemons());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(checkboxAdapter);
        moveLutemons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveLutemonsToOtherLocation(view);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.getAdapter().notifyDataSetChanged();
    }


    private Lutemon getCheckedLutemon() {
        Lutemon lutemon = new KRK("Aapo", 9999); // poistettava
        return lutemon;
    }

    public void moveLutemonsToOtherLocation(View view) {

        ArrayList<Lutemon> checkedLutemons = checkboxAdapter.getCheckedLutemons();

        for (Lutemon lutemon : checkedLutemons) {
            if (moveToHome.isChecked()) {
                Storage.getInstance().moveLutemon(Storage.Location.BATTLEFIELD, Storage.Location.HOME, lutemon);
            }
            else if (moveToTrain.isChecked()) {
                Storage.getInstance().moveLutemon(Storage.Location.BATTLEFIELD, Storage.Location.TRAINING, lutemon);            }
        }
    }
}

/*Storage S = Storage.getInstance();
        Lutemon lutemon = getCheckedLutemon();
        if (moveToHome.isChecked()) {
            S.moveLutemon(Storage.Location.TRAINING, Storage.Location.HOME, lutemon);
        }
        else if (moveToBattle.isChecked()) {
            S.moveLutemon(Storage.Location.TRAINING, Storage.Location.BATTLEFIELD, lutemon);
        }*/