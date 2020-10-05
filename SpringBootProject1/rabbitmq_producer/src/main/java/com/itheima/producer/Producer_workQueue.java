package com.itheima.producer;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
public class Producer_workQueue {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2.设置参数
        connectionFactory.setHost("49.234.93.130");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/itcast");
        connectionFactory.setUsername("heima");
        connectionFactory.setPassword("heima");
        //3.获取对应的连接 Connection
        Connection connection = connectionFactory.newConnection();
        //4.创建 Channel
        Channel channel = connection.createChannel();
        //5.创建队列
        channel.queueDeclare("work_queue",true,false,false,null);
        //6.发送消息

        for(int i =0;i<10;i++){
            String body = i+"hello rabbitmq--------";
            channel.basicPublish("","work_queue",null,body.getBytes());
        }
    }
}
