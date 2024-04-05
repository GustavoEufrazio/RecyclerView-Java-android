package com.gustavoeufrazio.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gustavoeufrazio.recyclerview.R;
import com.gustavoeufrazio.recyclerview.activity.RecyclerItemClickListener;
import com.gustavoeufrazio.recyclerview.activity.adapter.Adapter;
import com.gustavoeufrazio.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        Adapter adapter = new Adapter(listaFilmes);
        //acima estamos instanciando o "adapter" criado


        criarFilmes();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        //acima estamos a criar um "estilo de layout" no caso LinnerLayout
        recyclerView.setLayoutManager(layoutManager);
        //acima setamos ao LayoutManager da nossa recycler view

        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));

        recyclerView.setHasFixedSize(true);
        //e acima setamos a propriedade que torna fixa a quantidade a ser exibida

        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Item pressionado: " + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Clique longo: "+ filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                })
        );
    }

    public void criarFilmes(){
        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "ano");
        this.listaFilmes.add(filme);
        Filme filme1 = new Filme("Mulher Maravilha", "Fantasia", "2019");
        this.listaFilmes.add(filme1);
        Filme filme2 = new Filme("Ilha do Medo", "Terror", "2013");
        this.listaFilmes.add(filme2);
        Filme filme3 = new Filme("Clube da Luta", "Drama", "2005");
        this.listaFilmes.add(filme3);
        Filme filme4 = new Filme("Vingadores: Ultimato", "Ação", "2018");
        this.listaFilmes.add(filme4);
    }
}