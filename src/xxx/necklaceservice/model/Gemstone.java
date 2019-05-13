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
	public enum CuriosityLevel {VERY_RARE, RARE, MEDIUM, FREQUENT, VERY_FREQUENT}

	/**
	 * Level of hardness (strength to defeat) of {@code Gemstone}
	 */
	public enum HardnessLevel {HARD, SPARSE, SOFT}

	/**
	 * Curiosity of {@code Gemstone}
	 */
	private CuriosityLevel curiosityLevel;

	/**
	 * Hardness of {@code Gemstone}
	 */
	private HardnessLevel hardnessLevel;

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
			this.curiosityLevel = gemstone.curiosityLevel;
			this.hardnessLevel = gemstone.hardnessLevel;
			this.opacity = gemstone.opacity;
		}
	}

	/**
	 * @return {@code curiosityLevel} of {@code Gemstone}
	 */
	public CuriosityLevel getCuriosityLevel() {
		return curiosityLevel;
	}

	/**
	 * @param curiosityLevel set {@code curiosityLevel} of {@code Gemstone}
	 */
	public void setCuriosityLevel(CuriosityLevel curiosityLevel) {
		this.curiosityLevel = curiosityLevel;
	}

	/**
	 * @return {@code hardnessLevel} of {@code Gemstone}
	 */
	public HardnessLevel getHardnessLevel() {
		return hardnessLevel;
	}

	/**
	 * @param hardnessLevel set {@code hardnessLevel} of {@code Gemstone}
	 */
	public void setHardnessLevel(HardnessLevel hardnessLevel) {
		this.hardnessLevel = hardnessLevel;
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
		if (curiosityLevel != gemstone.curiosityLevel) return false;
		return hardnessLevel == gemstone.hardnessLevel;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		long temp;
		result = 31 * result + curiosityLevel.hashCode();
		result = 31 * result + hardnessLevel.hashCode();
		temp = Double.doubleToLongBits(opacity);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return super.toString() + "\nGemstone{" +
				"curiosityLevel=" + curiosityLevel +
				", hardnessLevel=" + hardnessLevel +
				", opacity=" + opacity +
				'}';
	}
}