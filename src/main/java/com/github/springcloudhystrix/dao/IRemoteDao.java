package com.github.springcloudhystrix.dao;

/**
 * <p>
 * 创建时间为 16:36 2019-04-16
 * 项目名称 spring-cloud-hystrix
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IRemoteDao {

    /**
     * 查看请求的 URL http 状态码是否为 200
     *
     * @param url 请求的 URL,例如: http://www.baidu.com,https://www.baidu.com
     * @return Boolean
     */
    Boolean getHttpStatus(String url);

}
