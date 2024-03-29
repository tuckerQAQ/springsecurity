package com.tucker.securitycore.validate.Sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSmsCodeSender implements SmsCodeSender {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void send(String mobile, String code) {
        logger.info("=====向手机发送短信验证码=====");
        logger.info("手机号:"+mobile);
        logger.info("验证码:"+code);
    }
}
