package com.data.structure.v2.tree;

public class Main {

    public static void main(String[] args) {
        SimpleTreeNode drinks = new SimpleTreeNode("Drinks");
        SimpleTreeNode hot = new SimpleTreeNode("HOT");
        SimpleTreeNode cold = new SimpleTreeNode("COLD");

        drinks.addChild(hot);
        drinks.addChild(cold);

        SimpleTreeNode tea = new SimpleTreeNode("TEA");
        SimpleTreeNode coffee = new SimpleTreeNode("Coffee");
        hot.addChild(tea);
        hot.addChild(coffee);
        SimpleTreeNode wine = new SimpleTreeNode("WINE");
        SimpleTreeNode beer = new SimpleTreeNode("BEER");
        cold.addChild(wine);
        cold.addChild(beer);
        System.out.println(drinks.print(0));
    }
}
