package xxx.pavelkisliuk.necklaceservice.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CanvasCheckerTest {
	private CanvasChecker canvasChecker = new CanvasChecker();

	@Test
	public void testIsValidNull() {
		assertFalse(canvasChecker.isValid(null));
	}

	@Test
	public void testIsValidEmpty() {
		assertFalse(canvasChecker.isValid(new String[0]));
	}

	@Test
	public void testIsValidCorrect() {
		String[] array = {"canvas00003", "10", "100", "ALBUM_AURUM"};
		assertTrue(canvasChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectId() {
		String[] array = {"canvas00003+", "10", "100", "ALBUM_AURUM"};
		assertFalse(canvasChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectWeight() {
		String[] array = {"canvas00003", "dsd", "100", "ALBUM_AURUM"};
		assertFalse(canvasChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectCost() {
		String[] array = {"canvas00003", "10", "100+6", "ALBUM_AURUM"};
		assertFalse(canvasChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectMetal() {
		String[] array = {"canvas00003", "10", "100", "ALBUM"};
		assertFalse(canvasChecker.isValid(array));
	}

	@Test
	public void testIsValidIdNull() {
		assertFalse(canvasChecker.isValidId(null));
	}

	@Test
	public void testIsValidIdCorrect() {
		assertTrue(canvasChecker.isValidId("canvas00001"));
	}

	@Test
	public void testIsValidIdIncorrect() {
		assertFalse(canvasChecker.isValidId("*/*-//+++*%&^$%&*("));
	}

	@Test
	public void testIsValidWeightNull() {
		assertFalse(canvasChecker.isValidWeight(null));
	}

	@Test
	public void testIsValidWeightCorrect() {
		assertTrue(canvasChecker.isValidWeight("13.3"));
	}

	@Test
	public void testIsValidWeightIncorrect() {
		assertFalse(canvasChecker.isValidWeight("-121"));
	}

	@Test
	public void testIsValidCostNull() {
		assertFalse(canvasChecker.isValidCost(null));
	}

	@Test
	public void testIsValidCostCorrect() {
		assertTrue(canvasChecker.isValidCost("12.2"));
	}

	@Test
	public void testIsValidCostIncorrect() {
		assertFalse(canvasChecker.isValidCost("212.2.2.2."));
	}

	@Test
	public void testIsValidMetalNull() {
		assertFalse(canvasChecker.isValidMetal(null));
	}

	@Test
	public void testIsValidMetalCorrect() {
		assertTrue(canvasChecker.isValidMetal("Aurum"));
	}

	@Test
	public void testIsValidMetalIncorrect() {
		assertFalse(canvasChecker.isValidMetal("GOLD"));
	}
}