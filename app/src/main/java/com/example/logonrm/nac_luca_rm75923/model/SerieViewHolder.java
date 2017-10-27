package com.example.logonrm.nac_luca_rm75923.model;

import android.view.View;
import android.widget.TextView;

import com.example.logonrm.nac_luca_rm75923.R;


public class SerieViewHolder {
    public final TextView tvNome;

    public SerieViewHolder(View view) {
        tvNome = (TextView)view.findViewById(R.id.tvSerie);
    }
}
