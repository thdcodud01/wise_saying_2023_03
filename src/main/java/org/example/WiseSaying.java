package org.example;

public class WiseSaying {
    private long id;
    private String content;
    private String authorName;

    WiseSaying(long id, String content, String authorName) {
        this.id = id;
        this.content = content;
        this.authorName = authorName;
    }
    public long getId() {
        return this.id;
    }
    public String getContent() {
        return this.content;
    }
    public String getAuthorName() {
        return this.authorName;
    }
}