package xxx.pavelkisliuk.necklaceservice.creator;

import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.model.Canvas;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class CanvasCreatorTest {

	@Test
	public void testCreate() {
		Canvas expected = new Canvas();
		expected.setCanvasId("canvas00001");
		expected.setWeight(150);
		expected.setCost(BigDecimal.valueOf(200.0));
		expected.setMetalType(Canvas.MetalType.ALBUM_AURUM);
		assertEquals(new CanvasCreator().create("canvas00001-150-200-ALBUM_AURUM".split("-")), expected);
	}
}