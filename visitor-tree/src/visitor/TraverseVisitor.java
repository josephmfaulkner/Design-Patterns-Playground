package visitor;

import visitor.treenode.TreeNode;
import visitor.treenode.TreeNodeInt;
import visitor.treenode.TreeNodeString;

public abstract class TraverseVisitor extends NodeVisitor {

	protected NodeVisitorCallBack callback;
	public TraverseVisitor(NodeVisitorCallBack callback)
	{
		this.callback = callback;
	}
	
	protected abstract void visitNode(TreeNode node);
	
	@Override
	public void VisitIntNode(TreeNodeInt intNode) {
		this.visitNode(intNode);
	}

	@Override
	public void VisitStringNode(TreeNodeString stringNode) {
		this.visitNode(stringNode);
	}
	
}
