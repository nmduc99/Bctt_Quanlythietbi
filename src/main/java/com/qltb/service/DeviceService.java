package com.qltb.service;

import java.util.List;
import java.util.Optional;

import com.qltb.entity.Device;


public interface DeviceService {

	List<Device> getAll();

	Optional<Device> findById(Long id);
	
	void deleteById(Long id);

	Device save(Device device);
}
