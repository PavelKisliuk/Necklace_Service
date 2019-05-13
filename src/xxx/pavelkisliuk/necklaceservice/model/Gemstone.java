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

/**
 * The {@code Gemstone} class extend's {@code Stone} class and represent
 * precious stone.
 * <p>
 * This class contain fields describing precious stone and methods for
 * setting and getting values of it's fields.
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 12.0
 */
public class Gemstone extends Stone {
	/**
	 * Level of opacity means that {@code Gemstone} ultimate transparent
	 */
	public static final double MIN_OPACITY = 0.0;

	/**
	 * Level of opacity means that {@code Gemstone} ultimate opaque
	 */
	public static final double MAX_OPACITY = 1.0;

	/**
	 * Level of curiosity (rarity in nature) of {@code Gemstone}
	 */
	public enum CuriosityLevelType {VERY_RARE, RARE, MEDIUM, FREQUENT, VERY_FREQUENT}

	/**
	 * Level of hardness (strength to defeat) of {@code Gemstone}
	 */
	public enum HardnessLevelType {HARD, SPARSE, SOFT}

	/**
	 * Curiosity of {@code Gemstone}
	 */
	private CuriosityLevelType curiosityLevelType;

	/**
	 * Hardness of {@code Gemstone}
	 */
	private HardnessLevelType hardnessLevelType;

	/**
	 * Opacity of {@code Gemstone}
	 * 0 - opaque, 1 - transparent
	 */
	private double opacity;

	/**
	 * default constructor
	 */
	public Gemstone() {
		super();
	}

	/**
	 * {@code Gemstone} copy constructor
	 *
	 * @param gemstone is object for copy
	 */
	public Gemstone(Gemstone gemstone) {
		super(gemstone);
		if (gemstone != null) {
			this.curiosityLevelType = gemstone.curiosityLevelType;
			this.hardnessLevelType = gemstone.hardnessLevelType;
			this.opacity = gemstone.opacity;
		}
	}

	/**
	 * @return {@code curiosityLevelType} of {@code Gemstone}
	 */
	public CuriosityLevelType getCuriosityLevelType() {
		return curiosityLevelType;
	}

	/**
	 * @param curiosityLevelType set {@code curiosityLevelType} of {@code Gemstone}
	 */
	public void setCuriosityLevelType(CuriosityLevelType curiosityLevelType) {
		this.curiosityLevelType = curiosityLevelType;
	}

	/**
	 * @return {@code hardnessLevelType} of {@code Gemstone}
	 */
	public HardnessLevelType getHardnessLevelType() {
		return hardnessLevelType;
	}

	/**
	 * @param hardnessLevelType set {@code hardnessLevelType} of {@code Gemstone}
	 */
	public void setHardnessLevelType(HardnessLevelType hardnessLevelType) {
		this.hardnessLevelType = hardnessLevelType;
	}

	/**
	 * @return {@code opacity} of {@code Gemstone}
	 */
	public double getOpacity() {
		return opacity;
	}

	/**
	 * @param opacity set {@code opacity} of {@code Gemstone}
	 */
	public void setOpacity(double opacity) {
		this.opacity = opacity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Gemstone gemstone = (Gemstone) o;

		if (Double.compare(gemstone.opacity, opacity) != 0) return false;
		if (curiosityLevelType != gemstone.curiosityLevelType) return false;
		return hardnessLevelType == gemstone.hardnessLevelType;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		long temp;
		result = 31 * result + curiosityLevelType.hashCode();
		result = 31 * result + hardnessLevelType.hashCode();
		temp = Double.doubleToLongBits(opacity);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return super.toString() + "\nGemstone{" +
				"curiosityLevelType=" + curiosityLevelType +
				", hardnessLevelType=" + hardnessLevelType +
				", opacity=" + opacity +
				'}';
	}
}