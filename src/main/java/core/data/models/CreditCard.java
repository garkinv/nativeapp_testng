package core.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "environment",
        "cardNumber",
        "expDate",
        "cvc",
})
public class CreditCard {
    @JsonProperty("environment")
    private String environment;

    @JsonProperty("cardNumber")
    private String cardNumber;

    @JsonProperty("expDate")
    private String expDate;

    @JsonProperty("cvc")
    private String cvc;
}