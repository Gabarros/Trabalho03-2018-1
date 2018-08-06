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
import com.example.gabriel.lista_trabalho3.model.Mecanico;


import java.util.List;

public class MecanicoAdapter extends RecyclerView.Adapter {


    private Context context;
    private List<Mecanico> mecanicos;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public MecanicoAdapter(List<Mecanico> mecanicos, Context context, ClickRecyclerViewListener clickRecyclerViewListener){
        this.mecanicos = mecanicos;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.linha_mecanico_cv, parent, false);
        MecanicoViewHolder mecanicoViewHolder = new MecanicoViewHolder(view);
        return mecanicoViewHolder;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        MecanicoViewHolder mecanicoHolder = (MecanicoViewHolder) viewHolder;

        Mecanico mecanico  = this.mecanicos.get(position) ;

        mecanicoHolder.nomeMecanico.setText(mecanico.getNome());
        mecanicoHolder.funcaoMecanico.setText(mecanico.getFuncao());


    }

    @Override
    public int getItemCount() {
        return mecanicos.size();
    }

    public class MecanicoViewHolder extends RecyclerView.ViewHolder {

        private final TextView nomeMecanico;
        private final TextView funcaoMecanico;


        public MecanicoViewHolder(View itemView) {
            super(itemView);
            nomeMecanico = (TextView) itemView.findViewById(R.id.tvNomeMecanico);
            funcaoMecanico = (TextView) itemView.findViewById(R.id.tvFuncaoMecanico);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(mecanicos.get(getLayoutPosition()));

                }
            });


        }
    }


}
