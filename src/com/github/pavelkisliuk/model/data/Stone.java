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

/**
 * The {@code Stone} class represent abstract stone
 * <p>
 * This class contain fields describing stone and methods for
 * setting and getting values of it's fields.
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 12.0
 */
public class Stone {
	/**
	 * Name of {@code Stone}
	 */
	private String name;

	/**
	 * ID of {@code Stone}
	 */
	private int id;

	/**
	 * Weight of {@code Stone} in carats
	 */
	private double ctWeight;

	/**
	 * Cost of {@code Stone} in dollars
	 */
	private double costD;

	/**
	 * default constructor
	 */
	public Stone() {
	}

	/**
	 * {@code Stone} copy constructor
	 *
	 * @param stone is object we copy
	 */
	public Stone(Stone stone) {
		if(stone != null) {
			this.name = stone.name;
			this.id = stone.id;
			this.ctWeight = stone.ctWeight;
			this.costD = stone.costD;
		}
	}

	/**
	 * @return {@code name} of {@code Stone}
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name set {@code name} of {@code Stone}
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return {@code id} of {@code Stone}
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id set {@code id} of {@code Stone}
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return {@code ctWeight} of {@code Stone}
	 */
	public double getCtWeight() {
		return ctWeight;
	}

	/**
	 * @param ctWeight set {@code ctWeight} of {@code Stone}
	 */
	public void setCtWeight(double ctWeight) {
		this.ctWeight = ctWeight;
	}

	/**
	 * @return {@code costD} of {@code Stone}
	 */
	public double getCostD() {
		return costD;
	}

	/**
	 * @param costD set {@code costD} of {@code Stone}
	 */
	public void setCostD(double costD) {
		this.costD = costD;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Stone stone = (Stone) o;

		if (id != stone.id) return false;
		if (Double.compare(stone.ctWeight, ctWeight) != 0) return false;
		if (Double.compare(stone.costD, costD) != 0) return false;
		return name.equals(stone.name);
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = name.hashCode();
		result = 31 * result + id;
		temp = Double.doubleToLongBits(ctWeight);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(costD);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Stone{" +
				"name='" + name + '\'' +
				", id=" + id +
				", ctWeight=" + ctWeight +
				", costD=" + costD +
				'}';
	}
}
