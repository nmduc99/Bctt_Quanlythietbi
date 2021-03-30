package com.qltb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qltb.entity.Device;
import com.qltb.repository.DeviceRepository;
import com.qltb.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	public DeviceRepository deviceRepo;

	public DeviceServiceImpl(DeviceRepository deviceRepo ) {
		super();
		this.deviceRepo=deviceRepo; 
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Device> getAll() {
		return deviceRepo.findAll();
	}
	
	@Override
	public Optional<Device> findById(Long id) {
		return deviceRepo.findById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		deviceRepo.deleteById(id);
	}
	
	@Override
	public Device save(Device device) {
		return deviceRepo.save(device);
	}
	
	
}
