package com.phaete.nf408restclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/species-statistic")
public class RickAndMortyStatisticsController {

    private final RickAndMortyApiService rickAndMortyApiService;

    public RickAndMortyStatisticsController(RickAndMortyApiService rickAndMortyApiService) {
        this.rickAndMortyApiService = rickAndMortyApiService;
    }

    @GetMapping
    public int getSpeciesStatistic(@RequestParam String species) {
        return rickAndMortyApiService.getSpeciesStatistic(species);
    }
}
