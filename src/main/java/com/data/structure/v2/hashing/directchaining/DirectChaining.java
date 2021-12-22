package com.data.structure.v2.hashing.directchaining;

import java.util.ArrayList;
import java.util.LinkedList;

public class DirectChaining {

    LinkedList<String>[] hashTable;
    int maxChainSize = 5;

    public DirectChaining(int size) {
        hashTable = new LinkedList[size];
    }

    public int modASCIIHashFunction(String word, int m) {
        char chars[] = word.toCharArray();
        int sum = 0;
        for (char ch : chars) {
            sum += ch;
        }
        return sum % m;
    }

    public void insertHashTable(String word) {
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        if (hashTable[newIndex] == null) {
            hashTable[newIndex] = new LinkedList<>();
            hashTable[newIndex].add(word);
        } else {
            hashTable[newIndex].add(word);
        }
    }

    public void printHashTable() {
        if (hashTable == null) {
            System.out.println("hashtable is null");
        } else {
            System.out.println("--------hash table------");
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("index : " + i + hashTable[i]);
            }
        }
    }

    public boolean search(String word) {
        boolean isFound;
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        if (hashTable[newIndex] == null) {
            System.out.println("value not found : " + word);
            return false;
        } else {
            LinkedList<String> list = hashTable[newIndex];
            isFound = list.contains(word);
            System.out.println(isFound
                    ? "value found at index : " + newIndex + " inside LL value: " + word
                    : "value not found .." + word);
            return isFound;
        }
    }
    public void delete(String word) {
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        if (search(word)) {
            hashTable[newIndex].remove(word);
            System.out.println("word removed successfully..");
        } else {
            System.out.println("item does not exists");
        }
    }


}
