package br.inatel;

import br.inatel.detalhes.Revisor;
import br.inatel.interfaces.Atribuivel;
import br.inatel.interfaces.Revisavel;
import br.inatel.itens.Bug;
import br.inatel.itens.Documentacao;
import br.inatel.itens.Melhoria;
import br.inatel.itens.Tarefa;
import br.inatel.sistema.Quadro;

public class Main {
    public static void main(String[] args) {
        // 1) Cria o quadro e um item de cada tipo
        Quadro quadro = new Quadro();

        Tarefa tarefa = new Tarefa("Criar tela de login", "A fazer", "20/11/2026");
        Bug bug = new Bug("Erro ao salvar usuario", "Aberto", "Alta");
        Revisor revisor = new Revisor("Ana");
        Melhoria melhoria = new Melhoria("Melhorar desempenho da busca", "Pendente", revisor);
        Documentacao documentacao = new Documentacao("Manual do usuario", "Rascunho");

        // 2) Usa os metodos de cada item
        tarefa.atribuir("Carlos");
        tarefa.concluir();

        // Bug: limite de 5 passos -> o 6o deve lancar excecao
        try {
            bug.adicionarPasso("Abrir o sistema");
            bug.adicionarPasso("Ir em cadastro");
            bug.adicionarPasso("Preencher os dados");
            bug.adicionarPasso("Clicar em salvar");
            bug.adicionarPasso("Ver a mensagem de erro");
            bug.adicionarPasso("Passo extra (6o)"); // estoura o limite
        } catch (Exception e) {
            System.out.println("Excecao: " + e.getMessage());
        }

        // Documentacao: limite de 3 comentarios -> o 4o deve lancar excecao
        try {
            documentacao.adicionarComentario("Faltou o sumario");
            documentacao.adicionarComentario("Corrigir a figura 2");
            documentacao.adicionarComentario("Revisar a ortografia");
            documentacao.adicionarComentario("Comentario extra (4o)"); // estoura o limite
        } catch (Exception e) {
            System.out.println("Excecao: " + e.getMessage());
        }
        documentacao.revisar();
        documentacao.publicar();

        // 3) Polimorfismo com interfaces
        Atribuivel a = bug;
        a.atribuir("Joao");
        bug.corrigir();

        Revisavel r = melhoria;
        r.revisar();
        melhoria.aprovar();

        // 4) Adiciona no quadro e lista
        try {
            quadro.adicionarItem(tarefa);
            quadro.adicionarItem(bug);
            quadro.adicionarItem(melhoria);
            quadro.adicionarItem(documentacao);
        } catch (Exception e) {
            System.out.println("Excecao: " + e.getMessage());
        }
        quadro.listarItens();
        quadro.buscarPorStatus("Corrigido");

        // 5) Salva e le o arquivo
        quadro.salvarEmArquivo("quadro.txt");
        quadro.lerArquivo("quadro.txt");
    }
}
