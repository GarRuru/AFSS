package Achieve;

import DeviceCatalog.DeviceCatalog;
import fish.Fish;

//���N�t��
public abstract class achievement {
	
	private String name; //�ٸ�
	private String statement; //�޾ɱ��󻡩�
	private String GETstatement;//�����U��ܥX������
	private boolean haveGET; //�O�_���L�ٸ��F
	
	
	//�T�{������y������
	public abstract boolean checkGetAchievement(DeviceCatalog d, Fish[] fishs);
	
	public achievement() 
	{
		this.setName("�ٸ�");
		this.setStatement("�޾ɱ���");
		this.setGETstatement("��o���N");
		this.setHaveGET(false);
	}
	
	//set
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setStatement(String statement) 
	{
		this.statement = statement;
	}
	public void setGETstatement(String GETstatement) 
	{
		this.GETstatement = GETstatement;
	}
	public void setHaveGET(boolean input) 
	{
		this.haveGET = input;
	}
	
	//get
	//��X���󻡩�
	public String getStatement() 
	{
		return this.statement;
	}
	public String getName() 
	{
		return this.name;
	}
	public String gerGetStatement() 
	{
		return this.GETstatement;
	}
	public boolean getHaveGET() 
	{
		return this.haveGET;
	}
	
	
}
