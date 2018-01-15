package main;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.*;

import BGM.AFSSSound;
import IOSave.Load;
import IOSave.Save;
import LandScape.Decoration;
import aquarium.Aquarium;
import aquarium.AquariumTask;
import aquarium.SpeedTask;
import db.Cost_data;
import db.Date_data;
import db.Event_data;
import db.Fish_data;
import dialog.NewDialog;
import dialog.SpeedDialog;
import enterPanel.EnterPanel;
import enviroment.Enviroment.Water;
import fish.Fish;
import fishtankPanel.FishtankPanel;
import status.Status;

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	private Timer timer;
	private AFSSSound buttom=new AFSSSound(1,2); 
	private AFSSSound buttom1=new AFSSSound(1,1); 
	private AFSSSound buttom2=new AFSSSound(2,1);
	
	private AFSSSound backgroundMusic2=new AFSSSound(32,3);
	
	private Aquarium aquarium = new Aquarium();
    //�إ߶i�J�I��.����
    public EnterPanel eP;
    //�إ߳����I�� 
    public FishtankPanel ftP;
    //���A�@������
    private Status statusP;
    //�\���    
    public JMenuBar mBr = new JMenuBar();
    //�i�J�e�����s
    private JButton openNew = new JButton();
    private JButton resume = new JButton();
    private JButton exit = new JButton();
    //�\���W���s
    private JButton swiftB = new JButton();
    private JButton speedB = new JButton();
    private JButton returnEB = new JButton();
    private JButton setbgmB = new JButton();
    private JButton feedB = new JButton();
    private JButton changewaterB = new JButton();
    private JButton netB = new JButton();
    private JButton tB = new JButton();
    //�u��C�Ϊť�
    private JLabel[] dash = { new JLabel("   "), new JLabel("   "), new JLabel("   "),
    		                  new JLabel("   "), new JLabel("   "), new JLabel("   "),
    		                  new JLabel("   "), new JLabel("   "), new JLabel("   "),
    		                  new JLabel("   "), new JLabel("   "), new JLabel("   ") };

    private final int ENTERBUTTONFONTSIZE = 15;

    private final int LEFT = 0;
    private final int TOP = 0;
    private final int LONGTH = 1280;
    private final int WIDTH = 720;

    private final int INITIALLOCATIONL = 50;
    private final int INITIALLOCATIONT = 40;
    
    
    private SpeedTask task;//�[�t���u�{
    private Thread speedUp;
    public MainFrame()
    {
        super("�����i��-Aquarium Farming Simulation System");
        setFishTank();
        Load load =new Load();
		try {
			aquarium=load.LoadData();
			ftP.loadDb(aquarium);
		} catch (IOException e) {
		}
		
        statusP = new Status(aquarium,ftP);
        System.out.println(statusP );
        setWindow();
        setEnterPanel();
        setMenuBar();
        setStatusPanel();
    }
    
    private void setWindow()
    {
        ImageIcon icon = new ImageIcon("d://pic//WindowIcon.png");
        setIconImage(icon.getImage());
        setLayout(null);
        setSize(LONGTH + 16, WIDTH + 69); //16, 39
        setLocation(INITIALLOCATIONL, INITIALLOCATIONT);
        setResizable(false);//������j���s�L�� 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//DO_NOTHING_ON_CLOSE
    }
    
    private void setEnterPanel()
    {
    	eP = new EnterPanel("Enter");
        eP.setLayout(null);
        eP.setBounds(LEFT, TOP, LONGTH, 750);
        add(eP);
        setEnterPanelButton();
    }
    
    private void setFishTank()
    {
    	ftP = new FishtankPanel("Fishtank");
    	ftP.setLayout(null);
        ftP.setBounds(LEFT, TOP, LONGTH, WIDTH);
        ftP.setVisible(false);
        add(ftP);
    }
    
    private void setEnterPanelButton()
    {
    	openNew.setText("�s����");
    	openNew.setToolTipText("test");
        openNew.setFont(new Font(null, Font.BOLD, ENTERBUTTONFONTSIZE));
        openNew.setBounds(550, 320, 100, 50);
        eP.add(openNew);
        resume.setText("�~�����");
        resume.setFont(new Font(null, Font.BOLD, ENTERBUTTONFONTSIZE));
        resume.setBounds(550, 380, 100, 50);
        eP.add(resume);
        exit.setText("���}");
        exit.setFont(new Font(null, Font.BOLD, ENTERBUTTONFONTSIZE));
        exit.setBounds(550, 440, 100, 50);
        eP.add(exit);
        //���s�[�J�\��
        openNew.addActionListener(bH);
        resume.addActionListener(bH);
        exit.addActionListener(bH);
    }
    
    private void setMenuBar()
    {
    	setJMenuBar(mBr);
        mBr.setVisible(false);        
        //�]�w�u��C�W�����s �[�J�Źj
        swiftB.setText("�����ܪ��A�@��");
        mBr.add(swiftB);
        mBr.add(dash[0]);
        speedB.setText("�[�t�ɶ�");
        mBr.add(speedB);
        mBr.add(dash[1]);
        returnEB.setText("�^����");
        mBr.add(returnEB);
        mBr.add(dash[2]);
        mBr.add(dash[3]);
        mBr.add(dash[4]);
        setbgmB.setText("�]�w����");
        mBr.add(setbgmB);
        mBr.add(dash[5]);
        mBr.add(dash[6]);
        mBr.add(dash[7]);
        mBr.add(dash[8]);
        feedB.setText("���}��");
        mBr.add(feedB);
        mBr.add(dash[9]);
        changewaterB.setText("����");
        mBr.add(changewaterB);
        mBr.add(dash[10]);
        netB.setText("������"); //  �ˬd���N
        mBr.add(netB);
        tB.setText("���N");
        tB.setVisible(false);
        mBr.add(tB);
        
        //���s�[�J�\��
        swiftB.addActionListener(bH);
        speedB.addActionListener(bH);
        returnEB.addActionListener(bH);
        setbgmB.addActionListener(bH);
        feedB.addActionListener(bH);
        changewaterB.addActionListener(bH);
        netB.addActionListener(bH);
        tB.addActionListener(bH);
    }
    
    private void setStatusPanel()
    {
    	statusP.setLayout(null);
        statusP.setBounds(LEFT, TOP, LONGTH, WIDTH);
        this.add(statusP);
        statusP.setVisible(false);
    }
    
    private void swift()
    {
    	if(statusP.isVisible() == false)
    	{
    		swiftB.setText("�����ܳ���");
    		returnEB.setVisible(false);
    		speedB.setVisible(false);
    		feedB.setVisible(false);
            changewaterB.setVisible(false);
            netB.setVisible(false);
            tB.setVisible(true);
            setbgmB.setVisible(false);
    	}
    	else
    	{
    		swiftB.setText("�����ܪ��A�@��");
    		returnEB.setVisible(true);
          	speedB.setVisible(true);
          	feedB.setVisible(true);
            changewaterB.setVisible(true);
            netB.setVisible(true);
            tB.setVisible(false);
            setbgmB.setVisible(true);
    	}
    }
    
    private ActionListener bH = new ActionListener()
    {
  		public void actionPerformed(ActionEvent ae)
        {
  			if(ae.getSource() == openNew)
  			{
  				//�ˬd���L����*******************************
  				
  				
  				
  				Fish_data  fish=new Fish_data();
  		    	Cost_data  cost=new Cost_data();
  		    	Event_data event= new Event_data();
  		    	Date_data  date=new Date_data();
  		    	
  		    	
  		    	fish.dropTable(); 
  		    	cost.dropTable();
  		    	event.dropTable();
  		    	date.dropTable();
  		    	
  		    
  		        date.createTable();
  		    	fish.createTable();
  		    	cost.createTable();
  		    	event.createTable();
  				
  				
  				
  				
  				NewDialog newD = new NewDialog();
  				newD.setBounds(INITIALLOCATIONL + 400, INITIALLOCATIONT + 225, 500, 400);
  				newD.setLayout(null);
  				newD.setAlwaysOnTop(true);
  				newD.setModal(true);
  				newD.setVisible(true);
  				newD.dispose();
  				//System.out.println("" + newD.result());
  				if(newD.result() != -1)
  				{
  					if(timer!=null) {
  					timer.cancel();
  					timer.purge();
  					}
  					ftP.reset();
  					int[] set;
  					set=newD.getSet();
  					
  					aquarium.aquariumReset(set[0],set[1]);
  					
  					//statusP.setDisplaySize(newD.result());/////////////�I�s�禡
  					AquariumTask temp=new AquariumTask(aquarium);
  	  				timer = new Timer();
  	  			    timer.schedule(temp, 0,1000);
  					
  					
  					mBr.setVisible(true);
  	  				ftP.setVisible(true);
  	  				eP.setVisible(false);
  	  				
  	  				buttom.play();//////////////////////////////////////////������
  	  				ftP.bcMusicPlay();
  				}
  				newD = null;
  				buttom.play();
  			}
  			else if(ae.getSource() == resume)
  			{
  				//�P�_���L����**********************************************
  				//������
  				//statusP.setDisplaySize(newD.result());///////////���ݭn?
  				//statusP.setDisplaySize(0);////////////////////////////////�I�s�禡
  				
  				
  				
  				AquariumTask temp=new AquariumTask(aquarium);
  				timer = new Timer();
  			    timer.schedule(temp, 0,1000);
  				
  			    mBr.setVisible(true);
  				ftP.setVisible(true);
  				eP.setVisible(false);
  				
  				buttom.play();//////////////////////////////////////////������
  				ftP.bcMusicPlay();
  				//�S����************************************��m
  				//JOptionPane.showMessageDialog(ebgP, "�å��o�{������","���~!!", JOptionPane.ERROR_MESSAGE);
  			}
  			else if(ae.getSource() == exit)
  			{
  				////////////////////////////////////////�s��
  				
  				Save save=new Save(aquarium);
                try {
					save.SaveData("test.txt");
				} catch (IOException e) {
					// TODO �۰ʲ��ͪ� catch �϶�
					e.printStackTrace();
				}  				
  				
  				System.exit(0);
  			}
  			else if(ae.getSource() == swiftB)
            {
  				if(statusP.isVisible() == false)
      			{
  					timer.cancel();
  					timer.purge();  					
  					///////////////////////�I�stimer
  					swift();
  					statusP.refresh();
  					statusP.setVisible(true);
  					ftP.setVisible(false);
  					buttom2.play();
  					
  				
  					ftP.bcMusicStop();
      			}
                else
                {
                	timer = new Timer();
                	AquariumTask temp=new AquariumTask(aquarium);
      				
      			    timer.schedule(temp, 0,1000);
                	///////////////////////�I�stimer
                	swift();
                	ftP.removeDisplay();
                	ftP.addDisplay(aquarium.getLandSpace().getTable(),aquarium.getEnviroment().getFishTankSize());
                	statusP.setVisible(false);
                  	ftP.setVisible(true);
                  	ftP.refresh(0);
                  	buttom2.play();
                  	
                  	ftP.bcMusicPlay();
                }
            }
  			else if(ae.getSource() == speedB)
  			{
  				//JOptionPane.showMessageDialog(ftP, "�[�t","�[�t!!", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("/pic/speedD.png"));
  				//�[�t�禡
  				//System.out.println(Fish.totalFish);
  				///////////////////////�I�stimer
  				if(speedUp==null ||speedUp.getState()!=Thread.State.RUNNABLE) {
  					SpeedDialog test = new SpeedDialog();
  	  				test.setBounds(INITIALLOCATIONL + 400, INITIALLOCATIONT + 225, 500, 420);
  	  				//test.setBounds(0, 0, 500, 420); ///////////////////////////////////�n���
  	  				test.setLayout(null);
  	  				test.setAlwaysOnTop(true);
  	  				test.setModal(true);
  	  				test.setVisible(true);
  	  				int[] tests = test.result();
  	  		
  					System.out.println("�[�t�ɶ����: 1:�@�p��  2:�@��  3:�@��§��  0:����\n" + tests[0] + "\n");
  					System.out.println("�����[   �۵M���`  �D�۵M���` " + 
  								   "���ͯf   ���ͪ��̤ܳj�������a�� " + 
  								   "�L�o���a�� ����a�� �ө����a�� " + 
  								   "�[�ž��a�� ���褣�}  �����V�|  " + 
  								   "�ūװ���  �ū׹L��  �ūװ��C  " + 
  								   "�ū׹L�C  �t��q���C �t��q�L�C " + 
  								   "�t��q���C\n");
  					for(int i = 1; i < 20; i++)
  						System.out.print("" + tests[i] + "     ");
  					System.out.println("");
  					if(tests[0] != 0)
  					{
  						/*
  						if(tests[0] == 1)
  						{
  							System.out.println("�[�t�@�p��");
  					 		//////////////////////////////////�[�t�@�p��
  						}
  						else if(tests[0] == 2)
  						{
  							System.out.println("�[�t�@��");
  							///////////////////////////////////�[�t�@��
  						}
  						else //tests[0] == 3
  						{
  							System.out.println("�[�t�@��§��");
  							///////////////////////////////////�[�t�@��§��
  						}
  						*/
  						timer.cancel();
  						timer.purge();  
  						timer = new Timer();
  		            	AquariumTask temp=new AquariumTask(aquarium);
  						task=new SpeedTask(aquarium,timer,tests);
  		  				speedUp=new Thread(task);
  		  				System.out.println(speedUp.getState());
  		  				speedUp.start();
  		  				System.out.println(speedUp.getState());
  		  				buttom1.play();
  					}
  					test = null;
  				}
  				//System.out.println(Fish.totalFish);
            	
  				
  			   // timer.schedule(temp, 0,1000);
  				
  				
  				
  			}
  			else if(ae.getSource() == returnEB)
  			{

					timer.cancel();
					timer.purge(); 
					ftP.bcMusicStop();
  				mBr.setVisible(false);
  				eP.setVisible(true);
  				ftP.setVisible(false);
  				/////////////////////////�I�stimer
  			}
  			else if(ae.getSource() == tB)
  			{
  				aquarium.achieve.runCheckAchievement(aquarium.getDevice(), aquarium.getFishs());
  				aquarium.achieve.setVisible(true);
  			}
  			else if(ae.getSource() == setbgmB)
  			{
  				ftP.changeBgm();
  			}
  			else if(ae.getSource() == feedB)
  			{
  				aquarium.getDevice().feeder[aquarium.getDevice().getFeederbuyer()].feed(aquarium.getEnviroment());
  			}
  			else if(ae.getSource() == changewaterB)
  			{
  				double quantity = Double.parseDouble(JOptionPane.showInputDialog("��J�����q(0~0.25)"));
  				aquarium.getDevice().changeWater.change(aquarium.getEnviroment(), 1, quantity);
  			}
  			else if(ae.getSource() == netB)
  			{
  				///////////////////////////�I�s������
  				ArrayList<Fish> removeFish=aquarium.removeAFish();
  				ftP.removeFish(removeFish);
  			}
        }
    };
        
  	public static void main(String [] args)
    {
		new MainFrame();
    }
}