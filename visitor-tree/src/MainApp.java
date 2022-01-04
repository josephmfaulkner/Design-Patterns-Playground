import visitor.AddNodeVisitor;
import visitor.NodeVisitor;
import visitor.SearchNodeVisitor;
import visitor.TraverseInOrderVisitor;
import visitor.TraversePreOrderVisitor;
import visitor.treenode.TreeNode;
import visitor.treenode.TreeNodeInt;
import visitor.treenode.TreeNodeString;

public class MainApp {

	public static void main(String[] args) {
		
		
		Tree myTree = new Tree(50);
		
		myTree.add(25);
		myTree.add(75);
		myTree.add(15);
		myTree.add(90);
		myTree.add(100);
		
		myTree.add("Apple");
		myTree.add("Montana");
		myTree.add("City");
		myTree.add("Egypt");
		myTree.add("Zebra");
		
		myTree.traversePreOrder(obj -> { System.out.println(obj.toString()); });
		
		try {
			String findString = myTree.search("City");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			int findInt = myTree.search(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
		/*
		NodeVisitor travelNodeVisitor = new TraversePreOrderVisitor(
				(obj) -> {
					if(obj.getClass() == String.class)
					{
						System.out.println(obj.toString());
					}
					else
					{
						System.out.println(obj.toString());
					}
					
				}
		);
		
		
		
		
		
		TreeNode treeNode = new TreeNodeInt(50);
		
		treeNode.accept(new AddNodeVisitor("Apple"));
		treeNode.accept(new AddNodeVisitor("Montana"));
		treeNode.accept(new AddNodeVisitor("City"));
		treeNode.accept(new AddNodeVisitor("Egypt"));
		treeNode.accept(new AddNodeVisitor("Zebra"));
		
		treeNode.accept(new AddNodeVisitor(25));
		treeNode.accept(new AddNodeVisitor(75));
		treeNode.accept(new AddNodeVisitor(15));
		treeNode.accept(new AddNodeVisitor(90));
		treeNode.accept(new AddNodeVisitor(100));
		

				
		treeNode.accept(travelNodeVisitor);
		
		
		SearchNodeVisitor searchNodeVisitor = new SearchNodeVisitor("City");
		treeNode.accept(searchNodeVisitor);
		Object foundObject = searchNodeVisitor.getFoundObject();
		System.out.println("Found " + foundObject.toString());
		
		*/
		
	}

}
