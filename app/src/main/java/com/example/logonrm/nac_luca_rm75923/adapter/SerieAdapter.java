package com.example.logonrm.nac_luca_rm75923.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.logonrm.nac_luca_rm75923.R;
import com.example.logonrm.nac_luca_rm75923.model.Serie;
import com.example.logonrm.nac_luca_rm75923.model.SerieViewHolder;

import java.util.List;


public class SerieAdapter extends BaseAdapter{
    private Context context;
    private List<Serie> series;
    public SerieAdapter(Context context, List<Serie> series) {
        this.context = context;
        this.series = series;
    }

    @Override
    public int getCount() {
        return series.size();
    }

    @Override
    public Object getItem(int position) {
        return series.get(position);
    }

    @Override
    public long getItemId(int position)
    {return series.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        SerieViewHolder holder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.series, parent, false);
            holder = new SerieViewHolder(view);
            view.setTag(holder);
        }
        else {
            view = convertView;
            holder = (SerieViewHolder) view.getTag();
        }

        Serie serie = series.get(position);

        holder.tvNome.setText(serie.getNome());

        return view;
    }
}
