package com.compasso;

import com.compasso.dao.FilmeDao;
import com.compasso.modelo.Filme;
import com.compasso.util.JPAutil;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAutil.getEntityManager();
        FilmeDao dao = new FilmeDao(em);
        adicionar20Filmes(em, dao);


        System.out.println("Quantos filmes deseja ver?");
        Scanner valor1 = new Scanner(System.in);
        int quantidade = Integer.parseInt(valor1.nextLine());
        System.out.println("Em qual página?");
        int pagina = Integer.parseInt(valor1.nextLine());

        ordenar(quantidade, pagina, em, dao);

        fecharConexao(em);

    }

    private static void adicionar20Filmes(EntityManager em, FilmeDao dao) {
        Filme filme1 = new Filme("Harry Potter 1 ", "Harry Potter e a Pedra Filosofal", 2001);
        Filme filme2 = new Filme("Harry Potter 2 ", "Harry Potter e a Câmara Secreta", 2002);
        Filme filme3 = new Filme("Harry Potter 3 ", "Harry Potter e o Prisioneiro de Azkaban", 2004);
        Filme filme4 = new Filme("Harry Potter 4 ", "Harry Potter e o Cálice de Fogo", 2005);
        Filme filme5 = new Filme("Harry Potter 5 ", "Harry Potter e a Ordem da Fênix", 2007);
        Filme filme6 = new Filme("Harry Potter 6 ", "Harry Potter e o Enigma do Príncipe", 2009);
        Filme filme7 = new Filme("Harry Potter 7 ", "Harry Potter e as Relíquias da Morte: Parte 1", 2010);
        Filme filme8 = new Filme("Harry Potter 8 ", "Harry Potter e as Relíquias da Morte: Parte 2", 2011);
        Filme filme9 = new Filme("O Senhor dos Anéis 1 ", "O Senhor dos Anéis: A Sociedade do Anel", 2001);
        Filme filme10 = new Filme("O Senhor dos Anéis 2", "O Senhor dos Anéis: O Retorno do Rei", 2002);
        Filme filme11 = new Filme("O Senhor dos Anéis 3", "O Senhor dos Anéis: As Duas Torres", 2003);
        Filme filme12 = new Filme("O Hobbit 1", "O Hobbit: Uma Jornada Inesperada", 2012);
        Filme filme13 = new Filme("O Hobbit 2", "O Hobbit: A Desolação de Smaug", 2013);
        Filme filme14 = new Filme("O Hobbit 3", "O Hobbit: A Batalha dos Cinco Exércitos", 2014);
        Filme filme15 = new Filme("Star Wars 1", "Star Wars: Episódio I – A Ameaça Fantasma", 1999);
        Filme filme16 = new Filme("Star Wars 2", "Star Wars: Episódio II – Ataque dos Clones", 2002);
        Filme filme17 = new Filme("Star Wars 3", "Star Wars: Episódio III – A Vingança dos Sith", 2005);
        Filme filme18 = new Filme("Star Wars 4", "Star Wars: Episódio IV – Uma Nova Esperança", 1977);
        Filme filme19 = new Filme("Star Wars 5", "Star Wars: Episódio V – O Império Contra-Ataca ", 1980);
        Filme filme20 = new Filme("Star Wars 6", "Star Wars: Episódio VI – O Retorno de Jedi", 1983);
        List<Filme> listaDeFi1mes = Arrays.asList(filme1, filme2, filme3, filme4, filme5,
                filme6, filme7, filme8, filme9, filme10,
                filme11, filme12, filme13, filme14, filme15,
                filme16, filme17, filme18, filme19, filme20);

        try {
            em.getTransaction().begin();
            for (int i = 0; i < listaDeFi1mes.size(); i++) {
                dao.cadastrar(listaDeFi1mes.get(i));
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }


    }

    private static void ordenar(int q, int p, EntityManager em, FilmeDao dao) {
        em.getTransaction().begin();
        List<Filme> resultado = dao.buscarN(q, p);
        if (resultado != null) {
            for (Filme x : resultado) {
                System.out.println(x);
            }
        } else {
            System.out.println("Registro não encontrado");
        }
    }

    public static void fecharConexao(EntityManager em) {
        em.close();
    }


}
