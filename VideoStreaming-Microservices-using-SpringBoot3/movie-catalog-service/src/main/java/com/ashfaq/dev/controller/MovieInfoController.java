package com.ashfaq.dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashfaq.dev.model.MovieInfo;
import com.ashfaq.dev.repo.MovieInfoRepo;

@RestController
@RequestMapping("/movie-Info")
public class MovieInfoController {

	private MovieInfoRepo movieInfoRepo;

	public MovieInfoController(MovieInfoRepo movieInfoRepo) {
		this.movieInfoRepo = movieInfoRepo;
	}



	@PostMapping("/save")
	public List<MovieInfo> saveAll(@RequestBody List<MovieInfo> moviesInfo) {

		return movieInfoRepo.saveAll(moviesInfo);
	}
	
	
	@GetMapping("/list")
	public List<MovieInfo> findAll(){
		return movieInfoRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	public String findById(@PathVariable Long id){
		
		String path = movieInfoRepo.findById(id).get().getPath();
		System.out.println(path);
		return path;
	}

}
