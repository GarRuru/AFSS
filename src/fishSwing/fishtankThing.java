package fishSwing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fish.Fish;
import fish.FishCataLog;

@SuppressWarnings("serial")
public class fishtankThing extends JLabel implements Runnable {

	//private static final long serialVersionUID = 45345345355L;
	
	//儲存gif動態圖片
	private Image image;
	
	//private Image[] ims;
	//刷新paint函数
	public Thread thread;
	//紀錄位置
	//public Location location;
	//紀錄移動
	//private int move; 
	private Image[] fishs = new Image[2];
	
	private int set = -1;
	
	private static int sleepTime = 100;
	//private static int MOVE = 1;
	//private static int NOTMOVE = 0;

	private Fish fish;
	
	private int displayX;
	private int displayZ;
    /*
	@param image:
	Sample:new ImageIcon(DynGifLabel.class.getResource("/picture.gif")).getImage()
    */
	
	public fishtankThing(Fish fish)
	{
		this.fish=fish;
		fishs[0]= (new ImageIcon("/pic/"+FishCataLog.getFishChineseName(fish)+"r.gif")).getImage();
		fishs[1]= (new ImageIcon("/pic/"+FishCataLog.getFishChineseName(fish)+"l.gif")).getImage();
		thread = new Thread(this);
		thread.start();
		//暫時先用蝦的圖片
		this.image = fishs[1];
	}
	
	
	
	
	public fishtankThing(Image image)
	{
		this.image = image;
		thread = new Thread(this);
		thread.start();
	}
	
	public fishtankThing(String im)
	{
		if (im == "Left")
		{
			this.image = fishs[1];
			set = 1;
			System.out.println("Left\n");
		}
		else if (im == "Right")
		{
			this.image = fishs[0];
			set = 0;
		}
		thread = new Thread(this);
		thread.start();
	}
	
    //重載paint函数
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D graph = (Graphics2D) g;

		if (image != null)
		{
			//全屏描繪圖片
			graph.drawImage(image, 0, 0, getWidth(), getHeight(), 0, 0, image.getWidth(null), image.getHeight(null), null);
		}
	}
	
	//刷新圖片
	public void run()
	{
		while (true)
		{
			this.repaint();//這裡調用了Paint
			try
			{
				Thread.sleep(sleepTime);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public Fish getFish()
	{
		return fish;
	}
	
	public void turn(int i)
	{
		if (i> 0)
		{
			set--;
			this.image = fishs[0];
		}
		else if(i<0)
		{
			set++;
			this.image = fishs[1];
		}
	}




	public int getDisplayX() {
		return displayX;
	}




	public void setDisplayX(int displayX) {
		this.displayX = displayX;
	}




	public int getDisplayZ() {
		return displayZ;
	}




	public void setDisplayZ(int displayZ) {
		this.displayZ = displayZ;
	}
}