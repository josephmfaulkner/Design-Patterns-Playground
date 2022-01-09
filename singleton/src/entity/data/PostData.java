package entity.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.DB;
import data.ResultSetCallback;
import data.SetDbParamsCallback;
import entity.Post;

public class PostData {
	
	private DB db;
	
	public PostData()
	{
		this.db = DB.getDB();
		this.setupEntity();
	}
	
	private void setupEntity()
	{
		String sql = "CREATE TABLE IF NOT EXISTS POST (\n"
		                + "	id integer PRIMARY KEY,\n"
		                + "	title text NOT NULL,\n"
		                + " content text NOT NULL, \n"
		                + "	capacity real\n"
		                + ");";
		
		db.runStatement(sql);
	}
	
	public void addNewPost(Post post)
	{
			String sql = "INSERT INTO POST (title,content) VALUES(?,?)";
			
			db.runStatement(sql, (PreparedStatement stmt) -> {
				try {
					stmt.setString(1, post.getTitle());
					stmt.setString(2, post.getContent());
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			});
	}
	
	public Post getPost(int id)
	{
		String sql = "SELECT id, title, content FROM POST WHERE id = ?";
		List<Post> postsList = new ArrayList<Post>();
		
		SetDbParamsCallback setDbParamsCallback = (PreparedStatement stmt) -> {
			try {
				stmt.setInt(1, id);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		};
		ResultSetCallback resultSetCallback = (ResultSet rs) -> {
			try {
				while(rs.next())
				{
					postsList.add(new Post(rs.getInt("id"), rs.getString("title"), rs.getString("content")));
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		};
		
		db.queryData(sql, setDbParamsCallback, resultSetCallback);
		
		return postsList.get(0);
	}
	
	public List<Post> getAllPosts()
	{
		String sql = "SELECT id, title, content FROM POST";
		List<Post> postsList = new ArrayList<Post>();
		
		SetDbParamsCallback setDbParamsCallback = (PreparedStatement stmt) -> {};
		ResultSetCallback resultSetCallback = (ResultSet rs) -> {
			try {
				while(rs.next())
				{
					postsList.add(new Post(rs.getInt("id"), rs.getString("title"), rs.getString("content")));
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		};
		
		db.queryData(sql, setDbParamsCallback, resultSetCallback);
		
		return postsList;
	}
	
	
	
}
