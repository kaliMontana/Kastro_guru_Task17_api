package in.reqres.helper.dataProviders;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApiBodyRequests {

	CREATE_BODY(
			"{ \"name\": \"Sapiens\","
					+ " \"job\": \"Team leader\" }"
	),
	UPDATE_BODY(
			"{ \"name\": \"Sapiens\","
					+ " \"job\": \"Director\" }"
	),
	UNSUCCESSFUL_REGISTRATION_BODY(
			"{ \"password\": \"pistol\" }"
	);


	private final String value;
}
