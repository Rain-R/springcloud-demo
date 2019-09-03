package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: wz
 * @Date: 2019/5/7 16:45
 * @Description:
 */
@Slf4j
@Component
public class MqReceiver {
    //1. @RabbitListener(queues="myQueue")
    //2. 自动创建消息队列@RabbitListener(queues="myQueue")
    //3.自动创建，Exchange 和Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExcahnge")
    ))
    public void process(String message)
    {
          log.info("mqreceiver:{}",message);
    }
    /**
     * 不同应用服务接受消息
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")

    ))
    public void processFruit(String message)
    {
        log.info(" fruit mqreceiver:{}",message);
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")

    ))
    public void processComputer(String message)
    {
        log.info(" computer mqreceiver:{}",message);
    }


}
