package au.edu.qut.solar;

import java.awt.Graphics;
import java.awt.Image;
import au.edu.qut.util.Constant;
import au.edu.qut.util.GameFrame;
import au.edu.qut.util.GameUtil;

public class MainFrame extends GameFrame
{
	/**
	 * ÊµÏÖË«»º³å
	 */
	private Image iBuffer;  
	private Graphics gBuffer; 
	public void update(Graphics scr)  
	{  
		if(iBuffer==null)  
		{  
			iBuffer=createImage(this.getSize().width,this.getSize().height);  
			gBuffer=iBuffer.getGraphics();  
		}  
		gBuffer.setColor(getBackground());  
		gBuffer.fillRect(0,0,this.getSize().width,this.getSize().height);  
		paint(gBuffer);  
		scr.drawImage(iBuffer,0,0,this);  
	} 

	Image bg= GameUtil.getImage("au/edu/qut/image/Background.jpg");
	Star sun=new Star("au/edu/qut/image/Sun.jpg", Constant.GAME_WIDTH/2-15, Constant.GAME_HEIGHT/2-this.getHeight());
	Planet mercury = new Planet(sun,"au/edu/qut/image/Mercury.jpg", 36, 24,0.35707819);
	Planet venus=new Planet(sun, "au/edu/qut/image/Venus.jpg", 66, 44, 0.28223572);
	Planet earth =  new Planet(sun, "au/edu/qut/image/Earth.jpg", 89, 59, 0.25000000);
	Planet mars =  new Planet(sun, "au/edu/qut/image/Mars.jpg", 129, 86, 0.21344068);
	Planet jupiter =  new Planet(sun, "au/edu/qut/image/Jupiter.jpg", 176, 118, 0.13468720);
	Planet saturn =  new Planet(sun, "au/edu/qut/image/Saturn.jpg", 239, 159, 0.09816830);
	Planet uranus=  new Planet(sun, "au/edu/qut/image/Uranus.jpg", 325, 216, 0.07557131);
	Planet neptune =  new Planet(sun, "au/edu/qut/image/Neptune.jpg", 400, 270, 0.06385391);
	Planet moon=new Planet(earth, "au/edu/qut/image/moon.jpg", 15, 15, 1.85239156, true);
	
	public void paint(Graphics g)
	{
		g.drawImage(bg, 0, 0, null);
		sun.draw(g);
		mercury.draw(g);
		venus.draw(g);
		earth.draw(g);
		mars.draw(g);
		jupiter.draw(g);
		saturn.draw(g);
		uranus.draw(g);
		neptune.draw(g);
		moon.draw(g);
	}
	
	public static void main(String[] args) 
	{
		new MainFrame().launchFrame();
	}
}
