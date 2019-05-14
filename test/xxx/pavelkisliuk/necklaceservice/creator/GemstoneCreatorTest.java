package xxx.pavelkisliuk.necklaceservice.creator;

import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.model.Gemstone;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class GemstoneCreatorTest {

	@Test
	public void testCreate() {
		Gemstone expected = new Gemstone();
		expected.setName("Emerald");
		expected.setStoneId("Emerald00001");
		expected.setWeight(100);
		expected.setCost(BigDecimal.valueOf(500.0));
		expected.setCuriosityLevelType(Gemstone.CuriosityLevelType.MEDIUM);
		expected.setHardnessLevelType(Gemstone.HardnessLevelType.HARD);
		expected.setOpacity(0.6);
		assertEquals(new GemstoneCreator().create("Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6".split("-")),
				expected);
	}
}