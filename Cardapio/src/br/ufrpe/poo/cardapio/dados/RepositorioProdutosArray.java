/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufrpe.poo.cardapio.dados;

import br.ufrpe.poo.cardapio.neo.Produtos;
import java.util.ArrayList;

/**
 *
 * @author Endryo
 */
public class RepositorioProdutosArray {

    Produtos p1 = new Produtos("Calabresa", 25.0, 1);
    Produtos p2 = new Produtos("Mussarela", 22.0, 1);
    Produtos p3 = new Produtos("4Queijos", 20.0, 1);

    Produtos p4 = new Produtos("Tradicional", 5.0, 1);
    Produtos p5 = new Produtos("X-Bracon", 8.0, 1);
    Produtos p6 = new Produtos("X-Tudo", 9.0, 1);

    Produtos p7 = new Produtos("Coca", 8.0, 1);
    Produtos p8 = new Produtos("Soda", 7.0, 1);
    Produtos p9 = new Produtos("Água", 2.0, 1);

    ArrayList<Produtos> c = new ArrayList<>();

    public void add() {
        c.add(p1);
        c.add(p2);
        c.add(p3);
        c.add(p4);
        c.add(p5);
        c.add(p6);
        c.add(p7);
        c.add(p8);
        c.add(p9);
    }

    public ArrayList<Produtos> getArray() {
        return this.c;
    }

}
