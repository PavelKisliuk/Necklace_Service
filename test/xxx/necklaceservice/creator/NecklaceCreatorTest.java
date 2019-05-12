package xxx.necklaceservice.creator;

import org.testng.annotations.Test;
import xxx.necklaceservice.exception.CustomException;
import xxx.necklaceservice.model.Canvas;
import xxx.necklaceservice.model.Gemstone;
import xxx.necklaceservice.model.Necklace;
import xxx.necklaceservice.model.NecklaceElement;

import static org.testng.Assert.*;

public class NecklaceCreatorTest {

	@Test
	public void testCreate() throws CustomException {
		Necklace necklace = new Necklace();
		NecklaceElement necklaceElement = new NecklaceElement();
		Canvas canvas = new Canvas();
		canvas.setIdCanvas("canvas00001");
		canvas.setGrWeight(150);
		canvas.setCostD(200);
		canvas.setMetal(Canvas.Metal.ALBUM_AURUM);
		Gemstone stone = new Gemstone();
		stone.setName("Emerald");
		stone.setIdStone("Emerald00001");
		stone.setCtWeight(100);
		stone.setCostD(500);
		stone.setCuriosityLevel(Gemstone.CuriosityLevel.MEDIUM);
		stone.setHardnessLevel(Gemstone.HardnessLevel.HARD);
		stone.setOpacity(0.6);
		necklaceElement.setCanvas(canvas);
		necklaceElement.getStonesGroup().add(stone);
		necklace.setIdNecklace("necklace00001");
		necklace.getNecklaceElementsList().add(necklaceElement);
		necklace.setCostD(3080);

		assertEquals(necklace, new NecklaceCreator().create(
			"necklace00001&canvas00001-150-200-ALBUM_AURUM#Emerald-Emerald00001-100-500-MEDIUM-HARD-0.6&3080".split("&")
		));
	}
}