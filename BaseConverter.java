import java.util.Scanner;

public class BaseConverter {
    private static final String DIGITS = "0123456789ABCDEF";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number to be converted:");
        String number = scanner.nextLine();

        System.out.println("Please enter the base of the number to be converted (2-16):");
        int fromBase = scanner.nextInt();

        System.out.println("Please enter the base to which the number should be converted (2-16):");
        int toBase = scanner.nextInt();

        try {
            validateInput(number, fromBase);
            String result = convertBase(number, fromBase, toBase);
            System.out.println("The converted number is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }

        scanner.close();

        runTests();
    }

    public static String convertBase(String number, int fromBase, int toBase) {
        if (fromBase < 2 || fromBase > 16 || toBase < 2 || toBase > 16) {
            throw new IllegalArgumentException("Bases must be between 2 and 16.");
        }

        int decimalValue = toDecimal(number, fromBase);
        return fromDecimal(decimalValue, toBase);
    }

    private static void validateInput(String number, int base) {
        for (char c : number.toUpperCase().toCharArray()) {
            int digit = DIGITS.indexOf(c);
            if (digit == -1 || digit >= base) {
                throw new IllegalArgumentException("Invalid character in the input number for base " + base);
            }
        }
    }

    private static int toDecimal(String number, int base) {
        int value = 0;
        for (char c : number.toUpperCase().toCharArray()) {
            int digit = DIGITS.indexOf(c);
            value = value * base + digit;
        }
        return value;
    }

    private static String fromDecimal(int decimal, int base) {
        StringBuilder result = new StringBuilder();
        while (decimal > 0) {
            int digit = decimal % base;
            result.insert(0, DIGITS.charAt(digit));
            decimal /= base;
        }
        return result.length() > 0 ? result.toString() : "0";
    }

    private static void runTests() {
        System.out.println("\nRunning tests...");

        testConversion("1010", 2, 10, "10");
        testConversion("A", 16, 2, "1010");
        testConversion("25", 10, 8, "31");
        testConversion("0", 2, 16, "0");
        testConversion("1", 2, 16, "1");
        testConversion("F", 16, 2, "1111");

        // Edge cases
        testConversion("11111111", 2, 16, "FF");
        testConversion("FF", 16, 2, "11111111");
        testConversion("777", 8, 10, "511");

        System.out.println("All tests passed!");
    }

    private static void testConversion(String number, int fromBase, int toBase, String expected) {
        String result = convertBase(number, fromBase, toBase);
        if (result.equals(expected)) {
            System.out.println("Test passed: " + number + " (base " + fromBase + ") -> " + result + " (base " + toBase + ")");
        } else {
            System.out.println("Test failed: " + number + " (base " + fromBase + ") -> " + result + " (base " + toBase + "), expected " + expected);
        }
    }
}


