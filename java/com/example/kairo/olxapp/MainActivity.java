package com.example.kairo.olxapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Anuncio> anuncios = new ArrayList<>();

    private RecyclerView recyclerView;
    private AnuncioAdapter anuncioAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private FloatingActionButton fabAddAnuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        fabAddAnuncio = (FloatingActionButton) findViewById(R.id.fab_add_anuncio);

        fabAddAnuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final View mView = getLayoutInflater().inflate(R.layout.add_anuncio, null);

                final TextInputEditText novoNome = (TextInputEditText) mView.findViewById(R.id.nome_novo_produto);
                final TextInputEditText novoValor = (TextInputEditText) mView.findViewById(R.id.valor_novo_produto);
                final TextInputEditText novoLocal = (TextInputEditText) mView.findViewById(R.id.local_novo_produto);
                final TextInputEditText novoDescricao = (TextInputEditText) mView.findViewById(R.id.descricao_novo_produto);


                builder.setView(mView)
                        .setTitle("ADICIONAR NOVO ANÚNCIO")
                        .setPositiveButton("SALVAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Anuncio anuncio = new Anuncio(novoNome.getText().toString(),
                                        Double.parseDouble(novoValor.getText().toString()),
                                        novoLocal.getText().toString(),
                                        novoDescricao.getText().toString());
                                anuncios.add(anuncio);
                                initializeAdapter();
                                Toast.makeText(MainActivity.this,"Feito ", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
                            }
                        })
                        ;

                final AlertDialog dialog = builder.create();

                dialog.show();

            }
        });


        initializeAdapter();

    }

    private void initializeAdapter(){
        recyclerView = (RecyclerView) findViewById(R.id.rv_anuncios);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        anuncioAdapter = new AnuncioAdapter(anuncios, MainActivity.this);
        recyclerView.setAdapter(anuncioAdapter);
    }

}
