package classes;

import java.io.File;
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

    public Estoque(){
        try {
            File fileIndex = new File(caminho_estoque);
            if (!fileIndex.exists()) { // Verificar se o arquivo existe e, se não existir, criá-lo
                fileIndex.createNewFile();
            } 

        } catch (IOException e) {
            System.out.println("Error: Failed create file " + e.getMessage());
        }
    }

    public void listarItens(){}

}
