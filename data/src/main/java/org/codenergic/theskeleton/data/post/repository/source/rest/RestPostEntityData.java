package org.codenergic.theskeleton.data.post.repository.source.rest;

import io.reactivex.Flowable;
import org.codenergic.theskeleton.data.helper.RxTransformer;
import org.codenergic.theskeleton.data.post.PostEntity;
import org.codenergic.theskeleton.data.post.repository.source.PostData;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class RestPostEntityData implements PostData {
    private PostApi postApi;

    @Inject
    public RestPostEntityData(PostApi postApi) {
        this.postApi = postApi;
    }

    @Override
    public Flowable<List<PostEntity>> loadPost() {
        return postApi.loadPost().compose(RxTransformer.applyThreadTransformer());
    }
}
