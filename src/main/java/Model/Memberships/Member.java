package Model.Memberships;

import Model.HaveID;
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
@JsonPropertyOrder({"id","name", "status", "phone", "point"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Member extends HaveID implements Serializable {
    private static final long serialVersionUID = 2L;
@JsonProperty("id")
    private final String ID;
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



    public Member(String ID, @NonNull String Name, @NonNull String Phone){
        this.ID = ID;
        this.Name = Name;
        this.Phone = Phone;
    }

    public void addPoint(int amount) {
        setPoint(Point+amount);
    }
    public void resetPoint() {
        setPoint(0);
    }

    @JsonCreator
    public static Member JacksonCreate(
            @JsonProperty("id") String ID,
            @JsonProperty("name") String name,
            @JsonProperty("phone") String phone
    )
    {
        return new Member(ID, name, phone);
    }
}