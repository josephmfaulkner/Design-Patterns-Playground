package composite.controls;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import composite.DrawableInfo;

public class TreeViewControls implements TreeSelectionListener  {

	private JTree jTree;
	private TreeSelectCallBack treeSelectCallBack;
	
	public TreeViewControls(JTree jTree, TreeSelectCallBack treeSelectCallBack)
	{
		this.jTree = jTree;
		this.treeSelectCallBack = treeSelectCallBack;
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent arg0) {

		DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
		if (node != null)
		{
			DrawableInfo drawableInfo = (DrawableInfo) node.getUserObject();
			treeSelectCallBack.callback(drawableInfo);
		}
	}

}
