package org.example.Translator;

import java.util.HashMap;
import java.util.Map;

public class Translator {

    private final Map<String, String> dictionary = new HashMap<>();

    public int getSize() {
        return dictionary.size();
    }

    public String translate(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (String token : text.trim().split("\\s+")) {
            String correctWord = token.replaceAll("^[^a-zA-Z']+|[^a-zA-Z']+$", "").toLowerCase();
            if (correctWord.isEmpty()) {
                continue;
            }
            String translated = dictionary.get(correctWord);
            result.append(translated != null ? translated : "[" + correctWord + "]").append(' ');
        }
        return result.toString().trim();
    }

    public void addWord(String eng, String ukr) {
        if (ukr == null || ukr.trim().isEmpty() || eng == null || eng.trim().isEmpty())
                 {
            throw new IllegalArgumentException("Word must not be empty.");
        }
        dictionary.put(eng.trim().toLowerCase(), ukr.trim());
    }

}