package br.estacio.biblioteca;

public class Livro implements Comparable<Livro> {

    private int codigo;
    private String titulo;
    private String autor;
    private String ISBN;
    private int numPaginas;
    private float valorCompra;
    private String editora;

    public Livro() {
    }

    public Livro(int codigo, String ISBN, String titulo, String autor,
            int numPaginas, float valorCompra, String editora) {
        setAutor(autor);
        setCodigo(codigo);
        setISBN(ISBN);
        setNumPaginas(numPaginas);
        setTitulo(titulo);
        setValorCompra(valorCompra);
        setEditora(editora);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setNumPaginas(int numPaginas) {
        if (numPaginas < 0) {
            this.numPaginas = 0;
        } else {
            this.numPaginas = numPaginas;
        }
    }

    public void setValorCompra(float valorCompra) {
        if (valorCompra < 0) {
            this.valorCompra = 0;
        } else {
            this.valorCompra = valorCompra;
        }
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public int compareTo(Livro livro) {
        return this.titulo.compareTo(livro.titulo);
    }

}
