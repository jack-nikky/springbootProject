package com.itheima.producer;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/*
* 发送消息*/
public class Producer_HelloWorld {
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
        /*queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
        参数：
            1.queue:队列名称
            2.durable：是否持久化，当mq还在
            3.exclusive:
                是否独占：只能有一个消费者监听这个队列
                当connection关闭时，是否删除队列
            4.autoDelete  ：是否自动删除，当没有consume时，它会自动删除
            5.arguments: 参数
        */
        //如果没有hello_world队列，则会自动创建队列
        channel.queueDeclare("hello_world",true,false,false,null);

        /*basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
        参数：
            1.exchange 交换机名称，简单模式下交换机会使用默认的“”
            2.routingKey   路由名称
            3.props： 配置信息
            4.body: 发送的消息数据
         */
        //6.发送消息
        String body = "hello rabbitmq--------";
        channel.basicPublish("","hello_world",null,body.getBytes());

        //7.释放资源
        //channel.close();
        //connection.close();
    }
}
