package com.qltb.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.qltb.entity.Device;
import com.qltb.service.DeviceService;

@RestController
@CrossOrigin("http://localhost:3000")
public class DeviceController {
	@Autowired
	private DeviceService deviceService;
	
	@GetMapping("/devices")
	public List<Device> retrieveAllDevice()
	{
		return deviceService.getAll();
	}
	
	@GetMapping("/devices/{id}")
	public Device retrieveDevice(@PathVariable long id) {
		Optional<Device> device = deviceService.findById(id);
		return device.get();
	}
	
	@DeleteMapping("/devices/{id}")
	public void deleteDevice(@PathVariable long id) {
		deviceService.deleteById(id);
	}
	
	@PostMapping("/devices")
	public ResponseEntity<Object> createDevice(@RequestBody Device device) {
		Device savedDevice = deviceService.save(device);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedDevice.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/devices/{id}")
	public ResponseEntity<Object> updateDevice(@RequestBody Device device, @PathVariable long id) {

		Optional<Device> deviceOptional = deviceService.findById(id);

		if (!deviceOptional.isPresent())
			return ResponseEntity.notFound().build();

		device.setId(id);
		
		deviceService.save(device);

		return ResponseEntity.noContent().build();
	}
}	
