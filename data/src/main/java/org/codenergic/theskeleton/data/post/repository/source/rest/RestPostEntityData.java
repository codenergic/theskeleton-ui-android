package org.codenergic.theskeleton.data.post.repository.source.rest;

import org.codenergic.theskeleton.data.helper.RxTransformer;
import org.codenergic.theskeleton.data.post.PostEntity;
import org.codenergic.theskeleton.data.post.repository.source.PostData;
import org.codenergic.theskeleton.data.response.RetrofitResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by diasa on 1/27/18.
 */
@Singleton
public class RestPostEntityData implements PostData {

    private PostApi postApi;

    @Inject
    public RestPostEntityData(PostApi postApi) {
        this.postApi = postApi;
    }

    @Override
    public Flowable<RetrofitResponse<List<PostEntity>>> getPosts(int page, int size) {
        return postApi.getPosts(page, size)
            .compose(RxTransformer.applyThreadTransformer());
    }
}
