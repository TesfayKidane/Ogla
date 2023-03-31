package blind75.trie;

import blind75.backtracking.WordSearchIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearchII {
    static TrieNode root;
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;

        TrieNode() {
            for (int i = 0 ; i < 26; i++) {
                children[i] = null;
            }
            isWord = false;
        }
    }

    static void insert(String word) {
        TrieNode currentTrieNode = root;
        for(int level = 0; level < word.length(); level++) {
            int childIndex = word.charAt(level) - 'a';
            if(currentTrieNode.children[childIndex] == null) {
                currentTrieNode.children[childIndex] = new TrieNode();
            }
            currentTrieNode = currentTrieNode.children[childIndex];
        }
        currentTrieNode.isWord = true;
    }

    static boolean search(String word) {
        TrieNode currentTrieNode = root;
        for (int level = 0; level < word.length(); level++) {
            int childIndex = word.charAt(level) - 'a';
            if(currentTrieNode.children[childIndex] == null) {
                return false;
            }
            currentTrieNode = currentTrieNode.children[childIndex];
        }
        return currentTrieNode.isWord;
    }

    private List<String> findWords(char[][] board, String[] words) {
        int nr = board.length;
        int nc = board[0].length;
        // Insert each word into the Trie (pre fix Tree)
        for(int i = 0; i < words.length; i++ ) {
            insert(words[i]);
        }
        TrieNode node = root;
        List<String> result = new ArrayList<>();

        for(int r = 0 ; r < nr; r++) {
            for (int c = 0 ; c < nc; c++) {
               dfs(board, r, c, nr, nc, "", node, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, int nr, int nc, String word, TrieNode node,  List<String> result) {
        if(r < 0 || c < 0 || r >= nr || c >= nc || board[r][c] == '#') {
            return;
        }

        char temp = board[r][c];

        node = node.children[temp - 'a'];
        if(node == null) {
            return;
        }

        word += board[r][c];
        if(node.isWord) {
            result.add(word);
            node.isWord = false;
        }

        board[r][c] = '#';

        dfs(board, r - 1, c, nr, nc, word, node, result);
        dfs(board, r + 1, c, nr, nc, word, node, result);
        dfs(board, r, c - 1, nr, nc, word, node, result);
        dfs(board, r, c + 1, nr, nc, word, node, result);
        board[r][c] = temp;
    }

    public static void main(String[] args) {
        root = new TrieNode();
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] tWords = {"oath","pea","eat","rain"};
        WordSearchII ws = new WordSearchII();
        System.out.println(ws.findWords(board, tWords));
    }
}
