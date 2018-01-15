package multiPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import aquarium.Aquarium;
import insertImage.ImagePanel;
import jpanelList.DeviceList;

@SuppressWarnings("serial")
public class DevicePanelChoose extends JPanel
{
	private Aquarium aquarium;
	private String[] set = {"0", "4", "8", "12", "16"};
	private int[] sets = {0, 4, 8, 12, 16};
	private final int boxSize = 130;
	private final int space = 10;
	private final int fontSize = 20;
	private String[] itemsL = { "null", "���������", "����������", "����������",
								"null", "��ŹL�o��", "���ŹL�o��", "���ŹL�o��",
								"null", "��Ů��", "���Ů��", "���Ů��",
								"null", "��ť[�ž�", "���ť[�ž�", "���ť[�ž�",
								"null", "��ŷө���", "���ŷө���", "���ŷө���" };
	private int[] Money = {0, 700, 1000, 1300,
						   0, 1000, 2000, 3000,
						   0, 200, 300, 400,
						   0, 200, 400, 600,
						   0, 200, 500, 800};
	private DeviceList fishfood = new DeviceList(boxSize, boxSize, space, "   ������", Color.BLUE, fontSize);
    private DeviceList waterfilter = new DeviceList(boxSize, boxSize, space, "   �L�o��", Color.BLUE, fontSize);
    private DeviceList deaerator = new DeviceList(boxSize, boxSize, space, "   ���", Color.BLUE, fontSize);
    private DeviceList warmer = new DeviceList(boxSize, boxSize, space, "   �[�ž�", Color.BLUE, fontSize);
    private DeviceList lighter = new DeviceList(boxSize, boxSize, space, "   �ө���", Color.BLUE, fontSize);
	private ImagePanel[] itemsI = { new ImagePanel(itemsL[0]), new ImagePanel(itemsL[1]), 
            						new ImagePanel(itemsL[2]), new ImagePanel(itemsL[3]),
            						new ImagePanel(itemsL[4]), new ImagePanel(itemsL[5]),
            						new ImagePanel(itemsL[6]), new ImagePanel(itemsL[7]),
            						new ImagePanel(itemsL[8]), new ImagePanel(itemsL[9]),
            						new ImagePanel(itemsL[10]), new ImagePanel(itemsL[11]),
            						new ImagePanel(itemsL[12]), new ImagePanel(itemsL[13]),
            						new ImagePanel(itemsL[14]), new ImagePanel(itemsL[15]),
            						new ImagePanel(itemsL[16]), new ImagePanel(itemsL[17]),
            						new ImagePanel(itemsL[18]), new ImagePanel(itemsL[19]) };
	private JPanel[] itemsII = { new JPanel(), new JPanel(), 
								 new JPanel(), new JPanel(),
								 new JPanel(), new JPanel(),
								 new JPanel(), new JPanel(),
								 new JPanel(), new JPanel(),
								 new JPanel(), new JPanel(),
								 new JPanel(), new JPanel(),
								 new JPanel(), new JPanel(),
								 new JPanel(), new JPanel(),
								 new JPanel(), new JPanel() };
	private JPanel listP = new JPanel()
    {
    	public Component add(Component c)
        {
            c.setBounds(5, getComponentCount() * 160 + 10, 720, 150);
            super.add(c);
            if(getHeight() <= getComponentCount() * 160 + 10)
                setPreferredSize(new Dimension(300, getComponentCount() * 160 + 10));
            return c;
        }
    };
    private JButton changeb = new JButton();
    private JScrollPane listS = new JScrollPane(listP);
	private ImagePanel lastChoose = null;
	private JLabel MoneyL;
    private int lastChooses = -1;
    
	public DevicePanelChoose(Aquarium a)
	{
		aquarium = a;
		setLists();
		setListPandS();
		setButton();
	}
	
	public void Money(JLabel moneyL)
	{
		MoneyL = moneyL;
	}
	
	private void setLists()
	{
		setfishfood();
		setwaterfilter();
		setdeaerator();
		setwarmer();
		setlighter();
	}
	
