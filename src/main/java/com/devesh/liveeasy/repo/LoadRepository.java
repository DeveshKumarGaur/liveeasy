package com.devesh.liveeasy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devesh.liveeasy.entity.Load;

public interface LoadRepository extends JpaRepository<Load, Long> {
	List<Load> getLoadsByShipperId(String shipperId);
}
