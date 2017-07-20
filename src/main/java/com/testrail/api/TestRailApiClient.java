package com.testrail.api;

import com.google.gson.Gson;
import com.testrail.api.gurock.APIClient;
import org.json.simple.JSONAware;

/*
    Wrapper for gurock APIClient
 */
public class TestRailApiClient {
    private final APIClient client;

    public TestRailApiClient(String base_url) {
        this.client = new APIClient(base_url);
    }

    public String getUser() {
        return client.getUser();
    }

    public void setUser(String user) {
        client.setUser(user);
    }

    public String getPassword() {
        return client.getPassword();
    }

    public void setPassword(String password) {
        client.setPassword(password);
    }

    public <T> T sendPost(String uri, final Object data, Class<T> clazz) {
        return new Gson().fromJson(sendPost(uri, (JSONAware) data::toString), clazz);
    }

    public <T> T sendPost(RelativePath resource, Object bean, Class<T> clazz) {
        return sendPost(resource.toString(), new Gson().toJson(bean), clazz);
    }

    public <T> T sendGet(String uri, Class<T> clazz) {
        return new Gson().fromJson(sendGet(uri), clazz);
    }

    private String sendPost(String uri, Object data) {
        try {
            return client.sendPost(uri, data).toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String sendGet(String uri) {
        try {
            return client.sendGet(uri).toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
