package xxx.necklaceservice.creator;

import org.testng.annotations.Test;
import xxx.necklaceservice.exception.CustomException;
import xxx.necklaceservice.model.Stone;

import static org.testng.Assert.*;

public class StoneCreatorTest {

	@Test
	public void testCreate() throws CustomException {
		Stone stone = new Stone();
		stone.setName("Emerald");
		stone.setIdStone("Emerald00001");
		stone.setCtWeight(100);
		stone.setCostD(500);
		assertEquals(stone, new StoneCreator().create("Emerald-Emerald00001-100-500".split("-")));
	}
}