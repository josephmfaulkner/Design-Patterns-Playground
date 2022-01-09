package composite.drawable.examples;

import java.awt.Color;

import composite.drawable.Circle;
import composite.drawable.Drawable;
import composite.drawable.DrawableParent;
import composite.drawable.Triangle;

public class Triangles implements DrawableExample{

	@Override
	public Drawable setup() {
		
		DrawableParent drawableParentMain = new DrawableParent();
		drawableParentMain.setName("Triangles");
		
		
		Triangle triangle;
		
		DrawableParent drawableParentA = new DrawableParent();
		drawableParentA.setName("Red, Blue, Green");
		
		triangle = new Triangle(Math.PI + (Math.PI/2), 50, Color.RED);
		triangle.move(100, 0);
		drawableParentA.addChild(triangle);
		
		triangle = new Triangle(Math.PI + (Math.PI/2), 50, Color.GREEN);
		drawableParentA.addChild(triangle);
		
		triangle = new Triangle(2 * Math.PI + (Math.PI/2), 50, Color.BLUE);
		triangle.move(50, -25);
		drawableParentA.addChild(triangle);
		
		drawableParentA.move(100, 100);
		drawableParentMain.addChild(drawableParentA);

		
		DrawableParent drawableParentB = new DrawableParent();
		drawableParentB.setName("Pink, White, Yellow");
		
		triangle = new Triangle(Math.PI + (Math.PI/2), 50, Color.MAGENTA);
		triangle.move(100, 0);
		drawableParentB.addChild(triangle);
		
		triangle = new Triangle(Math.PI + (Math.PI/2), 50, Color.WHITE);
		drawableParentB.addChild(triangle);
		
		triangle = new Triangle(2 * Math.PI + (Math.PI/2), 50, Color.YELLOW);
		triangle.move(50, -25);
		drawableParentB.addChild(triangle);
		
		drawableParentB.move(250, 200);
		drawableParentMain.addChild(drawableParentB);
		
		
		DrawableParent drawableParentC = new DrawableParent();
		drawableParentC.setName("Cyan, Orange, Gray");
		
		triangle = new Triangle(Math.PI + (Math.PI/2), 50, Color.CYAN);
		triangle.move(100, 0);
		drawableParentC.addChild(triangle);
		
		triangle = new Triangle(Math.PI + (Math.PI/2), 50, Color.ORANGE);
		drawableParentC.addChild(triangle);
		
		triangle = new Triangle(2 * Math.PI + (Math.PI/2), 50, Color.DARK_GRAY);
		triangle.move(50, -25);
		drawableParentC.addChild(triangle);
		
		drawableParentC.move(0, 200);
		drawableParentMain.addChild(drawableParentC);
		
		
		drawableParentMain.move(50, 50);
		drawableParentMain.move(0, -10);
		
		return drawableParentMain;
		
	}

}
