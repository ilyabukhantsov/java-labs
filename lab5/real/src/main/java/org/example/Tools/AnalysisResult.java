package org.example.Tools;

import java.io.Serializable;

public class AnalysisResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private String dataName;
    private String content;

    public AnalysisResult(String dataName, String content) {
        this.dataName = dataName;
        this.content = content;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AnalysisResult{" +
                "dataName='" + dataName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}