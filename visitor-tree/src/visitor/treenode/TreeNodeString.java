package visitor.treenode;

import visitor.NodeVisitor;

public class TreeNodeString extends TreeNode {

	public TreeNodeString(String nodeData) {
		super(nodeData);
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.VisitStringNode(this);
	}

}
