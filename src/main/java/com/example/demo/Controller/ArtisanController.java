package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Artisan;
import com.example.demo.service.ArtisanService;

@RestController
@RequestMapping("/api/artisans")
public class ArtisanController {

    @Autowired
    private ArtisanService artisanService;

    @GetMapping
    public List<Artisan> getAllArtisans() {
        return artisanService.getAllArtisans();
    }

    @GetMapping("/{id}")
    public Optional<Artisan> getArtisanById(@PathVariable Long id) {
        return artisanService.getArtisanById(id);
    }

    @PostMapping
    public Artisan createArtisan(@RequestBody Artisan artisan) {
        return artisanService.addArtisan(artisan);
    }

    @PutMapping("/{id}")
    public Artisan updateArtisan(@PathVariable Long id, @RequestBody Artisan artisan) {
        return artisanService.updateArtisan(id, artisan);
    }

    @DeleteMapping("/{id}")
    public void deleteArtisan(@PathVariable Long id) {
        artisanService.deleteArtisan(id);
    }
}