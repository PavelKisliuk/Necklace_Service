package xxx.necklaceservice.creator;

import org.testng.annotations.Test;
import xxx.necklaceservice.exception.CustomException;
import xxx.necklaceservice.model.Gemstone;
import xxx.necklaceservice.model.Stone;

import java.math.BigDecimal;

import static org.testng.Assert.*;

public class GemstoneCreatorTest {

	@Test
	public void testCreate() throws CustomException {
		Gemstone stone = new Gemstone();
		stone.setName("Emerald");
		stone.setStoneId("Emerald00001");
		stone.setWeight(100);
		stone.setCost(BigDecimal.valueOf(500.0));
		stone.setCuriosityLevel(Gemstone.CuriosityLevel.MEDIUM);
		stone.setHardnessLevel(Gemstone.HardnessLevel.HARD);
		stone.setOpacity(0.6);
		assertEquals(stone, new GemstoneCreator().create(
				"Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6".split("-")));
	}
}