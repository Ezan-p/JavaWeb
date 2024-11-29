package com.ezan;

import com.ezan.controller.DeptController;
import com.ezan.service.DeptService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class SpringbootwebTliasApplicationTests {

    @Autowired
    private DeptService deptService;


    @Test
    public void testUuid(){
        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    /**
     * JWT-生成 -----采用链式编程的思想
     */
    @Test
    public void testGenJWT(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","ezan");

        //生成秘钥
        //SecretKey key = Jwts.SIG.HS256.key().build();

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "EzanEzanEzanEzanEzanEzanEzanEzanEzanEzanEzanEzan")  //签名算法（自定义加入秘钥时，秘钥位数要多）
                .setClaims(claims)         //自定义内容，map数组（载荷）
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))      //令牌的有效期
                .compact();
        System.out.println(jwt);
    }

    /**
     * JWT-解析
     */
    /*
    @Test
    public void testParseJWT(){
        //将JWT令牌放到charSequence类型
        CharSequence jws = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiZXphbiIsImlkIjoxLCJleHAiOjE3MzE0OTYxMzl9.v_umKSgikXRLeifHtbUMVrUIqlBrBqsZfKli5adtNiU";
        //秘钥
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode("HfkjksFKLJISJFKLFKWJFQFIQWIOFJQOFFQGGSDGFFJIQOEUFIE" +
                "JFIOQWEFHFQOK5FKOIQWUFFEFE423FIQEOFJHUEWHFKASKDLQWJIFSJDJKFHJIJWO"));
        //解析JWT令牌

        //版本一
        Claims claims =Jwts.parser()
                .setSigningKey("HfkjksFKLJISJFKLFKWJFQFIQWIOFJQOFFQGGSDGFFJIQOEUFIE" +
                        "JFIOQWEFHFQOK5FKOIQWUFFEFE423FIQEOFJHUEWHFKASKDLQWJIFSJDJKFHJIJWO")
                        .build()
                                .parseClaimsJws(jws)
                                        .getBody();
        //版本二
        Claims claims = Jwts.parser()
                .verifyWith(secretKey)      //传递秘钥
                .build()
                .parseSignedClaims(jws) //传递JWT令牌参数
                .getPayload();      //获取有效载荷

        System.out.println(claims);
    }*/

    @Test
    public void TestAopDelete(){
        deptService.delete(5);
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testGetBean(){
        //获取bean的名称
        DeptController bean1 = (DeptController) applicationContext.getBean("deptController");
        System.out.println(bean1);
        //获取bean的类型
        DeptController bean2 = applicationContext.getBean(DeptController.class);
        System.out.println(bean2);
        //获取bean的名称和类型
        DeptController bean3 = applicationContext.getBean("deptController", DeptController.class);
        System.out.println(bean3);
    }

}
