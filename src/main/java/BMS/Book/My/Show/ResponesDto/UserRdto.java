package BMS.Book.My.Show.ResponesDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserRdto {

    private String name;

    private String mobile;
}
