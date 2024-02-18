package org.example.springclientredis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

@Configuration
public class RedisConfig {

    /*
    * JEDIS CONFIGURATION
    * */

   /* @Bean
    public JedisConnectionFactory jedisConnectionFactory(
        @Value("${spring.data.redis.host}") String host) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(6379);

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);
        poolConfig.setTestWhileIdle(true);
        JedisClientConfiguration.JedisClientConfigurationBuilder clientConfiguration = JedisClientConfiguration.builder();
        clientConfiguration.usePooling().poolConfig(poolConfig);
        clientConfiguration.connectTimeout(Duration.ofMillis(100000));
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }*/


    /*
    * LETTUCE CONFIGURATION
    * */

    /* @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
        return new LettuceConnectionFactory("localhost", 6379);
    }*/

    @Bean
    public Config redissonConfig() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        return config;
    }

    @Bean
    public RedissonClient redisson(Config config) {
        return Redisson.create(config);
    }
}
