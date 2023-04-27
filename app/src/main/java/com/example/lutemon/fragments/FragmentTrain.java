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
import android.widget.RadioGroup;

import com.example.lutemon.CheckboxAdapter;
import com.example.lutemon.Lutemons.Lutemon;
import com.example.lutemon.R;
import com.example.lutemon.Storage;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTrain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTrain extends Fragment {
    RecyclerView recyclerView;
    private CheckboxAdapter checkboxAdapter;
    private RadioGroup rgOptions;
    private Button moveLutemons;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentTrain() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTrain.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTrain newInstance(String param1, String param2) {
        FragmentTrain fragment = new FragmentTrain();
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
        moveLutemons = view.findViewById(R.id.btnMove);
        rgOptions = view.findViewById(R.id.rgOptions);

        recyclerView = view.findViewById(R.id.rvHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        checkboxAdapter = new CheckboxAdapter(getContext(), Storage.getInstance().getTraining().getLutemons());
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

    public void moveLutemonsToOtherLocation(View view) {
        ArrayList<Lutemon> checkedLutemons = checkboxAdapter.getCheckedLutemons();
        System.out.println(checkedLutemons.size());

        for (Lutemon lutemon : checkedLutemons) {
            switch (rgOptions.getCheckedRadioButtonId()) {
                case R.id.rbHome:
                    Storage.getInstance().moveLutemon(Storage.Location.TRAINING, Storage.Location.HOME, lutemon);
                    break;
                case R.id.rbBattle:
                    Storage.getInstance().moveLutemon(Storage.Location.TRAINING, Storage.Location.BATTLEFIELD, lutemon);
                    break;
            }
        }
        checkboxAdapter.notifyDataSetChanged();
    }
}