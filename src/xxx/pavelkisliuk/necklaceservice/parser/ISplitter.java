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

import java.util.List;

/**
 * The {@code ISplitter} interface provide method for separating data
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see NecklaceSplitter
 * @since 12.0
 */
public interface ISplitter {
	/**
	 * @param stringList represent {@code List for separating}
	 * @return array of separated data
	 */
	String[] split(List<String> stringList);
}