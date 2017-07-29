import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TemplateMethodTest {
	Coffee coffee;
	Tea tea;
	@Before
	public void setUp() throws Exception {
		tea = new Tea();
		coffee = new Coffee();
	}

	@Test
	public void test() {
		tea.prepareRecip();
		System.out.println("--------");
		coffee.prepareRecip();
	}

}
