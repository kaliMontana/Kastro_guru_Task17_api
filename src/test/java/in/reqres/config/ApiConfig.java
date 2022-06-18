package in.reqres.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/test.properties"
})
public interface ApiConfig extends Config {

    @Config.Key("base.url")
    String getBaseUrl();

    @Config.Key("create.service.path")
    String getCreateService();

    @Config.Key("service.path")
    String getService();

    @Config.Key("registration.service.path")
    String getRegistrationService();

    @Config.Key("users.service.path")
    String getUsersService();
}
