/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufrpe.poo.cardapio.neo;

import java.util.ArrayList;
import br.ufrpe.poo.cardapio.dados.RepositorioProdutosArray;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Endryo
 */
public class Fachada extends AbstractFachada {

    Clientes c = new Clientes(); //Cria objetos que serão utilizados
    ArrayList<Produtos> carrinho = new ArrayList<>();
    ArrayList<Produtos> itens = new ArrayList<>();
    RepositorioProdutosArray rep = new RepositorioProdutosArray();

    //Metodos das classes
    //
    //
    //Metodos decrementa e incrementa de mesa
    public int incrementa(int mesa) {
        return ++mesa;
    }

    public int decrementa(int mesa) {
        if (mesa > 1) { //Se mesa maior do que 1 decrementa
            return --mesa;
        } else { // Caso não, mesa recebe 1
            return mesa = 1;
        }
    }

    //Exceções de entrada
    public void entradaException(String cliente, String mesa, String total) {

        int mesateste = 1; //Variável de inicialização
        boolean status = true; //Variável de controle
        while (status) { // Enquanto o status for true a ação continua
            try {
                if (cliente.isEmpty() || cliente.isBlank() || !cliente.matches("[a-zA-Z\s]+")) { // Se cliente for campo vázio ou espaços ou Qualquer coisa diferente de letras
                    throw new IllegalArgumentException(); //Lança exception
                }

                mesateste = Integer.parseInt("" + mesa); //Transforma mesa em inteiro
                if (mesateste < 1) { // Se mesa menor do que 1
                    throw new IllegalArgumentException(); // Lança uma exception
                }

                status = false; //Se foi inteiro, muda status para false e printa
                JOptionPane.showMessageDialog(null, "" + cliente + " da mesa " + mesateste + "\nTotal a pagar " + total);
            } catch (NumberFormatException exception) {  // caso tenha sido digitado uma String a exceção é capturada
                JOptionPane.showMessageDialog(null, "Mesa deve ser um numero positivo");
            } catch (IllegalArgumentException exception) {  // caso tenha sido digitado algo que não seja uma String
                JOptionPane.showMessageDialog(null, "Só é permitida letras no campo 'Cliente'\nSó é permitido números positivos no campo 'Mesa'.");
            }

            break; // Para o Enquanto
        }

    }

    //calcula todos os produtos do carrinho e soma, mostrando resultado da soma embaixo
    @Override
    public void calcularTotalProdutos(JTable tabela, JLabel label) {
        try { //Tratamento de Exception
            double soma = 0; //Variável de inicialização
            for (int i = 0; i < tabela.getRowCount(); i++) { //Para cada linha da tabela
                Double valorAux = (Double) tabela.getValueAt(i, 1); //Transforma o o objeto de todas as linhas, coluna 2 (Ou seja, Preço) em tipo double
                soma += valorAux; //Faz um montante do preco
            }
            label.setText(String.valueOf("R$ " + soma)); //Troca o que estiver na Label de total pelo montante do Preço do carrinho
        } catch (Exception e) { //Se não conseguir calcular por algum motivo, é lançada uma Exception
            JOptionPane.showMessageDialog(null, "Erro ao calcular Total Produtos:" + e.getMessage());
        }
    }
    
    //Digita o campo de observações em preto
    public void resetObs(JTextArea obs){
        obs.setText(null); // Deixa a area de texto em branco quando clicado
        obs.setForeground(Color.black); // Deixa o texto na cor preta quando digitado 
    }
    
    // metodo para limpar o carrinho
    public void limparCarrinho(ArrayList<Produtos> itens, JTable tabela, JLabel label, JLabel label1) {
        itens.clear(); // Limpa todos os objetos de itens

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0); // Zera todas as linhas da tabela

        label.setText("R$ 0.0"); // Zera o valor total da Label Total
        label1.setText("0 Itens no Carrinho");
    }

    // Metodo para deletar itens especificos do carrinho
    public void deleteItem(ArrayList<Produtos> itens, JTable tabela, JLabel label, JLabel label1) {
        itens.remove(tabela.getSelectedRow());  //Removo do array(itens) o que for selecionado da tabela

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        String obj = String.valueOf(modelo.getValueAt(tabela.getSelectedRow(), 1)); //Pego o objeto que esta na linha selecionada e na coluna 2, e transforma em um objeto String

        try {
            double soma = 0; //Variável de inicialização
            for (int i = 0; i < tabela.getRowCount(); i++) {  //Para cada linha da tabela
                Double valorAux = (Double) tabela.getValueAt(i, 1);  //Transforma o o objeto de todas as linhas, coluna 2 (Ou seja, Preço) em tipo double
                soma += valorAux;  //Faz um montante do preco
            }
            double total = soma - Double.parseDouble(obj); // Subtrai o valor da celula selecionada do montante da soma
            label.setText(String.valueOf("R$ " + total));  // Altera o Label total para o novo valor subtraido
        } catch (Exception e) {  //Se não conseguir calcular por algum motivo, é lançada uma Exception
            JOptionPane.showMessageDialog(null, "Erro ao calcular Total Produtos:" + e.getMessage());
        }
        try {
            int s = 0;
            for (int i = 0; i < itens.size(); i++) { //Depois que atualiza a lista de itens os números também reduzem na soma
                s = i + 1;
            }
            label1.setText(String.valueOf(s + " Itens no Carrinho"));  //Altera o label1 para a quantidade de itens atual
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao calcular Total Produtos:" + e.getMessage());
        }
        modelo.removeRow(tabela.getSelectedRow()); //Removo a linha selecionada da tabela
    }

    public void addCarrinho(RepositorioProdutosArray rep, ArrayList<Produtos> carrinho, ArrayList<Produtos> itens, JTable tabela, JLabel label, JComboBox combo, JTextArea obs, JLabel label1) {
        carrinho = rep.getArray(); // Pega todos os Produtos do repositório e coloca em carrinho

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0); // Apaga tudo e mostra só o que vai ser escrito no topo
        
        carrinho.get(combo.getSelectedIndex()).setObs(obs.getText());
        
        itens.add(carrinho.get(combo.getSelectedIndex()));
        
        
        
        for (Produtos pr : itens) { //Para cada item do tipo Produto em carrinho

            modelo.addRow(new Object[]{ //Adiciona uma nova linha com os seguintes objetos
                pr.getNome(), pr.getPreco(), pr.getObs(), pr.getQuantidade()
            });
            
            
            //  Soma todos os produtos
            try {
                double soma = 0;
                for (int i = 0; i < tabela.getRowCount(); i++) {
                    //double soma = 0;
                    Double valorAux = (Double) tabela.getValueAt(i, 1);
                    soma += valorAux;
                }
                label.setText(String.valueOf("R$ " + soma));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao calcular Total Produtos:" + e.getMessage());
            }
            //  Soma todos os Itens e joga na Label
            try {
                int s = 0;
                for (int i = 0; i < itens.size(); i++) {
                    s = i + 1;
                }
                label1.setText(String.valueOf(s + " Itens no Carrinho"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao calcular Produtos no Carrinho:" + e.getMessage());
            }
            
            //Padrão de texto e cor do TextAreaObs + ComboBox Vázio
            obs.setText("Escreva aqui as observações do seu pedido...");
            obs.setForeground(Color.lightGray);
            combo.setSelectedItem(null);
        }
    }
}
