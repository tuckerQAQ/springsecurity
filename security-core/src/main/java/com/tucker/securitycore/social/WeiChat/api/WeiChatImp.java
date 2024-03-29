package com.tucker.securitycore.social.WeiChat.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class WeiChatImp extends AbstractOAuth2ApiBinding implements WeiChat  {

    private ObjectMapper objectMapper = new ObjectMapper();

   private static final String URL_GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?openid=";

   public WeiChatImp(String accessToken){
       super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
   }

   protected List<HttpMessageConverter<?>> getMessageConverter(){
       List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
       messageConverters.remove(0);
       messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
       return messageConverters;
   }

    @Override
    public WeiChatUserInfo getUserInfo(String openId) {
        String url = URL_GET_USER_INFO+openId;
        String response = getRestTemplate().getForObject(url,String.class);
        if(StringUtils.contains(response,"errcode")){
            return null;
        }
        WeiChatUserInfo profile = null;
            try {
                profile = objectMapper.readValue(response,WeiChatUserInfo.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return profile;
    }
}
