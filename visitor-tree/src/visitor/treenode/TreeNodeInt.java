package visitor.treenode;

import visitor.NodeVisitor;

public class TreeNodeInt extends TreeNode {

	public TreeNodeInt(int nodeData) {
		super(nodeData);
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.VisitIntNode(this);
	}
	
}
