package org.codenergic.theskeleton.data.helper;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by putrice on 9/27/17.
 */

@Singleton
public class RxTransformer {

    private final FlowableTransformer<Flowable, Flowable> threadTransformer =
        observable -> observable
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread());

    @Inject
    public RxTransformer() {
    }

    @SuppressWarnings("unchecked")
    public <T> FlowableTransformer<T, T> applyThreadTransformer() {
        return (FlowableTransformer<T, T>) threadTransformer;
    }
}
