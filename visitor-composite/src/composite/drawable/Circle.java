package composite.drawable;

import java.awt.Color;
import java.awt.Graphics;

import composite.drawable.util.Boundaries;
import composite.drawable.visitor.DrawableVisitor;

public class Circle extends Drawable {
	
	private int diameter;
	public int getDiameter() { return this.diameter; }
	
	
	public Circle(int x, int y, int radius)
	{
		super(x, y);
		this.diameter = radius * 2;
	}
	
	public Circle(int x, int y, int radius, Color color)
	{
		super(x, y, color);
		this.diameter = radius * 2;
	}
	
	@Override
	public void accept(DrawableVisitor drawableVisitor) {
		drawableVisitor.visit(this);	
	}
	
}
