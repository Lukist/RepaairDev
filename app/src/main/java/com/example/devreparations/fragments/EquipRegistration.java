package com.example.devreparations.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.devreparations.R;
import com.example.devreparations.database.DataBaseHelper;
import com.example.devreparations.modelos.ModeloProducto;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EquipRegistration#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EquipRegistration extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EquipRegistration() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EquipRegistration.
     */
    // TODO: Rename and change types and number of parameters
    public static EquipRegistration newInstance(String param1, String param2) {
        EquipRegistration fragment = new EquipRegistration();
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

    private Button registro_btn;
    private EditText registro_serie, registro_tipo, registro_problema, registro_telefono, registro_tecnico;

    DataBaseHelper db;

    ModeloProducto producto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_equip_registration, container, false);

        registro_serie = root.findViewById(R.id.registro_seriaInput);
        registro_tipo = root.findViewById(R.id.registro_tipoInput);
        registro_problema = root.findViewById(R.id.registro_problemaInput);
        registro_telefono = root.findViewById(R.id.registro_telefonoInput);
        registro_tecnico = root.findViewById(R.id.registro_tecnicoInput);

        registro_btn = root.findViewById(R.id.registro_btn);

        db = new DataBaseHelper(getContext());

        registro_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                producto = new ModeloProducto(-1, registro_serie.getText().toString(), registro_tipo.getText().toString(), registro_problema.getText().toString(), registro_telefono.getText().toString(), registro_tecnico.getText().toString());
                boolean succes = db.createProduct(producto);
                Toast.makeText(getContext(), producto.toString() + succes, Toast.LENGTH_SHORT).show();
            }
        });


        return root;
    }
}