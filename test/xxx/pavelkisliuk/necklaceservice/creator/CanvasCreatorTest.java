package xxx.pavelkisliuk.necklaceservice.creator;

import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.model.Canvas;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class CanvasCreatorTest {

	@Test
	public void testCreate() {
		Canvas canvas = new Canvas();
		canvas.setCanvasId("canvas00001");
		canvas.setWeight(150);
		canvas.setCost(BigDecimal.valueOf(200.0));
		canvas.setMetal(Canvas.Metal.ALBUM_AURUM);
		assertEquals(canvas, new CanvasCreator().create("canvas00001-150-200-ALBUM_AURUM".split("-")));
	}
}