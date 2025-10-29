import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // You will need to import the Random library from java.util

        // To use methods from the Random library you will need to create an instance of Random
        Random randMachine = new Random();

        int[] tenRolls = getTenRolls(randMachine);
        for (int tenRoll : tenRolls) {
            System.out.println(tenRoll);
        }
        System.out.println("\n");
        char letter = getRandomLetter(randMachine);
        System.out.println(letter);

        StringBuilder password = generatePassword(randMachine);
        System.out.println("\n" + password + "\n");

        String[] passwordSet = getNewPasswordSet(randMachine,10);
        for (String s : passwordSet) {
            System.out.println(s);
        }
        int[] shuffledArray = shuffleArray(randMachine, new int[]{5, 1, 24, 4, 123, 12, 5325, 421});
        System.out.println("\n");
        for (int shuffled : shuffledArray) {
            System.out.println(shuffled);
        }
    }

    public static int[] getTenRolls(Random rand) {
        int[] rolls = new int[10];
        for (int i = 0; i < rolls.length; i++) {
            rolls[i] = rand.nextInt(20) + 1;
        }
        return rolls;
    }

    public static char getRandomLetter(Random rand) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int randIdx = rand.nextInt(26);
        return letters[randIdx];
    }

    public static StringBuilder generatePassword(Random rand) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            password.append(letters[rand.nextInt(letters.length)]);
        }
        return password;
    }

    public static String[] getNewPasswordSet(Random rand, int length) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        StringBuilder password = new StringBuilder();
        String[] passwordSet = new String[length];
        for (int i = 0; i < length; i++) {
            password = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                password.append(letters[rand.nextInt(letters.length)]);
            }
            passwordSet[i] = password.toString();
        }
        return passwordSet;
    }

    public static int[] shuffleArray(Random rand,int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int randIdx = rand.nextInt(arr.length);
            int temp = arr[randIdx];
            arr[randIdx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
