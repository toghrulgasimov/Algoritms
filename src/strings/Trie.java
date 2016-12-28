/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

/**
 *
 * @author Toghrul
 */
public class Trie {
    public Node root;
    public class Node {
        public Node parent;
        public Node[] child;
        public Node() {
            child = new Node[26];
            parent = null;
        }
    }
    public Trie() {
        root = new Node();
    }
    public void insert(String s) {
        Node curr = root;
        for(int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            if(curr.child[a] == null) {
                curr.child[a] = new Node();
                curr.child[a] = curr;
            }
            curr = curr.child[a];
        }
    }
    public boolean search(String s) {
        Node curr = root;
        for(int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            if(curr.child[a] == null) return false;
            curr = curr.child[a];
        }
        return true;
    }
}
