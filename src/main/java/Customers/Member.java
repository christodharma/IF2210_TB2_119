package Customers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonPropertyOrder({"customer", "status", "class", "phone", "point"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Member extends Membership implements Serializable {
    private static final long serialVersionUID = 22L;
@JsonProperty("customer")
    private final Customer customerRef;
@JsonProperty("name")
@NonNull
    private String Name;
@JsonProperty("phone")
@NonNull
    private String Phone;
@JsonProperty("point")
    private int Point = 0;
@JsonProperty("status")
    private boolean Status = true;
@JsonProperty(value = "class")
    private String Type = "Member";
    @Override
    public String getID()
    {
        return customerRef.getID();
    }

    public Member(Customer customerRef, String Name, String Phone){
        this.customerRef = customerRef;
        this.Name = Name;
        this.Phone = Phone;
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