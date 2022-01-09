package composite;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import composite.drawable.Circle;
import composite.drawable.Drawable;
import composite.drawable.visitor.DrawableVisitor;
import composite.drawable.visitor.RenderDrawableVisitor;

public class AppCanvas extends Canvas {

	private Drawable drawable;
	private Drawable selectionBox;
	
	RenderDrawableVisitor renderDrawableVisitor;
	
	
	AppCanvas(Drawable drawable, Drawable selectionBox){
		this.drawable = drawable;
		this.selectionBox = selectionBox;
		
		this.renderDrawableVisitor = new RenderDrawableVisitor();
		
	}
	
	@Override
	public void paint(Graphics graphics)
	{
		this.setBackground(Color.BLACK);
		this.setForeground(Color.WHITE);
		
		this.renderDrawableVisitor.setGraphicsRef(graphics);
		
		drawable.accept(renderDrawableVisitor);
		selectionBox.accept(renderDrawableVisitor);
	}
	
}
