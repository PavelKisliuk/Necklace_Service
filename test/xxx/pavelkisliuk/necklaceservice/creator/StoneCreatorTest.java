package xxx.pavelkisliuk.necklaceservice.creator;

import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.model.Stone;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class StoneCreatorTest {

	@Test
	public void testCreate() {
		Stone expected = new Stone();
		expected.setName("Emerald");
		expected.setStoneId("Emerald00001");
		expected.setWeight(100);
		expected.setCost(BigDecimal.valueOf(500.0));
		assertEquals(new StoneCreator().create("Emerald-Emerald00001-100-500.0".split("-")), expected);
	}
}