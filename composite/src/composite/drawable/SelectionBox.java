package composite.drawable;

import java.awt.BasicStroke;
import java.awt.Graphics;

import composite.drawable.util.Boundaries;

public class SelectionBox extends Drawable {

	private Boundaries boundaries;
	
	public SelectionBox(Boundaries boundaries)
	{
		this.boundaries = boundaries;
	}
	
	public void updateBoundaries(Boundaries boundaries)
	{
		this.x = 0;
		this.y = 0;
		this.boundaries = boundaries;
		
	}
		
	@Override
	public void render(Graphics graphics) {
		// TODO Auto-generated method stub
		int height = boundaries.getFarBottom() - boundaries.getFarTop();
		int width  = boundaries.getFarRight()  - boundaries.getFarLeft();
		graphics.setColor(this.color);
		graphics.drawRect(boundaries.getFarLeft() + x, boundaries.getFarTop() + y, width, height);
	}

	@Override
	public void setBoundaries(Boundaries boundaries) {
		// TODO Auto-generated method stub
		
	}

}
