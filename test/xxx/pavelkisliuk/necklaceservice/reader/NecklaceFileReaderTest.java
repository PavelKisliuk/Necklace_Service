package xxx.pavelkisliuk.necklaceservice.reader;

import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class NecklaceFileReaderTest {
	private NecklaceFileReader necklaceFileReader = new NecklaceFileReader();

	@Test(expectedExceptions = CustomException.class)
	public void testReadNull() throws CustomException {
		necklaceFileReader.read(null);
	}

	@Test(expectedExceptions = CustomException.class)
	public void testReadEmpty() throws CustomException {
		necklaceFileReader.read("");
	}

	@Test(expectedExceptions = CustomException.class)
	public void testReadNotExist() throws CustomException {
		necklaceFileReader.read("sgsgdgfgdfg");
	}

	@Test
	public void testRead() throws CustomException {
		List<String> expected = new ArrayList<>();
		expected.add("necklace00001");
		expected.add("&canvas00001-150-200-ALBUM_AURUM");
		expected.add("#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6");
		expected.add("&3080");
		expected.add(">");

		assertEquals(necklaceFileReader.read("testfile/Filetest.txt"), expected);
	}
}