package testNG;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
public class HardAssertTest {
	@Test
	public void hardAssert() {
		System.out.println("***Step-1***");
		System.out.println("***Step-2***");
		assertEquals("A", "A");
		System.out.println("***Step-3***");
	}
	
	@Test
	public void hadrAssert() {
		System.out.println("***Step-4***");
		assertEquals("B", "B");
		System.out.println("***Step-5***");
	}

}
