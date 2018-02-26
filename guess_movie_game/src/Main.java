import java.util.Scanner;

public class Main {
    public static void main(String [] args) {

        GuessMovieGame guessMovieGame = new GuessMovieGame();

        //get string from user input
        Scanner scanner = new Scanner(System.in);

        while (!guessMovieGame.isWin()) {
            char guessChar = scanner.next().trim().charAt(0);
            guessMovieGame.guess(guessChar);
        }
    }
}
