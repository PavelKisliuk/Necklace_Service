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
 * The {@code Stone} class represent abstract stone
 * <p>
 * This class contain fields describing stone and methods for
 * setting and getting values of it's fields.
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 12.0
 */
public class Stone implements IProduct {
	/**
	 * Name of {@code Stone}
	 */
	private String name;

	/**
	 * ID of {@code Stone}
	 */
	private String stoneId;

	/**
	 * Weight of {@code Stone} in carats
	 */
	private double weight;

	/**
	 * Cost of {@code Stone} in dollars
	 */
	private double cost;

	/**
	 * default constructor
	 */
	public Stone() {
	}

	/**
	 * {@code Stone} copy constructor
	 *
	 * @param stone is object for copy
	 */
	public Stone(Stone stone) {
		if (stone != null) {
			this.name = stone.name;
			this.stoneId = stone.stoneId;
			this.weight = stone.weight;
			this.cost = stone.cost;
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
	 * @return {@code stoneId} of {@code Stone}
	 */
	public String getStoneId() {
		return stoneId;
	}

	/**
	 * @param id set {@code stoneId} of {@code Stone}
	 */
	public void setStoneId(String id) {
		this.stoneId = id;
	}

	/**
	 * @return {@code weight} of {@code Stone}
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight set {@code weight} of {@code Stone}
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return {@code cost} of {@code Stone}
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost set {@code cost} of {@code Stone}
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Stone stone = (Stone) o;

		if (Double.compare(stone.weight, weight) != 0) return false;
		if (Double.compare(stone.cost, cost) != 0) return false;
		if (!name.equals(stone.name)) return false;
		return stoneId.equals(stone.stoneId);

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = name.hashCode();
		result = 31 * result + stoneId.hashCode();
		temp = Double.doubleToLongBits(weight);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cost);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Stone{" +
				"name='" + name + '\'' +
				", stoneId=" + stoneId +
				", weight=" + weight +
				", cost=" + cost +
				'}';
	}
}