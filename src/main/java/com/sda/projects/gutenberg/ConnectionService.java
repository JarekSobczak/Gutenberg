package com.sda.projects.gutenberg;

import lombok.NoArgsConstructor;
import org.springframework.web.client.RestTemplate;

@NoArgsConstructor
public class ConnectionService {

    public String connect() {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://www.gutenberg.org/cache/epub/514/pg514.txt", String.class);

    }
}