	private void setListPandS()
	{
		listP.setLayout(null);
		listP.setBackground(Color.white);
		listP.add(fishfood);
		listP.add(waterfilter);
		listP.add(deaerator);
		listP.add(warmer);
		listP.add(lighter);
		
		listS.setBounds(0, 0, 750, 580);
		listS.getVerticalScrollBar().setUnitIncrement(16);
		add(listS);
	}
	
	private void setButton()
	{
		changeb.setText("��");
		changeb.setFont(new Font(null, Font.BOLD, 16));
		changeb.setBounds(800, 485, 100, 40);
		changeb.addActionListener(bH);
		add(changeb);
	}
	
	private void setfishfood()
	{
		fishfood.setLayout(null);
		for(int i = 0; i < 4; i++)
		{
			itemsI[i].setName("" + i);
			itemsI[i].setToolTipText(itemsL[i]);
			itemsI[i].setBounds(5, 5, 120, 120);
			itemsII[i].setLayout(null);
			itemsII[i].setBackground(Color.white);
			itemsII[i].add(itemsI[i]);
			fishfood.add(itemsII[i]);
			itemsI[i].addMouseListener(listener);
		}
	}
	private void setwaterfilter()
	{
		waterfilter.setLayout(null);
		for(int i = 4; i < 8; i++)
		{
			itemsI[i].setName("" + i);
			itemsI[i].setToolTipText(itemsL[i]);
			itemsI[i].setBounds(5, 5, 120, 120);
			itemsII[i].setLayout(null);
			itemsII[i].setBackground(Color.white);
			itemsII[i].add(itemsI[i]);
			waterfilter.add(itemsII[i]);
			itemsI[i].addMouseListener(listener);
		}
	}
	private void setdeaerator()
	{
		deaerator.setLayout(null);
		for(int i = 8; i < 12; i++)
		{
			itemsI[i].setName("" + i);
			itemsI[i].setToolTipText(itemsL[i]);
			itemsI[i].setBounds(5, 5, 120, 120);
			itemsII[i].setLayout(null);
			itemsII[i].setBackground(Color.white);
			itemsII[i].add(itemsI[i]);
			deaerator.add(itemsII[i]);
			itemsI[i].addMouseListener(listener);
		}
	}
	private void setwarmer()
	{
		warmer.setLayout(null);
		for(int i = 12; i < 16; i++)
		{
			itemsI[i].setName("" + i);
			itemsI[i].setToolTipText(itemsL[i]);
			itemsI[i].setBounds(5, 5, 120, 120);
			itemsII[i].setLayout(null);
			itemsII[i].setBackground(Color.white);
			itemsII[i].add(itemsI[i]);
			warmer.add(itemsII[i]);
			itemsI[i].addMouseListener(listener);
		}
	}
	private void setlighter()
	{
		lighter.setLayout(null);
		for(int i = 16; i < 20; i++)
		{
			itemsI[i].setName("" + i);
			itemsI[i].setToolTipText(itemsL[i]);
			itemsI[i].setBounds(5, 5, 120, 120);
			itemsII[i].setLayout(null);
			itemsII[i].setBackground(Color.white);
			itemsII[i].add(itemsI[i]);
			lighter.add(itemsII[i]);
			itemsI[i].addMouseListener(listener);
		}
	}
	
	private void resetImage()
	{
		for(int i = 0; i < 20; i++)
		{
			itemsII[i].setBackground(Color.white);
		}
		for(int i = 0; i < 20; i++)
		{
				if(i == aquarium.getDevice().getFeederbuyer() || i == aquarium.getDevice().getFilterbuyer() + 4 || i == aquarium.getDevice().getInflatorbuyer() + 8 || i == aquarium.getDevice().getHeaterbuyer() + 12 || i == aquarium.getDevice().getFlashLightbuyer() + 16)
					itemsII[i].setBackground(Color.red);
		}
		/*
			for(int j = 0; j < 20; j++)
				if(itemsI[j].getName().equals(set[i]))
				{
					itemsII[j].setBackground(Color.red);
					/////////////////////////////////////////////�I�schoose�禡
					break;
				}
		*/
		lastChooses = -1;
		lastChoose = null;
	}
	
