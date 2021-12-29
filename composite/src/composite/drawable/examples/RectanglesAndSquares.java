package composite.drawable.examples;

import java.awt.Color;

import composite.drawable.Circle;
import composite.drawable.Drawable;
import composite.drawable.DrawableParent;
import composite.drawable.Rectangle;

public class RectanglesAndSquares implements DrawableExample{

	@Override
	public Drawable setup() {
		DrawableParent drawableParentMain = new DrawableParent();
		drawableParentMain.setName("Squares and Rectangles");
		
		DrawableParent drawableParentA = new DrawableParent();
		drawableParentA.setName("White, Purple, Yellow");
		drawableParentA.addChild(new Rectangle(0,0,25,50,Color.WHITE));
		drawableParentA.addChild(new Rectangle(25,45,25,50,Color.MAGENTA));
		drawableParentA.addChild(new Rectangle(50,0,25,50,Color.YELLOW));
		
		
		DrawableParent drawableParentB = new DrawableParent();
		drawableParentB.setName("Cyan, Orange, Gray");
		drawableParentB.addChild(new Rectangle(0,0,50,25,Color.CYAN));
		drawableParentB.addChild(new Rectangle(25,45,50,25,Color.ORANGE));
		drawableParentB.addChild(new Rectangle(50,0,50,25,Color.GRAY));
		drawableParentB.move(200, 0);
		
		DrawableParent drawableParentC = new DrawableParent();
		drawableParentC.setName("Red, Blue, Green");
		drawableParentC.addChild(new Rectangle(0,0,50,Color.RED));
		drawableParentC.addChild(new Rectangle(25,50,50,Color.BLUE));
		drawableParentC.addChild(new Rectangle(50,0,50,Color.GREEN));
		drawableParentC.move(100, 100);
	
		drawableParentMain.addChild(drawableParentA);
		drawableParentMain.addChild(drawableParentB);
		drawableParentMain.addChild(drawableParentC);
		
		drawableParentMain.move(50, 50);
		drawableParentMain.move(0, -10);
		
		return drawableParentMain;
	}

}
