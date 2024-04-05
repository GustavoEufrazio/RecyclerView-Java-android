package com.gustavoeufrazio.recyclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gustavoeufrazio.recyclerview.R;
import com.gustavoeufrazio.recyclerview.activity.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
//acima criamos uma classe adapter, para configurar o recycleView e herdamos da classe adapter que é inner class da RecycleView
//entre os sinais de maior e menor setamos a ViewHolder, que seria propriamente os itens a serem exibidos

    private List<Filme> listaFilmes;
    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        //acima estamos criando um objeto do tipo view, que recebe o resultado de um metodo"inflar xml", passamos o layout
        // que criamos para exibição dos conteudos, passamos o parametro parent para adequar ao parente
        return new MyViewHolder(itemLista);
        //acima no onCreateViewHolder, estamos retornando o objeto criado acima
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Filme filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTituloFilme());
        holder.genero.setText(filme.getGeneroFilme());
        holder.ano.setText(filme.getAnoFilme());
        //acima acessamos o holder/objeto que criamos acima do tipo view, por meio dele, acessamos aos
        //elementos do layout adapter
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
        //acima configuramos a contagem de items
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        TextView ano;
        TextView genero;

        //acima estamos criando os objetos, que serão utilizados para manipular os objetos dos tipos views do adapter_lista
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
            //aciama estamos a atribuir os objetos criados ao elementos do itemview/Layoutusado
        }
    }
}
