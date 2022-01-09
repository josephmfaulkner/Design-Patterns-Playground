package composite.drawable;

import java.awt.Color;
import java.awt.Graphics;

import composite.drawable.util.Boundaries;
import composite.drawable.visitor.DrawableVisitor;

public class Rectangle extends Drawable {

	private int height, width;
	
	public int getHeight() { return this.height; }
	public int getWidth()  { return this.width;  }
	
	public Rectangle(int x, int y, int width, int height)
	{
		super(x, y);
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(int x, int y, int width, int height, Color color)
	{
		super(x, y, color);
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(int x, int y, int width)
	{
		this(x, y, width, width);
	}
	
	public Rectangle(int x, int y, int width, Color color)
	{
		this(x, y, width, width, color);
	}
	
	@Override
	public void accept(DrawableVisitor drawableVisitor) {
		drawableVisitor.visit(this);	
	}
	
}
