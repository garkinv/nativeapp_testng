package core.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "environment",
        "city",
        "province",
        "street",
        "floor",
        "code",
})
public class Address {
    @JsonProperty("environment")
    private String environment;

    @JsonProperty("city")
    private String city;

    @JsonProperty("province")
    private String province;

    @JsonProperty("street")
    private String street;

    @JsonProperty("floor")
    private String floor;

    @JsonProperty("code")
    private String code;
}