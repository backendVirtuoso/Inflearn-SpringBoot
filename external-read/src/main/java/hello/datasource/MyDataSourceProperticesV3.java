package hello.datasource;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.util.List;

@Getter
@ConfigurationProperties("my.datasource")
@Validated
public class MyDataSourceProperticesV3 {
    @NotEmpty
    private String url;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private Etc etc;

    public MyDataSourceProperticesV3(Etc etc, String password, String url, String username) {
        this.etc = etc;
        this.password = password;
        this.url = url;
        this.username = username;
    }

    @Getter
    public static class Etc  {
        @Min(1)
        @Max(999)
        private int maxConnection;

        @DurationMin(seconds = 1)
        @DurationMax(seconds = 60)
        private Duration timeout;

        private List<String> options;

        public Etc(int maxConnection, @DefaultValue("DEFAULT") List<String> options, Duration timeout) {
            this.maxConnection = maxConnection;
            this.options = options;
            this.timeout = timeout;
        }
    }
}
