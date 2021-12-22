package com.data.structure.v2.hashing.linearprobing;

import java.util.ArrayList;


public class LinearProbing {
    String[] hashTable;
    int usedCellNo;

    LinearProbing(int size) {
        hashTable = new String[size];
        usedCellNo = 0;
    }

    public int modASCIIHashFunction(String word, int m) {
        char chars[] = word.toCharArray();
        int sum = 0;
        for (char ch : chars) {
            sum += ch;
        }
        return sum % m;
    }

    public double getLoadFactor() {
        double loadFactor;
        loadFactor = usedCellNo * (1.0 / hashTable.length);
        return loadFactor;
    }

    //create a new hashtable with size of 2x
    //insert element with new hash key to the new table
    public void rehashKeys(String word) {
        usedCellNo = 0;
        ArrayList<String> data = new ArrayList<>();
        for (String s : hashTable) {
            if (s != null) {
                data.add(s);
            }
        }
        data.add(word);
        hashTable = new String[hashTable.length * 2];
        for (String s : data) {
            insertInHashtable(s);
        }
    }

    public void insertInHashtable(String word) {
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75) {
            rehashKeys(word);
        } else {
            int index = modASCIIHashFunction(word, hashTable.length);
            //linear probing /
            //in case of hash collision/conflict add element to next empty slot
            for (int i = index; i < index + hashTable.length; i++) {
                int newIndex = i % hashTable.length; //circular look up for empty slot
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    usedCellNo++;
                    System.out.println("value insertted successfully. at index : " + newIndex);
                    break;
                } else {
                    System.out.println(newIndex + " is already filled , tryign next one");
                }
            }
        }
    }

    public void printHashTable() {
        if (hashTable == null) {
            System.out.println("emtpy hashtable...");
        } else {
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("index : " + i + " keys : " + hashTable[i]);
            }
        }
    }

    public boolean searchHashTable(String value) {
        int index = modASCIIHashFunction(value, hashTable.length);
        for (int i = index; i < index + hashTable.length; i++) {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equalsIgnoreCase(value)) {
                System.out.println("value found at index : " + newIndex);
                return true;
            } else {
                System.out.println("looking value in next index");
            }
        }
        System.out.println("value not available in hashtable");
        return false;
    }

    public void deleteKeyFromHashTable(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        for (int i = index; i < index + hashTable.length; i++) {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equalsIgnoreCase(word)) {
                System.out.println("value deleted at index : " + newIndex);
                hashTable[newIndex] = null;
                return;
            }
        }
        System.out.println("value not found to be deleted..");
    }

}
