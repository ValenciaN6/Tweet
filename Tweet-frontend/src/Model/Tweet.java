package Model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.TweetEntity;

@ManagedBean(name = "tweet")
@SessionScoped
public class Tweet {
	private String body;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public TweetEntity getTweetEntity() {
		TweetEntity tweet = new TweetEntity();
		tweet.setBody(this.getBody());
		
		return tweet;
	}
}
