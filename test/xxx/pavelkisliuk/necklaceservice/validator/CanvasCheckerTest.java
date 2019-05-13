package xxx.pavelkisliuk.necklaceservice.validator;

import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.exception.CustomException;
import xxx.pavelkisliuk.necklaceservice.validator.CanvasChecker;

import static org.testng.Assert.*;

public class CanvasCheckerTest {
	private CanvasChecker canvasChecker = new CanvasChecker();

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidNull() throws CustomException {
		canvasChecker.isValid(null);
	}

	@Test
	public void testIsValidEmpty() throws CustomException {
		assertFalse(canvasChecker.isValid(new String[0]));
	}

	@Test
	public void testIsValidCorrect() throws CustomException {
		String[] array = {"canvas00003", "10", "100", "ALBUM_AURUM"};
		assertTrue(canvasChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectId() throws CustomException {
		String[] array = {"canvas00003+", "10", "100", "ALBUM_AURUM"};
		assertFalse(canvasChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectWeight() throws CustomException {
		String[] array = {"canvas00003", "dsd", "100", "ALBUM_AURUM"};
		assertFalse(canvasChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectCost() throws CustomException {
		String[] array = {"canvas00003", "10", "100+6", "ALBUM_AURUM"};
		assertFalse(canvasChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectMetal() throws CustomException {
		String[] array = {"canvas00003", "10", "100", "ALBUM"};
		assertFalse(canvasChecker.isValid(array));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidIdNull() throws CustomException {
		canvasChecker.isValidId(null);
	}

	@Test
	public void testIsValidIdCorrect() throws CustomException {
		assertTrue(canvasChecker.isValidId("canvas00001"));
	}

	@Test
	public void testIsValidIdIncorrect() throws CustomException {
		assertFalse(canvasChecker.isValidId("*/*-//+++*%&^$%&*("));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidWeightNull() throws CustomException {
		canvasChecker.isValidWeight(null);
	}

	@Test
	public void testIsValidWeightCorrect() throws CustomException {
		assertTrue(canvasChecker.isValidWeight("13.3"));
	}

	@Test
	public void testIsValidWeightIncorrect() throws CustomException {
		assertFalse(canvasChecker.isValidWeight("-121"));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidCostNull() throws CustomException {
		canvasChecker.isValidCost(null);
	}

	@Test
	public void testIsValidCostCorrect() throws CustomException {
		assertTrue(canvasChecker.isValidCost("12.2"));
	}

	@Test
	public void testIsValidCostIncorrect() throws CustomException {
		assertFalse(canvasChecker.isValidCost("212.2.2.2."));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidMetalNull() throws CustomException {
		canvasChecker.isValidMetal(null);
	}

	@Test
	public void testIsValidMetalCorrect() throws CustomException {
		assertTrue(canvasChecker.isValidMetal("Aurum"));
	}

	@Test
	public void testIsValidMetalIncorrect() throws CustomException {
		assertFalse(canvasChecker.isValidMetal("GOLD"));
	}
}