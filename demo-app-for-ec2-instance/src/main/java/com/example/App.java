package com.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        String[] heart = {
            "  ***     ***  ",
            " *****   ***** ",
            "******* *******",
            "***************",
            " ************* ",
            "  ***********  ",
            "   *********   ",
            "    *******    ",
            "     *****     ",
            "      ***      ",
            "       *       "
        };

        // Print the heart shape
        for (String line : heart) {
            System.out.println(line);
            Thread.sleep(100); // small delay for effect
        }

        // Print your names with emojis
        System.out.println();
        System.out.println("💖 Jai ❤️ Dhana 💖");
        System.out.println("✨ Forever Together ✨");
        System.out.println();
        System.out.println("  Sending love from your EC2 instance! 😎");
    }
}

