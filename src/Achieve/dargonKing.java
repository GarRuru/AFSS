package Achieve;

import DeviceCatalog.DeviceCatalog;
import enviroment.Enviroment;
import fish.Fish;

public class dargonKing extends achievement {

	public dargonKing() 
	{
		this.setName("�`���s��");
		this.setStatement("���Ǧʤt�A�w�Ǩ����A���o�e���U�A���e�j�����ߡA�A�u�n�@���D�U�h�N�|......");
		//���p��D�A�Ψ줣��A�A�Y�U�h�N�|�Q�����@�D�b!
		this.setGETstatement("***��o��k �u����U��A�i���N���i�k�B�������v ����i�H��������F!!***");
	}
	

	@Override
	public boolean checkGetAchievement(DeviceCatalog deviceCatalog, Fish[] fishs) {
		//check arraylist �̭��Ҧ�����
		//�p�G�F��̤j����h�F������
		if(this.getHaveGET()==true)
			return false;
	
		int i=0;

		for(i=0 ;i<fishs.length;i++)
		{
			if(fishs[i]==null)
				return false;
			if(fishs[i].getMaxWeight() == fishs[i].getWeight())
			{
				achieveBox button3 = new achieveBox("���p��D�A�Ψ줣��A�A�Y�U�h�N�|�Q�����@�D�b!");
				achieveBox button4 = new achieveBox("***��o��k �u����U��A�i���N���i�k�B�������v ����i�H��������F!!***");
				for(int j=0;j<3;j++)
					deviceCatalog.feeder[j].setAchieve(true);
				this.setHaveGET(true);
				return true;
			}
		}
		return false;
	}

}
