package xxx.necklaceservice.creator;

import org.testng.annotations.Test;
import xxx.necklaceservice.exception.CustomException;
import xxx.necklaceservice.model.Canvas;

import static org.testng.Assert.*;

public class CanvasCreatorTest {

	@Test
	public void testCreate() throws CustomException {
		Canvas canvas = new Canvas();
		canvas.setIdCanvas("canvas00001");
		canvas.setGrWeight(150);
		canvas.setCostD(200);
		canvas.setMetal(Canvas.Metal.ALBUM_AURUM);
		assertEquals(canvas, new CanvasCreator().create("canvas00001-150-200-ALBUM_AURUM".split("-")));
	}
}