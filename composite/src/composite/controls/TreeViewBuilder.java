package composite.controls;

import java.awt.Dimension;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import composite.DrawableInfo;
import composite.controls.TreeSelectCallBack;
import composite.drawable.Drawable;
import composite.drawable.DrawableParent;

public class TreeViewBuilder {
	
	public static JTree createTreeView(Drawable drawable, TreeSelectCallBack selectCallBack)
	{
		DefaultMutableTreeNode tree = new DefaultMutableTreeNode( new DrawableInfo ("Object Info", drawable));
		populateTreeViewRecursive(tree, drawable);
				
		JTree jTree = new JTree(tree);
		jTree.getSelectionModel().setSelectionMode (TreeSelectionModel.SINGLE_TREE_SELECTION);
		//Listen for when the selection changes.
		
		jTree.addTreeSelectionListener( new TreeViewControls( jTree, selectCallBack));
		
		Dimension treeDim = new Dimension(250,250);
		jTree.setPreferredSize(treeDim);
		
		expandAllNodes(jTree, 0, jTree.getRowCount());
		
		return jTree;
	}
	
	private static void populateTreeViewRecursive(DefaultMutableTreeNode parentNode, Drawable drawable)
	{
		if (drawable.getClass() == DrawableParent.class)
		{
			DrawableParent parent = (DrawableParent) drawable;
			DefaultMutableTreeNode newSubTreeNode = new DefaultMutableTreeNode(new DrawableInfo(drawable.getName(), parent));
			parentNode.add(newSubTreeNode);
			
			for(Drawable drawableChild : parent.getDrawableChildren())
			{
				populateTreeViewRecursive(newSubTreeNode, drawableChild);
			}
		}
		else
		{
			String objectName = drawable.getClass().getSimpleName();
			DefaultMutableTreeNode newSubTreeNode = new DefaultMutableTreeNode(new DrawableInfo(drawable.getName(), drawable));
			parentNode.add(newSubTreeNode);
		}
	}
	
	private static void expandAllNodes(JTree tree, int startingIndex, int rowCount){
	    for(int i=startingIndex;i<rowCount;++i){
	        tree.expandRow(i);
	    }

	    if(tree.getRowCount()!=rowCount){
	        expandAllNodes(tree, rowCount, tree.getRowCount());
	    }
	}
}
