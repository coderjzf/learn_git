
public abstract class CaffeineBeverage {
	
	//ģ�巽��
	public final void prepareRecip(){
		boilWater();
		brew();
		pourInCup();
		if(customerCondiment()){
			addCondiment();
		}
	}

	abstract void brew();
	abstract void addCondiment();
	
	public void boilWater(){
		System.out.println("Boiling water.");
	}
	
	public void pourInCup(){
		System.out.println("Pour water in cup.");
	}
	
	//���ӷ������������ѡ���Ƿ񸲸ǡ�
	public boolean customerCondiment(){
		return true;
	}
}
