package br.estacio.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class ProgramaBiblioteca {
    
    public static void main(String[] args) {
        Biblioteca biblio = new Biblioteca();
        
        JOptionPane.showMessageDialog(null, "* Bem-vindo ao Programa Biblioteca !\n"
                + "* Cadastro de Livros com Consulta do Acervo Cadastrado\n"
                + "* Aplicado para efeitos didáticos de Programação Orientada a Objetos\n"
                + "* Autor: Newton Gomes (Versão 2016)",
                "Programa Biblioteca - 2016", JOptionPane.INFORMATION_MESSAGE);
        
        biblio.setNome(JOptionPane.showInputDialog("Nome da Biblioteca:"));
        biblio.setLocal(JOptionPane.showInputDialog("Localização da Biblioteca:"));
        biblio.setNomeResponsavel(JOptionPane.showInputDialog("Nome do Responsável da Biblioteca:"));
        
        Livro livro;
        ArrayList<Livro> listaLivros = new ArrayList<>();
        int opcao = 0, cont;
        String opcoes
                = "Biblioteca: " + biblio.getNome()
                + "\nLocalização: " + biblio.getLocal()
                + "\n\n***Opções*** "
                + "\n1. Cadastrar Livro"
                + "\n2. Pesquisar Livro (código)"
                + "\n3. Pesquisar Livro (título)"
                + "\n4. Listar Livros"
                + "\n5. Informações"
                + "\n---------------------------------------"
                + "\n6. Alterar Dados da Biblioteca"
                + "\n7. Alterar Dados do Livro"
                + "\n8. Alterar Dados do Livro"
                + "\n9. Listar Livros Ordem Alfabética"
                + "\n10. Resetar dados da biblioteca"
                + "\n---------------------------------------s"
                + "\n11. Finalizar"
                + "\n\nSelecione a opção: ";
        
        while (opcao != 11) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, opcoes,
                    "Biblioteca " + biblio.getNome(), JOptionPane.QUESTION_MESSAGE));
            
            switch (opcao) {
                case 1:
                    try {
                        biblio.incluirLivro(digitarLivro());
                    } catch (NullPointerException npe) {
                        JOptionPane.showConfirmDialog(null, "Objeto não instanciado\n" + npe.toString(), "Objeto Nulo", JOptionPane.ERROR_MESSAGE);
                    } catch (ArrayIndexOutOfBoundsException aiobe) {
                        JOptionPane.showConfirmDialog(null, "Posição do array não existe\n" + aiobe.toString(), "Posição Inexistente", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showConfirmDialog(null, "Erro não pré-visto\n" + ex.toString(), "Erro Genérico", JOptionPane.ERROR_MESSAGE);
                    }
                    try {
                        JOptionPane.showMessageDialog(null, "Livro Cadastrado!\nTotal: "
                                + biblio.getQuantidade() + " livro(s)");
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showConfirmDialog(null, "A informação digitada não é um número", "Dado incompatível", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    try {
                        livro = biblio.obterLivro(Integer.parseInt(JOptionPane.showInputDialog("Digite código para pesquisar:")));
                        if (livro != null) {
                            mostrarLivro(livro, biblio.getNome());
                        } else {
                            JOptionPane.showMessageDialog(null, "Livro Não Localizado!");
                        }
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showConfirmDialog(null, "A informação digitada não é um número", "Dado incompatível", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 3:
                    listaLivros = biblio.obterLivro(JOptionPane.showInputDialog("Digite Título do Livro para pesquisar:"));
                    cont = 0;
                    if (listaLivros.size() > 0) {
                        for (Livro liv : listaLivros) {
                            cont++;
                            mostrarLivro(liv, biblio.getNome()
                                    + " " + cont + " / " + listaLivros.size());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Título de Livro Não Localizado!");
                    }
                    break;
                case 4: {
                    StringBuffer lista = new StringBuffer();
                    lista.append("Lista de Livros Cadastrados:\n");
                    for (int i = 0; i < biblio.getQuantidade(); i++) {
                        livro = biblio.getLivro(i);
                        lista.append(livro.getCodigo() + " - "
                                + livro.getTitulo() + " - " + livro.getAutor() + " - "
                                + livro.getNumPaginas() + " pags.\n");
                    }
                    lista.append("Total: " + biblio.getQuantidade() + " livro(s)");
                    JOptionPane.showMessageDialog(null, lista.toString());
                    break;
                }
                case 5:
                    JOptionPane.showMessageDialog(null, "Informações da Biblioteca\n"
                            + "Nome da Biblioteca: " + biblio.getNome() + "\n"
                            + "Nome do  Responsável da Biblioteca: " + biblio.getNomeResponsavel() + "\n"
                            + "Localização: " + biblio.getLocal() + "\n"
                            + "Existem até o momento\n" + biblio.getQuantidade()
                            + " livro(s) cadastrado(s)");
                    break;
                case 6:
                    biblio.setNome(JOptionPane.showInputDialog("Nome da Biblioteca:"));
                    biblio.setLocal(JOptionPane.showInputDialog("Localização da Biblioteca:"));
                    biblio.setNomeResponsavel(JOptionPane.showInputDialog("Nome do Responsável da Biblioteca:"));
                    break;
                case 7:
                    listaLivros = biblio.obterLivro(JOptionPane.showInputDialog("Digite Título do Livro a ser alterado:"));
                    cont = 0;
                    if (listaLivros.size() > 0) {
                        for (Livro liv : listaLivros) {
                            cont++;
                            mostrarLivro(liv, biblio.getNome()
                                    + " " + cont + " / " + listaLivros.size());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Título de Livro Não Localizado!");
                    }
                    break;
                case 8:
                    try {
                        livro = biblio.obterLivro(Integer.parseInt(JOptionPane.showInputDialog("Digite código do livro a ser excluído:")));
                        if (livro != null) {
                            listaLivros.remove(livro);
                        } else {
                            JOptionPane.showMessageDialog(null, "Livro Não Localizado!");
                        }
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showConfirmDialog(null, "A informação digitada não é um número", "Dado incompatível", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 9:
                    List<Livro> ordenar = listaLivros;
                    Collections.sort(ordenar);
                    StringBuffer lista = new StringBuffer();
                    lista.append("Lista de Livros Cadastrados:\n");
                    for (int i = 0; i < ordenar.size(); i++) {
                        livro = ordenar.get(i);
                        lista.append(livro.getCodigo() + " - "
                                + livro.getTitulo() + " - " + livro.getAutor() + " - "
                                + livro.getNumPaginas() + " pags.\n");
                    }
                    lista.append("Total: " + ordenar.size() + " livro(s)");
                    JOptionPane.showMessageDialog(null, lista.toString());
                    System.out.println("Teste...");
                    break;
                case 10:
                    listaLivros.removeAll(listaLivros);
                    biblio = null;
                    biblio = new Biblioteca();
                    biblio.setNome(JOptionPane.showInputDialog("Nome da Biblioteca:"));
                    biblio.setLocal(JOptionPane.showInputDialog("Localização da Biblioteca:"));
                    biblio.setNomeResponsavel(JOptionPane.showInputDialog("Nome do Responsável da Biblioteca:"));
                    break;
            }
        }
        System.out.println("# Fim do Programa #");
        System.out.println("bye...");
    }
    
    static Livro digitarLivro() {
        Livro liv = new Livro();
        try {
            liv.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Código do Livro:")));
            liv.setTitulo(JOptionPane.showInputDialog("Título do Livro:"));
            liv.setAutor(JOptionPane.showInputDialog("Autor do Livro:"));
            liv.setISBN(JOptionPane.showInputDialog("Número ISBN do Livro:"));
            liv.setNumPaginas(Integer.parseInt(JOptionPane.showInputDialog("Número de Páginas do Livro:")));
            liv.setValorCompra(Float.parseFloat(JOptionPane.showInputDialog("Valor de Compra:")));
            liv.setEditora(JOptionPane.showInputDialog("Nome do Responsável:"));
        } catch (NumberFormatException nfe) {
            JOptionPane.showConfirmDialog(null, "A informação digitada não é um número", "Dado incompatível", JOptionPane.ERROR_MESSAGE);
        }
        return liv;
    }
    
    static void mostrarLivro(Livro x, String bib) {
        String texto = "Livro:\n"
                + "\nCódigo: " + x.getCodigo()
                + "\nTítulo: " + x.getTitulo()
                + "\nAutor: " + x.getAutor()
                + "\nISBN: " + x.getISBN()
                + "\nPáginas: " + x.getNumPaginas()
                + "\nValor: " + x.getValorCompra();
        JOptionPane.showMessageDialog(null, texto, "Biblioteca: " + bib,
                JOptionPane.WARNING_MESSAGE);
    }
    
    static void editarLivro(Livro x, String bib) {
        try {
            x.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Código do Livro:")));
            x.setTitulo(JOptionPane.showInputDialog("Título do Livro:"));
            x.setAutor(JOptionPane.showInputDialog("Autor do Livro:"));
            x.setISBN(JOptionPane.showInputDialog("Número ISBN do Livro:"));
            x.setNumPaginas(Integer.parseInt(JOptionPane.showInputDialog("Número de Páginas do Livro:")));
            x.setValorCompra(Float.parseFloat(JOptionPane.showInputDialog("Valor de Compra:")));
            x.setEditora(JOptionPane.showInputDialog("Nome do Responsável:"));
            JOptionPane.showMessageDialog(null, "Livro Editado com Sucesso!");
        } catch (NumberFormatException nfe) {
            JOptionPane.showConfirmDialog(null, "A informação digitada não é um número", "Dado incompatível", JOptionPane.ERROR_MESSAGE);
        }
    }
}
