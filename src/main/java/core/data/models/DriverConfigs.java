package core.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

/**
 * Created by Vladimir Garkin on 2/23/18
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "device.name",
        "platform.name",
        "platform.version",
        "app",
        "udid",
})
public class DriverConfigs {

    @JsonProperty("device.name")
    private String deviceName;

    @JsonProperty("platform.name")
    private String platformName;

    @JsonProperty("platform.version")
    private String platformVersion;

    @JsonProperty("app")
    private String app;

    @JsonProperty("udid")
    private String udid;
}