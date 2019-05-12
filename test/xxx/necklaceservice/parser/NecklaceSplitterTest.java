package xxx.necklaceservice.parser;

import org.testng.annotations.Test;
import xxx.necklaceservice.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class NecklaceSplitterTest {
	ISplitter iSplitter = new NecklaceSplitter();

	@Test(expectedExceptions = CustomException.class)
	public void testSplitNull() throws CustomException {
		iSplitter.split(null);
	}

	@Test
	public void testSplitEmpty() throws CustomException {
		assertEquals(new String[0], iSplitter.split(new ArrayList<>()));
	}

	@Test
	public void testSplit() throws CustomException {
		List<String> necklaceList = new ArrayList<>();
		necklaceList.add("necklace00001");
		necklaceList.add("&canvas00001-150-200-ALBUM_AURUM");
		necklaceList.add("#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6");
		necklaceList.add("&3080");
		necklaceList.add(">");
		String[] array =
				{"necklace00001&canvas00001-150-200-ALBUM_AURUM#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6&3080"};
		assertEquals(array, iSplitter.split(necklaceList));
	}
}