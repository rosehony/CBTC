import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int maxAttempts = 5;
        int score = 0;
        boolean playAgain = true;
        
        System.out.println("Welcome to Guess the Number!");
        
        while (playAgain) {
            int level = 1;
            boolean guessedCorrectly;
            
            do {
                int lowerBound = 1;
                int upperBound = 100 * level;
                int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                int numberOfAttempts = 0;
                int guess = 0;
                guessedCorrectly = false;
                
                System.out.println("\nLevel " + level);
                System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");
                
                while (guess != numberToGuess && numberOfAttempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    guess = scanner.nextInt();
                    numberOfAttempts++;
                    
                    if (guess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else if (guess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        guessedCorrectly = true;
                        int points = (maxAttempts-numberOfAttempts) * 10;
                        score += points;
                        System.out.println("Congratulations! You guessed the number in " + numberOfAttempts + " attempts.");
                        System.out.println("You earned " + points + " points. Total score: " + score);
                    }
                }
                
                if (!guessedCorrectly) {
                    System.out.println("Sorry! You've reached the maximum number of attempts. The number was " + numberToGuess);
                }
                
                level++;
            } while (guessedCorrectly);
            
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
        
        scanner.close();
    }
}
