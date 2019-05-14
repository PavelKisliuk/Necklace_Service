package xxx.pavelkisliuk.necklaceservice.specification;

import xxx.pavelkisliuk.necklaceservice.model.Gemstone;
import xxx.pavelkisliuk.necklaceservice.model.Necklace;
import xxx.pavelkisliuk.necklaceservice.model.NecklaceElement;
import xxx.pavelkisliuk.necklaceservice.model.Stone;

import java.util.ArrayList;
import java.util.List;

public class StoneNameSpec implements ISpec{
	private String stoneName;

	public StoneNameSpec(String stoneName) {
		this.stoneName = stoneName;
	}


	@Override
	public boolean test(Necklace necklace) {
		List<Stone> stoneList = new ArrayList<>();

		for (NecklaceElement necklaceElement : necklace.getNecklaceElementsList()) {
			stoneList.addAll(necklaceElement.getStonesGroup());
		}

		int i = 0;
		while (i < stoneList.size()) {
			if (stoneList.get(i).getName().equals(stoneName)) {
				return true;
			}
			i++;
		}
		return false;
	}
}
