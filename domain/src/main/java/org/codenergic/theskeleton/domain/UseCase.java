package org.codenergic.theskeleton.domain;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by putrice on 9/27/17.
 */

public abstract class UseCase<T, Params> {

    private CompositeDisposable compositeDisposable;

    protected UseCase() {
        initCompositeDisposable();
    }

    private void initCompositeDisposable() {
        compositeDisposable = new CompositeDisposable();
    }

    public void clearAllSubscription() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

    public Disposable execute(DisposableSubscriber<T> subscriber) {
        return execute(subscriber, null);
    }

    public Disposable execute(DisposableSubscriber<T> subscriber, Params params) {
        return addDisposable(
            buildUseCaseFlowable(params)
                .subscribeWith(subscriber));
    }

    protected Disposable addDisposable(Disposable disposable) {
        if (null != compositeDisposable && compositeDisposable.isDisposed()) {
            initCompositeDisposable();
        }

        if (disposable != null && !disposable.isDisposed()) {
            assert compositeDisposable != null;
            compositeDisposable.remove(disposable);
        }

        assert disposable != null;
        assert compositeDisposable != null;
        compositeDisposable.add(disposable);
        return compositeDisposable;
    }

    protected abstract Flowable<T> buildUseCaseFlowable(Params params);
}
