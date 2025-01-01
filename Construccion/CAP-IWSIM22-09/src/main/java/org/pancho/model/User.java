package org.pancho.model;

import org.pancho.model.enums.LanguageEnum;
import org.pancho.model.enums.ProviderType;
import utilidades.Cifrado;

/** */
public abstract class User implements IUser{
	/** */
	private final String id;
	/** */
	private static int counter = 0;
	/** */
	private String email;
	/** */
	private ProviderType oauth_provider;

	/** */
	private String oauth_id;

	/** */
	private String name;

	/** */
	private String address;

	/** */
	private LanguageEnum language;

	/** */
	private boolean loggedIn;

	public User(String name, String address, LanguageEnum language, String email) {
		this.id = Cifrado.cifrar(email);
		this.email = email;
		this.oauth_id = null;
		this.name = name;
		this.address = address;
		this.language = language;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ProviderType getOauthProvider() {
		return oauth_provider;
	}

	public void setOauthProvider(ProviderType oauth_provider) {
		this.oauth_provider = oauth_provider;
	}

	public String getOauthId() {
		return oauth_id;
	}

	public void setOauthId(String oauth_id) {
		this.oauth_id = oauth_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LanguageEnum getLanguage() {
		return language;
	}

	public void setLanguage(LanguageEnum language) {
		this.language = language;
	}
}