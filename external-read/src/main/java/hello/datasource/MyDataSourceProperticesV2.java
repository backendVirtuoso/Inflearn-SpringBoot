package hello.datasource;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
@ConfigurationProperties("my.datasource")
public class MyDataSourceProperticesV2 {
    private String url;
    private String username;
    private String password;
    private Etc etc;

    public MyDataSourceProperticesV2(@DefaultValue Etc etc, String password, String url, String username) {
        this.etc = etc;
        this.password = password;
        this.url = url;
        this.username = username;
    }

    @Getter
    public static class Etc  {
        private int maxConnection;
        private Duration timeout;
        private List<String> options;

        public Etc(int maxConnection, @DefaultValue("DEFAULT") List<String> options, Duration timeout) {
            this.maxConnection = maxConnection;
            this.options = options;
            this.timeout = timeout;
        }
    }
}
