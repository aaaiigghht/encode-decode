import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();   // ENCODE або DECODE
        int pseudoRandomNumber = Integer.parseInt(in.nextLine());
        String rotor1 = in.nextLine();
        String rotor2 = in.nextLine();
        String rotor3 = in.nextLine();
        String message = in.nextLine();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (operation.equals("ENCODE")) {
            // Caesar shift
            String shifted = "";
            for (int i = 0; i < message.length(); i++) {
                char currentChar = message.charAt(i);
                int position = alphabet.indexOf(currentChar);
                int newPosition =
                        (position + pseudoRandomNumber + i) % 26;
                shifted += alphabet.charAt(newPosition);
            }
            // Rotor 1
            String afterRotor1 = "";
            for (int i = 0; i < shifted.length(); i++) {
                char currentChar = shifted.charAt(i);
                int position = alphabet.indexOf(currentChar);
                afterRotor1 += rotor1.charAt(position);
            }
            // Rotor 2
            String afterRotor2 = "";
            for (int i = 0; i < afterRotor1.length(); i++) {
                char currentChar = afterRotor1.charAt(i);
                int position = alphabet.indexOf(currentChar);
                afterRotor2 += rotor2.charAt(position);
            }
            // Rotor 3
            String result = "";
            for (int i = 0; i < afterRotor2.length(); i++) {
                char currentChar = afterRotor2.charAt(i);
                int position = alphabet.indexOf(currentChar);
                result += rotor3.charAt(position);
            }
            System.out.println(result);
        }
        else if (operation.equals("DECODE")) {
            // Ротор 3\\зворотній напрямок
            String afterRotor3 = "";
            for (int i = 0; i < message.length(); i++) {
                char currentChar = message.charAt(i);
                int position = rotor3.indexOf(currentChar);
                afterRotor3 += alphabet.charAt(position);
            }
            // Ротор 2\\зворотній напрямок
            String afterRotor2 = "";
            for (int i = 0; i < afterRotor3.length(); i++) {
                char currentChar = afterRotor3.charAt(i);
                int position = rotor2.indexOf(currentChar);
                afterRotor2 += alphabet.charAt(position);
            }
            // Ротор 1\\зворотній напрямок
            String afterRotor1 = "";
            for (int i = 0; i < afterRotor2.length(); i++) {
                char currentChar = afterRotor2.charAt(i);
                int position = rotor1.indexOf(currentChar);
                afterRotor1 += alphabet.charAt(position);
            }
            // Прибираємо Caesar
            String result = "";
            for (int i = 0; i < afterRotor1.length(); i++) {
                char currentChar = afterRotor1.charAt(i);
                int position = alphabet.indexOf(currentChar);
                int newPosition =
                        (position - pseudoRandomNumber - i) % 26;
                // у Java % може дати від'ємне число
                if (newPosition < 0) {
                    newPosition += 26;
                }
                result += alphabet.charAt(newPosition);
            }

            System.out.println(result);
        }
    }
}
