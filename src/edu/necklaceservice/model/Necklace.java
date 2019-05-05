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

package edu.necklaceservice.model;

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
public class Necklace {
	/**
	 * ID of {@code Necklace}
	 */
	private String idNecklace;

	/**
	 * List of {@code NecklaceElement} class-wrapper for storing particular elements of
	 * {@code Necklace}
	 */
	private List<NecklaceElement> necklaceElementsList;

	/**
	 * Cost of {@code Necklace} in dollars
	 */
	private double costD;

	/**
	 * default constructor
	 */
	public Necklace() {
		necklaceElementsList = new ArrayList<>();
	}

	/**
	 * {@code Necklace} copy constructor
	 *
	 * @param necklace is object we copy
	 */
	public Necklace(Necklace necklace) {
		if(necklace != null) {
			this.idNecklace = necklace.idNecklace;
			this.necklaceElementsList = new ArrayList<>(necklace.necklaceElementsList);
			this.costD = necklace.costD;
		}
	}

	/**
	 * @return {@code id} of {@code Necklace}
	 */
	public String getIdNecklace() {
		return idNecklace;
	}

	/**
	 * @param id set {@code id} of {@code Necklace}
	 */
	public void setIdNecklace(String id) {
		this.idNecklace = id;
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
	 * @return {@code costD} of {@code Necklace}
	 */
	public double getCostD() {
		return costD;
	}

	/**
	 * @param costD set {@code id} of {@code Necklace}
	 */
	public void setCostD(double costD) {
		if(costD < 0) {
			throw new IllegalArgumentException("New costD value < 0");
		}
		this.costD = costD;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Necklace necklace = (Necklace) o;

		if (Double.compare(necklace.costD, costD) != 0) return false;
		if (!idNecklace.equals(necklace.idNecklace)) return false;
		return necklaceElementsList.equals(necklace.necklaceElementsList);

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = idNecklace.hashCode();
		result = 31 * result + necklaceElementsList.hashCode();
		temp = Double.doubleToLongBits(costD);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Necklace{" +
				"idNecklace='" + idNecklace + '\'' +
				", necklaceElementsList=" + necklaceElementsList +
				", costD=" + costD +
				'}';
	}
}
