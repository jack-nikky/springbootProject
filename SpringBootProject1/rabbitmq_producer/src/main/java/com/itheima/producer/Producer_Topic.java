package com.itheima.producer;


import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer_Topic {
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

        /*
        exchangeDeclare(String exchange, BuiltinExchangeType type, boolean durable, boolean autoDelete, Map<String, Object> arguments)
         参数：
            1.exchange 交换机名称
            2.type 交换机类型
                DIRECT("direct") :定向
                DANOUT（"fanout") 扇形 （广播） 发送消息到每一个与之绑定队列
                TOPIC（“topic”） 通配符的方式
                HEADES（“headers") 参数匹配

            3.durable 是否持久化

            4.autoDelete 是否自动删除
            5.internal 内部使用，一般为false
            6.arguments 参数
         */
        String exchangeName = "test_topic";
        //5.创建交换机
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC,true,false,false,null);
        //6.创建队列
        String queue1name = "test_topic_queue1";
        String queue2name = "test_topic_queue2";
        channel.queueDeclare(queue1name,true,false,false,null);
        channel.queueDeclare(queue2name,true,false,false,null);
        //7.绑定队列和交换机
        /*
        queueBind(String queue, String exchange, String routingKey)
        参数：
            1.queue：队列名称
            2.exchange 交换机名称
            3.routingKey  路由键，绑定队列
                如果交换机的类型为fanout，routingKey设置为空
         */
        //routingKey  系统的名称.日志的级别
        //需求： 所有的error级别的日志存入数据库，所有的order系统的日志存入数据库
        //队列一的绑定
        channel.queueBind(queue1name,exchangeName,"#.error");
        channel.queueBind(queue1name,exchangeName,"order.*");
        //队列二的绑定
        channel.queueBind(queue2name,exchangeName,"*.*");

        //8.发送消息
        String body = "日志信息：张三调用了delete方法，info";
        channel.basicPublish(exchangeName,"goos.info",null,body.getBytes());
        //9.释放资源
        channel.close();
        connection.close();
    }
}
