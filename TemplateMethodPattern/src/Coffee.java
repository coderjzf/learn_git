
public class Coffee extends CaffeineBeverage {

	@Override
	void brew() {
		System.out.println("Driping coffee through filter.");
	}

	@Override
	void addCondiment() {
		System.out.println("Add sugar and milk.");
	}
}
