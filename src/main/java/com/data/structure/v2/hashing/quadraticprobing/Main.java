package com.data.structure.v2.hashing.quadraticprobing;

public class Main {
    public static void main(String[] args) {
        QuadraticProbing quadraticProbing = new QuadraticProbing(5);
        quadraticProbing.insertKeyInHashTable("the");
        quadraticProbing.insertKeyInHashTable("quick");
        quadraticProbing.insertKeyInHashTable("brown");
        quadraticProbing.insertKeyInHashTable("fox");
        quadraticProbing.insertKeyInHashTable("wolfo");
        quadraticProbing.displayHashTable();
    }
}
