package composite.drawable.util;

public class Boundaries {
	
	private boolean initial;
	private int farTop;
	private int farBottom;
	private int farLeft;
	private int farRight;
	
	public Boundaries()
	{
		this.initial = true;
		this.farTop = 0;
		this.farBottom = 0;
		this.farLeft = 0;
		this.farRight = 0;
	}
	
	public void updateBoundaries(int top, int bottom, int left, int right)
	{
		if(this.initial)
		{
			this.initial = false;
			this.farTop = top;
			this.farBottom = bottom;
			this.farLeft = left;
			this.farRight = right;
		}
		else
		{
			if( top < this.farTop )
			{
				this.farTop = top;
			}
			if( bottom > this.farBottom)
			{
				this.farBottom = bottom;
			}
			if( left < this.farLeft )
			{
				this.farLeft = left;
			}
			if( right > this.farRight)
			{
				this.farRight = right;
			}	
		}
		
		
	}

	public int getFarTop() {
		return farTop;
	}

	public int getFarBottom() {
		return farBottom;
	}

	public int getFarLeft() {
		return farLeft;
	}

	public int getFarRight() {
		return farRight;
	}

	@Override
	public String toString() {
		return "Boundaries [farTop=" + farTop + ", farBottom=" + farBottom + ", farLeft=" + farLeft + ", farRight="
				+ farRight + "]";
	}
	
	
	
	
}
