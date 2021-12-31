package composite.drawable;

import java.awt.Color;
import java.awt.Graphics;

import composite.drawable.util.Boundaries;

public class Rectangle extends Drawable {

	private int height, width;
	
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
	public void render(Graphics graphics) {
		graphics.setColor(this.color);
		graphics.fillRect(this.x, this.y, this.width, this.height);
	}

	@Override
	public void setBoundaries(Boundaries boundaries) {
		// TODO Auto-generated method stub
		boundaries.updateBoundaries(y, y + height , x, x + width);
	}

}
