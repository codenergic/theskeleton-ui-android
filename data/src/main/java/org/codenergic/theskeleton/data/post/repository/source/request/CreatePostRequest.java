package org.codenergic.theskeleton.data.post.repository.source.request;

/**
 * Created by diasa on 2/5/18.
 */
public class CreatePostRequest {

    private String title;

    private String content;

    public CreatePostRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
