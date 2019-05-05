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
	private String idStone;

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
		if (stone == null) {
			throw new NullPointerException("Null pointer in Stone copy constructor");
		}
		this.name = stone.name;
		this.idStone = stone.idStone;
		this.ctWeight = stone.ctWeight;
		this.costD = stone.costD;
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
	public String getIdStone() {
		return idStone;
	}

	/**
	 * @param id set {@code id} of {@code Stone}
	 */
	public void setIdStone(String id) {
		this.idStone = id;
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
		if(ctWeight <= 0) {
			throw new IllegalArgumentException("New ctWeight value <= 0");
		}
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
		if(costD < 0) {
			throw new IllegalArgumentException("New costD value < 0");
		}
		this.costD = costD;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Stone stone = (Stone) o;

		if (Double.compare(stone.ctWeight, ctWeight) != 0) return false;
		if (Double.compare(stone.costD, costD) != 0) return false;
		if (!name.equals(stone.name)) return false;
		return idStone.equals(stone.idStone);

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = name.hashCode();
		result = 31 * result + idStone.hashCode();
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
				", id=" + idStone +
				", ctWeight=" + ctWeight +
				", costD=" + costD +
				'}';
	}
}
