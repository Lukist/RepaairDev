package com.example.devreparations.adaptersLists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.devreparations.R;
import com.example.devreparations.modelos.ModeloProducto;

import java.util.List;


public class EquipAdapter extends ArrayAdapter<ModeloProducto> {

    private List<ModeloProducto> mList;
    private Context mContext;
    private int resourceLayout;

    public EquipAdapter(@NonNull Context context, int resource, @NonNull List<ModeloProducto> objects) {
        super(context, resource, objects);
        mList = objects;
        mContext = context;
        resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null)
            view = LayoutInflater.from(mContext).inflate(resourceLayout, null);

        ModeloProducto producto = mList.get(position);

        TextView equipRow_seria = view.findViewById(R.id.equipRow_serie);
        equipRow_seria.setText(producto.getSerie());

        TextView equipRow_tipo = view.findViewById(R.id.equipRow_tipo);
        equipRow_tipo.setText(producto.getTipo());

        return view;

    }
}
