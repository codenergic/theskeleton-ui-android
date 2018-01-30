package org.codenergic.theskeleton.data.response;

import android.support.annotation.Keep;

/**
 * Created by diasa on 1/27/18.
 */
@Keep
public class RetrofitResponse<T> {

    T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}