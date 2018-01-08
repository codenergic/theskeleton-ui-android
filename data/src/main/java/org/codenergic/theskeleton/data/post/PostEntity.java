package org.codenergic.theskeleton.data.post;

import android.support.annotation.Keep;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.auto.value.AutoValue;
import org.codenergic.theskeleton.data.DomainEntity;
import org.codenergic.theskeleton.model.Post;

@Keep
@AutoValue
@JsonDeserialize(builder = AutoValue_PostEntity.Builder.class)
public abstract class PostEntity implements DomainEntity {
    public abstract String getId();

    public abstract String getTitle();

    public abstract String getContent();

    public static Builder builder() {return new AutoValue_PostEntity.Builder();}

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    public static abstract class Builder {

        public abstract PostEntity.Builder id(String id);

        public abstract PostEntity.Builder title(String title);

        public abstract PostEntity.Builder content(String content);

        public abstract PostEntity build();

        public PostEntity.Builder fromPost(Post post) {
            return id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent());
        }
    }
}