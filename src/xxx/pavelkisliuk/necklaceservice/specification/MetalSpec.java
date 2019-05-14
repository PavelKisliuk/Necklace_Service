package xxx.pavelkisliuk.necklaceservice.specification;

import xxx.pavelkisliuk.necklaceservice.model.Canvas;
import xxx.pavelkisliuk.necklaceservice.model.Necklace;
import xxx.pavelkisliuk.necklaceservice.model.NecklaceElement;

import java.util.ArrayList;
import java.util.List;

public class MetalSpec implements ISpec {

	private Canvas.MetalType metalType;

	public MetalSpec(Canvas.MetalType metalType) {
		this.metalType = metalType;
	}

	@Override
	public boolean test(Necklace necklace) {
		List<Canvas> canvasList = new ArrayList<>();
		for(NecklaceElement necklaceElement : necklace.getNecklaceElementsList()) {
			canvasList.add(necklaceElement.getCanvas());
		}
		int i = 0;
		while(i < canvasList.size()) {
			if(canvasList.get(i).getMetalType() == metalType) {
				return true;
			}
			i++;
		}
		return false;
	}
}
