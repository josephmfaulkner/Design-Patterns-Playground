

import java.util.List;

import data.DB;
import entity.Post;
import entity.data.PostData;

public class AppMain {
	
	public static void main(String args[])
	{
		SetupTestData.setup();
		PostData postData = new PostData();
	
		List<Post> allPosts = postData.getAllPosts();
		allPosts.forEach(post -> {
			System.out.println(post.toString());
		});	
		
		DB dbA = DB.getDB();
		DB dbB = DB.getDB();
		
		boolean dbsEqual = dbA == dbB;
		System.out.println(dbA.toString() + " == " + dbB.toString() + " : " + dbsEqual);
	}

}
