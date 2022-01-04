package visitor;
import visitor.treenode.TreeNodeInt;
import visitor.treenode.TreeNodeString;

public abstract class NodeVisitor {
	public abstract void VisitIntNode(TreeNodeInt intNode);
	public abstract void VisitStringNode(TreeNodeString stringNode);
}
