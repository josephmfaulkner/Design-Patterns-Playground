package composite.drawable.visitor;

import java.util.Arrays;

import composite.drawable.Circle;
import composite.drawable.Drawable;
import composite.drawable.DrawableParent;
import composite.drawable.Rectangle;
import composite.drawable.SelectionBox;
import composite.drawable.Text;
import composite.drawable.Triangle;
import composite.drawable.util.Boundaries;

public class SetBoundariesDrawableVisitor extends DrawableVisitor {

	private Boundaries boundaries;
	public Boundaries getBoundaries() { return this.boundaries; }
	public SetBoundariesDrawableVisitor()
	{
		this.boundaries = new Boundaries();
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
		boundaries.updateBoundaries(
				circle.getY(), 
				circle.getY() + circle.getDiameter(), 
				circle.getX(), 
				circle.getX() + circle.getDiameter()
		);
	}

	@Override
	public void visit(Rectangle rectangle) {
		boundaries.updateBoundaries(
				rectangle.getY(), 
				rectangle.getY() + rectangle.getHeight() , 
				rectangle.getX(), rectangle.getX() + rectangle.getWidth()
		);
		
	}

	@Override
	public void visit(Triangle triangle) {
		
		int[] xDrawCoordsSort = {
				triangle.getXCoords()[0] + triangle.getX(),
				triangle.getXCoords()[1] + triangle.getX(),
				triangle.getXCoords()[2] + triangle.getX(),
			  };
		int[] yDrawCoordsSort = {
				triangle.getYCoords()[0] + triangle.getY(),
				triangle.getYCoords()[1] + triangle.getY(),
				triangle.getYCoords()[2] + triangle.getY(),
			  };
		
		Arrays.sort(xDrawCoordsSort);
		Arrays.sort(yDrawCoordsSort);
		
		int top = yDrawCoordsSort[0];
		int bottom = yDrawCoordsSort[2];
		int left = xDrawCoordsSort[0];
		int right = xDrawCoordsSort[2];
		
		boundaries.updateBoundaries(top, bottom, left, right);
	}

	@Override
	public void visit(Text text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(SelectionBox selectionBox) {
		
		Boundaries selectionBoxBoundaries = selectionBox.getBoundaries();
		
		boundaries.updateBoundaries(
				selectionBoxBoundaries.getFarTop(), 
				selectionBoxBoundaries.getFarBottom(), 
				selectionBoxBoundaries.getFarLeft(), 
				selectionBoxBoundaries.getFarRight()
		);
		
	}

}
