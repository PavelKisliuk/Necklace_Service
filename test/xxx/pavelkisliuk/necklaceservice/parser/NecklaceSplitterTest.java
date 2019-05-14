package xxx.pavelkisliuk.necklaceservice.parser;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class NecklaceSplitterTest {
	private ISplitter iSplitter = new NecklaceSplitter();

	@Test
	public void testSplitNull() {
		assertEquals(new String[0], iSplitter.split(null));
	}

	@Test
	public void testSplitEmpty() {
		assertEquals(new String[0], iSplitter.split(new ArrayList<>()));
	}

	@Test
	public void testSplit() {
		List<String> necklaceList = new ArrayList<>();
		necklaceList.add("necklace00001");
		necklaceList.add("&canvas00001-150-200-ALBUM_AURUM");
		necklaceList.add("#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6");
		necklaceList.add("&3080");
		necklaceList.add(">");
		String[] expected =
				{"necklace00001&canvas00001-150-200-ALBUM_AURUM#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6&3080"};
		assertEquals(iSplitter.split(necklaceList), expected);
	}
}