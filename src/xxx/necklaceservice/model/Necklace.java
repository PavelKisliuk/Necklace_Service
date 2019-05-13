/*
 * By Pavel Kisliuk, 03.05.2019
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

package xxx.necklaceservice.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Necklace} class represent necklace as group of {@code NecklaceElement}
 * <p>
 * This class contain field of {@code NecklaceElement} and methods for
 * setting and getting values of it's field.
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 12.0
 */
public class Necklace implements IProduct {
	/**
	 * ID of {@code Necklace}
	 */
	private String necklaceId;

	/**
	 * List of {@code NecklaceElement} class-wrapper for storing particular elements of
	 * {@code Necklace}
	 */
	private List<NecklaceElement> necklaceElementsList;

	/**
	 * Cost of {@code Necklace} in dollars
	 */
	private double cost;

	/**
	 * default constructor
	 */
	public Necklace() {
		necklaceElementsList = new ArrayList<>();
	}

	/**
	 * {@code Necklace} copy constructor
	 *
	 * @param necklace is object for copy
	 */
	public Necklace(Necklace necklace) {
		if (necklace != null) {
			this.necklaceId = necklace.necklaceId;
			this.necklaceElementsList = new ArrayList<>(necklace.necklaceElementsList);
			this.cost = necklace.cost;
		}
	}

	/**
	 * @return {@code necklaceId} of {@code Necklace}
	 */
	public String getNecklaceId() {
		return necklaceId;
	}

	/**
	 * @param id set {@code necklaceId} of {@code Necklace}
	 */
	public void setNecklaceId(String id) {
		this.necklaceId = id;
	}

	/**
	 * @return {@code necklaceElementsList} of {@code Necklace}
	 */
	public List<NecklaceElement> getNecklaceElementsList() {
		return necklaceElementsList;
	}

	/**
	 * @param necklaceElementsList set {@code id} of {@code Necklace}
	 */
	public void setNecklaceElementsList(List<NecklaceElement> necklaceElementsList) {
		this.necklaceElementsList = necklaceElementsList;
	}

	/**
	 * @return {@code cost} of {@code Necklace}
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost set {@code id} of {@code Necklace}
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Necklace necklace = (Necklace) o;

		if (Double.compare(necklace.cost, cost) != 0) return false;
		if (!necklaceId.equals(necklace.necklaceId)) return false;
		return necklaceElementsList.equals(necklace.necklaceElementsList);

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = necklaceId.hashCode();
		result = 31 * result + necklaceElementsList.hashCode();
		temp = Double.doubleToLongBits(cost);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Necklace{" +
				"necklaceId='" + necklaceId + '\'' +
				", necklaceElementsList=" + necklaceElementsList +
				", cost=" + cost +
				'}';
	}
}