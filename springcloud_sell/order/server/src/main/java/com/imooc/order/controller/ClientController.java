package com.imooc.order.controller;

import com.imooc.order.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wz
 * @version v1.0
 * @description
 * @datetime 2019/9/3 9:14
 * @since JDK 1.8
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String  getProductMsg(){
        String res="";
       //第一种方式
//        RestTemplate restTemplate=new RestTemplate();
//        String res=restTemplate.getForObject("http://localhost:8082/msg",String.class);

//        //第二种方式 通过应用名获取URL
//        RestTemplate restTemplate=new RestTemplate();
//        ServiceInstance serviceInstance=loadBalancerClient.choose("PRODUCT");
//        String url=String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()+"/msg");
//        String res=restTemplate.getForObject(url,String.class);
//

        //第三种方式
//      String res =  restTemplate.getForObject("http://PRODUCT/msg",String.class);



        //第四中方式 使用feign

        res=productClient.getProductMsg();

        log.info("response:"+res);
        return  res;
    }


}
