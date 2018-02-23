package core.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.util.List;

/**
 * Created by Vladimir Garkin on 2/23/18
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "user",
        "creditCard",
        "address",
})
public class TestData {
    @JsonProperty("user")
    private List<User> users;

    @JsonProperty("creditCard")
    private List<CreditCard> creditCards;

    @JsonProperty("address")
    private List<Address> addresses;
}