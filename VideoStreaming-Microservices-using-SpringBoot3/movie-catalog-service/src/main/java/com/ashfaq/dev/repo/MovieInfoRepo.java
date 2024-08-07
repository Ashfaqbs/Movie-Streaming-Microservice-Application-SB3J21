package com.ashfaq.dev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashfaq.dev.model.MovieInfo;

public interface MovieInfoRepo  extends JpaRepository<MovieInfo, Long> {

}