	private void resetListS()
	{
		JScrollBar a = listS.getVerticalScrollBar();
		a.setValue(a.getMinimum());
		listS.setVisible(true);
	}
	
	public void refresh()
	{
		resetImage();
		resetListS();
	}
	
	private void money(/*int add*/)
	{
		/*///////////////////�I�s�禡       ���B +add
		 * MoneyL.setText("");
		 * 
		 */
		MoneyL.setText("�`��O���B: " + aquarium.getCost().getTotalCost());
	}
	
	private MouseAdapter listener = new MouseAdapter()
    {
        public void mousePressed(MouseEvent e)
        {
        	ImagePanel pnl=(ImagePanel)e.getSource();
        	System.out.println("Device click:" + pnl.getName());
        	int i;
        	for(i = 0; i < 20; i++)
        	{
        		if(pnl.getName().equals(itemsI[i].getName()))
        		{
        			break;
        		}
        	}
        	if(i == aquarium.getDevice().getFeederbuyer() || i == aquarium.getDevice().getFilterbuyer() + 4 || i == aquarium.getDevice().getInflatorbuyer() + 8 || i == aquarium.getDevice().getHeaterbuyer() + 12 || i == aquarium.getDevice().getFlashLightbuyer() + 16)
        		return; //�w�g���
        	if(lastChooses != -1)
        		itemsII[lastChooses].setBackground(Color.white);
        	lastChoose = pnl;
        	for(i = 0; i < 20; i++)
        	{
        		if(lastChoose.getName().equals(itemsI[i].getName()))
        		{
        			lastChooses = i;
        			itemsII[i].setBackground(Color.decode("#1E90FF"));
        			break;
        		}
        	}
        }
    };
    
    private ActionListener bH = new ActionListener()
    {
    	public void actionPerformed(ActionEvent ae)
        {
    		if(ae.getSource() == changeb)
    		{
    			if(lastChooses == -1 )
    			{
    				JOptionPane.showMessageDialog(listS, "�Х���ܳ]��", "ĵ�i", JOptionPane.WARNING_MESSAGE);
    				return;
    			}
    			int i = lastChooses / 4;
    			int j = lastChooses % 4;
    			if(i == 0)
    			{
    				itemsII[aquarium.getDevice().getFeederbuyer()].setBackground(Color.white);
    				aquarium.getDevice().buyFeeder(j, aquarium.getCost(), aquarium.getTimer());
    			}
    			else if(i == 1)
    			{
    				itemsII[aquarium.getDevice().getFilterbuyer() + 4].setBackground(Color.white);
    				aquarium.getDevice().buyFilter(j, aquarium.getCost(), aquarium.getTimer());
    			}
    			else if(i == 2)
    			{
    				itemsII[aquarium.getDevice().getInflatorbuyer() + 8].setBackground(Color.white);
    				aquarium.getDevice().buyInflator(j, aquarium.getCost(), aquarium.getTimer());
    			}
    			else if(i == 3)
    			{
    				itemsII[aquarium.getDevice().getHeaterbuyer() + 12].setBackground(Color.white);
    				aquarium.getDevice().buyheater(j, aquarium.getCost(), aquarium.getTimer());
    			}
    			else if(i == 4)
    			{
    				itemsII[aquarium.getDevice().getFlashLightbuyer() + 16].setBackground(Color.white);
    				aquarium.getDevice().buyflashLight(j, aquarium.getCost(), aquarium.getTimer());
    			}
    			//itemsII[sets[i]].setBackground(Color.white);
    			itemsII[lastChooses].setBackground(Color.red);
    			//set[i] = itemsI[lastChooses].getName();//
    			//sets[i] = lastChooses;//
    			lastChoose = null;
    			lastChooses = -1;
    			//JOptionPane.showMessageDialog(listS, "�ʶR��n��ܼҦ�\n�_�h�L�k�ҥ�", "ĵ�i", JOptionPane.WARNING_MESSAGE);
    			money();
    			//
    			//money(Money[lastChooses]);
    			///////////////////////////////////////////////////�禡->��Ѽ� finish
    		}
        }
    };
}