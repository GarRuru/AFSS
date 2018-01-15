package fish.fishClass.oceanFish;

import fish.fishClass.OceanFish;

public class CentropygeFerrugata extends OceanFish {

	public CentropygeFerrugata(int weight, int lively, int lifeEnd, int maxWeight,int fight) {
		super(weight, lively, lifeEnd, maxWeight,fight);
	}
	
	public int getSatiationRate()
	{
		return ((super.getSatiation()*100)/(super.getWeight()));
	}
	
	@Override
	public String toString()
	{
		String str;
		str="	���{�q " +super.toString();
		return str;
	}

}
