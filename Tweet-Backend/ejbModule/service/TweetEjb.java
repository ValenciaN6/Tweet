package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.TweetEntity;

@Stateless
@LocalBean
public class TweetEjb {
	 @PersistenceContext(unitName = "tweet")
	 EntityManager em;
	    
	 public TweetEjb() {
	        // TODO Auto-generated constructor stub
	 }
	 
	 public void saveTweet(TweetEntity tweet) {
		 System.out.println("<<Save tweet in database>>");
		 em.persist(tweet);
	 }
	 
	 public List<TweetEntity> getAllTweets(){
		 return em.createQuery("select e from TweetEntity e",
				 TweetEntity.class).getResultList();
	 }
}
