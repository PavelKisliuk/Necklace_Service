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
 * The {@code NecklaceElement} class-wrapper for storing particular elements of
 * {@code Necklace}
 * <p>
 * This class contain fields describing special elements of necklace and methods for
 * setting and getting values of it's fields.
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 12.0
 */
public class NecklaceElement {
	/**
	 * The {@code Canvas} class represent place where are situated {@code Stone}
	 */
	private Canvas canvas;

	/**
	 * List of {@code Stone} the class represent abstract stone
	 */
	private List<Stone> stonesGroup;

	/**
	 * default constructor
	 */
	public NecklaceElement() {
		stonesGroup = new ArrayList<>();
	}

	/**
	 * {@code NecklaceElement} copy constructor
	 *
	 * @param necklaceElement is object we copy
	 */
	public NecklaceElement(NecklaceElement necklaceElement) {
		if (necklaceElement == null) {
			throw new NullPointerException("Null pointer in NecklaceElement copy constructor");
		}
		this.canvas = necklaceElement.canvas;
		this.stonesGroup = new ArrayList<>(necklaceElement.stonesGroup);
	}

	/**
	 * @return {@code canvas} of {@code NecklaceElement}
	 */
	public Canvas getCanvas() {
		return canvas;
	}

	/**
	 * @param canvas set {@code canvas} of {@code NecklaceElement}
	 */
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	/**
	 * @return {@code stonesGroup} of {@code NecklaceElement}
	 */
	public List<Stone> getStonesGroup() {
		return stonesGroup;
	}

	/**
	 * @param stonesGroup set {@code stonesGroup} of {@code NecklaceElement}
	 */
	public void setStonesGroup(List<Stone> stonesGroup) {
		this.stonesGroup = stonesGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		NecklaceElement that = (NecklaceElement) o;

		if (!canvas.equals(that.canvas)) return false;
		return stonesGroup.equals(that.stonesGroup);

	}

	@Override
	public int hashCode() {
		int result = canvas.hashCode();
		result = 31 * result + stonesGroup.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "NecklaceElement{" +
				"canvas=" + canvas +
				", stonesGroup=" + stonesGroup +
				'}';
	}
}
