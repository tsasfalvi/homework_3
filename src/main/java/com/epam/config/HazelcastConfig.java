package com.epam.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class HazelcastConfig {

    private static final int TIME_TO_LIVE_SECONDS = 60 * 60 * 24;

    @Bean
    public Config config() {
        Config config = new Config();

        MapConfig mapConfig = createMapConfig();
        config.addMapConfig(mapConfig);

        return config;
    }

    private MapConfig createMapConfig() {
        // @formatter:off
        return new MapConfig("userIds")
                .setEvictionPolicy(EvictionPolicy.RANDOM)
                .setTimeToLiveSeconds(TIME_TO_LIVE_SECONDS);
        // @formatter:on
    }
}
