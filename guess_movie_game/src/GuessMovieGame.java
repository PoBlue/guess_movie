import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessMovieGame {

    private String movieName;
    private StringBuilder outputBuilder;

    public GuessMovieGame() {
        movieName = getRandomMovieName();

        String output = movieName.replaceAll("[a-zA-Z]", "_");
        outputBuilder = new StringBuilder(output);

        welcomeMessage();
    }

    private void welcomeMessage() {
        System.out.println(outputBuilder);
    }

    private void wrongMessage() {
        System.out.println("wrong");
    }

    private void rightMessage() {
        System.out.println("right");
        System.out.println(outputBuilder);
    }

    public void guess(char guessChar) {
        int foundIndex = movieName.indexOf(guessChar);

        if(foundIndex == -1) {
            wrongMessage();
        } else {
            outputBuilder.setCharAt(foundIndex, guessChar);
            rightMessage();
        }
    }

    public boolean isWin() {
        return outputBuilder.indexOf("_") == -1;
    }

    //get random movie name
    public String getRandomMovieName() {
        List<String> moviesName = new ArrayList<>();

        //read file line by line
        File file = new File("movies.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                //add to list
                moviesName.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        //random movie num
        int totalNum = moviesName.size();
        int randomNum = (int) (Math.random() * totalNum);

        return moviesName.get(randomNum);
    }
}
