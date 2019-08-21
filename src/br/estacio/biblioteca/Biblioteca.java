package br.estacio.biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    private String nome;
    private String nomeResponsavel;

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
    private String local;
    private ArrayList<Livro> livros;

    public Biblioteca() {
        livros = new ArrayList<Livro>();
    }

    public Biblioteca(String nome) {
        this();
        setNomeResponsavel(nomeResponsavel);
    }

    public Biblioteca(String nome, String local, String nomeResponsavel) {
        this(nome);
        setLocal(local);
        setNomeResponsavel(nomeResponsavel);
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public int getQuantidade() {
        return livros.size();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void incluirLivro(Livro livro) throws NullPointerException {
        if (livro == null) {
            throw new NullPointerException("Erro de Objeto Livro null");
        } else {
            livros.add(livro);
        }
    }

    public Livro obterLivro(int cod) {
        for (Livro livro : livros) {
            if (livro != null) {
                if (livro.getCodigo() == cod) {
                    return livro;
                }
            }
        }
        return null;
    }

    public ArrayList<Livro> obterLivro(String tit) {
        ArrayList<Livro> lista = new ArrayList<Livro>();

        for (Livro livro : livros) {
            if (livro != null) {
                if (livro.getTitulo().indexOf(tit) >= 0) {
                    lista.add(livro);
                }
            }
        }
        return lista;
    }

    public Livro getLivro(int posicao) throws IndexOutOfBoundsException {
        if (posicao < this.getQuantidade()) {
            return livros.get(posicao);
        } else {
            throw new IndexOutOfBoundsException("Índice de Livro Inválido!");
        }
    }

}
