package composite.drawable.examples;

import java.awt.Color;

import composite.drawable.Circle;
import composite.drawable.Drawable;
import composite.drawable.DrawableParent;
import composite.drawable.Rectangle;
import composite.drawable.Triangle;

public class Snowman implements DrawableExample {

	@Override
	public Drawable setup() {
		DrawableParent drawableParentMain = new DrawableParent();
		drawableParentMain.setName("Snowman Scene");
		
		
		Triangle triangle;
		
		
		Color snowManColor = new Color(0.80f, 0.90f, 1.0f);
		DrawableParent snowmanHead = new DrawableParent();
		snowmanHead.setName("Head");
		
		Circle snowmanFace = new Circle(0,0,50,snowManColor);
		snowmanFace.setName("Face");
		Circle snowmanLeftEye = new Circle(25,25,10,Color.BLACK);
		snowmanLeftEye.setName("Left Eye");
		Circle snowmanRightEye = new Circle(60,25,10,Color.BLACK);
		snowmanRightEye.setName("Right Eye");
		
		Triangle nose = new Triangle(Math.PI, 15, Color.ORANGE);
		nose.setName("Nose");
		nose.move(50, 55);
		
		DrawableParent hat = new DrawableParent();
		hat.setName("Hat");
		Rectangle hatTop = new Rectangle(25,-30,50,45,Color.DARK_GRAY);
		hatTop.setName("Hat Top");
		Rectangle hatRim = new Rectangle(0,0,100,15,Color.DARK_GRAY);
		hatTop.setName("Hat Rim");
		hat.addChild(hatTop);
		hat.addChild(hatRim);
		
		
		
		snowmanHead.addChild(snowmanFace);
		snowmanHead.addChild(snowmanLeftEye);
		snowmanHead.addChild(snowmanRightEye);
		snowmanHead.addChild(nose);
		snowmanHead.addChild(hat);
		
		
		DrawableParent snowmanBody = new DrawableParent();
		snowmanBody.setName("Body");
		
		Circle bodyMiddle = new Circle(-30,70,80,snowManColor);
		bodyMiddle.setName("Middle");
		Circle bodyLower = new Circle(-50,125,100,snowManColor);
		bodyMiddle.setName("Lower");
		
		snowmanBody.addChild(bodyLower);
		snowmanBody.addChild(bodyMiddle);
		
		DrawableParent snowman = new DrawableParent();
		snowman.setName("Snowman");
		snowman.addChild(snowmanBody);
		snowman.addChild(snowmanHead);
		snowman.move(400, 250);
		
		
		Color groundColor = new Color(0.90f, 0.90f, 1.0f);
		Rectangle ground = new Rectangle(-500,520,2000,700, groundColor);
		ground.setName("Ground");
		
		DrawableParent tree = new DrawableParent();
		tree.setName("Tree");
		
		Rectangle treeStump = new Rectangle(400,450,40,100, Color.ORANGE.darker().darker().darker().darker());
		treeStump.setName("Stump");
		
		Triangle treeLeavesBottom = new Triangle(Math.PI + (Math.PI/2), 100, Color.GREEN.darker().darker());
		treeLeavesBottom.move(420, 450);
		treeLeavesBottom.setName("Leaves B");
		
		Triangle treeLeavesMiddle = new Triangle(Math.PI + (Math.PI/2), 100, Color.GREEN.darker().darker());
		treeLeavesMiddle.move(420, 380);
		treeLeavesMiddle.setName("Leaves Mid");
		
		Triangle treeLeavesTop = new Triangle(Math.PI + (Math.PI/2), 65, Color.GREEN.darker().darker());
		treeLeavesTop.move(420, 310);
		treeLeavesTop.setName("Leaves Top");
		
		tree.addChild(treeStump);
		
		tree.addChild(treeLeavesBottom);
		tree.addChild(treeLeavesMiddle);
		tree.addChild(treeLeavesTop);
		tree.move(-300, 20);
		
		DrawableParent house = new DrawableParent();
		house.setName("House");
		
		DrawableParent houseWalls = new DrawableParent();
		houseWalls.setName("Walls");
		Rectangle houseFront = new Rectangle(95,55,190,150, Color.orange.darker().darker().darker());
		houseFront.setName("Front Wall");
		Rectangle houseBack  = new Rectangle(-95,55,190,150, Color.orange.darker().darker());
		houseFront.setName("Back Wall");
		houseWalls.addChild(houseBack);
		houseWalls.addChild(houseFront);
		
		
		DrawableParent houseRoof = new DrawableParent();
		houseRoof.setName("Roof");
		Triangle roof1 = new Triangle(Math.PI + (Math.PI/2), 110, Color.RED.darker());
		roof1.setName("RoofA");
		
		Triangle roof2 = new Triangle(2*Math.PI + (Math.PI/2), 110, Color.RED.darker());
		roof2.setName("RoofB");
		roof2.move(95, -55);
		Triangle roof3 = new Triangle(Math.PI + (Math.PI/2), 110, Color.RED.darker().darker());
		roof3.setName("RoofC");
		roof3.move(190, 0);
		
		houseRoof.addChild(roof1);
		houseRoof.addChild(roof2);
		houseRoof.addChild(roof3);
		
		
		house.addChild(houseWalls);
		house.addChild(houseRoof);
		house.move(0, 340);
		
		drawableParentMain.addChild(ground);
		drawableParentMain.addChild(house);
		drawableParentMain.addChild(tree);
		drawableParentMain.addChild(snowman);

		
		drawableParentMain.move(50, 50);
		drawableParentMain.move(0, -10);
		
		return drawableParentMain;
	}

}
