package com.example.demo.service.impl;/**
 * @description:
 * @author: ManolinCoder
 * @time: 2022/9/28
 */

import com.aliyun.tea.TeaException;
import com.example.demo.service.IAliyunNoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 *@Auther 月鸟石 2022/9/28 10:45:37
 *联系方式(QQ)：3054578922
 *周三 
 *欢迎回家，主人
 */
@Service
@Slf4j
public class AliyunNoteServiceImpl implements IAliyunNoteService {


    
    //两者须在aliyun官网自行获取
    private static final String  accessKeyId = "*****************";

    private static final String accessKeySecret = "*************************";


    @Override
    public boolean send(String phone, String code) {
        com.aliyun.dysmsapi20170525.Client client = null;
        try {
            client = AliyunNoteServiceImpl.createClient(accessKeyId, accessKeySecret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("创建短信模板");
        com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
                .setSignName("阿里云短信测试")
                .setTemplateCode("SMS_154950909")
                .setPhoneNumbers(phone)
                .setTemplateParam("{\"code\":\"" + code + "\"}");
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        log.info("短信模板创建成功");
        try {
            // 复制代码运行请自行打印 API 的返回值
            log.info("开始发送短信");
            client.sendSmsWithOptions(sendSmsRequest, runtime);
            log.info("短信发送成功");
            return true;
        } catch (TeaException error) {
            // 如有需要，请打印 error
            com.aliyun.teautil.Common.assertAsString(error.message);

        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 如有需要，请打印 error
            com.aliyun.teautil.Common.assertAsString(error.message);
        }
        return false;
    }


    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }
}

/**
 *一切顺心
 */
