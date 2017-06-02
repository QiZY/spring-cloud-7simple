package com.seven.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;

@SpringBootApplication
@EnableZuulProxy
public class CloudApiGatewayApplication {

    /**
     * 打开http://127.0.0.1:8000/cloud-simple-ui就可以访问到相应的cloud-simple-ui服务(默认的Zuul接口转换就是/serviceId)
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CloudApiGatewayApplication.class, args);
    }

    /**
     * 实现ETag功能
     *
     * @return
     */
    @Bean
    public Filter shallowEtagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }
}
