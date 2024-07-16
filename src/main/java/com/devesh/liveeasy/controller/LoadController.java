package com.devesh.liveeasy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.liveeasy.entity.Load;
import com.devesh.liveeasy.service.LoadService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/load")
public class LoadController {
    @Autowired
    private LoadService LoadService;
    
    @PostMapping
    public String addLoad(@RequestBody Load load) {
    	LoadService.saveLoad(load);
		return "Load details added successfully";
    }
    
    @GetMapping("/{loadId}")
    public Optional<Load> getLoadById(@PathVariable Long loadId) {
    	return LoadService.getLoadById(loadId);
    }
    

    @GetMapping
    public List<Load> getAllLoads(@RequestParam String shipperId) {
        return LoadService.getLoads(shipperId);
    }
    
    @DeleteMapping("/{loadId}")
    public String deleteLoadById(@PathVariable Long loadId) {
    	LoadService.deleteLoadById(loadId);
    	return "Deleted Successfully";
    }
    
    
    
    @PutMapping("{loadId}")
    public String updateLoad(@PathVariable Long loadId, @RequestBody Load load) {
        LoadService.updateLoad(loadId, load);
        
        return "Updated Record Successfully";
    }

    
    
}
