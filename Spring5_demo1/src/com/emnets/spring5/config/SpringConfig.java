package com.emnets.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lannisite
 * @program SpringConfig
 * @description 描述
 * @date 2023/2/10 15:24
 */

@Configuration      //  作为配置类，替代配置文件
@ComponentScan(basePackages = {"com.emnets.spring5"})
public class SpringConfig {

}
