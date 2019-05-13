package xxx.necklaceservice.creator;

import org.testng.annotations.Test;
import xxx.necklaceservice.exception.CustomException;
import xxx.necklaceservice.model.Canvas;
import xxx.necklaceservice.model.Gemstone;
import xxx.necklaceservice.model.Necklace;
import xxx.necklaceservice.model.NecklaceElement;

import java.math.BigDecimal;

import static org.testng.Assert.*;

public class NecklaceCreatorTest {

	@Test
	public void testCreate() throws CustomException {
		Necklace necklace = new Necklace();
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
		necklace.setNecklaceId("necklace00001");
		necklace.getNecklaceElementsList().add(necklaceElement);
		necklace.setCost(BigDecimal.valueOf(3080.0));

		assertEquals(necklace, new NecklaceCreator().create(
			"necklace00001&canvas00001-150-200-ALBUM_AURUM#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6&3080".
					split("&")));
	}
}