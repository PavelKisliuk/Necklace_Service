package xxx.pavelkisliuk.necklaceservice.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class NecklaceElementCheckerTest {
	private NecklaceElementChecker necklaceElementChecker = new NecklaceElementChecker();

	@Test
	public void testIsValidNull() {
		assertFalse(necklaceElementChecker.isValid(null));
	}

	@Test
	public void testIsValid() {
		String[] stonesGroup = {"canvas00003-100-175-ALBUM_AURUM",
				"Diamond-Diamond00006-10-100-RARE-HARD-0.45",
				"Diamond-Diamond00007-10-300-RARE-HARD-0.08",
				"Diamond-Diamond00008-10-190-RARE-HARD-0.21"};
		assertTrue(necklaceElementChecker.isValid(stonesGroup));
	}

	@Test
	public void testIsValidIncorrectCanvas() {
		String[] stonesGroup = {"&canvas00003-100-175-ALBUM_AURUM",
				"Diamond-Diamond00006-10-100-RARE-HARD-0.45",
				"Diamond-Diamond00007-10-300-RARE-HARD-0.08",
				"Diamond-Diamond00008-10-190-RARE-HARD-0.21"};
		assertFalse(necklaceElementChecker.isValid(stonesGroup));
	}

	@Test
	public void testIsValidIncorrectStonesGroup() {
		String[] stonesGroup = {"canvas00003-100-175-ALBUM_AURUM",
				"#Diamond-Diamond00006-10-100-RARE-HARD-0.45",
				"#Diamond-Diamond00007-10-300-RARE-HARD-0.08",
				"#Diamond-Diamond00008-10-190-RARE-HARD-0.21"};
		assertFalse(necklaceElementChecker.isValid(stonesGroup));
	}

	@Test
	public void testIsValidCanvasNull() {
		assertFalse(necklaceElementChecker.isValidCanvas(null));
	}

	@Test
	public void testIsValidCanvasCorrect() {
		assertTrue(necklaceElementChecker.isValidCanvas("canvas00003-100-175-ALBUM_AURUM"));
	}

	@Test
	public void testIsValidCanvasIncorrect() {
		assertFalse(necklaceElementChecker.isValidCanvas("&canvas00003-100-175-ALBUM_AURUM"));
	}

	@Test
	public void testIsValidStonesGroupCorrectWithString() {
		String stonesGroup = "Diamond-Diamond00006-10-100-RARE-HARD-0.45\n" +
				"#Diamond-Diamond00007-10-300-RARE-HARD-0.08\n" +
				"#Diamond-Diamond00008-10-190-RARE-HARD-0.21";
		assertTrue(necklaceElementChecker.isValidStonesGroup(stonesGroup));
	}

	@Test
	public void testIsValidStonesGroupIncorrectWithString() {
		String stonesGroup = "Diamond-Diamond00006-10-100-RARE-HARD-0.45\n" +
				"#Diamond-Diamond00007-10-300-RARE-HARD-0.08\n" +
				"#Diamond-Diamond00008-10-190-RARE-HARD-0.21&";
		assertFalse(necklaceElementChecker.isValidStonesGroup(stonesGroup));
	}

	@Test
	public void testIsValidStonesGroupCorrectWithArray() {
		String[] stonesGroup = {"Diamond-Diamond00006-10-100-RARE-HARD-0.45",
				"Diamond-Diamond00007-10-300-RARE-HARD-0.08",
				"Diamond-Diamond00008-10-190-RARE-HARD-0.21"};
		assertTrue(necklaceElementChecker.isValidStonesGroup(stonesGroup));
	}

	@Test
	public void testIsValidStonesGroupIncorrectWithArray() {
		String[] stonesGroup = {"Diamond-Diamond00006-10-100-RARE-HARD-0.45\n",
				"#Diamond-Diamond00007-10-300-RARE-HARD-0.08\n",
				"#Diamond-Diamond00008-10-190-RARE-HARD-0.21"};
		assertFalse(necklaceElementChecker.isValidStonesGroup(stonesGroup));
	}
}