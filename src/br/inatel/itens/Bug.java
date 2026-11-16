package br.inatel.itens;

import br.inatel.detalhes.Passo;
import br.inatel.interfaces.Atribuivel;

public class Bug extends Item implements Atribuivel {
    private String severidade;
    private Passo[] passos;
    private  int quantidadePassos;

    public Bug(String titulo, String status, String severidade){
        super(titulo, status);
        this.severidade = severidade;
        this.passos = new Passo[5];
        this.quantidadePassos = 0;
    }

    @Override
    public void mostrarInfo(){
        System.out.println("Bug:" +  this.titulo);
        System.out.println("Status do bug:" +  this.status);
        System.out.println("Severidade do Bug:" +  this.severidade);
        for(int i = 0; i < quantidadePassos; i++){
            System.out.println("Passo " + (i + 1) + ": " +  passos[i].getDescricao());
        }
    }
    
    @Override
    public void atribuir(String responsavel){
        System.out.println("Bug  " + titulo + " foi atribuido para " + responsavel);
    }

    public void adicionarPasso(String descricao) throws Exception{
        if(quantidadePassos >= passos.length){
            throw new Exception("Limite de passos atigindo no bug" + titulo);
        }
        passos[quantidadePassos] = new Passo(descricao);
        quantidadePassos++;
    }

    public void corrigir(){
        setStatus("Corrigido");
        System.out.println("O bug " + titulo + " foi corrigido");

    }

}
