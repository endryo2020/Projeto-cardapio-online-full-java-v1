/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufrpe.poo.cardapio.neo;

import java.util.ArrayList;

/**
 *
 * @author Endryo
 */
public class Carrinho {

    private ArrayList<Produtos> carrinho;
    

    //contrutores
    public Carrinho(Produtos produtos) {
        carrinho = new ArrayList<Produtos>();
    }

    public Carrinho() {
        carrinho = new ArrayList<Produtos>();
    }

    //metodos get's
    public ArrayList<Produtos> getProdutos() {
        return this.carrinho;
    }

    //metodos set's
    public void setProdutos(ArrayList<Produtos> carrinho) {
        this.carrinho = carrinho;
    }

    public void addProdutos(ArrayList<Produtos> carrinho) {
        Produtos p = new Produtos();
        carrinho.add(p);
    }

    public void todosProdutos(ArrayList<Produtos> carrinho) {
        carrinho.toString();
    }

}
