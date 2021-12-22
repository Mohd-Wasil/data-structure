package com.data.structure.v2.trie;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        System.out.println("trie has been created...");
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                currentNode.children.put(ch, node);
            }
            currentNode = node;
        }
        currentNode.endOfString = true;
        System.out.println("word : " + word + " successfully insrted..");
    }

    public boolean search(String word) {
        boolean isFound = false;
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                System.out.println("string: " + word + " NOT available in trie");
                return false;
            }
            current = node;
        }
        if (current.endOfString) {
            System.out.println("string: " + word + " available in trie");
        } else {
            System.out.println("string: " + word + " is prefix of another word");
        }
        return current.endOfString;
    }

    private boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBedeleted;

        //case 1 : currentNode has more characters , few more strings comes out of it...
        //string is prefix of another word
        if (currentNode.children.size() > 1) {
            delete(currentNode, word, index + 1);
            return false;
        }
        //case 2: at end of string
        if (index == word.length() - 1) {
            //if string is prefix of another word.. dont remove just set eos - false;
            if (currentNode.children.size() >= 1) {
                currentNode.endOfString = false;
                return false;
            } else {
                //if string isnot prefix and is ending then remove the character
                parentNode.children.remove(ch);
                return true;
            }
        }
        //case 3:some other complete word is prefix of this string
        if (currentNode.endOfString == true) {
            delete(currentNode, word, index + 1);
            return false;
        }
        //case 4: no other node is dependent on this word.. (A,(K))->. ->p->I->.
        canThisNodeBedeleted = delete(currentNode, word, index + 1);
        if (canThisNodeBedeleted) {
            parentNode.children.remove(ch);
            return true;
        } else {
            return false;
        }
    }

    public void delete(String word) {
        if (search(word)) {
            delete(root, word, 0);
        }
    }

}
