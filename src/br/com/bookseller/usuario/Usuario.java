package br.com.bookseller.usuario;

public class Usuario {
    private String usuario;
    private double prazo;

    public double getPrazo() {
        return prazo;
    }

    public void setPrazo(double prazo) {
        this.prazo = prazo;
    }

    public Usuario(String usuario) {
        this.usuario = usuario;
    }
}

