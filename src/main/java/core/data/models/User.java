package core.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "environment",
        "email",
        "iOSEmail",
        "androidEmail",
        "password",
        "name",
        "surname",
        "gender",
        "birthday",
        "phone",
})
public class User {
    @JsonProperty("environment")
    private String environment;

    @JsonProperty("email")
    private String email;

    @JsonProperty("iOSEmail")
    private String iOSEmail;

    @JsonProperty("androidEmail")
    private String androidEmail;

    @JsonProperty("password")
    private String password;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("phone")
    private String phone;
}