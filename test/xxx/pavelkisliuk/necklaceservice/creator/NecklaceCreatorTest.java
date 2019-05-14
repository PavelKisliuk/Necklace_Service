package xxx.pavelkisliuk.necklaceservice.creator;

import org.testng.annotations.Test;
import xxx.pavelkisliuk.necklaceservice.model.Canvas;
import xxx.pavelkisliuk.necklaceservice.model.Gemstone;
import xxx.pavelkisliuk.necklaceservice.model.Necklace;
import xxx.pavelkisliuk.necklaceservice.model.NecklaceElement;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class NecklaceCreatorTest {

	@Test
	public void testCreate() {
		Necklace expected = new Necklace();
		NecklaceElement necklaceElement = new NecklaceElement();
		Canvas canvas = new Canvas();
		canvas.setCanvasId("canvas00001");
		canvas.setWeight(150);
		canvas.setCost(BigDecimal.valueOf(200.0));
		canvas.setMetalType(Canvas.MetalType.ALBUM_AURUM);
		Gemstone stone = new Gemstone();
		stone.setName("Emerald");
		stone.setStoneId("Emerald00001");
		stone.setWeight(100);
		stone.setCost(BigDecimal.valueOf(500.0));
		stone.setCuriosityLevelType(Gemstone.CuriosityLevelType.MEDIUM);
		stone.setHardnessLevelType(Gemstone.HardnessLevelType.HARD);
		stone.setOpacity(0.6);
		necklaceElement.setCanvas(canvas);
		necklaceElement.getStonesGroup().add(stone);
		expected.setNecklaceId("necklace00001");
		expected.getNecklaceElementsList().add(necklaceElement);
		expected.setCost(BigDecimal.valueOf(3080.0));

		assertEquals(new NecklaceCreator().create(
				"necklace00001&canvas00001-150-200-ALBUM_AURUM#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6&3080".
						split("&")), expected);
	}
}