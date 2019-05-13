package xxx.pavelkisliuk.necklaceservice.validator;

import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.exception.CustomException;
import xxx.pavelkisliuk.necklaceservice.validator.NecklaceElementChecker;

import static org.testng.Assert.*;

public class NecklaceElementCheckerTest {
	private NecklaceElementChecker necklaceElementChecker = new NecklaceElementChecker();

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidNull() throws CustomException {
		necklaceElementChecker.isValid(null);
	}

	@Test
	public void testIsValid() throws CustomException {
		String[] stonesGroup = {"canvas00003-100-175-ALBUM_AURUM",
				"Diamond-Diamond00006-10-100-RARE-HARD-0.45",
				"Diamond-Diamond00007-10-300-RARE-HARD-0.08",
				"Diamond-Diamond00008-10-190-RARE-HARD-0.21"};
		assertTrue(necklaceElementChecker.isValid(stonesGroup));
	}

	@Test
	public void testIsValidIncorrectCanvas() throws CustomException {
		String[] stonesGroup = {"&canvas00003-100-175-ALBUM_AURUM",
				"Diamond-Diamond00006-10-100-RARE-HARD-0.45",
				"Diamond-Diamond00007-10-300-RARE-HARD-0.08",
				"Diamond-Diamond00008-10-190-RARE-HARD-0.21"};
		assertFalse(necklaceElementChecker.isValid(stonesGroup));
	}

	@Test
	public void testIsValidIncorrectStonesGroup() throws CustomException {
		String[] stonesGroup = {"canvas00003-100-175-ALBUM_AURUM",
				"#Diamond-Diamond00006-10-100-RARE-HARD-0.45",
				"#Diamond-Diamond00007-10-300-RARE-HARD-0.08",
				"#Diamond-Diamond00008-10-190-RARE-HARD-0.21"};
		assertFalse(necklaceElementChecker.isValid(stonesGroup));
	}

	@Test(expectedExceptions = CustomException.class)
	public void testIsValidCanvasNull() throws CustomException {
		necklaceElementChecker.isValidCanvas(null);
	}

	@Test
	public void testIsValidCanvasCorrect() throws CustomException {
		assertTrue(necklaceElementChecker.isValidCanvas("canvas00003-100-175-ALBUM_AURUM"));
	}

	@Test
	public void testIsValidCanvasIncorrect() throws CustomException {
		assertFalse(necklaceElementChecker.isValidCanvas("&canvas00003-100-175-ALBUM_AURUM"));
	}

	@Test
	public void testIsValidStonesGroupCorrectWithString() throws CustomException {
		String stonesGroup = "Diamond-Diamond00006-10-100-RARE-HARD-0.45\n" +
				"#Diamond-Diamond00007-10-300-RARE-HARD-0.08\n" +
				"#Diamond-Diamond00008-10-190-RARE-HARD-0.21";
		assertTrue(necklaceElementChecker.isValidStonesGroup(stonesGroup));
	}

	@Test
	public void testIsValidStonesGroupIncorrectWithString() throws CustomException {
		String stonesGroup = "Diamond-Diamond00006-10-100-RARE-HARD-0.45\n" +
				"#Diamond-Diamond00007-10-300-RARE-HARD-0.08\n" +
				"#Diamond-Diamond00008-10-190-RARE-HARD-0.21&";
		assertFalse(necklaceElementChecker.isValidStonesGroup(stonesGroup));
	}

	@Test
	public void testIsValidStonesGroupCorrectWithArray() throws CustomException {
		String[] stonesGroup = {"Diamond-Diamond00006-10-100-RARE-HARD-0.45",
				"Diamond-Diamond00007-10-300-RARE-HARD-0.08",
				"Diamond-Diamond00008-10-190-RARE-HARD-0.21"};
		assertTrue(necklaceElementChecker.isValidStonesGroup(stonesGroup));
	}

	@Test
	public void testIsValidStonesGroupIncorrectWithArray() throws CustomException {
		String[] stonesGroup = {"Diamond-Diamond00006-10-100-RARE-HARD-0.45\n",
				"#Diamond-Diamond00007-10-300-RARE-HARD-0.08\n",
				"#Diamond-Diamond00008-10-190-RARE-HARD-0.21"};
		assertFalse(necklaceElementChecker.isValidStonesGroup(stonesGroup));
	}
}