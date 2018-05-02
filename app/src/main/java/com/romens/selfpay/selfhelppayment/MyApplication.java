package com.romens.selfpay.selfhelppayment;


import com.romens.erp.library.LibraryApplication;
import com.romens.images.CloudImagesManager;

/**
 * Created by mMerlin on 2018/4/24.
 */

public class MyApplication extends LibraryApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        CloudImagesManager.init(this);
    }
}
