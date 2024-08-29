# Word Guessing Game

The purpose of this project is to build a simple word guessing game. You've been provided with a hard-coded array of strings that are five-letter words. In a future assignment, we'll expand on this.

## Sample Code

## Choosing the Word

For right now, we're going to set the program to choose the same word over and over. After the code that defines `words`, insert the following and run the code.

```
// User selects a word from the array
Scanner scan = new Scanner(System.in);
int choice = 0;

String selectedWord = words[choice];

// Display the selected word (for demonstration purposes)
System.out.println("You chose: " + selectedWord + "\n");

```

This will always pick "apple". Later we'll modify the code to randomize the choice, but it's easier to test if you know which word is being chosen. Later we will remove this print statement - imagine playing a guessing game where the answer was given!

## Creating the Model Word

Because strings are *immutable* (you should look that word up), they are hard to work with for certain purposes. Instead, we are going to work with an array of `char`. Insert the following code snippet and run the code.

```
// creates an array of black rectangles
char[] modelWord = new char[5];
for (int i = 0; i < 5; i++) {
    modelWord[i] = '\u25A0';            
}

System.out.println(new String(modelWord));
```

The code '\u25A0' generates a unicode character which looks like a black rectangle. I tried to find one that looked like a box, but couldn't find one that would display on this system. If you find something better, let me know!

Notice also that `new String(modelWord)` generates a string out of an array of `char`. Which is very convenient here! But because we want to be able to use string methods, we want to have a string variable associated with it. So remove the print statement, replacing it with the following. Run the code to make sure it still works.

```
String printModel = new String(modelWord);
System.out.println("The initial guess is " + printModel);
```

## Letter Guessing Step

Since the user needs to make guesses, we need to use the `Scanner` class. We've done something like this previously. Insert the following code and make sure it runs.

```
// User is asked to guess a letter
Scanner scan = new Scanner(System.in);

System.out.print("Guess a letter: ");

char guess = scan.next().toLowerCase().charAt(0);

System.out.println("You guessed " + guess);
```

After you're satisfied the input works the way you want, move the instantiation of `scan` to the top of `main`, just after defining `words`. Then declare `guess` there with `char guess;` and remove the type declaration `char` from the line that uses `scan` in the preceding.

The reason we're doing those is because we will (eventually) need to repeat the guessing over & over. You've already seen that declaring the same variable twice gives you an error.

Test this to make sure it still works, then comment out the last print line.

If you have not been prompted to do so by VSCode already, insert `scan.close();` as the last line of the `main` method. This is necessary to prevent "resource leaks". In fact, you should always do this for any `Scanner` you instantiate, whether the instructions includ this or not!

## Checking Whether the Guess Is Present

Insert code the following code and test it by running and guessing letters you know are in "apple" and letters you know aren't.

```
// lets user know whether the letter is in the word
if (selectedWord.indexOf(guess) == -1) {
    System.out.println(guess + " is not in the word");
} 
```

The string method `indexOf()` returns the location of a letter in a string if it is present. Like the code for finding the maximum and minimum values we saw back in Project 2, it starts with a nonsensical value of -1, and returns the position of the first occurrence of a character in the string. If the character doesn't occur, the value of -1 remains. So if the method returns -1, it didn't find the character.

Notice that we used the method `toLowerCase()` in a previous step because our hard-coded strings for `words` were all in lower case.

Once you are satisfied this works, add an `else` statement that prints when `guess` is in the word.

## Updating `modelWord` With `guess`

We want to run through `selectedWord` and every place `guess` appears, put a copy in `modelWord`, then print what we have. Insert the following and test it by inputting letters that are in "apple" and letters that aren't.

```
// replaces correct characters in modelWord
for (int i = 0; i < 5; i++) {
    if (selectedWord.charAt(i) == guess) {
        modelWord[i] = guess;
    }            
}

// prints updated modelWord
printModel = new String(modelWord);
System.out.println("The word is " + printModel);
```

Once you're satisfied this works, replace the 5 with `selectedWord.length()`. This allows you to use words that have different lengths later!

Note the cycle of usage. We updated `modelWord` based on `selectedWord`, then put a copy of it in `printModel`. Later, we'll add a second use for `printModel`, otherwise we would have just used `new String(modelWord)` here.

Once you have this working, move the code to be inside the `else` block from the previous section. There is no harm in *not* doing this, but it is slightly more efficient to only have that code run when `guess` is in `selectedWord`.

## Making It Repeat

So far you've been guessing a single letter, but we've built a process that should repeat easily. Just make the user continue guessing until all the letters have been filled in. But it's hard to find an end condition. Recall, however, that `indexOf()` could be used to tell when a character was *not* in a string.

Insert the following code after the end of the preceding `else` block and test it.

```
System.out.println('\u25A0' + "is at " + printModel.indexOf('\u25A0'));
```

Because we start with `modelWord` and `printModel` as black rectangles, we should get the position of the first black rectangle from this. If you are satisfied this works, then enclose the code in a `while` loop like the following.

```
while (true) {
    // User is asked to guess a letter
        ...
        LOTS & LOTS OF CODE
        ...
    System.out.println('\u25A0' + "is at " + printModel.indexOf('\u25A0'));
}
```

Test this by inputting each letter in "apple" one by one. Maybe try a few that aren't. Since the `while` loop condition is `true`, you're stuck in an infinite loop. Hit Control-C to break out.

Now replace that obnoxious print line with the following.

```
if (printModel.indexOf('\u25A0') == -1) {
    break;
}
```

As previously discussed, break throws you out of a loop. Test this, but it should now loop until the user has guessed all the letters of the word. Insert a pleasant congratulations to the user on winning the game.

## Making It Into an Actual Game

Now go back through the game and find where `choice` was set. Instantiate a `Random` object and use the randomizer to choose an integer from 0 to 99. Test this for a few words.

Then find the line where you're printing the word out and remove that. Instead insert something to explain the idea of the game.

Now the user should be presented with an explanation and the five black squares and asked to guess a letter. This should continue until they have all the letters and get congratulated.

## Wrapping Up

Go back through and make sure there are sufficient comments to remind you how every part of this works. As mentioned, we will return to this example to make it work better.

Save your work. Stage your changes. Commit. Put a note on Canvas that you're done.