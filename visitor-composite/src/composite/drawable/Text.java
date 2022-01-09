package composite.drawable;

import java.awt.Graphics;

import composite.drawable.util.Boundaries;
import composite.drawable.visitor.DrawableVisitor;

public class Text extends Drawable {

	@Override
	public void accept(DrawableVisitor drawableVisitor) {
		drawableVisitor.visit(this);	
	}
	
	@Override
	public void move(int deltX, int deltY) {
		// TODO Auto-generated method stub
		
	}

}
