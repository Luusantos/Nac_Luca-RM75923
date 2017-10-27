package com.example.logonrm.nac_luca_rm75923;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SeriesActivity extends AppCompatActivity {

    private EditText etSerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        final EditText serie = (EditText) findViewById(R.id.etSerie);
        final TextView loga = (TextView) findViewById(R.id.tvLoga);
        final Button salvar = (Button) findViewById(R.id.btsalvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                SharedPreferences pref = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = pref.edit();
                ed.putString("nome", serie.getText().toString());
                ed.apply();
                Toast.makeText(getBaseContext(), "salvo com sucesso", Toast.LENGTH_SHORT).show();

                loga.setText(pref.getString("nome", "não encontrado"));
            }
        });


        final Button lembrar = (Button) findViewById(R.id.btrecuperar);
        lembrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                loga.setText(prefs.getString("nome", "nops"));
            }
        });
    }

    public void logar(View view){
        Intent intent1 = new Intent(getApplicationContext(), ListaActivity.class);
        startActivity(intent1);
        finish();
    }

}
