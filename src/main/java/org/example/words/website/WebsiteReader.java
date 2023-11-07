package org.example.words.website;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class WebsiteReader {
    static StringBuilder read(String link) throws IOException {
        URL url = URI.create(link).toURL();
        String inputLine;
        StringBuilder content = new StringBuilder();

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
            content.append(System.lineSeparator());
        }
        in.close();

        return content;
    }
}
