package xxx.pavelkisliuk.necklaceservice.repository;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.creator.NecklaceCreator;
import xxx.pavelkisliuk.necklaceservice.exception.CustomException;
import xxx.pavelkisliuk.necklaceservice.model.Canvas;
import xxx.pavelkisliuk.necklaceservice.model.Necklace;
import xxx.pavelkisliuk.necklaceservice.parser.NecklaceSplitter;
import xxx.pavelkisliuk.necklaceservice.reader.NecklaceFileReader;
import xxx.pavelkisliuk.necklaceservice.specification.metalSpec;

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
		assertEquals(expected, repository.query(new metalSpec(Canvas.MetalType.ALBUM_AURUM)));
	}

	@Test
	public void testQueryMetalAlbumIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/AlbumAurum.txt");
		assertNotEquals(expected, repository.query(new metalSpec(Canvas.MetalType.AERIS)));
	}

	@Test
	public void testQueryMetalAerisCorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Aeris.txt");
		assertEquals(expected, repository.query(new metalSpec(Canvas.MetalType.AERIS)));
	}

	@Test
	public void testQueryMetalAerisIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Aeris.txt");
		assertNotEquals(expected, repository.query(new metalSpec(Canvas.MetalType.ALBUM_AURUM)));
	}

	@Test
	public void testQueryMetalAurumCorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Aurum.txt");
		assertEquals(expected, repository.query(new metalSpec(Canvas.MetalType.AURUM)));
	}

	@Test
	public void testQueryMetalAurumIncorrect() throws CustomException {
		readExpectedData("testfile/ForRepository/Aurum.txt");
		assertNotEquals(expected, repository.query(new metalSpec(Canvas.MetalType.ALBUM_AURUM)));
	}
}