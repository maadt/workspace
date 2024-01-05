package game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Pattern;

class GameUtils {
    static String REGEX_ALPHABET = "^[A-Za-z]{4,12}$";//アルファベットのみで4~12文字
    private GameUtils() {};

    public static String getInputString() {
        String name = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            name = br.readLine();
            if (name.matches(REGEX_ALPHABET)) {
                name = name;
            } else if (name.matches("\\d+")) {
                name = name;
            } else {
                throw new IOException();
            }
        } catch (IOException e) {
            System.out.println("Input error...Please retype!");
            e.printStackTrace();
            return getInputString();
        }
        return name;
    }

    public static int getInputInt() {
        int bet = 0;
        try {
            bet = Integer.parseInt(getInputString());
        } catch (NumberFormatException e) {
            System.out.println("Please enter an integer!");
            e.printStackTrace();
            return getInputInt();
        }
        return bet;
    }


    public static int getRandomInt(int maxValue) {
        Random random = new Random();
        int card = random.nextInt(maxValue);
        return card;
    }

    public static boolean checkPattern(String targetStr) {
        boolean result = Pattern.matches(REGEX_ALPHABET, targetStr);
        return result;
    }
}
