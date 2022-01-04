import visitor.AddNodeVisitor;
import visitor.NodeVisitor;
import visitor.NodeVisitorCallBack;
import visitor.SearchNodeVisitor;
import visitor.TraverseInOrderVisitor;
import visitor.TraversePostOrderVisitor;
import visitor.TraversePreOrderVisitor;
import visitor.treenode.TreeNode;
import visitor.treenode.TreeNodeInt;
import visitor.treenode.TreeNodeString;

public class Tree {
	
	private TreeNode rootNode;
	
	public Tree(String string)
	{
		this.rootNode = new TreeNodeString(string);
	}
	
	public Tree(int integer)
	{
		this.rootNode = new TreeNodeInt(integer);
	}
	
	public void add(String string)
	{
		NodeVisitor addNodeVisitor = new AddNodeVisitor(string);
		this.rootNode.accept(addNodeVisitor);
	}
	
	public void add(int integer)
	{
		NodeVisitor addNodeVisitor = new AddNodeVisitor(integer);
		this.rootNode.accept(addNodeVisitor);
	}
	
	public int search(int searchInt) throws Exception
	{
		SearchNodeVisitor searchNodeVisitor = new SearchNodeVisitor(searchInt);
		this.rootNode.accept(searchNodeVisitor);
		
		if(searchNodeVisitor.getFoundObject() != null)
		{
			return (int) searchNodeVisitor.getFoundObject();
		}
		throw new Exception("No such int in tree");
	}
	
	public String search(String searchString) throws Exception
	{
		SearchNodeVisitor searchNodeVisitor = new SearchNodeVisitor(searchString);
		this.rootNode.accept(searchNodeVisitor);
		
		if(searchNodeVisitor.getFoundObject() != null)
		{
			return (String) searchNodeVisitor.getFoundObject();
		}
		throw new Exception("No such string in tree");
	}
	
	public void traversePreOrder(NodeVisitorCallBack callBack)
	{
		this.rootNode.accept(new TraversePreOrderVisitor(callBack));
	}
	
	public void traverseInOrder(NodeVisitorCallBack callBack)
	{
		this.rootNode.accept(new TraverseInOrderVisitor(callBack));
	}
	
	public void traversePostOrder(NodeVisitorCallBack callBack)
	{
		this.rootNode.accept(new TraversePostOrderVisitor(callBack));
	}

	
}
