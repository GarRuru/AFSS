package dialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SpeedDialog extends JDialog
{
	private JLabel speedL = new JLabel("��ܥ[�t�ɶ�:");
	
	private JButton hourB = new JButton("�@�p��");
	private JButton dayB = new JButton("�@��");
	private JButton weekB = new JButton("�@��§��");
	
	private JLabel eventL = new JLabel("�����ܨƥ�:");
	
	private JCheckBox[] test = { new JCheckBox("�����["), new JCheckBox("�۵M���`"), new JCheckBox("�D�۵M���`"),
								 new JCheckBox("���ͯf"), new JCheckBox("���ͪ��̤ܳj"), new JCheckBox("�������a��"),
								 new JCheckBox("�L�o���a��"), new JCheckBox("����a��"), new JCheckBox("�ө����a��"),
								 new JCheckBox("�[�ž��a��"), new JCheckBox("���褣�}"), new JCheckBox("�����V�|"),
								 new JCheckBox("�ūװ���"), new JCheckBox("�ū׹L��"), new JCheckBox("�ūװ��C"),
								 new JCheckBox("�ū׹L�C"), new JCheckBox("�t��q���C"), new JCheckBox("�t��q�L�C"),
								 new JCheckBox("�t��q���C") };
	
	private JButton confirmB = new JButton("�T�{");
	private JButton cancelB = new JButton("����");
	
	private final int LEFT = 80;
	private final int TOP = 130;
	private final int WEIGHT = 120;
	private final int HEIGHT = 20;
	private final int LSPACE = 120;
	private final int TSPACE = 30;
	
	private int[] set = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			   			 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
 	
	public SpeedDialog()
	{
		setDialog();
		setLabel();
		setTime();
		setEvent();
	}
	
	private void setDialog()
	{
		setTitle("�[�t�ɶ�");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	private void setLabel()
	{
		speedL.setBounds(30, 15, 100, 25);
		add(speedL);
		eventL.setBounds(30, 95, 120, 25);
		add(eventL);
	}
	
	private void setTime()
	{
		hourB.setBounds(80, 55, 100, 25);
		hourB.addActionListener(bH);
		add(hourB);
		dayB.setBounds(190, 55, 100, 25);
		dayB.addActionListener(bH);
		add(dayB);
		weekB.setBounds(300, 55, 100, 25);
		weekB.addActionListener(bH);
		add(weekB);
		confirmB.setBounds(270, 340, 75, 25);
		confirmB.addActionListener(bH);
		add(confirmB);
		cancelB.setBounds(370, 340, 75, 25);
		add(cancelB);
		cancelB.addActionListener(bH);
	}
	
	private void setEvent()
	{
		for(int i = 0; i < 19; i++)
		{
			test[i].setBounds(LEFT + LSPACE * (i % 3), TOP + TSPACE * (i / 3), WEIGHT, HEIGHT);
			add(test[i]);
		}
	}
	
	private void resetTimeButton()
	{
		hourB.setForeground(Color.black);
		dayB.setForeground(Color.black);
		weekB.setForeground(Color.black);
	}
	
	public int[] result()
	{
		return set;
	}
	
	private ActionListener bH = new ActionListener()
    {
    	public void actionPerformed(ActionEvent ae) 
        {
    		if(ae.getSource() == hourB)
    		{
    			resetTimeButton();
    			hourB.setForeground(Color.blue);
    			set[0] = 1;
    		}
    		else if(ae.getSource() == dayB)
    		{
    			resetTimeButton();
    			dayB.setForeground(Color.blue);
    			set[0] = 2;
    		}
    		else if(ae.getSource() == weekB)
    		{
    			resetTimeButton();
    			weekB.setForeground(Color.blue);
    			set[0] = 3;
    		}
    		else if(ae.getSource() == confirmB)
    		{
    			for(int i = 0; i < 19; i++)
    			{
    				if(test[i].isSelected())
    					set[i + 1] = 1;
    			}
    			setVisible(false);
    		}
    		else if(ae.getSource() == cancelB)
    		{
    			set[0] = 0;
    			setVisible(false);
    		}
        }
    };
}
