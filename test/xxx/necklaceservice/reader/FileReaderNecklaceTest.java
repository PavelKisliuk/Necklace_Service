package xxx.necklaceservice.reader;

import org.testng.annotations.Test;
import xxx.necklaceservice.creator.CanvasCreator;
import xxx.necklaceservice.creator.GemstoneCreator;
import xxx.necklaceservice.creator.NecklaceCreator;
import xxx.necklaceservice.creator.NecklaceElementCreator;
import xxx.necklaceservice.exception.CustomException;
import xxx.necklaceservice.model.Canvas;
import xxx.necklaceservice.model.Gemstone;
import xxx.necklaceservice.model.Necklace;
import xxx.necklaceservice.model.Stone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class FileReaderNecklaceTest {
	private FileReaderNecklace fileReaderNecklace = new FileReaderNecklace();

	@Test(expectedExceptions = CustomException.class)
	public void testReadNull() throws CustomException {
		fileReaderNecklace.read(null);
	}

	@Test(expectedExceptions = CustomException.class)
	public void testReadEmpty() throws CustomException {
		fileReaderNecklace.read("");
	}

	@Test(expectedExceptions = CustomException.class)
	public void testReadNotExist() throws CustomException {
		fileReaderNecklace.read("sgsgdgfgdfg");
	}

	@Test
	public void testRead() throws CustomException {
		List<String> necklaceList = new ArrayList<>();
		necklaceList.add("necklace00001");
		necklaceList.add("&canvas00001-150-200-ALBUM_AURUM");
		necklaceList.add("#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6");
		necklaceList.add("&3080");
		necklaceList.add(">");

		assertEquals(necklaceList, fileReaderNecklace.read("testfile/Filetest.txt"));
	}
}