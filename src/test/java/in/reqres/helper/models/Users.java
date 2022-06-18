package in.reqres.helper.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
	private int id;
	private String email;
	private String first_name;
	private String last_name;
	private String avatar;
}
