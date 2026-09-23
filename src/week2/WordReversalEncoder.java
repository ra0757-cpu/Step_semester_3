package week2;

public class WordReversalEncoder {

    static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");
        String result = "";

        for (String word : words) {

            StringBuilder reversed = new StringBuilder(word);
            reversed.reverse();

            result += reversed + " ";
        }

        return result.trim();
    }

    public static void main(String[] args) {

        String sentence = "hello club";

        System.out.println(reverseEachWord(sentence));
    }
}