package xxx.pavelkisliuk.necklaceservice.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class GemstoneCheckerTest {
	private GemstoneChecker gemstoneChecker = new GemstoneChecker();

	@Test
	public void testIsValidNull() {
		assertFalse(gemstoneChecker.isValid(null));
	}

	@Test
	public void testIsValidEmpty() {
		assertFalse(gemstoneChecker.isValid(new String[0]));
	}

	@Test
	public void testIsValidCorrect() {
		String[] array = {"Diamond", "Diamond00006", "10", "100", "MEDIUM", "HARD", "0.6"};
		assertTrue(gemstoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectCuriosity() {
		String[] array = {"Diamond", "Diamond00006", "10", "100", "MEDIUM+", "HARD", "0.6"};
		assertFalse(gemstoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectHardness() {
		String[] array = {"Diamond", "Diamond00006", "10", "100", "MEDIUM", "HARD-", "0.6"};
		assertFalse(gemstoneChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectOpacity() {
		String[] array = {"Diamond", "Diamond00006", "10", "100", "MEDIUM+", "HARD", "5.6"};
		assertFalse(gemstoneChecker.isValid(array));
	}

	@Test
	public void testIsValidCuriosityNull() {
		assertFalse(gemstoneChecker.isValidCuriosity(null));
	}

	@Test
	public void testIsValidCuriosityCorrect() {
		assertTrue(gemstoneChecker.isValidCuriosity("RARE"));
	}

	@Test
	public void testIsValidCuriosityIncorrect() {
		assertFalse(gemstoneChecker.isValidCuriosity("sdfdsfsdfsdfsf"));
	}

	@Test
	public void testIsValidHardnessNull() {
		assertFalse(gemstoneChecker.isValidHardness(null));
	}

	@Test
	public void testIsValidHardnessCorrect() {
		assertTrue(gemstoneChecker.isValidHardness("SPARSE"));
	}

	@Test
	public void testIsValidHardnessIncorrect() {
		assertFalse(gemstoneChecker.isValidHardness("sldgfs;dlgf"));
	}

	@Test
	public void testIsValidOpacityNull() {
		assertFalse(gemstoneChecker.isValidOpacity(null));
	}

	@Test
	public void testIsValidOpacityCorrect() {
		assertTrue(gemstoneChecker.isValidOpacity("0.2332"));
	}

	@Test
	public void testIsValidOpacityIncorrect() {
		assertFalse(gemstoneChecker.isValidOpacity("1.01"));
	}
}