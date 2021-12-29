package composite.drawable.examples;

import java.awt.Color;

import composite.drawable.Circle;
import composite.drawable.Drawable;
import composite.drawable.DrawableParent;

public class ColorCircles implements DrawableExample {

	@Override
	public Drawable setup() {
		DrawableParent drawableParentMain = new DrawableParent();
		DrawableParent drawableParentA = new DrawableParent();
		DrawableParent drawableParentB = new DrawableParent();
		DrawableParent drawableParentC = new DrawableParent();
		
		
		drawableParentA.addChild(new Circle(0,0,25,Color.WHITE));
		drawableParentA.addChild(new Circle(25,45,25,Color.MAGENTA));
		drawableParentA.addChild(new Circle(50,0,25,Color.YELLOW));
		
		drawableParentB.addChild(new Circle(0,0,25,Color.CYAN));
		drawableParentB.addChild(new Circle(25,45,25,Color.ORANGE));
		drawableParentB.addChild(new Circle(50,0,25,Color.GRAY));
		drawableParentB.move(200, 0);
		
		drawableParentC.addChild(new Circle(0,0,25,Color.RED));
		drawableParentC.addChild(new Circle(25,45,25,Color.BLUE));
		drawableParentC.addChild(new Circle(50,0,25,Color.GREEN));
		drawableParentC.move(100, 100);
	
		drawableParentMain.addChild(drawableParentA);
		drawableParentMain.addChild(drawableParentB);
		drawableParentMain.addChild(drawableParentC);
		
		drawableParentMain.move(50, 50);
		drawableParentMain.move(0, -10);
		
		return drawableParentMain;
	}

}
