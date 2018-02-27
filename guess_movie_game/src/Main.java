import java.util.Scanner;

public class Main {
    public static void main(String [] args) {

        GuessMovieGame guessMovieGame = new GuessMovieGame(10);

        //get string from user input
        Scanner scanner = new Scanner(System.in);

        while (!guessMovieGame.isFinished()) {
            char guessChar = scanner.next().trim().charAt(0);
            guessMovieGame.guess(guessChar);
        }

        if(guessMovieGame.isWin()) {
            System.out.println("you win");
        } else {
            System.out.println("you lose");
        }
    }
}
