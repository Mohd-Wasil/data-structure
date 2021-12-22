package com.data.structure.v2.hashing.quadraticprobing;

import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;

import java.util.ArrayList;

public class QuadraticProbing {

    String[] hashTable;
    int usedCellNo;

    public QuadraticProbing(int size) {
        hashTable = new String[size];
        usedCellNo = 0;
    }

    public int modASCIIHashFunction(String word, int m) {
        char[] ch = word.toCharArray();
        int sum = 0;
        for (char c : ch) {
            sum += c; //a- 65
        }
        return sum % m;
    }

    public double getLoadFactor() {
        return usedCellNo * (1.0 / hashTable.length);
    }

    private void reHashKeys(String word) {
        System.out.println("****rehashing.... for " + word);
        usedCellNo =0;
        ArrayList<String> list = new ArrayList<>();
        for (String s : hashTable) {
            if(s!= null) {
                list.add(s);
            }
        }
        list.add(word);
        hashTable = new String[2 * hashTable.length];
        for (String s : list) {
            insertKeyInHashTable(s);
        }
    }

    public void insertKeyInHashTable(String word) {
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75) {
            reHashKeys(word);
        } else {
            int index = modASCIIHashFunction(word, hashTable.length);
            int counter = 0;
            //quadratic probing
            for (int i = index; i < index + hashTable.length; i++) {
                int newIndex = (i + (counter * counter)) % hashTable.length;
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    System.out.println("key : "+ word +" inserted at index : "+ newIndex);
                    break;
                }
                counter++;
            }
            usedCellNo++;
        }
    }

    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("hash table is empty");
        } else {
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("key : " + hashTable[i] + " index : " + i);
            }
        }
    }
}
