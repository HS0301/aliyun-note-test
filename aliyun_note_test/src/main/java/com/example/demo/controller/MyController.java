package com.example.demo.controller;/**
 * @description:
 * @author: ManolinCoder
 * @time: 2022/9/28
 */

import com.example.demo.service.impl.AliyunNoteServiceImpl;
import com.example.demo.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *@Auther 月鸟石 2022/9/28 10:42:18
 *联系方式(QQ)：3054578922
 *周三 
 *欢迎回家，主人
 */
@RestController
@Slf4j
public class MyController {

    @Autowired
    private AliyunNoteServiceImpl msmService;

    @RequestMapping("/test/{phone}")
    public String test(@PathVariable String phone) {
        //获取code码
        String code = RandomUtil.getSixBitRandom();

        System.out.println("短信验证码内容是------------------->  "+code);

        boolean send = msmService.send(phone, code);

       /* if(send){
            try {
                log.info("将验证码存储redis中");
                redisTemplate.opsForValue().set("duan_xin:"+phone,code,300, TimeUnit.MINUTES);
                log.info("存储成功");
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            return "发送短信成功了";
        /*}else{
            return Result.error().message("发送短信失败了");
        }*/

    }

}

/**
 *一切顺心
 */