package composite;

import composite.drawable.Drawable;

public class DrawableInfo {
	public String name;
	public Drawable drawable;
	
	public DrawableInfo(String name, Drawable drawable)
	{
		this.name = name;
		this.drawable = drawable;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
}
