package xxx.pavelkisliuk.necklaceservice.creator;

import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.creator.NecklaceElementCreator;
import xxx.pavelkisliuk.necklaceservice.exception.CustomException;
import xxx.pavelkisliuk.necklaceservice.model.Canvas;
import xxx.pavelkisliuk.necklaceservice.model.Gemstone;
import xxx.pavelkisliuk.necklaceservice.model.NecklaceElement;

import java.math.BigDecimal;

import static org.testng.Assert.*;

public class NecklaceElementCreatorTest {

	@Test
	public void testCreate() throws CustomException {
		NecklaceElement necklaceElement = new NecklaceElement();
		Canvas canvas = new Canvas();
		canvas.setCanvasId("canvas00001");
		canvas.setWeight(150);
		canvas.setCost(BigDecimal.valueOf(200.0));
		canvas.setMetal(Canvas.Metal.ALBUM_AURUM);
		Gemstone stone = new Gemstone();
		stone.setName("Emerald");
		stone.setStoneId("Emerald00001");
		stone.setWeight(100);
		stone.setCost(BigDecimal.valueOf(500.0));
		stone.setCuriosityLevel(Gemstone.CuriosityLevel.MEDIUM);
		stone.setHardnessLevel(Gemstone.HardnessLevel.HARD);
		stone.setOpacity(0.6);
		necklaceElement.setCanvas(canvas);
		necklaceElement.getStonesGroup().add(stone);
		assertEquals(necklaceElement, new NecklaceElementCreator().create(
				"canvas00001-150-200.0-ALBUM_AURUM#Emerald-Emerald00001-100-500.0-MEDIUM-HARD-0.6".split("#")));
	}
}