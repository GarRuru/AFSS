package Achieve;

import javax.swing.JFrame;
import javax.swing.JLabel;

import DeviceCatalog.DeviceCatalog;
import db.Cost_data;
import enviroment.Enviroment;
import fish.Fish;

public class deviceMaster extends achievement {

	public deviceMaster() 
	{
		this.setName("�]Ĺ�v");
		this.setStatement("�N�zC�y���N���zC�n�M�A���p�G�A��N�z�]�Ƥ]�R�F�W�j�M(���MComebuy���������)...");
		//���󤵤Ѥ��A�a�A������Ӥj���A�g��r�e
		this.setGETstatement("*** �u�A�ϥΪ��]�Ʀ��󳣦b�e�A�@�M(�@�l���k0)�A����ƻ�!!!�v");
	}
	//�]�Ƥj�v �O���ƺٸ��ץ�


	@Override
	public boolean checkGetAchievement(DeviceCatalog deviceCatalog, Fish[] fishs) {
		if(this.getHaveGET())
			return false;
		
		Cost_data costConnect = new Cost_data();
	
		System.out.println(costConnect.CountData());
		if(costConnect.CountData()>10) 
		{
			achieveBox button = new achieveBox("���󤵤Ѥ��A�a�A������Ӥj���A�g��r�e");
			achieveBox button2 = new achieveBox("*** �u�A�ϥΪ��]�Ʀ��󳣦b�e�A�@�M(�@�l���k0)�A����ƻ�!!!�v***");
			deviceCatalog.feeder[deviceCatalog.getFeederSelector()].setDamageRateNow(0);
			deviceCatalog.filter[deviceCatalog.getFilterSelector()].setDamageRateNow(0);
			deviceCatalog.inflator[deviceCatalog.getInflatorSelector()].setDamageRateNow(0);
			deviceCatalog.heater[deviceCatalog.getHeaterSelector()].setDamageRateNow(0);
			deviceCatalog.flashLight[deviceCatalog.getFlashLightSelector()].setDamageRateNow(0);
			this.setHaveGET(true);
			return true;
		}
		return false;
	}

}
