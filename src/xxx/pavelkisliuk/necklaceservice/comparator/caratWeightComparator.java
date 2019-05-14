package xxx.pavelkisliuk.necklaceservice.comparator;

import xxx.pavelkisliuk.necklaceservice.logic.NecklaceProcessor;
import xxx.pavelkisliuk.necklaceservice.model.Necklace;

public class caratWeightComparator implements IComp {
	@Override
	public int compare(Necklace necklace1, Necklace necklace2) {
		return Double.compare(new NecklaceProcessor().computeCaratWeight(necklace1),
				new NecklaceProcessor().computeCaratWeight(necklace2));
	}
}
