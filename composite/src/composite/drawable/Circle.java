package composite.drawable;

import java.awt.Color;
import java.awt.Graphics;

public class Circle implements Drawable {
	
	private int x, y, diameter;
	private Color color;
	
	public Circle(int x, int y, int radius)
	{
		this.x = x;
		this.y = y;
		this.diameter = radius * 2;
		this.color = Color.GRAY;
	}
	
	public Circle(int x, int y, int radius, Color color)
	{
		this.x = x;
		this.y = y;
		this.diameter = radius * 2;
		this.color = color;
	}
	
	public void move(int deltX, int deltY)
	{
		this.x += deltX;
		this.y += deltY;
	}
	
	public void render(Graphics graphics)
	{
		graphics.setColor(this.color);
		graphics.fillOval(x, y, this.diameter, this.diameter);	
	}
}
