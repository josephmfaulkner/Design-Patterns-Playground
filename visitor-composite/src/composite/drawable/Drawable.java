package composite.drawable;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.tree.DefaultMutableTreeNode;

import composite.DrawableInfo;
import composite.drawable.util.Boundaries;
import composite.drawable.visitor.DrawableVisitor;

public abstract class Drawable {
	
	private static int instanceCount = 0;
	private int instanceId;
	protected int x, y;
	protected Color color;
	private String customName = null;
	
	public int getX(){ return this.x; }
	public int getY(){ return this.y; }
	public Color getColor(){ return this.color; }
	
	Drawable()
	{
		this.instanceCount++;
		this.instanceId = instanceCount;
	}
	
	Drawable(int x, int y)
	{
		this();
		this.x = x;
		this.y = y;
	}
	
	Drawable(int x, int y, Color color)
	{
		this(x,y);
		this.color = color;
	}
	
	public abstract void accept(DrawableVisitor drawableVisitor);
	
	
	
	public void move(int deltX, int deltY)
	{
		this.x += deltX;
		this.y += deltY;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public void setName(String name)
	{
		this.customName = name;
	}
	
	public String getName()
	{
		if(customName != null)
		{
			return customName + " - " + this.instanceId;
		}	

		String objName = this.getClass().getSimpleName();
		return objName + " - " + this.instanceId;
	}
	
}
