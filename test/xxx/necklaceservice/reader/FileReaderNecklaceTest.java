package xxx.necklaceservice.reader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import xxx.necklaceservice.creator.CanvasCreator;
import xxx.necklaceservice.creator.GemstoneCreator;
import xxx.necklaceservice.creator.NecklaceCreator;
import xxx.necklaceservice.creator.NecklaceElementCreator;
import xxx.necklaceservice.model.Canvas;
import xxx.necklaceservice.model.Gemstone;
import xxx.necklaceservice.model.Necklace;
import xxx.necklaceservice.model.Stone;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

import static org.testng.Assert.assertEquals;

public class FileReaderNecklaceTest {
	private FileReaderNecklace reader;

	@BeforeMethod
	public void setUp() {
		reader = new FileReaderNecklace();
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testReadNullPointerException() {
		reader.read(null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testReadIllegalArgumentException() {
		reader.read("");
	}

	@Test(expectedExceptions = FileSystemNotFoundException.class)
	public void testReadFileSystemNotFoundException() {
		reader.read("s68dsd64gsd654fsd654f986we4wf4ds1fsd64w9684d64s64f68we4f");
	}

	@Test
	public void testReadIfFileCorrect() {
		Canvas canvas = CanvasCreator.create("canvas00001", 150, 200, Canvas.Metal.ALBUM_AURUM);
		Stone gemstone = GemstoneCreator.create("Emerald", "Emerald00001", 100, 500,
				Gemstone.CuriosityLevel.MEDIUM, Gemstone.HardnessLevel.HARD, 0.6);

		Necklace necklace = NecklaceCreator.create("necklace00001",
				Collections.singletonList(NecklaceElementCreator.create(canvas, Collections.singletonList(gemstone))),
				3080);

		assertEquals(Collections.singletonList(necklace), reader.read("testfile/Filetest.txt"));
	}

	@Test
	public void testReadIfFileIncorrect() throws IOException {
		File file = new File("incorrect/data.txt");
		file.delete();

		reader.read("testfile/Icorrect.txt");

		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("incorrect/data.txt"))) {
			while(reader.ready()) {
				stringBuilder.append(reader.readLine()).append("\n");
			}
		}
		String str = "Incorrect" +
				"\n//--------------------------------------------------------\n";
		assertEquals(stringBuilder.toString(), str);
	}
}