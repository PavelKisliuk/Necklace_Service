package xxx.pavelkisliuk.necklaceservice.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class StoneCheckerTest {
	private StoneChecker stoneChecker = new StoneChecker();

	@Test
	public void testIsValidNull() {
		assertFalse(stoneChecker.isValid(null));
	}

	@Test
	public void testIsValidEmpty() {
		assertFalse(stoneChecker.isValid(new String[0]));
	}

	@Test
	public void testIsValidCorrect() {
		String[] array = {"Diamond", "Diamond00006", "10", "100"};
		assertTrue(stoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectName() {
		String[] array = {"Diamond.", "Diamond00006", "10", "100"};
		assertFalse(stoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectId() {
		String[] array = {"Diamond", "Diamond-00006", "10", "100"};
		assertFalse(stoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectWeight() {
		String[] array = {"Diamond", "Diamond00006", "10+10", "100"};
		assertFalse(stoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectCost() {
		String[] array = {"Diamond", "Diamond00006", "10", "100..10"};
		assertFalse(stoneChecker.isValid(array));
	}

	@Test
	public void testIsValidNameNull() {
		assertFalse(stoneChecker.isValidName(null));
	}

	@Test
	public void testIsValidNameCorrect() {
		assertTrue(stoneChecker.isValidName("Emerald"));
	}

	@Test
	public void testIsValidNameIncorrect() {
		assertFalse(stoneChecker.isValidName("Emerald+"));
	}

	@Test
	public void testIsValidIdNull() {
		assertFalse(stoneChecker.isValidId(null));
	}

	@Test
	public void testIsValidIdCorrect() {
		assertTrue(stoneChecker.isValidId("Emerald00001"));
	}

	@Test
	public void testIsValidIdIncorrect() {
		assertFalse(stoneChecker.isValidId("00001Emerald"));
	}

	@Test
	public void testIsValidWeightNull() {
		assertFalse(stoneChecker.isValidWeight(null));
	}

	@Test
	public void testIsValidWeightCorrect() {
		assertTrue(stoneChecker.isValidWeight("100.2"));
	}

	@Test
	public void testIsValidWeightIncorrect() {
		assertFalse(stoneChecker.isValidWeight("-100.2"));
	}

	@Test
	public void testIsValidCostNull() {
		assertFalse(stoneChecker.isValidCost(null));
	}

	@Test
	public void testIsValidCostCorrect() {
		assertTrue(stoneChecker.isValidCost("100.2"));
	}

	@Test
	public void testIsValidCostIncorrect() {
		assertFalse(stoneChecker.isValidCost("-100.2"));
	}
}