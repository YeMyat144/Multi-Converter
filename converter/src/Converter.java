import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            processChoice(choice);
        } while (choice != 8);

        System.out.println("BYE!");
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Choose Conversion:");
        System.out.println("1. Decimal to Binary");
        System.out.println("2. Binary to Decimal");
        System.out.println("3. Decimal to Hexadecimal");
        System.out.println("4. Binary to Hexadecimal");
        System.out.println("5. Hexadecimal to Decimal");
        System.out.println("6. Number to Roman Numeral");
        System.out.println("7. Roman Numeral to Number");
        System.out.println("8. End");
    }

    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                decimalToBinary();
                break;
            case 2:
                binaryToDecimal();
                break;
            case 3:
                decimalToHexadecimal();
                break;
            case 4:
                binaryToHexadecimal();
                break;
            case 5:
                hexadecimalToDecimal();
                break;
            case 6:
                numberToRomanNumeral();
                break;
            case 7:
                romanNumeralToNumber();
                break;
            case 8:
                System.out.println("Ending the program...");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void decimalToBinary() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a decimal number: ");
        int decimal = scanner.nextInt();
        System.out.println("Binary representation: " + Integer.toBinaryString(decimal));
    }

    private static void binaryToDecimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a binary number: ");
        String binary = scanner.next();
        int decimal = Integer.parseInt(binary, 2);
        System.out.println("Decimal representation: " + decimal);
    }

    private static void decimalToHexadecimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a decimal number: ");
        int decimal = scanner.nextInt();
        System.out.println("Hexadecimal representation: " + Integer.toHexString(decimal));
    }

    private static void binaryToHexadecimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a binary number: ");
        String binary = scanner.next();
        int decimal = Integer.parseInt(binary, 2);
        System.out.println("Hexadecimal representation: " + Integer.toHexString(decimal));
    }

    private static void hexadecimalToDecimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a hexadecimal number: ");
        String hexadecimal = scanner.next();
        int decimal = Integer.parseInt(hexadecimal, 16);
        System.out.println("Decimal representation: " + decimal);
    }

    private static void numberToRomanNumeral() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        String romanNumeral = toRoman(number);
        System.out.println("Roman Numeral representation: " + romanNumeral);
    }

    private static void romanNumeralToNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Roman Numeral: ");
        String romanNumeral = scanner.next().toUpperCase();
        int number = fromRoman(romanNumeral);
        System.out.println("Number representation: " + number);
    }

    // Utility function to convert a number to Roman numeral
    private static String toRoman(int number) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    // Utility function to convert a Roman numeral to number
    private static int fromRoman(String roman) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int number = 0;
        int i = 0;
        for (int j = 0; j < symbols.length; j++) {
            while (roman.startsWith(symbols[j], i)) {
                number += values[j];
                i += symbols[j].length();
            }
        }
        return number;
    }
}