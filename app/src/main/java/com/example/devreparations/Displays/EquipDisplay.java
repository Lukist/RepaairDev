package com.example.devreparations.Displays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.devreparations.R;
import com.example.devreparations.modelos.ModeloProducto;

public class EquipDisplay extends AppCompatActivity {

    ModeloProducto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip_display);

        producto = (ModeloProducto) getIntent().getSerializableExtra("producto");

        TextView equipDisplay_serieStatus = findViewById(R.id.equipDisplay_seriaStatus);
        equipDisplay_serieStatus.setText(producto.getSerie());

        TextView equipDisplay_tipoStatus = findViewById(R.id.equipDisplay_tipoStatus);
        equipDisplay_tipoStatus.setText(producto.getTipo());

        TextView equipoDisplay_problemaStatus = findViewById(R.id.equipDisplay_problemaStatus);
        equipoDisplay_problemaStatus.setText(producto.getProblema());

        TextView equipoDisplay_telefonoStatus = findViewById(R.id.equipDisplay_telefonoStatus);
        equipoDisplay_telefonoStatus.setText(producto.getTelefono());

        TextView equipoDisplay_tecnicoStatus = findViewById(R.id.equipDisplay_tecnicoStatus);
        equipoDisplay_tecnicoStatus.setText(producto.getTecnico());


    }
}