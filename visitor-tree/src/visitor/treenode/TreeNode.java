package visitor.treenode;

import visitor.NodeVisitor;

public abstract class TreeNode {

	private TreeNode leftNode;
	private TreeNode rightNode;
	private Object nodeData;
	
	public TreeNode(Object nodeData)
	{
		this.nodeData = nodeData;
		this.leftNode = null;
		this.rightNode = null;
	}

	public TreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public Object getNodeData() {
		return nodeData;
	}

	public void setNodeData(Object nodeData) {
		this.nodeData = nodeData;
	}
	
	public abstract void accept(NodeVisitor visitor);
		
}
