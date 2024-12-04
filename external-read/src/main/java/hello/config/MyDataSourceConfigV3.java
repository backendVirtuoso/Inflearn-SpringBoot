package hello.config;

import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourceProperticesV2;
import hello.datasource.MyDataSourceProperticesV3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableConfigurationProperties(MyDataSourceProperticesV3.class)
public class MyDataSourceConfigV3 {
    private final MyDataSourceProperticesV3 propertices;

    public MyDataSourceConfigV3(MyDataSourceProperticesV3 propertices) {
        this.propertices = propertices;
    }

    @Bean
    public MyDataSource dataSource() {
        return new MyDataSource(
                propertices.getUrl(),
                propertices.getUsername(),
                propertices.getPassword(),
                propertices.getEtc().getMaxConnection(),
                propertices.getEtc().getTimeout(),
                propertices.getEtc().getOptions());
    }
}
