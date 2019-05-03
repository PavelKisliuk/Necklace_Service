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

package com.github.pavelkisliuk.model.data;

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
	private int id;

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
			this.id = necklace.id;
			this.necklaceElementsList = new ArrayList<>(necklace.necklaceElementsList);
			this.costD = necklace.costD;
		}
	}

	/**
	 * @return {@code id} of {@code Necklace}
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id set {@code id} of {@code Necklace}
	 */
	public void setId(int id) {
		this.id = id;
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
		this.costD = costD;
	}
}
