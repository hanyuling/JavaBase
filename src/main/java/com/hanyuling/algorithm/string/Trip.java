package com.hanyuling.algorithm.string;

public class Trip {
    private Trip[] children;
    private boolean isEnd;

    public Trip(){
        children = new Trip[26];
        isEnd = false;
    }

    public void insert(String word){
        Trip node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trip();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trip node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trip searchPrefix(String prefix) {
        Trip node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        Trip trip = new Trip();
        trip.insert("world");
        trip.insert("hello");
        trip.insert("hanyuling");
        System.out.println(trip.search("hello"));
        System.out.println(trip.search("han"));
        System.out.println(trip.startsWith("hanyu"));
    }
}
