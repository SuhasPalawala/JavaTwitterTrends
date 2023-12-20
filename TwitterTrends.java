//Name: Suhas Palawala
//Date: 11/16/2023

import java.util.*;
import java.io.*;

//This class takes a text file with a some sample tweets and displays any risks of 
//covid misinformation and the word used most often in the collection of tweets.
public class TwitterTrends {
    // TODO: Your Code Here
    private TweetBot bot;

    /*
    Behavior: This method acts as a constructor for the TwitterTrends class, allowing the user to create a new
                instance of TwitterTrends to analyze a collection of tweets.
    Parameters: bot: the instance of TweetBot that acts as a medium for adding and removing tweets to analyze.
    */
    public TwitterTrends(TweetBot bot) {
        this.bot = bot;
    }

    /*
    Behavior: This method goes through the collection of tweets and determines what word is used the most 
                often over all the tweets.
    Returns: String: the word used most often across all the tweets
    */
    public String getMostFrequentWord() {
        Map<String, Integer> wordCounter = new HashMap();
        // if(wordCounter.size() == 1) {
        //     for(String x: wordCounter.keySet()) {
        //         return x;
        //     }
        // }

        for(int a = 0; a < this.bot.numTweets(); a++) {
            String nextStr = this.bot.nextTweet().toLowerCase();
            Scanner wordReader = new Scanner(nextStr);
            while(wordReader.hasNext()) {
                String tempStr = wordReader.next();
                if(!wordCounter.containsKey(tempStr)) {
                    wordCounter.put(tempStr, 1);
                } else {
                    wordCounter.put(tempStr, wordCounter.get(tempStr) + 1);
                }
            }
        }

        int largest = 0;
        String largestStr = " ";
        for(String y: wordCounter.keySet()) {
            if(wordCounter.get(y) > largest) {
                largest = wordCounter.get(y);
                largestStr = y;
            }
        }

        return largestStr;
    }

    /*
    Behavior: This method analyzes a set of tweets for certain keywords in order
                to determine if there is any risk of potential covid-19 misinformation.
                It also keeps track of what tweets were flagged as potential risks.
    Returns: String: If there are any tweets that might potentially contain covid-19 misinformation,
                        this method returns a message about accessing up-to-date information from the 
                        CDC website and returns a list of tweets that might have misinformation. If there aren't 
                        any tweets that match this description, the method simply returns a statement that says there
                        were no risks detected.
    */
    public String sicknessAlertSystem() {
        ArrayList<String> concerningTweets = new ArrayList<String>();
        for(int a = 0; a < this.bot.numTweets(); a++) {
            String nextStr = this.bot.nextTweet().toLowerCase();
            if(nextStr.contains("covid-19") ||
                nextStr.contains("pandemic") ||
                nextStr.contains("vaccine") ||
                nextStr.contains("coronavirus")) {
                    concerningTweets.add(nextStr);
                }
        }
        if(concerningTweets.size() > 0) {
            return "Tweets with Potential Misinformation: " + 
            concerningTweets.toString() + ". " +
            "For accurate and up-to-date information on the COVID-19 pandemic, " + 
            "please visit the official coronavirus page on the Center of Disease Control and Prevention's website: " + 
             "https://www.cdc.gov/coronavirus/2019-ncov/index.html";
        }
        return "No Covid-19 Misinformation Risk Here";
    }
}