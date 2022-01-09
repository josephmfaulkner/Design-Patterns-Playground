package composite.drawable;

import java.awt.Graphics;
import java.util.List;
import java.util.Vector;

import composite.drawable.util.Boundaries;
import composite.drawable.visitor.DrawableVisitor;

public class DrawableParent extends Drawable {

	private List<Drawable> drawableChildren;
	
	public List<Drawable> getDrawableChildren()
	{
		return this.drawableChildren;
	}
	
	public DrawableParent()
	{
		this.drawableChildren = new Vector<Drawable>();
	}
	
	public void addChild(Drawable drawable)
	{
		this.drawableChildren.add(drawable);
	}
	
	public void removeChild(Drawable drawable)
	{
		this.drawableChildren.remove(drawable);
	}
	
	@Override
	public void accept(DrawableVisitor drawableVisitor) {
		drawableVisitor.visit(this);	
	}
	
	@Override
	public void move(int deltX, int deltY) 
	{
		for(Drawable drawable: this.drawableChildren)
		{
			drawable.move(deltX, deltY);
		}
	}
	
}
