package com.data.structure.v2.hashing.linearprobing;

public class Main {

    public static void main(String[] args) {
        LinearProbing linearProbing = new LinearProbing(5);
        linearProbing.insertInHashtable("the");
        linearProbing.insertInHashtable("quick");
        linearProbing.insertInHashtable("brown");
        linearProbing.insertInHashtable("fox");
        linearProbing.insertInHashtable("red");
        linearProbing.insertInHashtable("white");
        linearProbing.insertInHashtable("is");
        linearProbing.insertInHashtable("now");
        linearProbing.insertInHashtable("blue");
        linearProbing.printHashTable();
        linearProbing.searchHashTable("no1w");
        linearProbing.deleteKeyFromHashTable("blue");
        linearProbing.printHashTable();

    }
}
