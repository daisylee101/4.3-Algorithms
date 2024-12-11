import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Algorithms {
    private static File f;
    private static Scanner s;
    public static void main(String[] args) throws FileNotFoundException {
        f = new File("words.txt");
        int twos = twos();
        int longest = least();
        int palindromes = palindromes();
        System.out.println(twos);
        System.out.println(longest);
        System.out.println(palindromes);
        s.close();
    }

 public static int twos() {
        int twos = 0;
        while (s.hasNext()) {
            String word = s.next(); // Read next word as a string
            if (word.length() == 2) {
                twos++;
            }
        }
        return twos;
    }

    public static int longest() throws FileNotFoundException {
        s = new Scanner(f);  // Re-initialize the scanner since it's closed after the previous method
        int maxLength = 0;
        int count = 0;

        while (s.hasNext()) {
            String word = s.next();
            int length = word.length();
            if (length > maxLength) {
                maxLength = length;
                count = 1;  // Reset count for new longest length
            } else if (length == maxLength) {
                count++;  // Increment the count if word is tied for longest
            }
        }
        return count;
    }

    // Method to count palindromes
    public static int palindromes() throws FileNotFoundException {
        s = new Scanner(f);  // Re-initialize the scanner since it's closed after the previous method
        int count = 0;

        while (s.hasNext()) {
            String word = s.next();
            if (isPalindrome(word)) {
                count++;
            }
        }
        return count;
    }

    // Helper method to check if a word is a palindrome
    public static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;  // Not a palindrome
            }
            left++;
            right--;
        }
        return true;  // Is a palindrome
    }
}