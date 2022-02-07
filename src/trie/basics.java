package trie;
import models.TrieNode;


class TrieImpl {
    private TrieNode root;

    TrieImpl() {
        root = new TrieNode();
    }

    public void insert(String s) {
        if (s == null || s.length() == 0) return;
        TrieNode ptr = root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (ptr.children[idx] == null) {
                ptr.children[idx] = new TrieNode();
            }
            ptr = ptr.children[idx];
        }
        ptr.end_of_word++;
    }

    public boolean search(String s) {
        TrieNode ptr = root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (ptr.children[idx] == null) {
                return false;
            }
            ptr = ptr.children[idx];
        }

        if (ptr.end_of_word > 0) {
            return true;
        }
        return false;
    }
}





public class basics {

    public static void main(String[] args) {

        TrieImpl trie = new TrieImpl();

        trie.insert("abc");
        trie.insert("abcd");

        System.out.println(trie.search("abc"));
        System.out.println(trie.search("abcd"));
        System.out.println(trie.search("xyz"));
        System.out.println(trie.search("abcde"));




    }
}
