package com.devesh.liveeasy.serviceimpl;

import com.devesh.liveeasy.entity.Load;
import com.devesh.liveeasy.repo.LoadRepository;
import com.devesh.liveeasy.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoadServiceImpl implements LoadService {
    @Autowired
    private LoadRepository LoadRepository;

    public List<Load> getAllLoads() {
        return LoadRepository.findAll();
    }

    public Load saveLoad(Load load) {
    	if(load.getShipperId().equalsIgnoreCase("shipper:<UUID>")) {
    		
    	load.setShipperId("shipper:" + UUID.randomUUID().toString());
    	}else {
    		load.setShipperId(load.getShipperId());
    	}
    	return LoadRepository.save(load);
    }

	@Override
	public List<Load> getLoads(String shipperId) {
		return LoadRepository.getLoadsByShipperId(shipperId);
	}

	@Override
	public Optional<Load> getLoadById(Long loadId) {
		return LoadRepository.findById(loadId);
	}

	@Override
	public void deleteLoadById(Long loadId) {
		Optional<Load> Load = LoadRepository.findById(loadId);
		if(Load.isPresent()) {
		LoadRepository.deleteById(loadId);
		}else {
			throw new RuntimeException("Load not found with this Id" + loadId);
		}
	}

	@Override
	public Load updateLoad(Long loadId, Load load) {
		Optional<Load> existLoadOptional = LoadRepository.findById(loadId);
		Load existLoad = existLoadOptional.get();
		existLoad.setLoadingPoint(load.getLoadingPoint());
		existLoad.setUnloadingPoint(load.getUnloadingPoint());
		existLoad.setProductType(load.getProductType());
		existLoad.setTruckType(load.getTruckType());
		existLoad.setNoOfTrucks(load.getNoOfTrucks());
		existLoad.setWeight(load.getWeight());
		existLoad.setComment(load.getComment());
		existLoad.setShipperId(load.getShipperId());
		
		return LoadRepository.save(existLoad);
		
	}	
    
}
