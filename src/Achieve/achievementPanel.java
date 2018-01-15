package Achieve;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import DeviceCatalog.DeviceCatalog;
import fish.Fish;

public class achievementPanel extends JFrame{
	
	achievement[] achieve = new achievement[3];
	private JLabel cryFishLabel = new JLabel();
	private JLabel deviceMasterLabel = new JLabel();
	private JLabel dargonKingLabel = new JLabel();
	public achievementPanel(DeviceCatalog deviceC,Fish[] fishs) {
		achieve[0] = new cryFish();
		achieve[1] = new dargonKing();
		achieve[2] = new deviceMaster();
		this.setTitle("���N�ؿ�-�A���H�ʹN��A���M�פ@�˥���");
		setSize(1500,950);
		setLayout(null);
	}
	public void runCheckAchievement(DeviceCatalog deviceC,Fish[] fishs) 
	{
		for(int i=0;i<3;i++) 
		{
			achieve[i].checkGetAchievement(deviceC,fishs);
		}
		//���ߤ���
			//��r
			JLabel cryFishText = new JLabel();
			cryFishText.setBounds(30, 30, 800,100);
			cryFishText.setText(achieve[0].getStatement());
			cryFishText.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
			add(cryFishText);
			//�Ϥ�
			String cryFishImageName = "/pic/001.PNG";
			if(achieve[0].getHaveGET()==true) 
			{
				cryFishImageName = "/pic/0011.png";
			}
			BufferedImage cryFishImage;
			  try
	          {
				  cryFishImage = ImageIO.read(new File(cryFishImageName));
	          }
			  catch(Exception e)
	          {
	                  javax.swing.JOptionPane.showMessageDialog(null, "���J���ɿ��~: "+cryFishImageName);
	                  cryFishImage=null;//�p�G���~������ܿ��~�T��
	          }
			  cryFishLabel.setVisible(false);
			  cryFishLabel = new JLabel(new ImageIcon(cryFishImage));
			  cryFishLabel.setBounds(700, 30, 800,200);
			  cryFishLabel.setVisible(true);
			  add(cryFishLabel);
			  
			  //�`���s��
			  //��r
			  JLabel dargonKingText = new JLabel();
			  dargonKingText.setBounds(500,300,800,100);
			  dargonKingText.setText(achieve[1].getStatement());
			  dargonKingText.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
			  add(dargonKingText);
			  //�Ϥ�
			  String dargonKingImageName = "/pic/002.PNG";
			 
			  if(achieve[1].getHaveGET()==true) 
			  {
				  dargonKingImageName = "/pic/0022.png";
			  }
			  BufferedImage dargonKingImage = null;
			  try
	          {
				  dargonKingImage = ImageIO.read(new File(dargonKingImageName));
	          }
			  catch(Exception e)
	          {
	                  javax.swing.JOptionPane.showMessageDialog(null, "���J���ɿ��~: "+dargonKingImageName);
	                  dargonKingImageName=null;//�p�G���~������ܿ��~�T��
	          }
			  dargonKingLabel.setVisible(false);
			  dargonKingLabel = new JLabel(new ImageIcon( dargonKingImage));
			  dargonKingLabel.setBounds(30,300,400,250);
			  dargonKingLabel.setVisible(true);
			  add(dargonKingLabel);
			  
			  //�]�Ƥj�v
			  JLabel deviceMasterText = new JLabel();
			  deviceMasterText.setBounds(30,600,1000,100);
			  deviceMasterText.setText(achieve[2].getStatement());
			  deviceMasterText.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
			  add(deviceMasterText);
			  //�Ϥ�
			  String deviceMasterImageName = "/pic/003.PNG";
			  if(achieve[2].getHaveGET()==true) 
			  {
				  deviceMasterImageName = "/pic/0033.png";
			  }
			  BufferedImage deviceMasterImage = null;
			  try
	          {
				  deviceMasterImage = ImageIO.read(new File(deviceMasterImageName));
	          }
			  catch(Exception e)
	          {
	                  javax.swing.JOptionPane.showMessageDialog(null, "���J���ɿ��~: "+deviceMasterImageName);
	                  deviceMasterImageName=null;//�p�G���~������ܿ��~�T��
	          }
			  deviceMasterLabel.setVisible(false);
			  deviceMasterLabel = new JLabel(new ImageIcon( deviceMasterImage));
			  deviceMasterLabel.setBounds(1000,500,400,300);
			  deviceMasterLabel.setVisible(true);
			  add(deviceMasterLabel);
	}
	
	//�x�s (�Ĥ@�Ӧ��N��o���A�A�ĤG�Ӧ��N��o���A�A�ĤT�Ӧ��N��o���A)
	public String savaAchieve() 
	{
		String allAchieve;
		allAchieve = String.format("cryFishGET:%s,dragonKingGET:%s,deviceMasterGET:%s", achieve[0].getHaveGET()?"true":"false", achieve[1].getHaveGET()?"true":"false", achieve[2].getHaveGET()?"true":"false");
		return allAchieve;
	}
}
