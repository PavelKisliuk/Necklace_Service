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
	private String canvasId;

	/**
	 * Weight of {@code Canvas} in grams
	 */
	private double weight;

	/**
	 * Cost of {@code Canvas} in dollars
	 */
	private double cost;

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
	 * @param canvas is object for copy
	 */
	public Canvas(Canvas canvas) {
		if (canvas != null) {
			this.canvasId = canvas.canvasId;
			this.weight = canvas.weight;
			this.cost = canvas.cost;
			this.metal = canvas.metal;
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
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost set {@code cost} of {@code Canvas}
	 */
	public void setCost(double cost) {
		this.cost = cost;
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

		if (Double.compare(canvas.weight, weight) != 0) return false;
		if (Double.compare(canvas.cost, cost) != 0) return false;
		if (!canvasId.equals(canvas.canvasId)) return false;
		return metal == canvas.metal;

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = canvasId.hashCode();
		temp = Double.doubleToLongBits(weight);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cost);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + metal.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Canvas{" +
				"canvasId=" + canvasId +
				", grWeight=" + weight +
				", costD=" + cost +
				", metal=" + metal +
				'}';
	}
}