package br.inatel.itens;

import br.inatel.detalhes.Prazo;
import br.inatel.interfaces.Atribuivel;

public class Tarefa extends Item implements Atribuivel {
    private Prazo prazo;

    public Tarefa(String titulo, String status, String data){
        super(titulo, status);
        this.prazo = new Prazo(data);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Titulo da tarefa:" +  this.titulo);
        System.out.println("Status da tarefa:" +  this.status);
        System.out.println("Prazo de entrega:" + this.prazo.getData());
    }

    public void concluir(){
        setStatus("Concluida");
        System.out.println("Tarefa  " + titulo + " foi concluida");
    }

    @Override
    public void atribuir(String responsavel){
        System.out.println("Tarefa  " + titulo + " foi atribuida para " + responsavel);

    }
}
