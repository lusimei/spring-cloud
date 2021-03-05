package com.kuang.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import java.util.List;

public class MyRule extends AbstractLoadBalancerRule {

    private int total = 0;//被调用的次数

    private int currentIndex = 0;//当前是谁在提供服务

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while(server == null) {
            if(Thread.interrupted()){
                return null;
            }

            List<Server> reachableServers = lb.getReachableServers();//获得活着的服务
            List<Server> allServers = lb.getAllServers();//获得全部服务

            int serverCount = allServers.size();
            if (serverCount == 0) {
                return null;
            }

            if(total < 5){
                server = reachableServers.get(currentIndex);
                total++;
            }else{
                total = 0;
                currentIndex++;
                if(currentIndex >= reachableServers.size()){
                    currentIndex = 0;
                }
                server = reachableServers.get(currentIndex);
            }
        }
        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        return null;
    }
}
