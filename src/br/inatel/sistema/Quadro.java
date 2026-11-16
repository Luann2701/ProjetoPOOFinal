package br.inatel.sistema;

import br.inatel.itens.Item;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Quadro {
    private Item[] itens;
    private int quantidade;

    public Quadro() {
        this.itens = new Item[10];
        this.quantidade = 0;
    }

    public void adicionarItem(Item item) throws Exception {
        if (quantidade >= itens.length) {
            throw new Exception("Quadro cheio! Nao da para adicionar " + item.getTitulo());
        }
        itens[quantidade] = item;
        quantidade++;
    }

    public void listarItens() {
        System.out.println("===== Itens do quadro =====");
        for (int i = 0; i < quantidade; i++) {
            itens[i].mostrarInfo();
            System.out.println("---------------------------");
        }
    }

    public void buscarPorStatus(String status) {
        System.out.println("===== Itens com status: " + status + " =====");
        for (int i = 0; i < quantidade; i++) {
            if (itens[i].getStatus().equalsIgnoreCase(status)) {
                itens[i].mostrarInfo();
                System.out.println("---------------------------");
            }
        }
    }

    public void salvarEmArquivo(String nomeArquivo) {
        String texto = "";
        for (int i = 0; i < quantidade; i++) {
            texto += itens[i].getClass().getSimpleName() + ";" + itens[i].getTitulo() + ";" + itens[i].getStatus() + "\n";
        }
        try {
            Files.writeString(Path.of(nomeArquivo), texto);
            System.out.println("Quadro salvo no arquivo " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public void lerArquivo(String nomeArquivo) {
        try {
            List<String> linhas = Files.readAllLines(Path.of(nomeArquivo));
            System.out.println("===== Conteudo do arquivo " + nomeArquivo + " =====");
            for (String linha : linhas) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
