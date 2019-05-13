/*
 * By Pavel Kisliuk, 05.05.2019
 * This is class for education and nothing rights don't reserved.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package xxx.pavelkisliuk.necklaceservice.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxx.pavelkisliuk.necklaceservice.exception.CustomException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code NecklaceFileReader} class read special data for {@code Necklace} creation
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 12.0
 */
public class NecklaceFileReader {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Read data from file and return it as {@code List} of {@code String}
	 *
	 * @param path to file
	 * @return {@code List} of {@code String} red data
	 * @throws CustomException if wrong {@param path} or {@param path} is {@code null}
	 */
	public List<String> read(String path) throws CustomException {
		if ((path == null) ||
				(path.length() == 0) ||
				(Files.notExists(Paths.get(path)))) {
			LOGGER.log(Level.ERROR, ("Problem with String path -> " + path));
			throw new CustomException();
		}

		List<String> data;
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
			LOGGER.log(Level.TRACE, "Start to read data from file.");
			data = reader.lines().collect(Collectors.toList());
			LOGGER.log(Level.DEBUG, "Data red from file.");
		} catch (FileNotFoundException e) {
			LOGGER.log(Level.ERROR, "File didn't find", e);
			return new ArrayList<>();
		} catch (IOException e) {
			LOGGER.log(Level.ERROR, "Can't read file", e);
			return new ArrayList<>();
		}
		return LOGGER.traceExit(data);
	}
}