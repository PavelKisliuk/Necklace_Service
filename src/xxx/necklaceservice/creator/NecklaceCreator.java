/*
 * By Pavel Kisliuk, 10.05.2019
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

package xxx.necklaceservice.creator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxx.necklaceservice.exception.CustomException;
import xxx.necklaceservice.model.IProduct;
import xxx.necklaceservice.model.Necklace;
import xxx.necklaceservice.validator.NecklaceChecker;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Creator of {@code Necklace} implementation of the {@code IFactory} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see IFactory
 * @see StoneCreator
 * @see GemstoneCreator
 * @see CanvasCreator
 * @see NecklaceElementCreator
 * @see IProduct
 * @see Necklace
 * @since 12.0
 */
public class NecklaceCreator implements IFactory {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Create {@code IProduct} instance of {@code Necklace} and return it
	 * <p>
	 *
	 * @param elementsString {@code String} representation of {@code IProduct}
	 * @return instance of {@code IProduct}
	 * @throws CustomException if {@param elementsString} is incorrect
	 */
	@Override
	public Necklace create(String[] elementsString) throws CustomException {
		if (!(new NecklaceChecker().isValid(elementsString))) {
			LOGGER.log(Level.ERROR, ("Incorrect elementsString ->" + Arrays.toString(elementsString)));
			return LOGGER.traceExit(new Necklace());
		}

		Necklace necklace = new Necklace();
		necklace.setNecklaceId(elementsString[NecklaceChecker.ID_PLACE].trim());
		for (String necklaceElement :
				elementsString[NecklaceChecker.NECLACE_ELEMENTS_LIST_PLACE].trim().split("~")) {
			necklace.getNecklaceElementsList().add(
					new NecklaceElementCreator().create(necklaceElement.split("#")));
		}
		necklace.setCost(BigDecimal.valueOf(
				Double.valueOf(elementsString[NecklaceChecker.COST_PLACE])));

		return LOGGER.traceExit(necklace);
	}
}