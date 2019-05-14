/*
 * By Pavel Kisliuk, 14.05.2019
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

package xxx.pavelkisliuk.necklaceservice.logic;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxx.pavelkisliuk.necklaceservice.model.Gemstone;
import xxx.pavelkisliuk.necklaceservice.model.Necklace;
import xxx.pavelkisliuk.necklaceservice.model.NecklaceElement;
import xxx.pavelkisliuk.necklaceservice.model.Stone;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Class provides special methods for {@code Necklace} processing
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see Necklace
 * @since 12.0
 */
public class NecklaceProcessor {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Quantity carat in one gram
	 */
	public static final double CARAT_IN_GRAM = 5;

	/**
	 * Return weight of {@code Necklace} in carat
	 * <p>
	 *
	 * @param necklace for computing weight
	 * @return weight of {@code Necklace} in carat
	 */
	public double computeCaratWeight(Necklace necklace) {
		if (necklace == null) {
			LOGGER.log(Level.ERROR, "necklace is null");
			return LOGGER.traceExit(0);
		}

		double weight = 0;
		for (NecklaceElement necklaceElement : necklace.getNecklaceElementsList()) {
			weight += necklaceElement.getCanvas().getWeight() * CARAT_IN_GRAM;
			weight += necklaceElement.getStonesGroup().stream().mapToDouble(Stone::getWeight).sum();
		}
		return LOGGER.traceExit(weight);
	}

	/**
	 * Return cost of all {@code Stone} and {@code Canvas} of {@code Necklace}
	 * <p>
	 *
	 * @param necklace for processing
	 * @return cost of all {@code Stone} and {@code Canvas} of {@code Necklace} without work cost
	 */
	public BigDecimal computePureCost(Necklace necklace) {
		if (necklace == null) {
			LOGGER.log(Level.ERROR, "necklace is null");
			return new BigDecimal(0);
		}

		BigDecimal pureCost = new BigDecimal(0);
		for (NecklaceElement necklaceElement : necklace.getNecklaceElementsList()) {
			pureCost = pureCost.add(necklaceElement.getCanvas().getCost());
			for (Stone stone : necklaceElement.getStonesGroup()) {
				pureCost = pureCost.add(stone.getCost());
			}
		}
		return LOGGER.traceExit(pureCost);
	}

	/**
	 * Return {@code List} of {@code Gemstone} by special {@code opacity}
	 * <p>
	 *
	 * @param necklace for processing
	 * @param min      boundary of opacity
	 * @param max      boundary of opacity
	 * @return {@code List} of {@code Gemstone} by special {@code opacity}
	 */
	public List<Gemstone> opacityFind(Necklace necklace, double min, double max) {
		if ((necklace == null) || (min < Gemstone.MIN_OPACITY) || (max > Gemstone.MAX_OPACITY)) {
			LOGGER.log(Level.ERROR, "Incorrect parameters.");
			return LOGGER.traceExit(new ArrayList<>());
		}

		List<Gemstone> tempList = new ArrayList<>();
		for (NecklaceElement necklaceElement : necklace.getNecklaceElementsList()) {
			for (Stone stone : necklaceElement.getStonesGroup()) {
				if (stone.getClass() == Gemstone.class &&
						((Gemstone) stone).getOpacity() >= min &&
						((Gemstone) stone).getOpacity() <= max) {
					tempList.add((Gemstone) stone);
				}
			}
		}
		return LOGGER.traceExit(tempList);
	}
}