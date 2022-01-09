package composite.controls;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.function.Function;

public class MouseDragControls {

	private int priorX, priorY = 0;
	private MouseDragCallBack callBack;
	private MyMouseAdapter mouseAdapter;
	private MyMouseMotionAdapter mouseMotionAdaper;
	
	public MouseDragControls(MouseDragCallBack callBack)
	{
		this.callBack = callBack;
		this.mouseAdapter = new MyMouseAdapter();
		this.mouseMotionAdaper = new MyMouseMotionAdapter();
	}
	
	public MouseAdapter getMouseAdapter()
	{
		return this.mouseAdapter;
	}
	
	public MouseMotionAdapter getMouseMotionAdapter()
	{
		return this.mouseMotionAdaper;
	}
		
	private class MyMouseAdapter extends MouseAdapter {
	      public void mousePressed(MouseEvent e) {
	    	  priorX = e.getX();
	    	  priorY = e.getY();
	      }
	}
	
	private class MyMouseMotionAdapter extends MouseMotionAdapter {
	      public void mouseDragged(MouseEvent e) {
	    	  int deltX = priorX - e.getX();
	    	  int deltY = priorY - e.getY();
	    	  
	    	  callBack.callback(deltX, deltY);
	    	  
	    	  priorX = e.getX();
	    	  priorY = e.getY();
	      }
	}


	
	
}
