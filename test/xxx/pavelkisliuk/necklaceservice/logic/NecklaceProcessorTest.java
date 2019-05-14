package xxx.pavelkisliuk.necklaceservice.logic;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.creator.GemstoneCreator;
import xxx.pavelkisliuk.necklaceservice.creator.NecklaceCreator;
import xxx.pavelkisliuk.necklaceservice.exception.CustomException;
import xxx.pavelkisliuk.necklaceservice.model.Gemstone;
import xxx.pavelkisliuk.necklaceservice.model.Necklace;
import xxx.pavelkisliuk.necklaceservice.parser.NecklaceSplitter;
import xxx.pavelkisliuk.necklaceservice.reader.NecklaceFileReader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class NecklaceProcessorTest {
	private Necklace necklace = new Necklace();

	@BeforeTest
	public void readData() throws CustomException {
		List<String> tempList = new NecklaceFileReader().read("testfile/Onenecklace.txt");
		for (String n : new NecklaceSplitter().split(tempList)) {
			necklace = new NecklaceCreator().create(n.split("&"));
		}
	}

	@Test
	public void testComputeCaratWeight() {
		double expected = 1930;
		assertEquals(new NecklaceProcessor().computeCaratWeight(necklace), expected);
	}

	@Test
	public void testComputePureCost() {
		BigDecimal expected = new BigDecimal(2620);
		assertEquals(expected.compareTo(new NecklaceProcessor().computePureCost(necklace)), 0);

	}
}