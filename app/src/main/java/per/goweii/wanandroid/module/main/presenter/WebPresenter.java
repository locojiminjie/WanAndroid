package per.goweii.wanandroid.module.main.presenter;

import per.goweii.basic.core.base.BasePresenter;
import per.goweii.rxhttp.request.base.BaseBean;
import per.goweii.rxhttp.request.exception.ExceptionHandle;
import per.goweii.wanandroid.event.CollectionEvent;
import per.goweii.wanandroid.http.RequestListener;
import per.goweii.wanandroid.module.main.model.CollectArticleBean;
import per.goweii.wanandroid.module.main.model.CollectionLinkBean;
import per.goweii.wanandroid.module.main.model.MainRequest;
import per.goweii.wanandroid.module.main.view.WebView;

/**
 * @author CuiZhen
 * @date 2019/5/20
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public class WebPresenter extends BasePresenter<WebView> {

    public void collect(int id) {
        addToRxLife(MainRequest.collect(id, new RequestListener<BaseBean>() {
            @Override
            public void onStart() {
                showLoadingBar();
            }

            @Override
            public void onSuccess(int code, BaseBean data) {
                CollectionEvent.postCollectWithArticleId(id);
                if (isAttachView()) {
                    getBaseView().collectSuccess();
                }
            }

            @Override
            public void onFailed(int code, String msg) {
                if (isAttachView()) {
                    getBaseView().collectFailed(msg);
                }
            }

            @Override
            public void onError(ExceptionHandle handle) {
            }

            @Override
            public void onFinish() {
                dismissLoadingBar();
            }
        }));
    }

    public void collect(String title, String author, String link) {
        addToRxLife(MainRequest.collect(title, author, link, new RequestListener<CollectArticleBean>() {
            @Override
            public void onStart() {
                showLoadingBar();
            }

            @Override
            public void onSuccess(int code, CollectArticleBean data) {
                CollectionEvent.postCollectWithCollectId(data.getId());
                if (isAttachView()) {
                    getBaseView().collectSuccess();
                }
            }

            @Override
            public void onFailed(int code, String msg) {
                if (isAttachView()) {
                    getBaseView().collectFailed(msg);
                }
            }

            @Override
            public void onError(ExceptionHandle handle) {
            }

            @Override
            public void onFinish() {
                dismissLoadingBar();
            }
        }));
    }

    public void collect(String title, String link) {
        addToRxLife(MainRequest.collect(title, link, new RequestListener<CollectionLinkBean>() {
            @Override
            public void onStart() {
                showLoadingBar();
            }

            @Override
            public void onSuccess(int code, CollectionLinkBean data) {
                CollectionEvent.postCollectWithCollectId(data.getId());
                if (isAttachView()) {
                    getBaseView().collectSuccess();
                }
            }

            @Override
            public void onFailed(int code, String msg) {
                if (isAttachView()) {
                    getBaseView().collectFailed(msg);
                }
            }

            @Override
            public void onError(ExceptionHandle handle) {
            }

            @Override
            public void onFinish() {
                dismissLoadingBar();
            }
        }));
    }
}
