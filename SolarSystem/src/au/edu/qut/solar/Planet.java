package au.edu.qut.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import au.edu.qut.util.GameUtil;

public class Planet extends Star
{
	//����ͼƬ�����꣬����������Բ�˶���
	// ���Ի�Ҫ�����������壬���ᣬ���ᣬ�ٶ�
	double longAxis;
	double shortAxis;
	double speed;
	double degree;
	Star center_star;
	boolean satellite;

	//������
	public Planet(	Star center_star, 
			String imagepath, 
			double longAxis, 
			double shortAxis, 
			double speed) 
	{
		super(GameUtil.getImage(imagepath));
		this.center_star = center_star;
		this.x=center_star.x+longAxis;
		this.y=center_star.y+shortAxis;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
	}
	
	public Planet(	Star center_star, 
			String imagepath, 
			double longAxis, 
			double shortAxis, 
			double speed,
			boolean satellite) 
	{
		this(center_star, imagepath, longAxis, shortAxis, speed);
		this.satellite = satellite;
	}
	
	@Override//��д�����draw����
	public void draw(Graphics g) 
	{
		super.draw(g);
		move();
		//�ж��Ƿ�������
		if (!satellite)
		{
			drawTrace(g);
		}
	}
	
	public void drawTrace(Graphics g)
	{
		double oval_x,oval_y,oval_width,oval_height;
		
		oval_x=center_star.x+(center_star.width/2)-longAxis;
		oval_y=center_star.y+(center_star.height/2)-shortAxis;
		oval_width=longAxis*2;
		oval_height=shortAxis*2;
		
		Color origin =g.getColor();
		g.setColor(Color.WHITE);
		g.drawOval((int)oval_x, (int)oval_y, (int)oval_width, (int)oval_height);
		g.setColor(origin);
	}
	
	public void move()
	{
		//����Բ�켣����
		x=center_star.x+(center_star.width/2)-(this.width/2)+longAxis*Math.cos(degree);
		y=center_star.y+(center_star.height/2)-(this.height/2)+shortAxis*Math.sin(degree);
		
		degree -= speed;
	}

	public Planet(Image image, double x, double y) 
	{
		super(image, x, y);
	}
	
	public Planet(String imagepath, double x, double y)
	{
		super(imagepath, x, y);
	}
	

}
