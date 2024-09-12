package com.phaete.nf408restclient;

public record RickAndMortyApiResponseResults(
        int id,
        String name,
        String status,
        String species
) {
}
