package com.example.demo;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * WordCountController REST controller
 * Please refer to the following swagger api for more detail on the available
 * operations and corresponding response status
 * https://app.swaggerhub.com/apis/nboumaza/springboot/1.0.0#/
 * 
 * https://virtserver.swaggerhub.com/nboumaza/springboot/1.0.0/countWords
 * it is post method
 * select post
 * and select body
 * raw
 * text/plain
 * as seen in the controller
 * 
 * 
 * 
 * 
 * 
 */
@RestController
public class WordCountController {

    @PostMapping(value = "/countWords", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> countWords(@RequestBody String text) {
        return compute(text);

    }

    /**
     * @param para SON object containing a paragraph of text
     * @return unique words from the supplied paragraph along with a count
     * of the number of occurrences.
     * Note: returned list is soted alphabetically
     */
    private Map<String, Long> compute(String para) {

        Map<String, Long> wordCounts = Arrays.stream(para.trim().split("[ ,.!?\r\n]"))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        Map<String, Long> sortedMap = new LinkedHashMap<>();

        Stream<Map.Entry<String, Long>> stream = wordCounts.entrySet().stream();

        stream.sorted(Map.Entry.comparingByKey())
                .forEachOrdered(c -> sortedMap.put(c.getKey(), c.getValue()));

        return sortedMap;

    }
}