package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import classes.Produto;

public class Estoque {
    /* Métodos
     * Listar itens
     * Adicionar item
     * Remover item
     * Editar item
     * Buscar item
     */

    private String caminho_estoque = "data/estoque.txt";
    BufferedWriter writer;
    BufferedReader reader;

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
        Boolean verificaSeExiste = buscarItem(produto);

        if(!verificaSeExiste){
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

    }
    public void removerItem(Produto produto){
        Boolean verifica = buscarItem(produto);
    }
    
    public void editarItem(Produto produto){

    }

    private Boolean buscarItem(Produto produto){

        try {
            reader = new BufferedReader(new FileReader(caminho_estoque));

            String linha;
            
            while ((linha = reader.readLine()) != null) {
                String[] info = linha.strip().split(",");
                String nome = info[0];
                String categoria = info[1];
                float preco = Float.parseFloat(info[2]) ;
                

                Produto produto2 = new Produto(nome, categoria, preco);

                if(produto.equals(produto2)){
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Erro ao escrever no arquivo "+ e.getMessage());
        }

        return false;
    }

}

