package string;


import java.util.*;

/**
 *
 * leetcode :  1451
 *
 * Given a sentence text (A sentence is a string of space-separated words) in the following format:
 *
 * First letter is in upper case.
 * Each word in text are separated by a single space.
 * Your task is to rearrange the words in text such that all words are rearranged in an increasing order of their lengths.
 * If two words have the same length, arrange them in their original order.
 *
 *
 * Input: text = "Leetcode is cool"
 * Output: "Is cool leetcode"
 * Explanation: There are 3 words, "Leetcode" of length 8, "is" of length 2 and "cool" of length 4.
 * Output is ordered by length and the new first word starts with capital letter
 *
 *
 */

/**
 *
 * usng custom comparator
 *
 * tc = nlogn
 * sc = n
 *
 */


class lc1_rearrange_words_by_length_helper {
    String word;
    int occurance_id;
    int length;

    lc1_rearrange_words_by_length_helper(String s, int o, int l) {
        this.word = s;
        this.occurance_id = o;
        this.length = l;
    }
}




public class lc1_rearrange_words_by_length {

    public static void main(String[] args) {
//        String text = "Leetcode is cool";

        String text = "Keep calm and code on";

        String ans = new lc1_rearrange_words_by_length_soln().function(text);
        System.out.println(ans);
    }


}



class lc1_rearrange_words_by_length_soln {

    String function(String text) {

        text = text.toLowerCase();
//        text = ('a' + (text.charAt(0) - 'A')) + text.substring(1);
        String[] tokens = text.split("\\s+");

        List<lc1_rearrange_words_by_length_helper> list = new LinkedList<>();

        for (int i = 0; i < tokens.length; i++) {
            list.add(new lc1_rearrange_words_by_length_helper(tokens[i], i, tokens[i].length()));
        }

        Collections.sort(list, new Comparator<lc1_rearrange_words_by_length_helper>() {
            @Override
            public int compare(lc1_rearrange_words_by_length_helper o1, lc1_rearrange_words_by_length_helper o2) {
                return o1.length == o2.length ? o1.occurance_id - o2.occurance_id : o1.length - o2.length;
            }
        });

        String answer = "";

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                answer += list.get(i).word;
            } else {
                answer += list.get(i).word + " ";
            }
        }

        answer = answer.substring(0,1).toUpperCase() + answer.substring(1);

        return answer;


    }

}