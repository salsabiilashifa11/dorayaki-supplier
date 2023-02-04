package com.wbd.dorayakisupplier;

import com.wbd.dorayakisupplier.service.DorayakiSupplierServiceImpl;

import javax.xml.ws.Endpoint;

public class DorayakiSupplierServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/dorayakisupplierservice",
                new DorayakiSupplierServiceImpl());

    }
}
