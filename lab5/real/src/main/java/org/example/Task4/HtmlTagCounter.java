package org.example.Task4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.*;

public class HtmlTagCounter {

    public static Map<String, Integer> countTags(String url)
            throws IOException {

        Document document = Jsoup.connect(url).get();

        Map<String, Integer> tags = new HashMap<>();

        for (Element element : document.getAllElements()) {
            String tag = element.tagName();

            tags.put(tag, tags.getOrDefault(tag, 0) + 1);
        }

        return tags;
    }
}