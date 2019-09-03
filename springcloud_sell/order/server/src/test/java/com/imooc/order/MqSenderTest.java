package com.imooc.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: wz
 * @Date: 2019/5/7 16:50
 * @Description:
 */
@Component
public class MqSenderTest extends  OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Test
    public void send(){

        amqpTemplate.convertAndSend("myQueue","now"+new Date());
    }

    @Test
    public void sendComputer(){

        amqpTemplate.convertAndSend("myOrder","computer","now"+new Date());
    }
    @Test
    public void sendFruit(){

        amqpTemplate.convertAndSend("myOrder","fruit","now"+new Date());
    }

}
