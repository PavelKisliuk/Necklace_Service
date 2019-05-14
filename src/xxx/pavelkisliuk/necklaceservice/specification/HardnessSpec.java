package xxx.pavelkisliuk.necklaceservice.specification;

import xxx.pavelkisliuk.necklaceservice.model.Gemstone;
import xxx.pavelkisliuk.necklaceservice.model.Necklace;
import xxx.pavelkisliuk.necklaceservice.model.NecklaceElement;
import xxx.pavelkisliuk.necklaceservice.model.Stone;

import java.util.ArrayList;
import java.util.List;

public class HardnessSpec implements ISpec{
	private Gemstone.HardnessLevelType hardness;


	public HardnessSpec(Gemstone.HardnessLevelType hardness) {
		this.hardness = hardness;
	}


	@Override
	public boolean test(Necklace necklace) {
		List<Gemstone> gemstoneList = new ArrayList<>();
		for (NecklaceElement necklaceElement : necklace.getNecklaceElementsList()) {
			for (int i = 0; i < necklaceElement.getStonesGroup().size(); i++) {
				Stone stone = necklaceElement.getStonesGroup().get(i);
				if (stone.getClass() == Gemstone.class) {
					gemstoneList.add((Gemstone) stone);
				}
			}
		}

		int i = 0;
		while (i < gemstoneList.size()) {
			if (gemstoneList.get(i).getHardnessLevelType() == hardness) {
				return true;
			}
			i++;
		}
		return false;
	}
}
