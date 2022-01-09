package composite.drawable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.Arrays;

import composite.drawable.util.Boundaries;
import composite.drawable.visitor.DrawableVisitor;


public class Triangle extends Drawable {

	public class Point 
	{
		public int x, y;
		Point(int x, int y) 
		{
			this.x = x;
			this.y = y;
		}
	}
	private int xCoords[] = new int[3];
	private int yCoords[] = new int[3];
	
	public int[] getXCoords() { return this.xCoords; }
	public int[] getYCoords() { return this.yCoords; }
	
	private int xDrawCoords[] = new int[3];
	private int yDrawCoords[] = new int[3];
	
	private int scale;
	
	public Triangle(double offsetTheta, double scale, Color color)
	{
		x = 0;
		y = 0;
		this.scale = (int) scale;
		double deltaPi = 2 * Math.PI / 3;
		for(int i = 0; i < 3; i++)
		{
			xCoords[i] = (int) (Math.cos((deltaPi * i) + offsetTheta) * scale);
			yCoords[i] = (int) (Math.sin((deltaPi * i) + offsetTheta) * scale);
			
			System.out.println(xCoords[i]);
			System.out.println(yCoords[i]);
		}
		this.color = color;
	}
	
	public Triangle()
	{
		this(0, 50, Color.ORANGE);
	}

	@Override
	public void accept(DrawableVisitor drawableVisitor) {
		drawableVisitor.visit(this);	
	}
	
}
