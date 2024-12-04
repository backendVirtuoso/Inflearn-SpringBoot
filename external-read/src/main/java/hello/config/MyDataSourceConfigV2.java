package hello.config;

import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourceProperticesV1;
import hello.datasource.MyDataSourceProperticesV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableConfigurationProperties(MyDataSourceProperticesV2.class)
public class MyDataSourceConfigV2 {
    private final MyDataSourceProperticesV2 propertices;

    public MyDataSourceConfigV2(MyDataSourceProperticesV2 propertices) {
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
