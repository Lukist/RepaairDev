package com.example.devreparations.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.devreparations.modelos.ModeloProducto;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String TABLA_PRODUCTOS = "TABLA_PRODUCTOS";
    public static final String COLUMN_PRODUCT_ID = "PRODUCT_ID";
    public static final String COLUMN_NUMERO_SERIE = "NUMERO_SERIE";
    public static final String COLUMN_TIPO = "TIPO";
    public static final String COLUMN_PROBLEMA = "PROBLEMA";
    public static final String COLUMN_TELEFONO = "TELEFONO";
    public static final String COLUMN_TECNICO = "TECNICO";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "RepDev.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createProductsTable = "CREATE TABLE " + TABLA_PRODUCTOS + " (" + COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NUMERO_SERIE + " TEXT, " + COLUMN_TIPO + " TEXT, " + COLUMN_PROBLEMA + " TEXT, " + COLUMN_TELEFONO + " TEXT, " + COLUMN_TECNICO + " TEXT)";

        db.execSQL(createProductsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean createProduct(ModeloProducto producto) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NUMERO_SERIE, producto.getSerie());
        cv.put(COLUMN_TIPO, producto.getTipo());
        cv.put(COLUMN_PROBLEMA, producto.getProblema());
        cv.put(COLUMN_TELEFONO, producto.getTelefono());
        cv.put(COLUMN_TECNICO, producto.getTecnico());

        long insert = db.insert(TABLA_PRODUCTOS, null, cv);

        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<ModeloProducto> getAllProducts(){
        List<ModeloProducto> returnList = new ArrayList<>();

        String query = "SELECT * FROM " + TABLA_PRODUCTOS;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int productoId = cursor.getInt(0);
                String productoSerie = cursor.getString(1);
                String productoTipo = cursor.getString(2);
                String productoProblema = cursor.getString(3);
                String productoTelefono = cursor.getString(4);
                String productoTecnico = cursor.getString(5);

                ModeloProducto nuevoProducto = new ModeloProducto(productoId, productoSerie, productoTipo, productoProblema, productoTelefono, productoTecnico);
                returnList.add(nuevoProducto);
            }while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return returnList;
    }
}
