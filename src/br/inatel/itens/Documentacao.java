package br.inatel.itens;

import br.inatel.detalhes.Comentario;
import br.inatel.interfaces.Revisavel;

public class Documentacao extends Item implements Revisavel {
    private Comentario[]  comentarios;
    private int quantidadeComentario;

    public Documentacao(String titulo, String status){
        super(titulo, status);
        this.comentarios = new Comentario[3];
        this.quantidadeComentario = 0;
    }

    @Override
    public void mostrarInfo(){
        System.out.println("Documentação: " + this.titulo);
        System.out.println("Status: " + this.status);
        for(int i = 0; i < quantidadeComentario; i++ ){
            System.out.println("Comentario "+ (i + 1) + ":" + comentarios[i].getTexto());
        }
    }

    @Override
    public void revisar(){
        setStatus("Revisando");
        System.out.println("A documentação " + titulo + " esta em revisão");
    }

    public void adicionarComentario(String texto) throws Exception{
       if(quantidadeComentario >= comentarios.length){
           throw new Exception("Limite de conmentarios atigindo " + titulo);
       }
       comentarios[quantidadeComentario] = new Comentario(texto);
       quantidadeComentario++;
    }

    public void publicar(){
        setStatus("Publicada");
        System.out.println("A documentação " + titulo + " esta publicada");
    }
}
