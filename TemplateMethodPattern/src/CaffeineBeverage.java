
public abstract class CaffeineBeverage {
	
	//模板方法
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
	
	//钩子方法。子类可以选择是否覆盖。
	public boolean customerCondiment(){
		return true;
	}
}
