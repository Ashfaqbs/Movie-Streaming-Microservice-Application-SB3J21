package com.ashfaq.example.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ashfaq.example.service.MovieCatalogService;

@RestController
public class MovieStreamController {

	@Autowired
	private MovieCatalogService movieCatalogService;

	@GetMapping("/stream/{videoPath}")
	public ResponseEntity<InputStreamResource> streamVideo(@PathVariable String videoPath) {

		String path = "C:\\Stream\\" + videoPath;

		File file = new File(path);

		if (file.exists()) {

			InputStreamResource resource = null;
			try {
				resource = new InputStreamResource(new FileInputStream(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok().contentType(MediaType.parseMediaType("video/mp4")).body(resource);

		} else {

			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/stream/with-id/{id}")
	public ResponseEntity<InputStreamResource> getVideopathById(@PathVariable long id) {

		String moviePath = movieCatalogService.getMoviePath(id);
		return streamVideo(moviePath);
	}	

}
