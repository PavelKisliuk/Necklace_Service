package xxx.pavelkisliuk.necklaceservice.repository;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.creator.NecklaceCreator;
import xxx.pavelkisliuk.necklaceservice.exception.CustomException;
import xxx.pavelkisliuk.necklaceservice.model.Canvas;
import xxx.pavelkisliuk.necklaceservice.model.Gemstone;
import xxx.pavelkisliuk.necklaceservice.model.Necklace;
import xxx.pavelkisliuk.necklaceservice.parser.NecklaceSplitter;
import xxx.pavelkisliuk.necklaceservice.reader.NecklaceFileReader;
import xxx.pavelkisliuk.necklaceservice.specification.CuriositySpec;
import xxx.pavelkisliuk.necklaceservice.specification.HardnessSpec;
import xxx.pavelkisliuk.necklaceservice.specification.MetalSpec;
import xxx.pavelkisliuk.necklaceservice.specification.StoneNameSpec;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class RepositoryTest {
	private Repository repository = new Repository();
	private NecklaceFileReader fileReader = new NecklaceFileReader();
	private List<Necklace> expected;

	private void readExpectedData(String path) throws CustomException {
		List<String> tempList = fileReader.read(path);
		expected = new ArrayList<>();
		for (String necklace : new NecklaceSplitter().split(tempList)) {
			expected.add(new NecklaceCreator().create(necklace.split("&")));
		}
	}

	@BeforeTest
	public void readBigData() throws CustomException {
		List<String> tempList = fileReader.read("testfile/ForRepository/BigData.txt");
		List<Necklace> workingList = new ArrayList<>();
		for (String necklace : new NecklaceSplitter().split(tempList)) {
			workingList.add(new NecklaceCreator().create(necklace.split("&")));
		}
		repository.setNecklaceList(workingList);
	}

	@Test
	public void testQueryMetalAlbumCorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/AlbumAurum.txt");
		assertEquals(repository.query(new MetalSpec(Canvas.MetalType.ALBUM_AURUM)), expected);
	}

	@Test
	public void testQueryMetalAlbumIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/AlbumAurum.txt");
		assertNotEquals(repository.query(new MetalSpec(Canvas.MetalType.AERIS)), expected);
	}

	@Test
	public void testQueryMetalAerisCorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Aeris.txt");
		assertEquals(repository.query(new MetalSpec(Canvas.MetalType.AERIS)), expected);
	}

	@Test
	public void testQueryMetalAerisIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Aeris.txt");
		assertNotEquals(repository.query(new MetalSpec(Canvas.MetalType.ALBUM_AURUM)), expected);
	}

	@Test
	public void testQueryMetalAurumCorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Aurum.txt");
		assertEquals(repository.query(new MetalSpec(Canvas.MetalType.AURUM)), expected);
	}

	@Test
	public void testQueryMetalAurumIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Aurum.txt");
		assertNotEquals(repository.query(new MetalSpec(Canvas.MetalType.ALBUM_AURUM)), expected);
	}

	@Test
	public void testQueryCuriosityFrequentCorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Frequent.txt");
		assertEquals(repository.query(new CuriositySpec(Gemstone.CuriosityLevelType.FREQUENT)), expected);
	}

	@Test
	public void testQueryCuriosityFrequentIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Frequent.txt");
		assertNotEquals(repository.query(new CuriositySpec(Gemstone.CuriosityLevelType.RARE)), expected);
	}

	@Test
	public void testQueryCuriosityMediumCorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Medium.txt");
		assertEquals(repository.query(new CuriositySpec(Gemstone.CuriosityLevelType.MEDIUM)), expected);
	}

	@Test
	public void testQueryCuriosityMediumIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Medium.txt");
		assertNotEquals(repository.query(new CuriositySpec(Gemstone.CuriosityLevelType.RARE)), expected);
	}

	@Test
	public void testQueryCuriosityRareCorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Rare.txt");
		assertEquals(repository.query(new CuriositySpec(Gemstone.CuriosityLevelType.RARE)), expected);
	}

	@Test
	public void testQueryCuriosityRareIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Rare.txt");
		assertNotEquals(repository.query(new CuriositySpec(Gemstone.CuriosityLevelType.MEDIUM)), expected);
	}

	@Test
	public void testQueryHardnessHardCorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Hard.txt");
		assertEquals(repository.query(new HardnessSpec(Gemstone.HardnessLevelType.HARD)), expected);
	}

	@Test
	public void testQueryHardnessHardIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Hard.txt");
		assertNotEquals(repository.query(new HardnessSpec(Gemstone.HardnessLevelType.SPARSE)), expected);
	}

	@Test
	public void testQueryHardnessSparseCorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Sparse.txt");
		assertEquals(repository.query(new HardnessSpec(Gemstone.HardnessLevelType.SPARSE)), expected);
	}

	@Test
	public void testQueryHardnessSparseIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Sparse.txt");
		assertNotEquals(repository.query(new HardnessSpec(Gemstone.HardnessLevelType.SOFT)), expected);
	}

	@Test
	public void testQueryHardnessSoftCorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Soft.txt");
		assertEquals(repository.query(new HardnessSpec(Gemstone.HardnessLevelType.SOFT)), expected);
	}

	@Test
	public void testQueryHardnessSoftIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Soft.txt");
		assertNotEquals(repository.query(new HardnessSpec(Gemstone.HardnessLevelType.HARD)), expected);
	}

	@Test
	public void testQueryStoneNameDiamondCorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Diamond.txt");
		assertEquals(repository.query(new StoneNameSpec("Diamond")), expected);
	}

	@Test
	public void testQueryStoneNameDiamondIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Diamond.txt");
		assertNotEquals(repository.query(new StoneNameSpec("Sardius")), expected);
	}

	@Test
	public void testQueryStoneNameSardiusCorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Sardius.txt");
		assertEquals(repository.query(new StoneNameSpec("Sardius")), expected);
	}

	@Test
	public void testQueryStoneNameSardiusIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Sardius.txt");
		assertNotEquals(repository.query(new StoneNameSpec("Emerald")), expected);
	}
}