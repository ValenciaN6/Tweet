package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.TweetEntity;

@Stateless
@LocalBean
public class TweetEjb {
	 @PersistenceContext(unitName = "digibank")
	 EntityManager em;
	    
	 public TweetEjb() {
	        // TODO Auto-generated constructor stub
	 }
	 
	 public void saveTweet(TweetEntity tweet) {
		 System.out.println("<<Save tweet in database>>");
		 em.persist(tweet);
	 }
}
