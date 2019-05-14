package xxx.pavelkisliuk.necklaceservice.comparator;

import xxx.pavelkisliuk.necklaceservice.logic.NecklaceProcessor;
import xxx.pavelkisliuk.necklaceservice.model.Necklace;

public class pureCostComparator implements IComp {
	@Override
	public int compare(Necklace necklace1, Necklace necklace2) {
		return new NecklaceProcessor().computePureCost(necklace1).
				compareTo(new NecklaceProcessor().computePureCost(necklace2));
	}
}
