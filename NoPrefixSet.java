import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/one-week-preparation-kit-no-prefix-set/problem
// solution: https://github.com/alexprut/HackerRank/blob/master/Data%20Structures/Trie/No%20Prefix%20Set/Solution.java

class TrieNode {
  public char c;
  public boolean isEndNode = false;
  public TrieNode parent = null;
  public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

  public TrieNode(char c, TrieNode parent) {
    this.c = c;
    this.parent = parent;
  }

  public TrieNode(char c, TrieNode parent, boolean isEndNode) {
    this.c = c;
    this.isEndNode = isEndNode;
    this.parent = parent;
  }
}

class Trie {
  public TrieNode root = new TrieNode(' ', null);

  public String add(String word) {
    TrieNode r = root;
    int i = 0;
    while (i < word.length()) {
        Character c = word.charAt(i);
        if (!r.children.containsKey(c)) {
            r.children.put(c, new TrieNode(c, r));
            r = r.children.get(c);
        } else {
            r = r.children.get(c);
            if (r.isEndNode) {  
                return word;
            }
        }
        i++;
    }

    if (r.children.size() > 0) {  
        return word; 
    }
    r.isEndNode = true;

    return "";
  }
}

class Result {
    

    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */

    public static void noPrefix(List<String> words) {
    // Write your code here
        String invalid = "";
        Trie root = new Trie();
        for (int i = 0; i < words.size(); i++) {
            invalid = root.add(words.get(i));
            if (invalid != "") {  
                System.out.println("BAD SET");
                System.out.println(invalid);
                return;
            }
        }
        System.out.println("GOOD SET");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        Result.noPrefix(words);

        bufferedReader.close();
    }
}
