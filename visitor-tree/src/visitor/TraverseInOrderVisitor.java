package visitor;

import visitor.treenode.TreeNode;
import visitor.treenode.TreeNodeInt;
import visitor.treenode.TreeNodeString;

public class TraverseInOrderVisitor extends TraverseVisitor {

	public TraverseInOrderVisitor(NodeVisitorCallBack callback)
	{
		super(callback);
	}
	
	@Override
	protected void visitNode(TreeNode node)
	{
		if(node == null)
		{
			return;
		}
		
		Object nodeData = node.getNodeData();
		
		if(node.getLeftNode() != null)
		{
			node.getLeftNode().accept(this);	
		}
		
		this.callback.call(nodeData);
		
		if(node.getRightNode() != null)
		{
			node.getRightNode().accept(this);	
		}
	}
	
}
