package com.bloomtech.entities;

import javax.persistence.*;

@Entity
@Table(name="urls")
public class URLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String shortId;
    private String originalUrl;

    public URLEntity() {
    }

    public URLEntity(String shortId, String originalUrl) {
        this.shortId = shortId;
        this.originalUrl = originalUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortId() {
        return shortId;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
