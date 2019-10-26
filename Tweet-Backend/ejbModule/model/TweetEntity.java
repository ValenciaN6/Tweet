package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tweetentity")
public class TweetEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tweetId;
	private String body;
	private Date tweetDate = new Date();
	
	public Long getTweetId() {
		return tweetId;
	}
	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getTweetDate() {
		return tweetDate;
	}
	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}
	
	
}
