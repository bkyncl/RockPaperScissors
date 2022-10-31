/* RockPaperScissors.java
 * Module 3 Assignment 
 * Name: Brittany Kyncl
 * Date: 10.27.22
 * Course: CSD320
 * Program to simulate Rock Paper Scissors game with random number generation 1 - 3
 * 1 = Rock
 * 2 = Paper
 * 3 = Scissors
 * */

import java.util.InputMismatchException;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String player; // player name
        int computerChoice; // computer choice
        int playerChoice; // player choice
        int playAgain = 1;
    
        // program message
        System.out.println("\nWelcome to Rock, Paper, and Scissors game!!!");
        System.out.print("Please enter player name: "); // get user's name
        player = input.nextLine();
    
        while (playAgain == 1) {

            // player options prompt
            System.out.println("\nWelcome " + player + "!" + "\nPlease choose your weapon..."
                            + "\n1 - ROCK \n2 - PAPER \n3 - SCISSORS");
            
            // User choice validation loop
            while (true) {

                computerChoice = (int)(Math.random() * 3 + 1); // randomly generate computer choice 1-3

                System.out.print("\nEnter choice: "); // user choice prompt
                try {   
                    playerChoice = input.nextInt();

                    if(playerChoice == computerChoice) { // check for tie
                        System.out.println("\nYou Tied. Try again!");// let user try again
                    }
                    else if (playerChoice >= 0 && playerChoice <= 3) {
                        break; // verify choice ic valid
                    }
                    else { // chech valid number range
                        System.out.println("Enter only integers between 1-3."); // error message
                    }
                }
                catch (InputMismatchException e) {
                    input.nextLine();
                    System.out.println("Invalid Input. Enter only integers 1-3.");
                }
            }

            String playerWeapon = Integer.toString(playerChoice);
            String computerWeapon = Integer.toString(computerChoice);

            // switching player choice 1-3 to cooresponding weapon options for print statement
            switch (playerChoice) {
                case 1: System.out.println("\n" + player +  " chose: \"ROCK\"");
                        playerWeapon = "ROCK"; break;
                case 2: System.out.println("\n" + player +  " chose: \"PAPER\""); 
                        playerWeapon = "PAPER"; break;
                case 3: System.out.println("\n" + player +  " chose: \"SCISSORS\"");
                        playerWeapon = "SCISSORS"; break;
            }

            // switching copmuter choice 1-3 to cooresponding weapon options for print statement
            switch (computerChoice) {
                case 1: System.out.println("Your oppenent chose: \"ROCK\"");
                        computerWeapon = "ROCK"; break;
                case 2: System.out.println("Your oppenent chose: \"PAPER\"");
                        computerWeapon = "PAPER"; break;
                case 3: System.out.println("Your oppenent chose: \"SCISSORS\"");
                        computerWeapon = "SCISSORS"; break;
            }

            // check player choice against computerchoice
            if (playerChoice == 1 && computerChoice == 3
                    || playerChoice == 3 && computerChoice == 2
                    || playerChoice == 2 && computerChoice == 1) {
                System.out.println("--- YOU WON!! ---");// winning statement
                System.out.println(playerWeapon + " beats " + computerWeapon);
            }
            else {
                System.out.println("--- You lost :( ---"); // losing statement
                System.out.println(computerWeapon + " beats " + playerWeapon);
            }
        
            System.out.print("\nTo play again enter 1 to exit press 2: ");
            playAgain = input.nextInt();

        }

        System.out.println("Goodbye...");

        input.close();
    }
        
}
