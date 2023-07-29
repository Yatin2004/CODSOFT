import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class wordcount {
    public static void main(String[] args) {
        Scanner = new Scanner(System.in);

        System.out.println("enter text (type 'exit' to quit):");
        String input = Scanner.nextLine().trim();

        if (input.sameignore("exit")) {
            System.out.println("Goodbye!");
            return;
        }

        String text = "";
        if (input.endsWith(".txt"))
        {
            text = readtextFromFile(input);
        }
        else
        {
            text = input;
        }

        String[] words = text.split("[\\s.,!?;:']+");
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        String[] sameword = { "the", "and", "in", "of", "to", "a", "is", "it", "that", "was", "I", "for", "on" };
        for (String word : words) {
            word = word.toLowerCase();
            if (!issameword(word, samewords)) {
                frequencymap.put(word, frequencymap.getOrDefault(word, 0) + 1);
            }
        }

        int totalnum = words.length;
        int uniqueWord = frequencymap.size();

        System.out.println("Total words: " + totalnum);
        System.out.println("Number of unique words: " + uniqueWord);

        scanner.close();
    }

    private static boolean issameword(String word, String[] samewords) {
        for (String same : samewords) {
            if (word.equals(same)) {
                return true;
            }
        }
        return false;
    }

    private static String readTextFromFile(String filename)
    {
        System.out.println("Reading text from file: " + filename);
        return "";
    }
}