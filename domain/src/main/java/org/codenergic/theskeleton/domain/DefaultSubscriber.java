package org.codenergic.theskeleton.domain;

import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by putrice on 9/27/17.
 */

public class DefaultSubscriber<T> extends DisposableSubscriber<T> {

    @Override
    public void onNext(T t) {
        // no-op by default.
    }

    @Override
    public void onError(Throwable t) {
        // no-op by default.
    }

    @Override
    public void onComplete() {
        // no-op by default.
    }
}
