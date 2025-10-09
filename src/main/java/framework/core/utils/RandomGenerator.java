package framework.core.utils;

import java.util.Random;

public class RandomGenerator {

    static Random random = new Random();
    private static String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"};
    private static String[] fakeDomains = {"fake.fake", "invalid.notvalid", "something.sg"};
    private static String [] names = {"John", "Marc", "Nick", "Max", "James", "Finn", "Rey", "Hex", "Hailey",
                                        "Philip", "Washington"};


    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOUPQRSTUVWXYZabcdefghijklmnoupqrstuvwxyz";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }
        return result.toString();
    }

    public static String generateRandomNumber(int length){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(length);
            result.append(digit);
        }
        return result.toString();
    }

    public static String generateRandomEmailAddress() {
        String userName = generateRandomString(10);
        String domain = domains[random.nextInt(domains.length)];

        return userName + "@" + domain;
    }

    public static String generateRandomNames() {
        String name = names[random.nextInt(names.length)];
        return name;
    }


    public static String generateRandomFakeEmail(){
        Random random = new Random();

        String username = generateRandomString(5);
        String domain = fakeDomains[random.nextInt(fakeDomains.length)];

        return username + "@" + domain;
    }

}
