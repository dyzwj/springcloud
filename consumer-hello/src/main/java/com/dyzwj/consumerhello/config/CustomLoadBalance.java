package com.dyzwj.consumerhello.config;

import com.netflix.loadbalancer.ClientConfigEnabledRoundRobinRule;


/**
 * 自定义负载均衡策略
 */
public class CustomLoadBalance extends ClientConfigEnabledRoundRobinRule {
}
