import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));

        System.out.println("---------------------------------------------");

        System.out.println(checkForPalindromeQueue("abccba"));
        System.out.println(checkForPalindromeQueue("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindromeQueue("I did, did I?"));
        System.out.println(checkForPalindromeQueue("hello"));
        System.out.println(checkForPalindromeQueue("Don't node"));

        System.out.println("---------------------------------------------");

        System.out.println(transformBinary(13));


    }

    public static boolean checkForPalindrome(String text) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder noPunctuation = new StringBuilder();
        String cleanTextBegin = text.replaceAll("I", "i");
        String lowerCase = cleanTextBegin.toLowerCase();
        String cleanText = lowerCase.replaceAll("[^a-zA-Z ]", "").replaceAll(" ", "");

        for (int i = 0; i < cleanText.length(); i++) {
            char c = cleanText.charAt(i);
            stack.push(c);
        }

        StringBuilder reverse = new StringBuilder();
        while (!stack.isEmpty()) {
            reverse.append(stack.pop());
        }


        if (cleanText.equals(reverse.toString())) {
            return true;
        } else {
            return false;
        }


    }

    public static boolean checkForPalindromeQueue(String text) {
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String cleanTextBegin = text.replaceAll("I", "i");
        String lowerCase = cleanTextBegin.toLowerCase();
        String cleanText = lowerCase.replaceAll("[^a-zA-Z ]", "").replaceAll(" ", "");

        for (int i = 0; i < cleanText.length(); i++) {
            char c = cleanText.charAt(i);
            stack.push(c);
            queue.addLast(c);
        }

        if (stack.equals(queue)) {
            return true;
        } else {
            return false;
        }


    }

    public static String transformBinary(int num){
        final int base = 2;
        Stack<Integer> digits = new Stack();

        while(num>0){
            digits.push(num%base);
            num=num/base;
        }

        String bits="";
        while(!digits.isEmpty()){
            bits += digits.pop();
        }
        return bits;



    }



}