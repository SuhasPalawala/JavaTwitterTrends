//Name: Suhas Palawala
//Date: 11/16/2023

import java.util.*;
import java.io.*;

//This class produces the output of the methods from the TwitterTrends java file.
public class TwitterMain {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("tweets.txt")); // Make Scanner over tweet file
        List<String> tweets = new ArrayList<>();
        while (input.hasNextLine()) { // Add each tweet in file to List
            tweets.add(input.nextLine());
        }

        TweetBot bot = new TweetBot(tweets); // Create TweetBot object with list of tweets
        TwitterTrends trends = new TwitterTrends(bot); // Create TwitterTrends object

        // TODO: Call and display results from getMostFrequentWord and your
        // creative method here
        System.out.println("Most frequently occuring word in text file:");
        System.out.println(trends.getMostFrequentWord());
        System.out.println();
        System.out.println("Covid Misinformation:");
        System.out.println(trends.sicknessAlertSystem());
    }
}