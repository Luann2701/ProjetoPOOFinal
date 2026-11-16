package br.inatel.itens;

import br.inatel.detalhes.Revisor;
import br.inatel.interfaces.Revisavel;

public class Melhoria extends Item implements Revisavel {
    private Revisor revisor;

    public Melhoria(String titulo, String status,Revisor revisor){
        super(titulo, status);
        this.revisor = revisor;
    }

    @Override
    public void mostrarInfo(){
        System.out.println("Melhoria: " + this.titulo);
        System.out.println("Status: " + this.status);
        System.out.println("Revisor: " +  revisor.getNome());

    }

    @Override
    public void revisar(){
        setStatus("Revisando");
        System.out.println("Melhoria: " + titulo + " está sendo revisada por " + revisor.getNome());
    }

    public void aprovar(){
        setStatus("Aprovado");
        System.out.println("A melhoria " + titulo + " foi aprovada por " + revisor.getNome());
    }
}
