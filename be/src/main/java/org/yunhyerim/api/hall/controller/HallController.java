package org.yunhyerim.api.hall.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import org.yunhyerim.api.analysis.service.AnalysisServiceImpl;
import org.yunhyerim.api.common.controller.AbstractController;
import org.yunhyerim.api.hall.domain.Hall;
import org.yunhyerim.api.hall.service.HallServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController 
@RequiredArgsConstructor 
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/halls")
public class HallController extends AbstractController<Hall> {
	final HallServiceImpl service;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping("")
	public ResponseEntity<Long> save(@RequestBody Hall t) {
		return ResponseEntity.ok(service.save(t));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Long> update(@RequestBody Hall t, @PathVariable long id) {
		logger.info("수정 정보: "+t.toString());
		Hall h = service.findByHallNum(id);
		if(!(t.getHallName().equals(h.getHallName()) || t.getHallName().equals(""))) {
			h.setHallName(t.getHallName());
		}
		if(!(t.getHallLocation().equals(h.getHallLocation()) || t.getHallLocation().equals(""))) {
			h.setHallLocation(t.getHallLocation());
		}
		if(!(t.getHallTime().equals(h.getHallTime()) || t.getHallTime().equals(""))) {
			h.setHallTime(t.getHallTime());
		}
		if(!(t.getHallClosed().equals(h.getHallClosed()) || t.getHallClosed().equals(""))) {
			h.setHallClosed(t.getHallClosed());
		}
		if(!(t.getHallPnumber().equals(h.getHallPnumber()) || t.getHallPnumber().equals(""))) {
			h.setHallPnumber(t.getHallPnumber());
		}
		if(!(t.getHallInfo().equals(h.getHallInfo()) || t.getHallInfo().equals(""))) {
			h.setHallInfo(t.getHallInfo());
		}
		if(!(t.getHallImage().equals(h.getHallImage()) || t.getHallImage().equals(""))) {
			h.setHallImage(t.getHallImage());
		}
		return ResponseEntity.ok(service.save(h));
	}

	@DeleteMapping("")
	public ResponseEntity<Long> delete(@RequestBody Hall t) {
		return ResponseEntity.ok(service.delete(t));
	}

	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		return ResponseEntity.ok(service.count());
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<Hall> getOne(@PathVariable long id) {
		return ResponseEntity.ok(service.getOne(id));
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Hall>> findById(@PathVariable long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping("/exists/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable long id) {
		return ResponseEntity.ok(service.existsById(id));
	}

	@GetMapping("")
	public ResponseEntity<List<Hall>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
}
