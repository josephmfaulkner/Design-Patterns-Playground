package visitor;

import visitor.treenode.TreeNode;
import visitor.treenode.TreeNodeInt;
import visitor.treenode.TreeNodeString;

public class TraversePostOrderVisitor extends TraverseVisitor {

	public TraversePostOrderVisitor(NodeVisitorCallBack callback) {
		super(callback);
	}

	@Override
	protected void visitNode(TreeNode node) {
			if(node == null)
			{
				return;
			}
			
			if(node.getLeftNode() != null)
			{
				node.getLeftNode().accept(this);	
			}
			
			if(node.getRightNode() != null)
			{
				node.getRightNode().accept(this);	
			}
			
			Object nodeData = node.getNodeData();
			this.callback.call(nodeData);
		
	}




}
