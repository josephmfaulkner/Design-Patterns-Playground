package composite.drawable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.geom.Point2D;


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
	private Point point1, point2, point3;
	private int xCoords[] = new int[3];
	private int yCoords[] = new int[3];
	
	private int xDrawCoords[] = new int[3];
	private int yDrawCoords[] = new int[3];
	
	private int scale = 70;
	
	public Triangle(double offsetTheta, double scale, Color color)
	{
		x = 0;
		y = 0;
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
	public void render(Graphics graphics) {
		xDrawCoords[0] = xCoords[0] + x;
		xDrawCoords[1] = xCoords[1] + x;
		xDrawCoords[2] = xCoords[2] + x;
		
		yDrawCoords[0] = yCoords[0] + y;
		yDrawCoords[1] = yCoords[1] + y;
		yDrawCoords[2] = yCoords[2] + y;
		
		System.out.println();
		
		graphics.setColor(this.color);
		graphics.fillPolygon(xDrawCoords, yDrawCoords, 3);
	}

}
