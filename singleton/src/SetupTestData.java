import java.util.List;

import data.DB;
import entity.Post;
import entity.data.PostData;

public class SetupTestData {
	public static void setup()
	{
		PostData postData = new PostData();
		List<Post> allPosts = postData.getAllPosts();
		
		if(allPosts.size() <= 0)
		{
			Post postA = new Post("A: First Post","A: Post Content");
			Post postB = new Post("B: Second Post","B: Post Content");
			Post postC = new Post("C: Third Post","C: Post Content");
			Post postD = new Post("D: Forth Post","D: Post Content");

			postData.addNewPost(postA);
			postData.addNewPost(postB);
			postData.addNewPost(postC);
			postData.addNewPost(postD);
		}
		
	}
}
