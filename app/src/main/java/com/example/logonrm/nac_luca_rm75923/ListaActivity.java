package com.example.logonrm.nac_luca_rm75923;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.logonrm.nac_luca_rm75923.adapter.SerieAdapter;
import com.example.logonrm.nac_luca_rm75923.dao.SerieDAO;
import com.example.logonrm.nac_luca_rm75923.model.Serie;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {


    private TextView tvSerie;
    private EditText etSerie;

    private List<Serie> series = new ArrayList<>();
    private ListView lvSerie;
    private List<Serie> listaSerie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        tvSerie = (TextView)findViewById(R.id.tvSerie);
        etSerie = (EditText) findViewById(R.id.etSerie);
        lvSerie = (ListView) findViewById(R.id.lvSeries);


        SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        tvSerie.setText(prefs.getString("nome", "nops"));
    }

    public void cadastrar(View view) {
        SerieDAO serieDAO = new SerieDAO (this);
        Serie serie = new Serie(0, etSerie.getText().toString());
        series.add(serie);

        serieDAO.add(serie);

        lvSerie.setAdapter(new SerieAdapter(ListaActivity.this, series));
    }
}
