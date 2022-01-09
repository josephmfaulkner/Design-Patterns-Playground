package composite.drawable.visitor;

import java.awt.Graphics;

import composite.drawable.Circle;
import composite.drawable.Drawable;
import composite.drawable.DrawableParent;
import composite.drawable.Rectangle;
import composite.drawable.SelectionBox;
import composite.drawable.Text;
import composite.drawable.Triangle;
import composite.drawable.util.Boundaries;

public class RenderDrawableVisitor extends DrawableVisitor {

	private Graphics graphicsRef;
		
	public void setGraphicsRef(Graphics graphicsRef)
	{
		this.graphicsRef = graphicsRef;
	}
	
	@Override
	public void visit(DrawableParent drawableParent) {
		// TODO Auto-generated method stub
		for(Drawable drawableChild : drawableParent.getDrawableChildren())
		{
			drawableChild.accept(this);
		}
	}

	@Override
	public void visit(Circle circle) {
		graphicsRef.setColor(circle.getColor());
		graphicsRef.fillOval(circle.getX(), circle.getY(), circle.getDiameter(), circle.getDiameter());	
	}

	@Override
	public void visit(Rectangle rectangle) {
		graphicsRef.setColor(rectangle.getColor());
		graphicsRef.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
	}

	@Override
	public void visit(Triangle triangle) {
		// TODO Auto-generated method stub
		
		int[] xDrawCoords = {triangle.getXCoords()[0] + triangle.getX(), triangle.getXCoords()[1] + triangle.getX(), triangle.getXCoords()[2] + triangle.getX()};
		int[] yDrawCoords = {triangle.getYCoords()[0] + triangle.getY(), triangle.getYCoords()[1] + triangle.getY(), triangle.getYCoords()[2] + triangle.getY()};
				
		graphicsRef.setColor(triangle.getColor());
		graphicsRef.fillPolygon(xDrawCoords, yDrawCoords, 3);
	}
	
	@Override
	public void visit(Text text) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void visit(SelectionBox selectionBox) {
		Boundaries boundaries = selectionBox.getBoundaries();
		
		int height = boundaries.getFarBottom() - boundaries.getFarTop();
		int width  = boundaries.getFarRight()  - boundaries.getFarLeft();
		graphicsRef.setColor(selectionBox.getColor());
		graphicsRef.drawRect(boundaries.getFarLeft() + selectionBox.getX(), boundaries.getFarTop() + selectionBox.getY(), width, height);
	}
	

}
