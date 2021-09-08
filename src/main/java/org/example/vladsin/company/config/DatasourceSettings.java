package org.example.vladsin.company.config;

import org.springframework.beans.factory.annotation.Value;

public class DatasourceSettings {

    @Value("${url}")
    private final String url = "jdbc:mysql://localhost:3306/company?profileSQL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow&characterEncoding=UTF-8";

    @Value("${name}")
    private final String user = "VladSin";

    @Value("${password}")
    private final String password = "VladSinSQL_8022";

    @Value("${driver}")
    private final String driver = "com.mysql.cj.jdbc.Driver";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDriver() {
        return driver;
    }
}
