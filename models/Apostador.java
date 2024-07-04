package models;

public class Apostador {
    private int numero;
    private boolean retirado;

    public Apostador(int numero) {
        this.numero = numero;
        this.retirado = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isRetirado() {
        return retirado;
    }

    public void setRetirado(boolean retirado) {
        this.retirado = retirado;
    }
}

