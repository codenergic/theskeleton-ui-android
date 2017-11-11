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

public class RxTransformer {

    private static final FlowableTransformer<Flowable, Flowable> threadTransformer =
        observable -> observable
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread());

    private RxTransformer() {
    }

    @SuppressWarnings("unchecked")
    public static <T> FlowableTransformer<T, T> applyThreadTransformer() {
        return (FlowableTransformer<T, T>) threadTransformer;
    }
}
