package controller;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import Model.Tweet;
import service.TweetEjb;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@RequestScoped
@Path("api")
public class TweetController {
	private final static String CONSUMER_KEY = "XpstGYeLThVeRBnYkeBSp84Dp";
    private final static String CONSUMER_KEY_SECRET = "cP8WdclKSZByN4AvGdpOn9NIUv7kfxTq5dD8bbbULRyNBIGGgf";
    private final static String ACCESS_TOKEN = "1186264213087543296-cHjDI4lzV9VKhyEkkwMAV8sZc9Bk4r";
	private final static String ACCESS_TOKEN_SECRET = "oen0p7B9LbgKnB5vMIlphyhXbRukrYTG2Gapo6Oc0EWah";
	
	@EJB
	TweetEjb ejb;
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createTweet(@FormParam("body") String body) {
		Tweet tweet = new Tweet();
		tweet.setBody(body);
		
		// Save tweet on the database
		ejb.saveTweet(tweet.getTweetEntity());
		
		
		// post a tweet on twitter
		try {
			this.tweetOnTwitter(body);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void tweetOnTwitter(String body) throws TwitterException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(CONSUMER_KEY)
		  .setOAuthConsumerSecret(CONSUMER_KEY_SECRET)
		  .setOAuthAccessToken(ACCESS_TOKEN)
		  .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		Status status = twitter.updateStatus("@ADH-lecture , " + body);
		status.getText();
	}

}
