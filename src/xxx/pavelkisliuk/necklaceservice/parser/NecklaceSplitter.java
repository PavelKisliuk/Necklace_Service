/*
 * By Pavel Kisliuk, 12.05.2019
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

package xxx.pavelkisliuk.necklaceservice.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxx.pavelkisliuk.necklaceservice.model.Necklace;

import java.util.ArrayList;
import java.util.List;

/**
 * Separator of {@code Necklace} implementation of the {@code ISplitter} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see ISplitter
 * @see Necklace
 * @since 12.0
 */
public class NecklaceSplitter implements ISplitter {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Return array of {@code String} as {@code Necklace} string representation
	 * <p>
	 *
	 * @param stringList represent {@code List for separating}
	 * @return array of separated data
	 */
	@Override
	public String[] split(List<String> stringList) {
		if (stringList == null) {
			LOGGER.log(Level.ERROR, ("Problem with stringList -> " + null));
			return LOGGER.traceExit(new String[0]);
		}
		if (stringList.size() == 0) {
			LOGGER.log(Level.ERROR, "stringList is empty.");
			return LOGGER.traceExit(new String[0]);
		}

		List<String> tempList = new ArrayList<>();
		StringBuilder stringBuilder = new StringBuilder();
		LOGGER.log(Level.TRACE, "Start separation.");
		for (String currentElement : stringList) {
			if (currentElement.equals(">")) {
				LOGGER.log(Level.DEBUG, ("Add new element -> " + stringBuilder.toString()));
				tempList.add(stringBuilder.toString());
				stringBuilder = new StringBuilder();
			} else {
				LOGGER.log(Level.TRACE, ("Add " + currentElement + " to stringBuilder."));
				stringBuilder.append(currentElement);
			}
		}

		return LOGGER.traceExit(tempList.toArray(new String[0]));
	}
}