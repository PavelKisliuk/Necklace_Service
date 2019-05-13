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

package xxx.pavelkisliuk.necklaceservice.model;

import java.math.BigDecimal;

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
	 * Latin name of metalType of {@code Canvas}
	 */
	public enum MetalType {AURUM, ALBUM_AURUM, ARGENTUM, PLATINUM, AERIS}

	/**
	 * ID of {@code Canvas}
	 */
	private String canvasId;

	/**
	 * Weight of {@code Canvas} in grams
	 */
	private double weight;

	/**
	 * Cost of {@code Canvas} in dollars
	 */
	private BigDecimal cost;

	/**
	 * Material of {@code Canvas}
	 */
	private MetalType metalType;

	/**
	 * default constructor
	 */
	public Canvas() {
	}

	/**
	 * {@code Canvas} copy constructor
	 *
	 * @param canvas is object for copy
	 */
	public Canvas(Canvas canvas) {
		if (canvas != null) {
			this.canvasId = canvas.canvasId;
			this.weight = canvas.weight;
			this.cost = canvas.cost;
			this.metalType = canvas.metalType;
		}
	}

	/**
	 * @return {@code canvasId} of {@code Canvas}
	 */
	public String getCanvasId() {
		return canvasId;
	}

	/**
	 * @param id set {@code canvasId} of {@code Canvas}
	 */
	public void setCanvasId(String id) {
		this.canvasId = id;
	}

	/**
	 * @return {@code weight} of {@code Canvas}
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight set {@code weight} of {@code Canvas}
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return {@code cost} of {@code Canvas}
	 */
	public BigDecimal getCost() {
		return cost;
	}

	/**
	 * @param cost set {@code cost} of {@code Canvas}
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	/**
	 * @return {@code metalType} of {@code Canvas}
	 */
	public MetalType getMetalType() {
		return metalType;
	}

	/**
	 * @param metalType set {@code metalType} of {@code Canvas}
	 */
	public void setMetalType(MetalType metalType) {
		this.metalType = metalType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Canvas canvas = (Canvas) o;

		if (Double.compare(canvas.weight, weight) != 0) return false;
		if (!canvasId.equals(canvas.canvasId)) return false;
		if (!cost.equals(canvas.cost)) return false;
		return metalType == canvas.metalType;

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = canvasId.hashCode();
		temp = Double.doubleToLongBits(weight);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + cost.hashCode();
		result = 31 * result + metalType.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Canvas{" +
				"canvasId=" + canvasId +
				", grWeight=" + weight +
				", costD=" + cost +
				", metalType=" + metalType +
				'}';
	}
}