package com.example.gabriel.lista_trabalho3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gabriel.lista_trabalho3.R;
import com.example.gabriel.lista_trabalho3.model.Oficina;

import java.util.ArrayList;

public class OficinaAdapter extends ArrayAdapter<Oficina> {

    private final Context context;
    private final ArrayList<Oficina> oficinas;

    public OficinaAdapter(Context context, ArrayList<Oficina> oficinas){

        super(context, R.layout.linha_oficina , oficinas);
        this.context = context;
        this.oficinas = oficinas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_oficina, parent, false);

        TextView nomeOficina = (TextView) rowView.findViewById(R.id.tvNomeOficina);
        TextView ruaOficina = (TextView) rowView.findViewById(R.id.tvRuaOficina);


        nomeOficina.setText(oficinas.get(position).getNome());
        ruaOficina.setText(oficinas.get(position).getRua());

        return rowView;

    }

    @Override
    public int getCount() {
        return oficinas.size();
        // Em vez de return 0;
    }

    public ArrayList<Oficina> getOficinas() {
        return oficinas;
    }
}
