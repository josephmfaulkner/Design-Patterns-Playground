package composite.drawable.visitor;

import composite.drawable.DrawableParent;
import composite.drawable.Circle;
import composite.drawable.Rectangle;
import composite.drawable.SelectionBox;
import composite.drawable.Text;
import composite.drawable.Triangle;

public abstract class DrawableVisitor {
	
	public abstract void visit(DrawableParent drawableParent);
	public abstract void visit(Circle circle);
	public abstract void visit(Rectangle rectangle);
	public abstract void visit(Triangle triangle);
	public abstract void visit(Text text);
	public abstract void visit(SelectionBox selectionBox);

}
