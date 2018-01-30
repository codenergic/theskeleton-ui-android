package org.codenergic.theskeleton.data.post;

import com.google.auto.value.AutoValue;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.codenergic.theskeleton.data.DomainEntity;
import org.codenergic.theskeleton.domain.post.Post;

/**
 * Created by diasa on 1/27/18.
 */
@AutoValue
@JsonDeserialize(builder = AutoValue_PostEntity.Builder.class)
public abstract class PostEntity implements DomainEntity {

    static Builder builder() {
        return new AutoValue_PostEntity.Builder();
    }

    public abstract String getContent();

    public abstract String getId();

    public abstract String getTitle();

    public Post toPost() {
        return new Post()
            .setContent(getContent())
            .setId(getId())
            .setTitle(getTitle());
    }

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    public static abstract class Builder {

        public abstract PostEntity build();

        public abstract Builder content(String content);

        public Builder fromPost(Post post) {
            return id(post.getId())
                .content(post.getContent())
                .title(post.getTitle());
        }

        public abstract Builder id(String id);

        public abstract Builder title(String title);
    }
}
