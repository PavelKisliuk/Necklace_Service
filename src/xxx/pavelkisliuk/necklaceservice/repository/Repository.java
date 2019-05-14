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

package xxx.pavelkisliuk.necklaceservice.repository;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxx.pavelkisliuk.necklaceservice.comparator.IComp;
import xxx.pavelkisliuk.necklaceservice.model.Necklace;
import xxx.pavelkisliuk.necklaceservice.specification.ISpec;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Repository of {@code List} of {@code Necklace}.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see Necklace
 * @see ISpec
 * @see IComp
 * @since 12.0
 */
public class Repository {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Instance of data of repository
	 */
	private List<Necklace> necklaceList;

	/**
	 * Default constructor
	 */
	public Repository() {
		necklaceList = new ArrayList<>();
	}

	/**
	 * Setter
	 * <p>
	 *
	 * @param necklaceList assigned to {@code neclaceList}
	 */
	public void setNecklaceList(List<Necklace> necklaceList) {
		this.necklaceList = necklaceList;
	}

	/**
	 * @return size of repository
	 */
	public int size() {
		return LOGGER.traceExit(necklaceList.size());
	}

	/**
	 * Add {@code Necklace} instance to repository and return {@code true}, else {@code false}
	 * <p>
	 *
	 * @param necklace is {@code Necklace} instance for adding
	 * @return {@code true} if element added successful, else {@code false}
	 */
	public boolean add(Necklace necklace) {
		if (necklace == null) {
			LOGGER.log(Level.WARN, "Adding null to necklaceList");
		}
		return LOGGER.traceExit(necklaceList.add(necklace));
	}

	/**
	 * Delete special element from repository
	 * <p>
	 *
	 * @param necklace is element for removing
	 * @return {@code true} if element removed
	 */
	public boolean remove(Necklace necklace) {
		return LOGGER.traceExit(necklaceList.remove(necklace));
	}

	/**
	 * Delete special element's from repository
	 * <p>
	 *
	 * @param specification designate element's for removing
	 * @return {@code true} if element's removed
	 */
	public boolean removeIf(ISpec specification) {
		return LOGGER.traceExit(necklaceList.removeIf(specification));
	}

	/**
	 * Delete all element's from repository
	 */
	public void clear() {
		necklaceList.clear();
	}

	/**
	 * Return list of special element's designated by {@param specification}
	 * <p>
	 *
	 * @param specification parameter designate attributes of returned elements
	 * @return {@code List} of {@code Necklace} designated by {@param specification}
	 */
	public List<Necklace> query(ISpec specification) {
		return necklaceList.stream().filter(specification).collect(Collectors.toList());
	}

	/**
	 * Sort repository
	 * <p>
	 *
	 * @param comparator specify character of sorting
	 */
	public void sort(IComp comparator) {
		necklaceList.sort(comparator);
	}
}