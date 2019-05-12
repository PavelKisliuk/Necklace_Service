package xxx.necklaceservice.validator;

import org.testng.annotations.Test;
import xxx.necklaceservice.exception.CustomException;

import static org.testng.Assert.*;

public class NecklaceCheckerTest {
	private NecklaceChecker necklaceChecker = new NecklaceChecker();

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidNull() throws CustomException {
		necklaceChecker.isValid(null);
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidEmpty() throws CustomException {
		necklaceChecker.isValid(new String[0]);
	}

	@Test
	public void testIsValidCorrect() throws CustomException {
		String[] array = {"necklace00001",
				"canvas00001-150-200-ALBUM_AURUM#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6",
				"3080"};
		assertTrue(necklaceChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectId() throws CustomException {
		String[] array = {"necklace-00001",
				"canvas00001-150-200-ALBUM_AURUM#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6",
				"3080"};
		assertFalse(necklaceChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectList() throws CustomException {
		String[] array = {"necklace00001",
				"&canvas00001-150-200-ALBUM_AURUM#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6&",
				"3080"};
		assertFalse(necklaceChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectCost() throws CustomException {
		String[] array = {"necklace00001",
				"canvas00001-150-200-ALBUM_AURUM#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6",
				"&3080"};
		assertFalse(necklaceChecker.isValid(array));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidIdNull() throws CustomException {
		necklaceChecker.isValidId(null);
	}

	@Test
	public void testIsValidIdCorrect() throws CustomException {
		assertTrue(necklaceChecker.isValidId("necklace00001"));
	}

	@Test
	public void testIsValidIdIncorrect() throws CustomException {
		assertFalse(necklaceChecker.isValidId("necklace00001&"));
	}

	@Test
	public void testIsValidNecklaceElementsListCorrectWithString() throws CustomException {
		String necklaceElementsGroup = "canvas00003-100-175-ALBUM_AURUM\n" +
				"#Diamond-Diamond00006-10-100-RARE-HARD-0.45\n" +
				"#Diamond-Diamond00007-10-300-RARE-HARD-0.08\n" +
				"#Diamond-Diamond00008-10-190-RARE-HARD-0.21\n" +
				"~canvas00001-150-200-ALBUM_AURUM\n" +
				"#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6\n" +
				"#Diamond-Diamond00001-10-200-RARE-HARD-0.12\n" +
				"#Diamond-Diamond00002-10-190-RARE-HARD-0.21\n" +
				"~canvas00002-100-175-ALBUM_AURUM\n" +
				"#Diamond-Diamond00003-10-200-RARE-HARD-0.15\n" +
				"#Diamond-Diamond00004-10-200-RARE-HARD-0.12\n" +
				"#Diamond-Diamond00005-10-190-RARE-HARD-0.21";
		assertTrue(necklaceChecker.isValidNecklaceElementsList(necklaceElementsGroup));
	}

	@Test
	public void testIsValidNecklaceElementsListIncorrectWithString() throws CustomException {
		String necklaceElementsGroup = "&canvas00003-100-175-ALBUM_AURUM\n" +
				"#Diamond-Diamond00006-10-100-RARE-HARD-0.45\n" +
				"#Diamond-Diamond00007-10-300-RARE-HARD-0.08\n" +
				"#Diamond-Diamond00008-10-190-RARE-HARD-0.21\n" +
				"~canvas00001-150-200-ALBUM_AURUM\n" +
				"#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6\n" +
				"#Diamond-Diamond00001-10-200-RARE-HARD-0.12\n" +
				"#Diamond-Diamond00002-10-190-RARE-HARD-0.21\n" +
				"~canvas00002-100-175-ALBUM_AURUM\n" +
				"#Diamond-Diamond00003-10-200-RARE-HARD-0.15\n" +
				"#Diamond-Diamond00004-10-200-RARE-HARD-0.12\n" +
				"#Diamond-Diamond00005-10-190-RARE-HARD-0.21&";
		assertFalse(necklaceChecker.isValidNecklaceElementsList(necklaceElementsGroup));
	}

	@Test
	public void testIsValidNecklaceElementsListCorrectWithArray() throws CustomException {
		String[] necklaceElementsGroup = {"canvas00003-100-175-ALBUM_AURUM\n" +
				"#Diamond-Diamond00006-10-100-RARE-HARD-0.45\n" +
				"#Diamond-Diamond00007-10-300-RARE-HARD-0.08\n" +
				"#Diamond-Diamond00008-10-190-RARE-HARD-0.21\n",
				"canvas00001-150-200-ALBUM_AURUM\n" +
				"#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6\n" +
				"#Diamond-Diamond00001-10-200-RARE-HARD-0.12\n" +
				"#Diamond-Diamond00002-10-190-RARE-HARD-0.21\n",
				"canvas00002-100-175-ALBUM_AURUM\n" +
				"#Diamond-Diamond00003-10-200-RARE-HARD-0.15\n" +
				"#Diamond-Diamond00004-10-200-RARE-HARD-0.12\n" +
				"#Diamond-Diamond00005-10-190-RARE-HARD-0.21"};
		assertTrue(necklaceChecker.isValidNecklaceElementsList(necklaceElementsGroup));
	}

	@Test
	public void testIsValidNecklaceElementsListIncorrectWithArray() throws CustomException {
		String[] necklaceElementsGroup = {"canvas00003-100-175-ALBUM_AURUM\n" +
				"#Diamond-Diamond00006-10-100-RARE-HARD-0.45\n" +
				"#Diamond-Diamond00007-10-300-RARE-HARD-0.08\n" +
				"#Diamond-Diamond00008-10-190-RARE-HARD-0.21\n",
				"~canvas00001-150-200-ALBUM_AURUM\n" +
				"#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6\n" +
				"#Diamond-Diamond00001-10-200-RARE-HARD-0.12\n" +
				"#Diamond-Diamond00002-10-190-RARE-HARD-0.21\n",
				"~canvas00002-100-175-ALBUM_AURUM\n" +
				"#Diamond-Diamond00003-10-200-RARE-HARD-0.15\n" +
				"#Diamond-Diamond00004-10-200-RARE-HARD-0.12\n" +
				"#Diamond-Diamond00005-10-190-RARE-HARD-0.21"};
		assertFalse(necklaceChecker.isValidNecklaceElementsList(necklaceElementsGroup));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidCostNull() throws CustomException {
		necklaceChecker.isValidCost(null);
	}

	@Test
	public void testIsValidCostCorrect() throws CustomException {
		assertTrue(necklaceChecker.isValidCost("100.2"));
	}

	@Test
	public void testIsValidCostIncorrect() throws CustomException {
		assertFalse(necklaceChecker.isValidCost("-100.2"));
	}
}