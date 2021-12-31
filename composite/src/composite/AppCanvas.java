package composite;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import composite.drawable.Circle;
import composite.drawable.Drawable;

public class AppCanvas extends Canvas {

	private Drawable drawable;
	private Drawable selectionBox;
	
	AppCanvas(Drawable drawable, Drawable selectionBox){
		this.drawable = drawable;
		this.selectionBox = selectionBox;
	}
	
	@Override
	public void paint(Graphics graphics)
	{
		this.setBackground(Color.BLACK);
		this.setForeground(Color.WHITE);
				
		drawable.render(graphics);
		selectionBox.render(graphics);
	}
	
}
