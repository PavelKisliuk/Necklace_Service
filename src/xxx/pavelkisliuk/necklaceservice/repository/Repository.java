package xxx.pavelkisliuk.necklaceservice.repository;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxx.pavelkisliuk.necklaceservice.model.Necklace;
import xxx.pavelkisliuk.necklaceservice.specification.ISpec;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
	private static final Logger LOGGER = LogManager.getLogger();

	private List<Necklace> necklaceList;

	public Repository() {
		necklaceList = new ArrayList<>();
	}

	public void setNecklaceList(List<Necklace> necklaceList) {
		this.necklaceList = necklaceList;
	}

	public int size() {
		return LOGGER.traceExit(necklaceList.size());
	}

	public boolean add(Necklace necklace) {
		if(necklace == null) {
			LOGGER.log(Level.WARN, "Adding null to necklaceList");
		}
		return LOGGER.traceExit(necklaceList.add(necklace));
	}

	public boolean remove(Necklace necklace) {
		return LOGGER.traceExit(necklaceList.remove(necklace));
	}

	public void clear() {
		necklaceList.clear();
	}

	public List<Necklace> query(ISpec specification) {
		return necklaceList.stream().filter(specification).collect(Collectors.toList());
	}
}
