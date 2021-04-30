package org.yunhyerim.api.wishilist.controller;

import lombok.RequiredArgsConstructor;
import org.yunhyerim.api.exhibition.domain.Exhbn;
import org.yunhyerim.api.exhibition.service.ExhbnServiceImpl;
import org.yunhyerim.api.user.service.UserServiceImpl;
import org.yunhyerim.api.wishilist.domain.WishDTO;
import org.yunhyerim.api.wishilist.domain.WishlistDTO;
import org.yunhyerim.api.wishilist.service.WishlistServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequiredArgsConstructor @CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/wishlist")
public class WishlistController{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	final WishlistServiceImpl service;
	final UserServiceImpl userService;
	final ExhbnServiceImpl exhbnService;

	@PostMapping("")
	public ResponseEntity<Long> save(@RequestBody WishlistDTO w) {
		w.setUser(userService.getOne(w.getUserNum()));
		w.setExhbn(exhbnService.getOne(w.getExhbnNum()));
		return ResponseEntity.ok(service.add(w));
	}
	@DeleteMapping("/{userNum}/{exhbnNum}")
	public ResponseEntity<Long> delete(@PathVariable long userNum, @PathVariable long exhbnNum) {
		return ResponseEntity.ok(service.delete(userNum, exhbnNum));
	}

	@GetMapping("")
	public ResponseEntity<List<WishDTO>> findWishlist() {
		return ResponseEntity.ok(service.findWishlist());
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Exhbn>> findByUser(@PathVariable long id) {
		return ResponseEntity.ok(service.findByUser(id));
	}

}
