package com.devesh.liveeasy.service;

import java.util.List;
import java.util.Optional;

import com.devesh.liveeasy.entity.Load;

public interface LoadService {

	List<Load> getAllLoads();

	Load saveLoad(Load load);

	List<Load> getLoads(String shipperId);

	Optional<Load> getLoadById(Long loadId);

	void deleteLoadById(Long loadId);

	Load updateLoad(Long loadId, Load load);
	
//	List<Load> getLoadsByShipperId(UUID shipperId);

}
