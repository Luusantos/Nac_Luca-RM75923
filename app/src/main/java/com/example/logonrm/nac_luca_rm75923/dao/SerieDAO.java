package com.example.logonrm.nac_luca_rm75923.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.logonrm.nac_luca_rm75923.model.Serie;

import java.util.LinkedList;
import java.util.List;


public class SerieDAO {

    private DBOpenHelder banco;
    public SerieDAO(Context context) {

        banco = new DBOpenHelder(context);

    }

    public static final String TABELA_PRODUTOS = "serie";
    public static final String COLUNA_ID = "id";
    public static final String COLUNA_NOME = "nome";

    public List<Serie> getAll() {
        List<Serie> series = new LinkedList<>();
        String query = "SELECT  * FROM " + TABELA_PRODUTOS;
        SQLiteDatabase db = banco.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Serie serie = null;
        if (cursor.moveToFirst()) {
            do {
                serie = new Serie(
                        cursor.getInt(cursor.getColumnIndex(COLUNA_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUNA_NOME))
                );
                series.add(serie);
            } while (cursor.moveToNext());
        }
        return series;
    }

    public Serie getBy(int id) {
        SQLiteDatabase db = banco.getReadableDatabase();
        String colunas[] = {COLUNA_ID, COLUNA_NOME};
        String where = "id = " + id;
        Cursor cursor = db.query(true, TABELA_PRODUTOS, colunas, where, null, null,
                null, null, null);
        Serie serie = null;
        if (cursor != null) {
            cursor.moveToFirst();
            serie = new Serie(
                    cursor.getInt(cursor.getColumnIndex(COLUNA_ID)),
                    cursor.getString(cursor.getColumnIndex(COLUNA_NOME))
            );
        }

        return serie;
    }

    public String add(Serie serie) {
        long resultado;
        SQLiteDatabase db = banco.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME, serie.getNome());
        resultado = db.insert(TABELA_PRODUTOS,
                null,
                values);
        db.close();
        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }
    }
}
