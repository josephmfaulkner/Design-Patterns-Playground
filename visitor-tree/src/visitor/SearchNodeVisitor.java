package visitor;

import visitor.treenode.TreeNode;
import visitor.treenode.TreeNodeInt;
import visitor.treenode.TreeNodeString;

public class SearchNodeVisitor extends NodeVisitor {

	public Object searchObject;
	private Object foundObject;
	
	public SearchNodeVisitor(Object searchObject)
	{
		this.searchObject = searchObject;
	}
	
	public Object getFoundObject()
	{
		return this.foundObject;
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
		if(compareObjects(this.searchObject, node.getNodeData()) == 0)
		{
			this.foundObject = node.getNodeData();
		}
		else if(compareObjects(this.searchObject, node.getNodeData()) < 0)
		{
			if(node.getLeftNode() == null)
			{
				this.foundObject = null;
			}
			else{
				node.getLeftNode().accept(this);
			};
		}
		else
		{
			if(node.getRightNode() == null)
			{
				this.foundObject = null;
			}
			else{
				node.getRightNode().accept(this);
			};
		}
	}
	
	@Override
	public void VisitIntNode(TreeNodeInt intNode) {
		this.visitNode(intNode);
	}

	@Override
	public void VisitStringNode(TreeNodeString stringNode) {
		this.visitNode(stringNode);
	}
	
	
	
}
