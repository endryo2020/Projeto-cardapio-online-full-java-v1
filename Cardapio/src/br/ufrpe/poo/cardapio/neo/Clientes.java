/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufrpe.poo.cardapio.neo;

import javax.swing.JOptionPane;

/**
 *
 * @author Endryo
 */
public class Clientes implements InterfaceClientes {

    private String cliente;
    private int mesa;

    //Contrutores
    public Clientes(int mesa) {
        this.mesa = mesa;
    }

    public Clientes(String cliente, int mesa) {
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public Clientes() {
    }

    //Métodos Get's
    public String getCliente() {
        return this.cliente;
    }

    public int getMesa() {
        return this.mesa;
    }

    //metodos Set's
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    //metodos para incrementar e decrementar a mesa Implementados da interface
    @Override
    public int incrementa(int mesa) {
        return ++this.mesa;
    }

    @Override
    public int decrementa(int mesa) {
        do {
            return --mesa;
        } while (mesa > 1);

    }

    @Override
    public String toString() {
        return "Cliente: " + getCliente() + "Mesa: " + getMesa();
    }
}
