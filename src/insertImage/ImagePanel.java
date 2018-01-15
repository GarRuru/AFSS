package insertImage;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel
{
	private Image im;
	private int set = -1;
	private static final String[] iml = {"Enter", "Fishtank", "Test", "white", "", "",
			                             "�ճ���", "����O", "���ԧB���P��", "���{�q", "���갫��", "������",
			                             "�\������", "�ŭ˦Q", "���Y��", "�]�����u", "null", "���������",
			                             "����������", "����������", "��ŹL�o��", "���ŹL�o��", "���ŹL�o��", "��Ů��",
			                             "���Ů��", "���Ů��", "��ť[�ž�", "���ť[�ž�", "���ť[�ž�", "��ŷө���",
			                             "���ŷө���", "���ŷө���", "1x1", "2x1.1", "2x1.2", "2x2.1",
			                             "2x2.2", "2x2.3", "2x2.4", "3x2.1", "3x2.2", "3x2.3",
			                             "3x2.4", "3x2.5", "3x2.6", "����", "���Y", "����",
			                             "�B��"};
	private static final Image[] ims = { (new ImageIcon("/pic/enter.jpg")).getImage(), (new ImageIcon("/pic/desk.jpg")).getImage(),
                                         (new ImageIcon("/pic/test.png")).getImage(), (new ImageIcon("/pic/white.png")).getImage(),
                                         (new ImageIcon("/pic/red.png")).getImage(), (new ImageIcon("/pic/blue.png")).getImage(),
                                         (new ImageIcon("/pic/123.456")).getImage(), (new ImageIcon("/pic/����O��3.jpg")).getImage(), // 6-15
                                         (new ImageIcon("/pic/���ԧB���P��4.jpg")).getImage(), (new ImageIcon("/pic/���{�q4.jpg")).getImage(),
                                         (new ImageIcon("/pic/���갫��3.jpg")).getImage(), (new ImageIcon("/pic/������1.jpg")).getImage(),
                                         (new ImageIcon("/pic/�\������4.jpg")).getImage(), (new ImageIcon("/pic/�ŭ˦Q1.jpg")).getImage(),
                                         (new ImageIcon("/pic/���Y��2.jpg")).getImage(), (new ImageIcon("/pic/�]�����u4.jpg")).getImage(),
                                         (new ImageIcon("/pic/null.png")).getImage(), (new ImageIcon("/pic/������1.jpg")).getImage(),
                                         (new ImageIcon("/pic/������2.jpg")).getImage(), (new ImageIcon("/pic/������3.jpg")).getImage(),
                                         (new ImageIcon("/pic/�L�o��1.jpg")).getImage(), (new ImageIcon("/pic/�L�o��2.jpg")).getImage(),
                                         (new ImageIcon("/pic/�L�o��3.jpg")).getImage(), (new ImageIcon("/pic/�����1.jpg")).getImage(),
                                         (new ImageIcon("/pic/�����2.jpg")).getImage(), (new ImageIcon("/pic/�����3.jpg")).getImage(),
                                         (new ImageIcon("/pic/�[�ž�1.jpg")).getImage(), (new ImageIcon("/pic/�[�ž�2.jpg")).getImage(),
                                         (new ImageIcon("/pic/�[�ž�3.jpg")).getImage(), (new ImageIcon("/pic/�ө���1.jpg")).getImage(),
                                         (new ImageIcon("/pic/�ө���2.jpg")).getImage(), (new ImageIcon("/pic/�ө���3.jpg")).getImage(),
                                         (new ImageIcon("/pic/����.jpg")).getImage(), (new ImageIcon("/pic/���Y1.jpg")).getImage(), //32-44
                                         (new ImageIcon("/pic/���Y2.jpg")).getImage(), (new ImageIcon("/pic/����1.jpg")).getImage(),
                                         (new ImageIcon("/pic/����2.jpg")).getImage(), (new ImageIcon("/pic/����3.jpg")).getImage(),
                                         (new ImageIcon("/pic/����4.jpg")).getImage(), (new ImageIcon("/pic/�B��1.jpg")).getImage(),
                                         (new ImageIcon("/pic/�B��2.jpg")).getImage(), (new ImageIcon("/pic/�B��3.jpg")).getImage(),
                                         (new ImageIcon("/pic/�B��4.jpg")).getImage(), (new ImageIcon("/pic/�B��5.jpg")).getImage(),
                                         (new ImageIcon("/pic/�B��6.jpg")).getImage(), (new ImageIcon("/pic/����.jpg")).getImage(),
                                         (new ImageIcon("/pic/���Y.jpg")).getImage(), (new ImageIcon("/pic/����.jpg")).getImage(),
                                         (new ImageIcon("/pic/�B��.jpg")).getImage() };
	
    public ImagePanel(Image im)
    {
        this.im = im;
        this.setOpaque(true);
    }
    
    public ImagePanel(String im)
    {
    	for(int i = 0; i < iml.length + 1; i++)
    		if(im.equals(iml[i]))
    		{
    			this.im = ims[i];
    			set = i;
    			break;
    		}
    	this.setOpaque(true);
    }
    
    //Draw the back ground
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
    public void fishClickImage()//newfish
    {
    	this.im = ims[5];//////////�n��
    	repaint();
    }
    
    public void fishChangeImage(int a)
    {
    	//if*9 ����/////////////////////////////�T�{���ذ_�l��m
    	this.im = ims[6 + a];
    	repaint();
    }
    
    public void deviceSetImage()//device
    {
    	this.im = ims[4];
    	repaint();
    }
    
    public void deviceClickImage()//device
    {
    	this.im = ims[5];
    	repaint();
    }
    
    public void singleImageChange(String im)//status.newfish
    {
    	for(int i = 0; i < iml.length + 1; i++)
    		if(im.equals(iml[i]))
    		{
    			this.im = ims[i];
    			break;
    		}
    	repaint();
    }
    
    public void displayImageChange(String im)//display
    {
    	for(int i = 0; i < iml.length + 1; i++)
    		if(im.equals(iml[i]))
    		{
    			this.im = ims[i];
    			break;
    		}
    	repaint();
    }
    
    public void resetImage()//all
    {
    	this.im = ims[set];
    	repaint();
    }
}