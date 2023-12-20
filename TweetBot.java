//Name: Suhas Palawala
//Date: 11/16/2023

import java.util.*;
import java.io.*;
//This class creates and manages a list of tweets for analysis. It contains methods that allows the user to 
//manipulate the list by performing actions like adding tweets, removing tweets, and cycling through tweets.
public class TweetBot {
    // TODO: Your Code Here
    private ArrayList<String> collectionTweets = new ArrayList<String>();
    private int counter = 0;

    /*
    Behavior: This method acts as a constructor for the TweetBot class, allowing the user to create a new
                instance of TweetBot and add tweets they would like to analyze.
    Parameters: tweets: the tweets that the user would like to initially add to this instance of TweetBot
    */
    public TweetBot(List<String> tweets) {
        if(tweets.size() < 1) {
            throw new IllegalArgumentException();
        }

        for(int a = 0; a < tweets.size(); a++) {
            collectionTweets.add(tweets.get(a));
        }
    }

    /*
    Behavior: This method returns the number of tweets that have been inputted by the user 
                into this instance of TweetBot.
    Returns: int: number of tweets that have been inputted by the user 
                into this instance of TweetBot.
    */
    public int numTweets() {
        return collectionTweets.size();
    }

    /*
    Behavior: This method allows a user to add a tweet to this instance of TweetBot.
    Parameters: tweet: the tweet that the user would like to add
    */
    public void addTweet(String tweet) {
        collectionTweets.add(collectionTweets.size() - counter, tweet);
    }

    /*
    Behavior: This method allows for the user to extract tweets to analyze in a way where
                they can pull all the tweets one at a time. Once they pull all the tweets, the order
                will start from the beginning again. 
    Returns: String: the next tweet the user would like to extract
    */
    public String nextTweet() {
        String nextStr = collectionTweets.get(0);
        if(counter == collectionTweets.size()) {
            counter = 1;
        } else {
            counter++;
        }
        collectionTweets.remove(0);
        collectionTweets.add(nextStr);
        return nextStr;
    }

    /*
    Behavior: This method allows the user to remove a tweet from this instance of TweetBot. 
    Parameters: String: the tweet the user would like to remove
    */
    public void removeTweet(String tweet) {
        if(collectionTweets.contains(tweet)) {
            if(collectionTweets.indexOf(tweet) >= collectionTweets.size() - counter) {
                counter--;
            }
            collectionTweets.remove(tweet);
        }
    }

    /*
    Behavior: This method resets the order in which the user to extract tweets. 
    */
    public void reset() {
        String tempStr = " ";
        for(int a = 0; a < counter; a++) {
            tempStr = collectionTweets.get(collectionTweets.size() - 1);
            collectionTweets.remove(tempStr);
            collectionTweets.add(0, tempStr);
        }
        counter = 0;
    }
}   