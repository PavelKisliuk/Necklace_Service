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

import xxx.necklaceservice.exception.CustomException;

/**
 * The {@code Canvas} class represent place where are situated {@code Stone}
 * <p>
 * This class contain fields describing place where are situated {@code Stone} and methods for
 * setting and getting values of it's fields.
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 12.0
 */
public class Canvas implements IProduct {
	/**
	 * Latin name of metal of {@code Canvas}
	 */
	public enum Metal {AURUM, ALBUM_AURUM, ARGENTUM, PLATINUM, AERIS}

	/**
	 * ID of {@code Canvas}
	 */
	private String idCanvas;

	/**
	 * Weight of {@code Canvas} in grams
	 */
	private double grWeight;

	/**
	 * Cost of {@code Canvas} in dollars
	 */
	private double costD;

	/**
	 * Material of {@code Canvas}
	 */
	private Metal metal;

	/**
	 * default constructor
	 */
	public Canvas() {
	}

	/**
	 * {@code Canvas} copy constructor
	 *
	 * @param canvas is object we copy
	 */
	public Canvas(Canvas canvas) throws CustomException {
		if (canvas == null) {
			throw new CustomException();
		}
		this.idCanvas = canvas.idCanvas;
		this.grWeight = canvas.grWeight;
		this.costD = canvas.costD;
		this.metal = canvas.metal;
	}

	/**
	 * @return {@code id} of {@code Canvas}
	 */
	public String getIdCanvas() {
		return idCanvas;
	}

	/**
	 * @param id set {@code id} of {@code Canvas}
	 */
	public void setIdCanvas(String id) {
		this.idCanvas = id;
	}

	/**
	 * @return {@code grWeight} of {@code Canvas}
	 */
	public double getGrWeight() {
		return grWeight;
	}

	/**
	 * @param grWeight set {@code grWeight} of {@code Canvas}
	 */
	public void setGrWeight(double grWeight) {
		this.grWeight = grWeight;
	}

	/**
	 * @return {@code costD} of {@code Canvas}
	 */
	public double getCostD() {
		return costD;
	}

	/**
	 * @param costD set {@code costD} of {@code Canvas}
	 */
	public void setCostD(double costD) {
		this.costD = costD;
	}

	/**
	 * @return {@code metal} of {@code Canvas}
	 */
	public Metal getMetal() {
		return metal;
	}

	/**
	 * @param metal set {@code metal} of {@code Canvas}
	 */
	public void setMetal(Metal metal) {
		this.metal = metal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Canvas canvas = (Canvas) o;

		if (Double.compare(canvas.grWeight, grWeight) != 0) return false;
		if (Double.compare(canvas.costD, costD) != 0) return false;
		if (!idCanvas.equals(canvas.idCanvas)) return false;
		return metal == canvas.metal;

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = idCanvas.hashCode();
		temp = Double.doubleToLongBits(grWeight);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(costD);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + metal.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Canvas{" +
				"id=" + idCanvas +
				", grWeight=" + grWeight +
				", costD=" + costD +
				", metal=" + metal +
				'}';
	}
}