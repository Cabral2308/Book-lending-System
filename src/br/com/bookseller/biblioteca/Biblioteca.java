package br.com.bookseller.biblioteca;

import br.com.bookseller.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;


    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivros() {                       // <- ele entra aqui
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.println("\nLivros:");
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            String status;
            if (livro.isDisponivel()) {
                status = "disponível";
            } else {
                status = "emprestado";
            }
            System.out.printf("%02d - %s / %s (%s)%n", i + 1, livro.getTitulo(), livro.getAutor(), status);
        }
    }

    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void emprestarLivro(Livro livro , Usuario usuario) {
        if(!livro.isDisponivel()) {
            System.out.println("Livro indisponivel no momento");
            return;
        } else {
            livro.setDisponivel(false);
            emprestimos.add(new Emprestimo(livro , usuario));
            System.out.println("Livro emprestimo realizado");
        }
    }

    public Livro buscarPorPosicao(int posicao) {
        if (posicao < 1 || posicao > livros.size()) {
            return null;
        }
        return livros.get(posicao - 1);
    }

    public void devolverLivro(Livro livro) {
        for(Emprestimo e : emprestimos) {
            if(e.getLivro() == livro && e.isAtivo()) {
                e.finalizar();
                livro.setDisponivel(true);
                System.out.println("Livro devolvido com sucesso!");
                return;
            }
        }
        System.out.println("Nao ha emprestimos disponiveis para esse livro");
    }
}

