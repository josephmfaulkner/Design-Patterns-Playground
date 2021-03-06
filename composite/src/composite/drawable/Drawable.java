package composite.drawable;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.tree.DefaultMutableTreeNode;

import composite.DrawableInfo;
import composite.drawable.util.Boundaries;

public abstract class Drawable {
	
	private static int instanceCount = 0;
	private int instanceId;
	protected int x, y;
	protected Color color;
	private String customName = null;
	
	
	
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
	
	
	
	public void move(int deltX, int deltY)
	{
		this.x += deltX;
		this.y += deltY;
	}
	
	
	abstract public void render(Graphics graphics);
	abstract public void setBoundaries(Boundaries boundaries);
	
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
