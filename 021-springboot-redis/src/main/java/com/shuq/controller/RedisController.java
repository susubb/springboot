package com.shuq.controller;


import com.shuq.vo.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.PublicKey;

@RestController
public class RedisController {

    /**
     *注入RedisTemplate
     *
     * RedisTemplate泛型
     * RedisTemplate<String,String>
     * RedisTemplate<Object,Object>
     * RedisTemplate
     *
     * 注意：RedisTemplate对象的默认名称 redisTemplate
     */
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //添加数据到redis
    @PostMapping("/redis/addstring")
    public String addToRedis(String name,String value){
        //操作Redis中String类型的数据，先获取ValueOperations对象
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //添加数据到redis
        valueOperations.set("myname","lisi");

        return "向redis添加String类型的数据";
    }

    //从redis获取数据
    @GetMapping("/redis/getk")
    public String getData(String k){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object v = valueOperations.get(k);
        return "key是"+ k + ",他的值是：" + v;
    }

    @PostMapping("/redis/{k}/{v}")
    public String addStringKV(@PathVariable String k ,
                              @PathVariable String v){
        //使用StringRedisTemplate对象
        stringRedisTemplate.opsForValue().set(k,v);
        return "使用StringRedisTemplate对象";
    }

    @GetMapping("/redis/getstr/{k}")
    public String getStringKV(@PathVariable String k){
        //使用StringRedisTemplate对象
        String v = stringRedisTemplate.opsForValue().get(k);
        return "k的value："+v ;
    }

    //设置RedisTemplate 序列化
    //可以设置 key 的序列化，也可以设置value的序列化
    //可以同时设置 key 和value 的序列化
    @PostMapping("/redis/addstr")
    public String addString(String k ,String v){
        //使用RedisTemplate
        //设置key 使用String的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置value 的序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        redisTemplate.opsForValue().set(k,v);
        return "定义RedisTemplate 对象的 key和value的序列化";
    }

    /**
     * 使用json序列化，把java对象转为json存储
     */
    @PostMapping("/redis/addjson")
    public String addJson(){
        Student student = new Student();
        student.setId(1001);
        student.setName("zhansan");
        student.setAge(20);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //把值作为json序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));
        redisTemplate.opsForValue().set("mystudent",student);

        return "json序列化";
    }

    @PostMapping("/redis/getjson")
    public String getJson(){

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //把值作为json序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));
        Object mystudent = redisTemplate.opsForValue().get("mystudent");

        return "json反序列化get" + mystudent.toString();
    }
}
