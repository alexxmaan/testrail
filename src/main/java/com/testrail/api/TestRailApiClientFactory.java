package com.testrail.api;

public class TestRailApiClientFactory {
    public static TestRailApiClient defaultClient() {
        TestRailApiClient client = new TestRailApiClient("https://bugaginho.testrail.net");
        client.setUser("nemanovich@gmail.com");
        client.setPassword("G6G6shszuoMuO9dosDYf-Od07FCDOZ.SvdAncCZk3");
        return client;
    }
}
