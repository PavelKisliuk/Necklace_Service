package xxx.pavelkisliuk.necklaceservice.creator;

import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.model.Gemstone;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class GemstoneCreatorTest {

	@Test
	public void testCreate() {
		Gemstone stone = new Gemstone();
		stone.setName("Emerald");
		stone.setStoneId("Emerald00001");
		stone.setWeight(100);
		stone.setCost(BigDecimal.valueOf(500.0));
		stone.setCuriosityLevelType(Gemstone.CuriosityLevelType.MEDIUM);
		stone.setHardnessLevelType(Gemstone.HardnessLevelType.HARD);
		stone.setOpacity(0.6);
		assertEquals(stone, new GemstoneCreator().create(
				"Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6".split("-")));
	}
}