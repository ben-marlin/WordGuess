package edu.guilford;

import java.util.Scanner;

public class WordGuessingGame {
    public static void main(String[] args) {
        // Hard-coded array of 100 five-letter words
        String[] words = {
            "apple", "grape", "melon", "peach", "lemon",
            "berry", "chess", "grass", "water", "stone",
            "brick", "light", "night", "chair", "table",
            "clock", "plant", "glass", "frame", "track",
            "wheat", "flame", "cloud", "floor", "spoon",
            "knife", "fruit", "bread", "salad", "sugar",
            "cream", "paint", "brush", "earth", "ocean",
            "storm", "field", "shade", "sword", "armor",
            "crown", "globe", "tiger", "eagle", "shark",
            "whale", "zebra", "horse", "sheep", "snake",
            "mouse", "goose", "steel", "metal", "stone",
            "flint", "forge", "weave", "hinge", "screw",
            "laser", "torch", "cable", "drill", "flask",
            "badge", "chain", "grill", "gauge", "lever",
            "patch", "pouch", "quill", "scale", "shear",
            "slice", "spike", "strap", "vapor", "valve",
            "vital", "yield", "blend", "bound", "braid",
            "broom", "crane", "clamp", "clasp", "angle",
            "adopt", "alter", "alert", "bless", "blink",
            "build", "bring", "cover", "grove", "slant"
        };

        // User selects a word from the array
        System.out.print("You have an array of 100 words. Pick a number 1-100: ");

        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        if (choice > 100) {
            choice = choice % 100;
            System.out.println("Pretty sure you meant " + choice);
        }

        String selectedWord = words[choice-1];

        // Display the selected word (for demonstration purposes)
        System.out.println("You chose: " + selectedWord + "\n");

        // User is asked to guess a letter
        System.out.print("Guess a letter: ");

        char guess = scan.next().charAt(0);

        // lets user know whether the letter is in the word
        if (selectedWord.indexOf(guess) == -1) {
            System.out.println(guess + " is not in the word");
        } else {
            System.out.println(guess + " is in the word");
        }

        scan.close();
    }
}
