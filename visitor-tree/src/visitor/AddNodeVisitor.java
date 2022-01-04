package visitor;

import visitor.treenode.TreeNode;
import visitor.treenode.TreeNodeInt;
import visitor.treenode.TreeNodeString;

public class AddNodeVisitor extends NodeVisitor {

	private Object newObject;
	private TreeNode newTreeNode;
	
	public AddNodeVisitor(Object newObject)
	{
		this.newObject = newObject;
		if ( newObject.getClass() == String.class )
		{
			String objStr = (String) newObject;
			this.newTreeNode = new TreeNodeString(objStr);
		}
		else
		{
			int objInt = (int) (newObject);
			this.newTreeNode = new TreeNodeInt(objInt);
		}
	}
	
	private int objToInt(Object obj)
	{
		int objInt;
		if ( obj.getClass() == String.class )
		{
			String objStr = (String) obj;
			objInt = objStr.hashCode();
		}
		else
		{
			objInt = (int) (obj);
		}
		return objInt;
	}
	
	private int compareObjects(Object obj1, Object obj2)
	{
		int obj1Int = objToInt(obj1);
		int obj2Int = objToInt(obj2);
		
		return obj1Int - obj2Int;
		
	}
	
	private void visitNode(TreeNode node)
	{
		if(compareObjects(this.newObject, node.getNodeData()) < 0)
		{
			if(node.getLeftNode() == null)
			{
				node.setLeftNode(this.newTreeNode);
			}
			else{
				node.getLeftNode().accept(this);
			};
		}
		else
		{
			if(node.getRightNode() == null)
			{
				node.setRightNode(this.newTreeNode);
			}
			else{
				node.getRightNode().accept(this);
			};
		}
	}
	
	@Override
	public void VisitIntNode(TreeNodeInt intNode) {
		visitNode(intNode);
	}

	@Override
	public void VisitStringNode(TreeNodeString stringNode) {
		visitNode(stringNode);
	}
	
	

}
