import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessMovieGame {
    public static void main(String [] args) {
        String movieName = getRandomMovieName();
        System.out.println(movieName);

        //get string from user input
//        Scanner scanner = new Scanner(System.in);
//        String guess  = scanner.next();

//        System.out.println(guess);

    }

    //get random movie name
    private static String getRandomMovieName() {
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
