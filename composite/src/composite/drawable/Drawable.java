package composite.drawable;

import java.awt.Graphics;

public interface Drawable {
	public void move(int deltX, int deltY);
	public void render(Graphics graphics);
}
