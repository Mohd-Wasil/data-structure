package com.data.structure.v2.hashing.directchaining;

public class Main {
    public static void main(String[] args) {
        DirectChaining directChaining = new DirectChaining(10);
        directChaining.insertHashTable("Wasil");
        directChaining.insertHashTable("Able");
        directChaining.insertHashTable("Angel");
        directChaining.insertHashTable("Brown");
        directChaining.insertHashTable("quick");
        directChaining.insertHashTable("fox");

        directChaining.printHashTable();
        directChaining.search("Able");
        directChaining.delete("quick");
        directChaining.printHashTable();
    }
}
