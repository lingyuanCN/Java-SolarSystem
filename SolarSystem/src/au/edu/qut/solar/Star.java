package au.edu.qut.solar;

import java.awt.Graphics;
import java.awt.Image;

import au.edu.qut.util.GameUtil;

public class Star 
{
	Image image;
	double x;
	double y;
	int width;
	int height;
	
	public void draw(Graphics g)
	{
		g.drawImage(image, (int)x, (int)y, null);
	}
	
	
	public Star() 
	{

	}
	
	public Star(Image image)
	{
		this.image=image;
		this.width= image.getWidth(null);
		this.height=image.getHeight(null);
	}

	public Star(Image image, double x, double y) 
	{
		this(image);
		this.x=x;
		this.y=y;
	}
	public Star(String imagepath, double x, double y) 
	{
		this(GameUtil.getImage(imagepath),x,y);
	}
}
