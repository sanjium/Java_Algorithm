package 前缀树;

import java.util.HashMap;
import java.util.Map;

class Trie {

    public class Tree {
        int pass;

        int end;

        Map<Integer, Tree> map;

        public Tree() {
            pass = 0;
            end = 0;
            map = new HashMap<>();
        }
    }

    public Tree root;

    public Trie() {
        root = new Tree();
    }

    public void insert(String word) {
        Tree temp = root;
        root.pass++;
        for (int i = 0; i < word.length(); i++) {
            int key = word.charAt(i);
            if (!temp.map.containsKey(key)) {
                temp.map.put(key, new Tree());
            }
            temp = temp.map.get(key);
            temp.pass++;
        }
        temp.end++;
    }

    public boolean search(String word) {
        Tree temp = root;
        for (int i = 0; i < word.length(); i++) {
            int key = word.charAt(i);
            if (!temp.map.containsKey(key)) {
                return false;
            }
            temp = temp.map.get(key);
        }
        return temp.end != 0;
    }

    public boolean startsWith(String prefix) {
        Tree temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            int key = prefix.charAt(i);
            if (!temp.map.containsKey(key)) {
                return false;
            }
            temp = temp.map.get(key);
        }
        return temp.pass != 0;
    }
}