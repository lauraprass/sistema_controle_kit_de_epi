package br.com.jp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Relatorio {
    
    private static final String DIR_USER = System.getProperty("user.home");
    private static final String FILE_NAME = "relatorio.txt";

    public static void gerarRelatorio(Pedido pedido) {
        
        String caminho = getPathFile();

        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(caminho))) {
            
            buffer.write("------------------------------------------------------------");
            buffer.newLine();
            buffer.write("-------------------------- PEDIDO --------------------------");
            buffer.newLine();
            buffer.write("------------------------------------------------------------");
            buffer.newLine();
            buffer.newLine();
            buffer.write("N° do código: " + pedido.getCodigo());
            buffer.newLine();
            buffer.write("Data da solicitação: " + pedido.getDataSolicitacao());
            buffer.newLine();
            if (pedido.getEnfermeiro() instanceof Enfermeiro) {
            Enfermeiro ef = (Enfermeiro)pedido.getEnfermeiro();
            buffer.write("Enfermeira(o) solicitante: " + ef.getNome());
            }

            buffer.newLine();
            if (pedido.getEstabelecimento() instanceof EstabelecimentoDeSaude) {
                EstabelecimentoDeSaude es = (EstabelecimentoDeSaude)pedido.getEstabelecimento();
                buffer.write("Estabelecimento responsável: " + es.getNome());
            }

            buffer.newLine();
            buffer.newLine();
            buffer.write("------------------------------------------------------------");
            buffer.newLine();
            buffer.write("------------------------- PRODUTOS -------------------------");
            buffer.newLine();
            buffer.write("------------------------------------------------------------");
            buffer.newLine();
            buffer.newLine();
            
            int contador = 1;

            for (ProdutoEpi produtos : pedido.getProdutos()) {
                String ped = "\n    Código do produto: " + produtos.getCodigo() + "\n    Quantidade do produto: " + produtos.getQuantidade() + "\n    Tamanho do produto: " + produtos.getTamanho() + "\n\n";
                if (produtos.getTipo() instanceof TipoProduto) {
                    TipoProduto tp = (TipoProduto)produtos.getTipo();
                    buffer.write(contador + " - " + "Tipo do produto: " + tp.getNome());
                }
                buffer.write("");
                buffer.write(ped);
                buffer.write("------------------------------------------------------------\n\n");
                contador ++;
            }

            buffer.write("------------------------------------------------------------");
            buffer.newLine();
            buffer.write("---------------------- FIM DO PEDIDO -----------------------");
            buffer.newLine();
            buffer.write("------------------------------------------------------------");
            buffer.newLine();
            buffer.newLine();

            buffer.flush();

            System.out.println("Relatório foi gerado com sucesso!");
        
            } catch (IOException e){
            
                System.out.println("Ocorreu um erro ao escrever o arquivo: " + e.getMessage());
            }
        }

    private static String getPathFile(){
        
        return DIR_USER + File.separator + FILE_NAME;
    }
}
