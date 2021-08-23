package com.compasso.dao;

import com.compasso.modelo.Filme;

import javax.persistence.EntityManager;
import java.util.List;

public class FilmeDao {

    private EntityManager em;

    public FilmeDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Filme filme) {
        this.em.persist(filme);
    }

    public List<Filme> buscarN(int q, int p) {
        List<Filme> resultado = null;
        try {
            String jpql = "SELECT f FROM Filme f ";
            resultado = em.createQuery(jpql, Filme.class).setMaxResults(q).
                    setFirstResult(((p - 1) * q)).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;

    }
}
