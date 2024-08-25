package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import classes.Produto;

public class Estoque {
    /* Métodos
     * Listar itens
     * Adicionar item
     * Remover item
     * Editar item
     * Buscar item
     */

    private String caminho_estoque = "../data/estoque.txt";
    private BufferedWriter writer;
    private BufferedReader reader;

    public Estoque(){
        try {
            File fileIndex = new File(caminho_estoque);
            if (!fileIndex.exists()) { // Verificar se o arquivo existe e, se não existir, criá-lo
                fileIndex.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("Error: Falha ao criar arquivo " + e.getMessage());
        }
    }

    public void listarItens(){

        try {
            reader = new BufferedReader(new FileReader(caminho_estoque));

            String linha;
            
            while ((linha = reader.readLine()) != null) {
                String info = linha.strip();
                System.out.println(info);

                /*String nome = info[0];
                String categoria = info[1];
                float preco = Float.parseFloat(info[2]) ;
                int quantidade = Integer.parseInt(info[3]);*/

            }
        } catch (IOException e) {
            System.out.println("Error: Erro ao ler no arquivo " + e.getMessage());
        }

        
    }
    
    public void adicionarProduto(Produto produto){
        int pos_produto = buscarItem(produto);

        if(pos_produto == -1){

            String nome = produto.getNome();
            String categoria = produto.getCategoria();
            float preco = produto.getPreco();
            int quantidade = 1;

            // Juntar no formato separado por vírgula
            String linha = nome + "," + categoria + "," + preco + "," + quantidade;
            try {
                // Escrever no arquivo
                writer = new BufferedWriter(new FileWriter(caminho_estoque, true));
                writer.write(linha);
                writer.newLine();
            
                // Fechar o Writer após a escrita
                writer.close();
                
            } catch (IOException e) {
                System.out.println("Error: Erro ao escrever no arquivo "+ e.getMessage());
            }

        }else{
            aumentarQuantidade(produto);
        }
        

    }
    private void aumentarQuantidade(Produto produto){
        int verifica = buscarItem(produto);

        
    }
    public void removerItem(Produto produto){
        int verifica = buscarItem(produto);
    }
    
    public void editarItem(Produto produto){

    }

    private int buscarItem(Produto produto){

        List<String> linhas = new ArrayList<>();
        BufferedReader reader;

        try {
                reader = new BufferedReader(new FileReader("src/main/java/a.txt"));

                String linha;
    
                while ((linha = reader.readLine()) != null) {
                    linhas.add(linha);
                }
            } catch (IOException e) {
                System.out.println("Error: Erro ao escrever no arquivo "+ e.getMessage());
            }

            for(String l : linhas){
            String[] info = l.strip().split(",");
            String nome = info[0];
            String categoria = info[1];
            float preco = Float.parseFloat(info[2]);
    
            Produto produto1 = new Produto(nome, categoria, preco);

            if(produto1.equals(produto)){
                return linhas.indexOf(l);
            }
            
            }
            return -1;
        }

}

