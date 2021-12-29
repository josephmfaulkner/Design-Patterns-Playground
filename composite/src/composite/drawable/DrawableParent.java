package composite.drawable;

import java.awt.Graphics;
import java.util.List;
import java.util.Vector;

public class DrawableParent implements Drawable {

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
	public void move(int deltX, int deltY) 
	{
		for(Drawable drawable: this.drawableChildren)
		{
			drawable.move(deltX, deltY);
		}
	}

	@Override
	public void render(Graphics graphics) 
	{
		for(Drawable drawable: this.drawableChildren)
		{
			drawable.render(graphics);
		}
	}
	

	
}