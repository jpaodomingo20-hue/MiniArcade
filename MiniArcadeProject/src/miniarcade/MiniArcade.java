package miniarcade;

import java.io.*;

public class MiniArcade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int running = 1; 

        while (running == 1) {
            // Main menu
            System.out.println("\n\n+=============================+");
            System.out.println("|         MINI ARCADE         |");
            System.out.println("+=============================+");
            System.out.println("| 1. Guess the Number         |");
            System.out.println("| 2. Word Scramble            |");
            System.out.println("| 3. Math Quiz                |");
            System.out.println("| 4. Rock, Paper, Scissors    |");
            System.out.println("| 5. Coin Toss                |");
            System.out.println("| 6. Exit                     |");
            System.out.println("+=============================+");
            System.out.print("Choose a game: ");

            String input = br.readLine();

            // Handle empty input
            if (input.isEmpty()) {
                System.out.println("\nYou must enter a number!\n");
                continue;
            }

            int choice = 0;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Enter a number between 1 and 6.\n");
                continue;
            }

            // Game 1
            if (choice == 1) {
                int number = (int)(Math.random() * 50) + 1;
                int guess = 0;
                System.out.println("\nGuess a number between 1 and 50!\n");
                while (guess != number) {
                    System.out.print("Your guess: ");
                    guess = Integer.parseInt(br.readLine());
                    if (guess < number) System.out.println("Too low!\n");
                    else if (guess > number) System.out.println("Too high!\n");
                    else System.out.println("Correct! You guessed it!\n");
                }

            // Game 2
            } else if (choice == 2) {
                String[] words = {"class", "public", "static", "void", "return"};
                int w = (int)(Math.random() * words.length);
                String word = words[w];

                // Scramble the word
                String scrambled = "";
                String temp = word;
                while (temp.length() > 0) {
                    int index = (int)(Math.random() * temp.length());
                    scrambled += temp.charAt(index);
                    temp = temp.substring(0, index) + temp.substring(index + 1);
                }

                System.out.println("\nGuess the word: " + scrambled + "\n");
                String guessWord = "";
                while (!guessWord.equalsIgnoreCase(word)) {
                    System.out.print("Your guess: ");
                    guessWord = br.readLine();
                    if (guessWord.equalsIgnoreCase(word))
                        System.out.println("Correct! You guessed the word!\n");
                    else
                        System.out.println("Wrong! Try again.\n");
                }

            // Game 3
            } else if (choice == 3) {
                System.out.println("\nMath Quiz! Solve 5 random problems.\n");
                int count = 0, score = 0;
                while (count < 5) {
                    int a = (int)(Math.random() * 20) + 1;
                    int b = (int)(Math.random() * 20) + 1;
                    int op = (int)(Math.random() * 3);
                    int answer = 0;
                    String symbol = "";
                    if (op == 0) { answer = a + b; symbol = "+"; }
                    else if (op == 1) { answer = a - b; symbol = "-"; }
                    else { answer = a * b; symbol = "*"; }

                    System.out.print("Problem " + (count + 1) + ": " + a + " " + symbol + " " + b + " = ");
                    int userAns = Integer.parseInt(br.readLine());
                    if (userAns == answer) { 
                        System.out.println("Correct!\n"); 
                        score++; 
                    } else System.out.println("Wrong! The answer is " + answer + "\n");
                    count++;
                }
                System.out.println("Math Quiz over! Your score: " + score + "/5\n");

            // Game 4
            } else if (choice == 4) {
                System.out.println("\nRock, Paper, Scissors! Type rock, paper, or scissors. Type quit to stop.\n");
                int playingRPS = 1;
                while (playingRPS == 1) {
                    System.out.print("Your move: ");
                    String playerMove = br.readLine().toLowerCase();
                    if (playerMove.equals("quit")) break;

                    int comp = (int)(Math.random() * 3);
                    String compMove = (comp == 0) ? "rock" : (comp == 1) ? "paper" : "scissors";
                    System.out.println("Computer chose: " + compMove);

                    if (playerMove.equals(compMove)) System.out.println("It's a tie!\n");
                    else if ((playerMove.equals("rock") && compMove.equals("scissors")) ||
                             (playerMove.equals("paper") && compMove.equals("rock")) ||
                             (playerMove.equals("scissors") && compMove.equals("paper"))) {
                        System.out.println("You win!\n");
                    } else {
                        System.out.println("You lose! Game over!\n");
                        break;
                    }
                }

            // Game 5
            } else if (choice == 5) {
                System.out.println("\nCoin Toss! Type heads or tails. Type quit to stop.\n");
                int playingCoin = 1;
                while (playingCoin == 1) {
                    System.out.print("Your guess: ");
                    String guessCoin = br.readLine().toLowerCase();
                    if (guessCoin.equals("quit")) break;

                    String coin = ((int)(Math.random() * 2) == 0) ? "heads" : "tails";
                    System.out.println("Coin shows: " + coin);
                    if (guessCoin.equals(coin)) System.out.println("Correct!\n");
                    else { System.out.println("You lose! Game over!\n"); break; }
                }

            // Exit
            } else if (choice == 6) {
                running = 0;

            // Invalid choice
            } else {
                System.out.println("\nInvalid choice! Enter a number between 1 and 6.\n");
            }
        }

        
        System.out.println("\n+=============================+");
        System.out.println("| Thanks for playing Mini Arc. |");
        System.out.println("+=============================+\n");
    }
}
