package com.example.gabriel.lista_trabalho3.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gabriel.lista_trabalho3.R;
import com.example.gabriel.lista_trabalho3.model.Oficina;

import java.util.List;

public class OficinaAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Oficina> oficinas;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public OficinaAdapter(List<Oficina> oficinas, Context context, ClickRecyclerViewListener clickRecyclerViewListener){

        this.context = context;
        this.oficinas = oficinas;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.linha_oficina_cv, parent, false);
        OficinaViewHolder oficinaViewHolder = new OficinaViewHolder(view);
        return oficinaViewHolder;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        OficinaViewHolder oficinaHolder = (OficinaViewHolder) viewHolder;

        Oficina oficina  = this.oficinas.get(position) ;


        oficinaHolder.nomeOficina.setText(oficina.getNome());
        oficinaHolder.ruaOficina.setText(oficina.getRua());


    }

    @Override
    public int getItemCount() {
        return oficinas.size();
    }

    public class OficinaViewHolder extends RecyclerView.ViewHolder {

        private final TextView nomeOficina;
        private final TextView ruaOficina;


        public OficinaViewHolder(View itemView) {
            super(itemView);
            nomeOficina = (TextView) itemView.findViewById(R.id.tvNomeOficina);
            ruaOficina = (TextView) itemView.findViewById(R.id.tvNomeOficina);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(oficinas.get(getLayoutPosition()));

                }
            });


        }
    }


}
