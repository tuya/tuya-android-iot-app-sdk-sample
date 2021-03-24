package com.tuya.iotapp.login.business;

import com.tuya.iotapp.common.utils.SHA256Util;
import com.tuya.iotapp.network.accessToken.bean.TokenBean;
import com.tuya.iotapp.network.business.Business;
import com.tuya.iotapp.network.request.IotApiParams;
import com.tuya.iotapp.network.request.ResultListener;

/**
 * TODO feature
 *
 * @author xiaoxiao <a href="mailto:developer@tuya.com"/>
 * @since 2021/3/20 2:12 PM
 */
public class LoginBusiness extends Business {

    private static final String LOGIN_API = "/v1.0/iot-03/users/login";

    /**
     * old :  user_name:18640825065   password:（b8a762334ab0c2f25a0503a86b152f77）Lbn123456  project-code：p1615796832753ggk9jt
     * new:  xiaoxiao.li@tuya.com  c679a76bc4315372c57ad1ba0a8e59f6
     *
     * @param userName
     * @param password
     * @param listener
     */
    public void login(String countryCode, String userName, String password, ResultListener<TokenBean> listener) {
        IotApiParams params = new IotApiParams(LOGIN_API, "1.0", "POST", countryCode);
        params.putPostData("user_name", userName);
        params.putPostData("password", SHA256Util.sha256(password));
        params.setSessionRequire(false);
        asyncRequest(params, TokenBean.class, listener);
    }

}
