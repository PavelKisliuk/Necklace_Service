package xxx.necklaceservice.validator;

import org.testng.annotations.Test;
import xxx.necklaceservice.exception.CustomException;

import static org.testng.Assert.*;

public class GemstoneCheckerTest {
	private GemstoneChecker gemstoneChecker = new GemstoneChecker();

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidNull() throws CustomException {
		gemstoneChecker.isValid(null);
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidEmpty() throws CustomException {
		gemstoneChecker.isValid(new String[0]);
	}

	@Test
	public void testIsValidCorrect() throws CustomException {
		String[] array = {"Diamond", "Diamond00006", "10", "100", "MEDIUM", "HARD", "0.6"};
		assertTrue(gemstoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectCuriosity() throws CustomException {
		String[] array = {"Diamond", "Diamond00006", "10", "100", "MEDIUM+", "HARD", "0.6"};
		assertFalse(gemstoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectHardness() throws CustomException {
		String[] array = {"Diamond", "Diamond00006", "10", "100", "MEDIUM", "HARD-", "0.6"};
		assertFalse(gemstoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectOpacity() throws CustomException {
		String[] array = {"Diamond", "Diamond00006", "10", "100", "MEDIUM+", "HARD", "5.6"};
		assertFalse(gemstoneChecker.isValid(array));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidCuriosityNull() throws CustomException {
		gemstoneChecker.isValidCuriosity(null);
	}

	@Test
	public void testIsValidCuriosityCorrect() throws CustomException {
		assertTrue(gemstoneChecker.isValidCuriosity("RARE"));
	}

	@Test
	public void testIsValidCuriosityIncorrect() throws CustomException {
		assertFalse(gemstoneChecker.isValidCuriosity("sdfdsfsdfsdfsf"));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidHardnessNull() throws CustomException {
		gemstoneChecker.isValidHardness(null);
	}

	@Test
	public void testIsValidHardnessCorrect() throws CustomException {
		assertTrue(gemstoneChecker.isValidHardness("SPARSE"));
	}

	@Test
	public void testIsValidHardnessIncorrect() throws CustomException {
		assertFalse(gemstoneChecker.isValidHardness("sldgfs;dlgf"));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidOpacityNull() throws CustomException {
		gemstoneChecker.isValidOpacity(null);
	}

	@Test
	public void testIsValidOpacityCorrect() throws CustomException {
		assertTrue(gemstoneChecker.isValidOpacity("0.2332"));
	}

	@Test
	public void testIsValidOpacityIncorrect() throws CustomException {
		assertFalse(gemstoneChecker.isValidOpacity("1.01"));
	}
}