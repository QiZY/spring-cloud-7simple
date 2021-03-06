package com.seven.cloud.thrift.conf;

import com.seven.cloud.thrift.interfaces.UserService;
import com.seven.cloud.thrift.service.UserServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by QiZY on 2017-5-27.
 */
@Configuration
public class ThriftConfig {
    ExecutorService executor = Executors.newSingleThreadExecutor();

    @Bean
    public TServerTransport tServerTransport() {
        try {
            return new TServerSocket(7911);
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public TServer tServer() {
        //发布服务
        UserService.Processor processor = new UserService.Processor(new UserServiceImpl());
        TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(tServerTransport()).processor(processor));
        return server;
    }

    @PostConstruct
    public void init() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                tServer().serve();
            }
        });
    }
}
