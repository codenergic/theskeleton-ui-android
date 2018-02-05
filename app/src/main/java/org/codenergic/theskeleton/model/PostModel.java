package org.codenergic.theskeleton.model;

/**
 * Created by diasa on 11/19/17.
 */
public class PostModel {

    private String id;

    private String title;

    private String shortContent;

    private String content;

    private String imageUrl;

    private int type;

    public String getId() {
        return id;
    }

    public PostModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PostModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getShortContent() {
        return shortContent;
    }

    public PostModel setShortContent(String shortContent) {
        this.shortContent = shortContent;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostModel setContent(String content) {
        this.content = content;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public PostModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getType() {
        return type;
    }

    public PostModel setType(int type) {
        this.type = type;
        return this;
    }
}
