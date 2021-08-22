package com.compasso.modelo;

import javax.persistence.*;

@Entity
@Table(name = "filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private Integer ano;

    public Filme() {
    }

    public Filme(String nome, String descricao, Integer ano) {
        this.nome = nome;
        this.descricao = descricao;
        this.ano = ano;
    }


    public long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "===============================" +
                "\nInformações do filme:" +
                "\nID= " + id +
                "\nNome= |" + nome +
                "\nDescrição= " + descricao +
                "\nQuantidade= " + ano +
                "\n==============================="
                ;
    }
}
