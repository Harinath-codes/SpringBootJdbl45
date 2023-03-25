package com.exampleredis.redisexamplejdbl45;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean
	public LettuceConnectionFactory getFactory() {

//	endpoint -- 	redis-14153.c305.ap-south-1-1.ec2.cloud.redislabs.com:14153

		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(
				"redis-14153.c305.ap-south-1-1.ec2.cloud.redislabs.com", 14153);

		redisStandaloneConfiguration.setPassword("kSWRwdlzAjebK7wX5wvRutWnrSij3kre");

		LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);

		return lettuceConnectionFactory;

	}

	@Bean
	public RedisTemplate<String, Object> getTemplate() {

		RedisTemplate<String, Object> redisTemp = new RedisTemplate<>();
		redisTemp.setKeySerializer(new StringRedisSerializer());
		redisTemp.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemp.setHashKeySerializer(new StringRedisSerializer());
		redisTemp.setHashValueSerializer(new JdkSerializationRedisSerializer());

		redisTemp.setConnectionFactory(getFactory());

		return redisTemp;

	}

}
