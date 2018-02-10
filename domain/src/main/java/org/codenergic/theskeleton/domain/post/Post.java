package org.codenergic.theskeleton.domain.post;

/**
 * Created by diasa on 10/24/17.
 */
public class Post {

    private String content;

    private String id;

    private String title;

    public String getId() {
        return id;
    }

    public Post setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }
}
