package org.codenergic.theskeleton.data.post.repository.source;

import org.codenergic.theskeleton.data.AbstractEntityDataFactory;
import org.codenergic.theskeleton.data.post.repository.source.rest.RestPostEntityData;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PostDataFactory extends AbstractEntityDataFactory<PostData> {
    private RestPostEntityData restPostEntityData;

    @Inject
    public PostDataFactory(RestPostEntityData restPostEntityData) {
        this.restPostEntityData = restPostEntityData;
    }

    @Override
    public PostData createData() {
        return null;
    }
}
