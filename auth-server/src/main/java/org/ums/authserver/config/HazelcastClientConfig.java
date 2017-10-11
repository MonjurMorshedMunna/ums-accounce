package org.ums.authserver.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastClientConfig {

    @Bean(destroyMethod = "shutdown")
    public HazelcastInstance clientInstance() throws Exception{
        return HazelcastClient.newHazelcastClient();
    }

    @Bean
    public ClientConfig clientConfig(){
        ClientConfig clientConfig = new ClientConfig();
        ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
        networkConfig.setConnectionAttemptLimit(0);
        return clientConfig;
    }
}
