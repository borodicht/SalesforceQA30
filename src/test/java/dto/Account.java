package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    private  String name;
    private String phone;
    private String fax;
    private String rating;
}
