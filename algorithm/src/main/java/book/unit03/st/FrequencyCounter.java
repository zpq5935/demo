package book.unit03.st;

import edu.princeton.cs.algs4.StdIn;

public class FrequencyCounter {
    public static void main(String[] args) {
        int minLen = Integer.valueOf(args[0]);
        ST<String, Integer> st = new SequentialSearchST();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minLen)
                continue;
            if (st.contain(word))
                st.put(word, st.get(word) + 1);
            else
                st.put(word, 1);
        }
    }
}
