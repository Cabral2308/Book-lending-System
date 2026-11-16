package br.com.bookseller.app;
import br.com.bookseller.biblioteca.Biblioteca;
import br.com.bookseller.biblioteca.Livro;
import java.util.Scanner;
import br.com.bookseller.biblioteca.Emprestimo;
import br.com.bookseller.usuario.Usuario;

public class Main {
    private static int lerInteiro(Scanner leitor) {
        try {
            return Integer.parseInt(leitor.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao = -1;
        Usuario usuario = new Usuario("Ana");

        System.out.println("Sistema de Biblioteca iniciado!");

        while (opcao != 0) {
            System.out.println("1 - cadastre seu livro");
            System.out.println("2 - livros cadastrados");
            System.out.println("3 - Pegar livro emprestado");
            System.out.println("4 - Devolver livro");
            System.out.println("0 - Sair");
            System.out.println("digite um número: ");

            opcao = lerInteiro(leitor);

            switch (opcao) {
                case 1:
                    System.out.println("titulo: ");
                    String titulo = leitor.nextLine();

                    System.out.println("autor: ");
                    String autor = leitor.nextLine();

                    Livro livro = new Livro(titulo, autor);
                    biblioteca.cadastrarLivro(livro);
                    System.out.println("livro cadastrado");
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    biblioteca.listarLivros();
                    System.out.print("Número do livro a emprestar: ");
                    Livro paraEmprestar = biblioteca.buscarPorPosicao(lerInteiro(leitor));

                    if (paraEmprestar == null) {
                        System.out.println("Livro não encontrado.");
                    } else {
                        biblioteca.emprestarLivro(paraEmprestar, usuario);
                    }
                    break;
                case 4:
                    biblioteca.listarLivros();
                    System.out.print("Número do livro a devolver: ");
                    Livro paraDevolver = biblioteca.buscarPorPosicao(lerInteiro(leitor));

                    if (paraDevolver == null) {
                        System.out.println("Livro não encontrado.");
                    } else {
                        biblioteca.devolverLivro(paraDevolver);
                    }
                    break;
                case 0:
                    System.out.println("Encerado");
                    break;
                default:
                    System.out.println("opção invalida");
            }
        }
        leitor.close();
    }
}
