package status;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aquarium.Aquarium;
import fishtankPanel.FishtankPanel;
import multiPanel.StatusPanel;
import multiPanel.DevicePanel;
import multiPanel.DisplayPanel;
import multiPanel.EventPanel;
import multiPanel.HistoryPanel;
import multiPanel.NewfishPanel;

@SuppressWarnings("serial")
public class Status extends JPanel
{
	private Aquarium aquarium;
	//���ʨƥ�
    private ButtonHandler bH = new ButtonHandler();
	//���A�@�����s
    private JButton statusB = new JButton(), eventB = new JButton(), historyB = new JButton(),
    		        newfishB = new JButton(), deviceB = new JButton(), displayB = new JButton();
    public JLabel MoneyL = new JLabel();
    private StatusPanel statusP;
    private EventPanel eventP;
    private HistoryPanel historyP;
    private NewfishPanel newfishP;
    private DevicePanel deviceP;
    private DisplayPanel displayP;
    
    //���s��m�j�p�`��
    private final int BUTTONLEFT = 30;
    private final int BUTTONTOP = 30;
    private final int BUTTONLENGTH = 200;
    private final int BUTTONWIDTH = 75;
    private final int BUTTONSPACING = 100;
    //�r��j�p
    private final int BUTTONFONTSIZE = 22;
    //���O��m�j�p�`��
    private final int PANELLEFT = 250;
    private final int PANELTOP = 30;
    private final int PANELLENGTH = 1000;
    private final int PANELWIDTH = 690;
    		
    public Status(Aquarium a,FishtankPanel ftp)
    {
    	aquarium = a;
    	newfishP = new NewfishPanel(aquarium,ftp);
    	deviceP = new DevicePanel(aquarium);
    	displayP = new DisplayPanel(aquarium);
    	eventP = new EventPanel(aquarium);
    	statusP = new StatusPanel(aquarium);
    	historyP = new HistoryPanel(aquarium);
    	deviceP.Money(MoneyL);
        displayP.Money(MoneyL);
        setButton();
        setPanel();
        setMoney();
        
    }
    /*
    public void setDisplaySize(int size)////////////////���ݭn?
    {
    	displayP.setSize(size);
    }
    */
    private void setButton()
    {
    	//��m.�j�p.�r��
    	statusB.setText("���A�@��");
    	statusB.setForeground(Color.red.brighter());
    	statusB.setFont(new Font(null, Font.BOLD, BUTTONFONTSIZE));
    	statusB.setBounds(BUTTONLEFT, BUTTONTOP, BUTTONLENGTH, BUTTONWIDTH);
        add(statusB);
        eventB.setText("�ƥ����");
        eventB.setFont(new Font(null, Font.BOLD, BUTTONFONTSIZE));
        eventB.setBounds(BUTTONLEFT, BUTTONTOP+BUTTONSPACING*1, BUTTONLENGTH, BUTTONWIDTH);
        add(eventB);
        historyB.setText("���v����");
        historyB.setFont(new Font(null, Font.BOLD, BUTTONFONTSIZE));
        historyB.setBounds(BUTTONLEFT, BUTTONTOP+BUTTONSPACING*2, BUTTONLENGTH, BUTTONWIDTH);
        add(historyB);
        newfishB.setText("�[�J�s��");
        newfishB.setFont(new Font(null, Font.BOLD, BUTTONFONTSIZE));
        newfishB.setBounds(BUTTONLEFT, BUTTONTOP+BUTTONSPACING*3, BUTTONLENGTH, BUTTONWIDTH);
        add(newfishB);
        deviceB.setText("�]�ƥؿ�");
        deviceB.setFont(new Font(null, Font.BOLD, BUTTONFONTSIZE));
        deviceB.setBounds(BUTTONLEFT, BUTTONTOP+BUTTONSPACING*4, BUTTONLENGTH, BUTTONWIDTH);
        add(deviceB);
        displayB.setText("�\��]�w");
        displayB.setFont(new Font(null, Font.BOLD, BUTTONFONTSIZE));
        displayB.setBounds(BUTTONLEFT, BUTTONTOP+BUTTONSPACING*5, BUTTONLENGTH, BUTTONWIDTH);
        add(displayB);
        //�[�J�\��
        statusB.addActionListener(bH);
        eventB.addActionListener(bH);
        historyB.addActionListener(bH);
        newfishB.addActionListener(bH);
        deviceB.addActionListener(bH);
        displayB.addActionListener(bH);
    }
    
