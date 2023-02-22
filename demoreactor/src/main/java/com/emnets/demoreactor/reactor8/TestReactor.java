package com.emnets.demoreactor.reactor8;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lannisite
 * @program TestReactor
 * @description 描述
 * @date 2023/2/22 10:50
 */

public class TestReactor {


    public static void main(String[] args) {
        //  使用了just方法，是一个比较直接的声明数据流的方法
        Flux.just(1,2,3,4).subscribe(System.out::println);
        Mono.just(1);

        //  其他方法声明
        //  数组
        Integer [] array = {1,2,3,4};
        Flux.fromArray(array);

        //  集合
        List<Integer> list = Arrays.asList(array);
        Flux.fromIterable(list);

        //  Stream流
        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream);

        //  错误信号示例
        Flux.error(new Exception("错误信号测试")).subscribe(System.out::println);
    }

}
