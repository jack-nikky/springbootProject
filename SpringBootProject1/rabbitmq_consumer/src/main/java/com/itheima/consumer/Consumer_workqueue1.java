package com.itheima.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer_workqueue1 {
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
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body:"+new String(body));

            }
        };
        channel.basicConsume("work_queue",true,consumer);
    }
}
