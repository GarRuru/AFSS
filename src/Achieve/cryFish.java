package Achieve;

import DeviceCatalog.DeviceCatalog;
import db.Fish_data;
import fish.Fish;

//�ٸ����ߤ���
public class cryFish extends achievement{

	public cryFish() 
	{
		this.setName("���ߤ���");
		this.setStatement("�p�G�A���p��bang���e�̡A���M���୫���������γ\��]�ױo�֩O......");
		//���`���b�]���������A���ѧA�i�H�b�a�̼������F
		this.setGETstatement("***��o���� �u�û����|�a�]�����������v �@�u!!***");
	}


	@Override
	public boolean checkGetAchievement(DeviceCatalog deviceCatalog, Fish[] fishs) {
		//�T�{����O�_�F��
		//�w�g����ٸ� �^��false
		if(this.getHaveGET()==true)
			return false;
		Fish_data fishConnect = new Fish_data();
		if(fishConnect.SelectDiedFishNum()>=3) 
		{
			int i;
	
			achieveBox button5 = new achieveBox("���`���b�]���������A���ѧA�i�H�b�a�̼������F");
			achieveBox button6 = new achieveBox("***��o���� �u�û����|�a�]�����������v �@�u!!***");
			//���즨�N
			this.setHaveGET(true);
			//new frame
			return true;
		}
		return false;
	}
	
	
}
