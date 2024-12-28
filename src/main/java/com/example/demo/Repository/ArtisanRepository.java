package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Artisan;


public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
	

}
