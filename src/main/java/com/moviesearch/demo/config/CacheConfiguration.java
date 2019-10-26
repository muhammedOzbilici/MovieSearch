package com.moviesearch.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfiguration extends CachingConfigurerSupport {

    private static final Logger logger = LoggerFactory.getLogger(CacheConfiguration.class);

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("movies")
        ));

        return cacheManager;
    }

    @CacheEvict(allEntries = true, cacheNames = {"movies"})
    @Scheduled(fixedDelay = 600000)
    public void cacheEvict() {
        logger.info("Cache flushed");
    }
}
