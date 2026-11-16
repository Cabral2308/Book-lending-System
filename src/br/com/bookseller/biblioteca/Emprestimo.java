package br.com.bookseller.biblioteca;
import br.com.bookseller.usuario.Usuario;

import java.time.LocalDate;


public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo( Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
    }

    public void finalizar() {
        this.dataDevolucao = LocalDate.now();
    }

    public boolean isAtivo() {
        return dataDevolucao == null;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }
}
