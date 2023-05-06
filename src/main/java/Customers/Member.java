package Customers;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@JsonPropertyOrder({"customer", "status", "class", "phone", "point", "discount"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Member extends Membership implements Serializable {
    private static final long serialVersionUID = 22L;
    @JsonProperty("customer") private final Customer customerRef;
    @JsonProperty("name") @NonNull private String Name;
    @JsonProperty("phone")@NonNull private String Phone;

    @JsonProperty("point") private int Point = 0;
    @JsonProperty("status") private boolean Status = true;
    @JsonProperty("discount")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double Discount = null;
    @JsonProperty(value = "class")
    public String isVIP(){
        if (Discount != null){
            return "VIP";
        } else {
            return "Member";
        }
    }
    @Override
    public String getID()
    {
        return customerRef.getID();
    }

    @JsonCreator
    public static Member JacksonCreate(
            @JsonProperty("customer") Customer customerRef,
            @JsonProperty("name") String name,
            @JsonProperty("phone") String phone
    )
    {
        return new Member(customerRef, name, phone);
    }
}