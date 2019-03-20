package com.example.countries.presentation.base;

import android.util.Log;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseViewModel extends ViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCleared() {
        disposables.clear();
        super.onCleared();
    }

    protected void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    protected void handleError(Throwable error) {
        Log.e("TAG", "handleError: " + error.getMessage());
    }
}
