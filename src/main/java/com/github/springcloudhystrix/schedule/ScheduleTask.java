package com.github.springcloudhystrix.schedule;

import com.github.springcloudhystrix.dao.IRemoteDao;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 14:41 2019-04-16
 * 项目名称 spring-cloud-hystrix
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class ScheduleTask {

    @Resource
    private IRemoteDao server;

    @Scheduled(fixedRate = 1200)
    public void task() {
        System.out.println("---------------------------------------");
        System.out.println(server.getHttpStatus("http://127.0.0.1:9999/403"));
    }

}
