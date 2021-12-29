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
		
		
		DrawableParent drawableParentA = new DrawableParent();
		drawableParentA.setName("Red, Blue, Green");
		
		Triangle triangle = new Triangle(Math.PI + (Math.PI/2), 50, Color.RED);
		triangle.move(100, 0);
		drawableParentA.addChild(triangle);
		
		triangle = new Triangle(Math.PI + (Math.PI/2), 50, Color.GREEN);
		drawableParentA.addChild(triangle);
		
		triangle = new Triangle(2 * Math.PI + (Math.PI/2), 50, Color.BLUE);
		triangle.move(50, -25);
		drawableParentA.addChild(triangle);
		
		
		//drawableParentA.addChild(new Triangle());
		
		drawableParentA.move(100, 100);
		drawableParentMain.addChild(drawableParentA);

		drawableParentMain.move(50, 50);
		drawableParentMain.move(0, -10);
		
		return drawableParentMain;
		
	}

}
