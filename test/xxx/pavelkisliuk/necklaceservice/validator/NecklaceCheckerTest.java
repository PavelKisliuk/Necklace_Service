package xxx.pavelkisliuk.necklaceservice.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class NecklaceCheckerTest {
	private NecklaceChecker necklaceChecker = new NecklaceChecker();

	@Test
	public void testIsValidNull() {
		assertFalse(necklaceChecker.isValid(null));
	}

	@Test
	public void testIsValidEmpty() {
		assertFalse(necklaceChecker.isValid(new String[0]));
	}

	@Test
	public void testIsValidCorrect() {
		String[] array = {"necklace00001",
				"canvas00001-150-200-ALBUM_AURUM#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6",
				"3080"};
		assertTrue(necklaceChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectId() {
		String[] array = {"necklace-00001",
				"canvas00001-150-200-ALBUM_AURUM#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6",
				"3080"};
		assertFalse(necklaceChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectList() {
		String[] array = {"necklace00001",
				"&canvas00001-150-200-ALBUM_AURUM#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6&",
				"3080"};
		assertFalse(necklaceChecker.isValid(array));
	}

	@Test
	public void testIsValidIncorrectCost() {
		String[] array = {"necklace00001",
				"canvas00001-150-200-ALBUM_AURUM#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6",
				"&3080"};
		assertFalse(necklaceChecker.isValid(array));
	}

	@Test
	public void testIsValidIdNull() {
		assertFalse(necklaceChecker.isValidId(null));
	}

	@Test
	public void testIsValidIdCorrect() {
		assertTrue(necklaceChecker.isValidId("necklace00001"));
	}

	@Test
	public void testIsValidIdIncorrect() {
		assertFalse(necklaceChecker.isValidId("necklace00001&"));
	}

	@Test
	public void testIsValidNecklaceElementsListCorrectWithString() {
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
	public void testIsValidNecklaceElementsListIncorrectWithString() {
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
	public void testIsValidNecklaceElementsListCorrectWithArray() {
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
	public void testIsValidNecklaceElementsListIncorrectWithArray() {
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

	@Test
	public void testIsValidCostNull() {
		assertFalse(necklaceChecker.isValidCost(null));
	}

	@Test
	public void testIsValidCostCorrect() {
		assertTrue(necklaceChecker.isValidCost("100.2"));
	}

	@Test
	public void testIsValidCostIncorrect() {
		assertFalse(necklaceChecker.isValidCost("-100.2"));
	}
}