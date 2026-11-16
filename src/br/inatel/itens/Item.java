package br.inatel.itens;

public abstract class Item {
    protected String titulo;
    protected String status;

    public Item(String titulo, String status) {
        this.titulo = titulo;
        this.status = status;
    }

    public abstract void mostrarInfo();

    public  String getTitulo() {
        return titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
