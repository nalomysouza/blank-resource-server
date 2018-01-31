package br.gov.ce.secult.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {
	private final String id;
	private final String firstName;
	private final String givenName;
	private final String email;
	private final String picture;

	@JsonCreator
	public UserInfo(@JsonProperty("id") String id, @JsonProperty("first_name") String firstName,
			@JsonProperty("given_name") String givenName, @JsonProperty("email") String email,
			@JsonProperty("picture") String picture) {
		this.id = id;
		this.firstName = firstName;
		this.givenName = givenName;
		this.email = email;
		this.picture = picture;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getGivenName() {
		return givenName;
	}

	public String getEmail() {
		return email;
	}

	public String getPicture() {
		return picture;
	}

}
