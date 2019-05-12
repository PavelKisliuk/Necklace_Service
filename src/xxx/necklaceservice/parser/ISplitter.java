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

package xxx.necklaceservice.parser;

import xxx.necklaceservice.exception.CustomException;

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
	 * @throws CustomException if {@param stringList} is {@code null}
	 */
	String[] split(List<String> stringList) throws CustomException;
}