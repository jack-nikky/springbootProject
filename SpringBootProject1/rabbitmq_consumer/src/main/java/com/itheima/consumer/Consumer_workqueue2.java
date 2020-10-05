package com.itheima.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer_workqueue2 {
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
        channel.queueDeclare("work_queue",true,false,false,null);

        //接收消息
        /*basicConsume(String queue, boolean autoAck, Consumer callback)
        参数：
            1.queue: 队列名称
            2.autoAck  是否自动确认
            3.callback  回调的对象
         */
        Consumer consumer = new DefaultConsumer(channel){

            /*回调方法，收到消息后，自动执行该方法
            * 1.consumerTag  标识
            * 2.envelop: 获取一些信息，交换机，路由key
            * 3.properties 配置信息
            * 4.body 数据
            * */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println("consumerTag:"+consumerTag);
//                System.out.println("Exchange:"+envelope.getExchange());
//                System.out.println("RoutingKey:"+envelope.getRoutingKey());
//                System.out.println("properties:"+properties);
                System.out.println("body:"+new String(body));

            }
        };
        channel.basicConsume("work_queue",true,consumer);
    }
}
