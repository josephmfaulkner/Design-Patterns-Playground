package visitor;

import visitor.treenode.TreeNode;
import visitor.treenode.TreeNodeInt;
import visitor.treenode.TreeNodeString;

public class TraversePreOrderVisitor extends TraverseVisitor {

	public TraversePreOrderVisitor(NodeVisitorCallBack callback) {
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
		this.callback.call(nodeData);
		
		if(node.getLeftNode() != null)
		{
			node.getLeftNode().accept(this);	
		}
		
		if(node.getRightNode() != null)
		{
			node.getRightNode().accept(this);	
		}
	}



}
