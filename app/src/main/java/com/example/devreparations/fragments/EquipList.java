package com.example.devreparations.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.devreparations.Displays.EquipDisplay;
import com.example.devreparations.R;
import com.example.devreparations.adaptersLists.EquipAdapter;
import com.example.devreparations.database.DataBaseHelper;
import com.example.devreparations.modelos.ModeloProducto;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EquipList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EquipList extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EquipList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EquipList.
     */
    // TODO: Rename and change types and number of parameters
    public static EquipList newInstance(String param1, String param2) {
        EquipList fragment = new EquipList();
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

    ListAdapter mAdapter;
    ListView equipList_lvProductos;
    DataBaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_equip_list, container, false);

        equipList_lvProductos = root.findViewById(R.id.equipList_LvProductos);

        db = new DataBaseHelper(getContext());

        mAdapter = new EquipAdapter(getContext(), R.layout.equip_row, db.getAllProducts());
        equipList_lvProductos.setAdapter(mAdapter);

        equipList_lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), EquipDisplay.class);
                intent.putExtra("producto", (ModeloProducto) mAdapter.getItem(i));
                startActivity(intent);
            }
        });

        return root;
    }
}