package com.github.springcloudhystrix.dao.impl;

import com.github.springcloudhystrix.dao.IRemoteDao;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 16:37 2019-04-16
 * 项目名称 spring-cloud-hystrix
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Repository
public class RemoteDaoImpl implements IRemoteDao {

    @Resource
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "defaultHystrix",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "100"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "100")
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "800"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "10"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "10000"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "48000")
            }
    )
    public Boolean getHttpStatus(String url) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        int code = responseEntity.getStatusCodeValue();
        return 200 == code;
    }

    /**
     * 超时或者错误 默认进入的方法
     *
     * @param url 请求的URL
     * @return Boolean
     */
    @SuppressWarnings("unused")
    public Boolean defaultHystrix(String url) {
        log.info("超时或者错误:" + url);
        return false;
    }

}
