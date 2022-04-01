package com.hanyuling.algorithm.string;

import java.util.*;

public class WorldSearch2 {

    public static void main(String[] args) {
//        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        char[][] board = {{'a'}};
        String[] words = {"a"};
        WorldSearch2 worldSearch2 = new WorldSearch2();
        List<String> words1 = worldSearch2.findWords(board, words);
        System.out.println(words1);

    }

    int[][] directs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ans = new HashSet<>();
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j, ans);
            }

        }
        return new ArrayList<>(ans);
    }

    private void dfs(char[][] board, Trie trie, int i1, int j1, Set<String> ans) {
        if (!trie.children.containsKey(board[i1][j1])) {
            return;
        }
        char ch = board[i1][j1];
        board[i1][j1] = '#';
        Trie now = trie.children.get(ch);
        if (!"".equals(now.word)) {
            ans.add(now.word);
        }
        for (int[] dir : directs) {
            int i2 = i1 + dir[0], j2 = j1 + dir[1];
            if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                dfs(board, now, i2, j2, ans);
            }
        }
        board[i1][j1] = ch;
    }

    class Trie {
        String word;
        Map<Character, Trie> children;

        public Trie() {
            this.word = "";
            this.children = new HashMap<>();
        }

        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!cur.children.containsKey(ch)) {
                    cur.children.put(ch, new Trie());
                }
                cur = cur.children.get(ch);
            }
            cur.word = word;
        }
    }

}