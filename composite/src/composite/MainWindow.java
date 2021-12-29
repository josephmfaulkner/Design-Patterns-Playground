package composite;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import composite.controls.MouseDragCallBack;
import composite.controls.MouseDragControls;
import composite.controls.TreeSelectCallBack;
import composite.controls.TreeViewBuilder;
import composite.controls.TreeViewControls;
import composite.drawable.Circle;
import composite.drawable.Drawable;
import composite.drawable.DrawableParent;
import composite.drawable.examples.ColorCircles;
import composite.drawable.examples.DrawableExample;
import composite.drawable.examples.RectanglesAndSquares;
import composite.drawable.examples.Triangles;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class MainWindow  {

	private JFrame frame;
	private JTree jTree;
	private Drawable drawable;
	private Drawable drawableMoveReference;
	private AppCanvas canvas;

	public MainWindow() {
		this.createDrawable();
	    this.setupControls();
	    this.setupWindowFrame();
	    this.drawFrame();
	}

	private void createDrawable()
	{
		//DrawableExample example = new ColorCircles();
		DrawableExample example = new Triangles();
		//DrawableExample example = new RectanglesAndSquares();
		this.drawable = example.setup();
		this.drawableMoveReference = drawable;
	}
	
	private void setupControls()
	{
		canvas = new AppCanvas(this.drawable);
		MouseDragControls mouseDragControls = new MouseDragControls(new MouseDrag());
		canvas.addMouseListener(mouseDragControls.getMouseAdapter());
	    canvas.addMouseMotionListener(mouseDragControls.getMouseMotionAdapter());
	    jTree = TreeViewBuilder.createTreeView(drawable, new TreeClick());
	}
	
	private void setupWindowFrame()
	{
	    frame = new JFrame();
		frame.setBounds(100, 100, 850, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().add(canvas, BorderLayout.CENTER);
		frame.getContentPane().add(jTree, BorderLayout.EAST);
	}
	
	private void moveDrawing(int xDelt, int yDelt)
	{
		this.drawableMoveReference.move(xDelt, yDelt);
		this.drawFrame();
	}
	
	private void drawFrame()
	{
		canvas.repaint();
	}
		
	private class TreeClick implements TreeSelectCallBack
	{

		@Override
		public void callback(DrawableInfo drawableInfo) {
			drawableMoveReference = drawableInfo.drawable;			
		}
		
	}
	
	private class MouseDrag implements MouseDragCallBack
	{
		@Override
		public void callback(int x, int y) {
			moveDrawing(-x, -y);
		}	
	}
	
	

}
