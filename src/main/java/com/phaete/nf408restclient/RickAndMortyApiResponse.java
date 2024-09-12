package com.phaete.nf408restclient;

import java.util.List;

public record RickAndMortyApiResponse(
        RickAndMortyApiResponseInfo info, // variable name is the tag in the json response>>
        List<RickAndMortyApiResponseResults> results // variable name is the tag in the json response
) {
}
