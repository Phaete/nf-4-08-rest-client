package com.phaete.nf408restclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureMockRestServiceServer
class RickAndMortyCharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MockRestServiceServer mockRestServiceServer; // Mock server

    @Test
    void getAllCharacters() throws Exception{
        mockRestServiceServer.expect( // Expect a request
                requestTo("https://rickandmortyapi.com/api/character") // to this url
        ).andExpect( // and expect
                method(HttpMethod.GET) // a GET request
        ).andRespond( // and respond
                withSuccess( // with a successful response
                        """
                            {
                                "info": {
                                    "count": 32,
                                    "pages": 42
                                },
                                "results": [
                                    {
                                        "id": 1,
                                        "name": "Rick Sanchez",
                                        "species": "Human"
                                    }
                                ]
                            }
                        """,
                        MediaType.APPLICATION_JSON
                ) // with this body
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/api/characters"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                    """
                        [
                            {
                                "id": 1,
                                "name": "Rick Sanchez",
                                "species": "Human"
                            }
                        ]
                    """
                ));
    }

    @Test
    void getCharacterById() {
    }
}