    private void setPanel()
    {
    	//�ƪ�.��m
        statusP.setLayout(null);
        statusP.setBounds(PANELLEFT, PANELTOP, PANELLENGTH, PANELWIDTH);
        add(statusP);
        eventP.setLayout(null);
        eventP.setBounds(PANELLEFT, PANELTOP, PANELLENGTH, PANELWIDTH);
        eventP.setVisible(false);
        add(eventP);
        historyP.setLayout(null);
        historyP.setBounds(PANELLEFT, PANELTOP, PANELLENGTH, PANELWIDTH);
        historyP.setVisible(false);
        add(historyP);
        newfishP.setLayout(null);
        newfishP.setBounds(PANELLEFT, PANELTOP, PANELLENGTH, PANELWIDTH);
        newfishP.setVisible(false);
        add(newfishP);
        deviceP.setLayout(null);
        deviceP.setBounds(PANELLEFT, PANELTOP, PANELLENGTH, PANELWIDTH);
        deviceP.setVisible(false);
        add(deviceP);
        displayP.setLayout(null);
        displayP.setBounds(PANELLEFT, PANELTOP, PANELLENGTH, PANELWIDTH);
        displayP.setVisible(false);
        add(displayP);
    }
    
    private void setMoney()
    {
    	MoneyL.setText("�`��O���B:");
    	MoneyL.setBounds(25, 640, 200, 20);
    	MoneyL.setForeground(Color.decode("#4169E1"));
    	MoneyL.setFont(new Font(null, Font.BOLD, 20));
    	add(MoneyL);
    }
    
    private void setAllPVisFalse()
    {
    	statusP.setVisible(false);
    	eventP.setVisible(false);
    	historyP.setVisible(false);
    	newfishP.setVisible(false);
    	deviceP.setVisible(false);
    	displayP.setVisible(false);
    }
    
    private void setAllButtonFontReset()
    {
    	statusB.setForeground(Color.black);
    	eventB.setForeground(Color.black);
    	historyB.setForeground(Color.black);
    	newfishB.setForeground(Color.black);
    	deviceB.setForeground(Color.black);
    	displayB.setForeground(Color.black);
    }
    
    public void refresh()
    {
    	statusP.refresh();
    	newfishP.refresh();
    	deviceP.refresh();
    	setAllButtonFontReset();
    	statusB.setForeground(Color.red);
    	statusP.setVisible(true);
    }
    
  	private class ButtonHandler implements  ActionListener
  	{
  		public void actionPerformed(ActionEvent ae) 
        {
  			if(ae.getSource() == statusB)
  			{
  				setAllButtonFontReset();
  				statusB.setForeground(Color.red.brighter());
  				setAllPVisFalse();
  				statusP.setVisible(true);
  				statusP.refresh();
  			}
  		    else if(ae.getSource() == eventB)
            {
  		    	setAllButtonFontReset();
  		    	eventB.setForeground(Color.red.brighter());
  		    	setAllPVisFalse();
  		    	eventP.refresh();
  				eventP.setVisible(true);
            }
  			else if(ae.getSource() == historyB)
  			{
  				setAllButtonFontReset();
  				historyB.setForeground(Color.red.brighter());
  				setAllPVisFalse();
  				historyP.refresh();
  				historyP.setVisible(true);
  			}
  			else if(ae.getSource() == newfishB)
  			{
  				setAllButtonFontReset();
  				newfishB.setForeground(Color.red.brighter());
  				setAllPVisFalse();
  				newfishP.setVisible(true);
  				newfishP.refresh();
  			}
  			else if(ae.getSource() == deviceB)
  			{
  				setAllButtonFontReset();
  				deviceB.setForeground(Color.red.brighter());
  				setAllPVisFalse();
  				deviceP.refresh();
  				deviceP.setVisible(true);
  			}
  			else if(ae.getSource() == displayB)
  			{
  				setAllButtonFontReset();
  				displayB.setForeground(Color.red.brighter());
  				setAllPVisFalse();
  				displayP.refresh();
  				displayP.setVisible(true);
  			}
        }
  	}
}
