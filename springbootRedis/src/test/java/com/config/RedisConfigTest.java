package com.config;

import com.domain.UserVo;
import com.service.RedisService;
import com.util.RedisKeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private ValueOperations<String,Object> valueOperations;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;

    @Resource
    private RedisService redisService;

    /**
     * 设置10秒后过期
     */
    @Test
    public void testExpire(){
        redisTemplate.opsForValue().set("key_epire","value_expire",10,TimeUnit.SECONDS);
    }


    @Test
    public void testObj() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("上海");
        userVo.setName("测试dfas");
        userVo.setAge(123);
        ValueOperations<String,Object> operations = redisTemplate.opsForValue();
        redisService.expireKey("name",10, TimeUnit.SECONDS);
        String key = RedisKeyUtil.getKey(UserVo.Table,"name",userVo.getName());
        operations.set(key,userVo);
        UserVo vo = (UserVo) operations.get(key);
        System.out.println(vo);
        System.out.println(vo);
    }

    @Test
    public void testValueOption( )throws  Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("上海");
        userVo.setName("jantent");
        userVo.setAge(23);
        valueOperations.set("test",userVo);

        System.out.println(valueOperations.get("test"));
    }

    @Test
    public void testSetOperation() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("北京2");
        userVo.setName("jantent");
        userVo.setAge(23);
        UserVo auserVo = new UserVo();
        auserVo.setAddress("上海2");
        auserVo.setName("antent");
        auserVo.setAge(23);
        setOperations.add("user:test2",userVo,auserVo);
        Set<Object> result = setOperations.members("user:test2");
        System.out.println(result);
    }

    @Test
    public void HashOperations() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
        hashOperations.put("hash:user",userVo.hashCode()+"",userVo);

        hashOperations.put("hash:user","address",userVo.getAddress());
        hashOperations.put("hash:user","name",userVo.getName());
        hashOperations.put("hash:user","age",userVo.getAge());

        System.out.println(hashOperations.get("hash:user",userVo.hashCode()+""));
        System.out.println(hashOperations.get("hash:user","address"+""));
        System.out.println(hashOperations.get("hash:user","name"+""));
        System.out.println(hashOperations.get("hash:user","age"+""));

    }

    @Test
    public void  ListOperations() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
        listOperations.leftPush("list:user",userVo);
//        System.out.println(listOperations.leftPop("list:user"));
        // pop之后 值会消失
        System.out.println(listOperations.leftPop("list:user"));
    }
}