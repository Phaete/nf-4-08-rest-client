package com.phaete.nf408restclient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RickAndMortyApiService {

    private final RestClient restClient;

    public RickAndMortyApiService(RestClient.Builder restClient) {
        this.restClient = restClient.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public List<RickAndMortyApiResponseResults> getAllCharacters() {
        RickAndMortyApiResponse response = this.restClient.get().uri("/character").retrieve().body(RickAndMortyApiResponse.class);
        assert response != null;
        return response.results();
    }

    public RickAndMortyApiResponseResults getCharacterById(int id) {
        return restClient.get().uri("/character/" + id).retrieve().body(RickAndMortyApiResponseResults.class);
    }

    public List<RickAndMortyApiResponseResults> getCharactersByStatus(String status) {
        RickAndMortyApiResponse response = this.restClient.get().uri("/character?status=" + status).retrieve().body(RickAndMortyApiResponse.class);
        assert response != null;
        return response.results();
    }

    public int getSpeciesStatistic(String species) {
        RickAndMortyApiResponse response = this.restClient.get().uri("/character?species=" + species + "&status=alive").retrieve().body(RickAndMortyApiResponse.class);
        assert response != null;
        return response.info().count();
    }

//    public static void main(String[] args) {
//        RestClient.Builder restClientBuilder = RestClient.builder();
//        RickAndMortyApiService service = new RickAndMortyApiService(restClientBuilder);
//        service.getAllCharacters();
//    }
}
