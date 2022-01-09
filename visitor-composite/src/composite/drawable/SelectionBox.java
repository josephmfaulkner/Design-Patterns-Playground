package composite.drawable;

import java.awt.BasicStroke;
import java.awt.Graphics;

import composite.drawable.util.Boundaries;
import composite.drawable.visitor.DrawableVisitor;

public class SelectionBox extends Drawable {

	private Boundaries boundaries;
	public Boundaries getBoundaries() { return this.boundaries; }
	
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
	public void accept(DrawableVisitor drawableVisitor) {
		drawableVisitor.visit(this);	
	}
			
}
