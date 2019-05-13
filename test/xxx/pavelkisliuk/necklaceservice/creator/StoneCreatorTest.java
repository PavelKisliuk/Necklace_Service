package xxx.pavelkisliuk.necklaceservice.creator;

import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.model.Stone;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class StoneCreatorTest {

	@Test
	public void testCreate() {
		Stone stone = new Stone();
		stone.setName("Emerald");
		stone.setStoneId("Emerald00001");
		stone.setWeight(100);
		stone.setCost(BigDecimal.valueOf(500.0));
		assertEquals(stone, new StoneCreator().create("Emerald-Emerald00001-100-500.0".split("-")));
	}
}