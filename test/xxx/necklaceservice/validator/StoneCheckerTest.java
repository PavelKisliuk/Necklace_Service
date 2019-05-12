package xxx.necklaceservice.validator;

import org.testng.annotations.Test;
import xxx.necklaceservice.exception.CustomException;

import static org.testng.Assert.*;

public class StoneCheckerTest {
	private StoneChecker stoneChecker = new StoneChecker();

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidNull() throws CustomException {
		stoneChecker.isValid(null);
	}

	@Test
	public void testIsValidEmpty() throws CustomException {
		assertFalse(stoneChecker.isValid(new String[0]));
	}

	@Test
	public void testIsValidCorrect() throws CustomException {
		String[] array = {"Diamond", "Diamond00006", "10", "100"};
		assertTrue(stoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectName() throws CustomException {
		String[] array = {"Diamond.", "Diamond00006", "10", "100"};
		assertFalse(stoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectId() throws CustomException {
		String[] array = {"Diamond", "Diamond-00006", "10", "100"};
		assertFalse(stoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectWeight() throws CustomException {
		String[] array = {"Diamond", "Diamond00006", "10+10", "100"};
		assertFalse(stoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectCost() throws CustomException {
		String[] array = {"Diamond", "Diamond00006", "10", "100..10"};
		assertFalse(stoneChecker.isValid(array));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidNameNull() throws CustomException {
		stoneChecker.isValidName(null);
	}

	@Test
	public void testIsValidNameCorrect() throws CustomException {
		assertTrue(stoneChecker.isValidName("Emerald"));
	}

	@Test
	public void testIsValidNameIncorrect() throws CustomException {
		assertFalse(stoneChecker.isValidName("Emerald+"));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidIdNull() throws CustomException {
		stoneChecker.isValidId(null);
	}

	@Test
	public void testIsValidIdCorrect() throws CustomException {
		assertTrue(stoneChecker.isValidId("Emerald00001"));
	}

	@Test
	public void testIsValidIdIncorrect() throws CustomException {
		assertFalse(stoneChecker.isValidId("00001Emerald"));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidWeightNull() throws CustomException {
		stoneChecker.isValidWeight(null);
	}

	@Test
	public void testIsValidWeightCorrect() throws CustomException {
		assertTrue(stoneChecker.isValidWeight("100.2"));
	}

	@Test
	public void testIsValidWeightIncorrect() throws CustomException {
		assertFalse(stoneChecker.isValidWeight("-100.2"));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidCostNull() throws CustomException {
		stoneChecker.isValidCost(null);
	}

	@Test
	public void testIsValidCostCorrect() throws CustomException {
		assertTrue(stoneChecker.isValidCost("100.2"));
	}

	@Test
	public void testIsValidCostIncorrect() throws CustomException {
		assertFalse(stoneChecker.isValidCost("-100.2"));
	}
}