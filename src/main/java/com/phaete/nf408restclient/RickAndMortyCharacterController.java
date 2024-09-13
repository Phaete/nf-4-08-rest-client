package com.phaete.nf408restclient;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController()
@RequestMapping("/api/characters")
public class RickAndMortyCharacterController {

    private final RickAndMortyApiService rickAndMortyApiService;

    public RickAndMortyCharacterController(RickAndMortyApiService rickAndMortyApiService) {
        this.rickAndMortyApiService = rickAndMortyApiService;
    }

    @GetMapping
    public List<RickAndMortyApiResponseResults> getAllCharacters(@RequestParam(required = false) String status) {
        if (status == null) {
            return rickAndMortyApiService.getAllCharacters();
        } else {
            return rickAndMortyApiService.getCharactersByStatus(status);
        }
    }

    @GetMapping("/{id}")
    public RickAndMortyApiResponseResults getCharacterById(@PathVariable int id) {
        return rickAndMortyApiService.getCharacterById(id);
    }


}
