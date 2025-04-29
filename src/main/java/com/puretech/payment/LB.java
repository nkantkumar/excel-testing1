package com.puretech.payment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LB {

    List<String> servers;

    AtomicInteger index;

    public LB(){
        servers  = new ArrayList<>();
        index = new AtomicInteger(0);
    }

    public void addServer(String name){
        servers.add(name);
    }

    public String getNextServer() {
        if (servers.isEmpty()) throw new RuntimeException("No servers available");
        int serverIndex = Math.abs(index.getAndIncrement() % servers.size());
        return servers.get(serverIndex);
    }

    public static void main(String[] args) {

    }
}
