package composite.drawable;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Drawable {
	
	private int diameter;
	
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
	public void render(Graphics graphics)
	{
		graphics.setColor(this.color);
		graphics.fillOval(x, y, this.diameter, this.diameter);	
	}
}
