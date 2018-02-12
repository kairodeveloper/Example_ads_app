package com.example.kairo.olxapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kairo on 11/02/2018.
 */

//1 - Declarar a lista de objetos e a variavel de contexto
//2 - criar classe view holder
//3 - cria o construtor da classe adapter
//4 - extende o adapter para a viewholder do proprio adapter
//5 - implementa os metodos

public class AnuncioAdapter extends RecyclerView.Adapter<AnuncioAdapter.AnuncioViewHolder>{

    private ArrayList<Anuncio> anuncios;
    private Context context;

    public AnuncioAdapter(ArrayList<Anuncio> anuncios, Context context) {
        this.anuncios = anuncios;
        this.context = context;
    }

    public class AnuncioViewHolder extends RecyclerView.ViewHolder{

        final TextView nome;
        final TextView localizacao;
        final TextView data;
        final TextView preco;

        public AnuncioViewHolder(View itemView) {

            super(itemView);

            nome = (TextView) itemView.findViewById(R.id.id_nome_cv);
            localizacao = (TextView) itemView.findViewById(R.id.id_local_cv);
            data = (TextView) itemView.findViewById(R.id.id_data_cv);
            preco = (TextView) itemView.findViewById(R.id.id_preco_cv);

        }
    }

    public View getView(int posicao, View convertView, ViewGroup parent) {

    }

    @Override
    public AnuncioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_anuncio, parent, false);
        AnuncioViewHolder anuncioViewHolder = new AnuncioViewHolder(view);



        return anuncioViewHolder;
    }

    @Override
    public void onBindViewHolder(AnuncioViewHolder holder, final int position) {
        //atribui a uma variavel o holder
        //pega da lista o objeto da posicao recebida
        //atribui aos objetos do card, os dados do objeto
        AnuncioViewHolder anuncioViewHolder = holder;
        Anuncio anuncio = anuncios.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Numero:"+position, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                return false;
            }
        });

        anuncioViewHolder.nome.setText(anuncio.getNome());
        anuncioViewHolder.localizacao.setText(anuncio.getLocalizacao());
        anuncioViewHolder.data.setText(anuncio.getData());
        anuncioViewHolder.preco.setText(anuncio.getValor().toString());

    }

    @Override
    public int getItemCount() {
        return anuncios.size();
    }

}
