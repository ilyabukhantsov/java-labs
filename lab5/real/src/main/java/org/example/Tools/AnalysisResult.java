package org.example.Tools;

import java.io.Serializable;

public class AnalysisResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private String dataName;
    private String content;
    private int wordCount;

    public AnalysisResult(String dataName, String content, int wordCount) {
        this.dataName = dataName;
        this.content = content;
        this.wordCount = wordCount;
    }

    public String getDataName() {
        return dataName;
    }

    public String getContent() {
        return content;
    }

    public int getWordCount() {
        return wordCount;
    }

    @Override
    public String toString() {
        return "AnalysisResult{" +
                "dataName='" + dataName + '\'' +
                ", content='" + content + '\'' +
                ", wordCount=" + wordCount +
                '}';
    }
}