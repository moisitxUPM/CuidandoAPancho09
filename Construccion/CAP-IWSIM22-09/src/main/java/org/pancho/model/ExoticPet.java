package org.pancho.model;

/** */
public class ExoticPet extends Pet {
	/** */
	private String legalPermission;

	/** */
	private String healthCertificate;

	/** */
	private String originCertificate;

	/** */
	public ExoticPet(String RIACCode, String name, String address, String description, int policyNumber, String type, String legalPermission, String healthCertificate, String originCertificate, Owner owner) {
		super(RIACCode, name, address, description, policyNumber, type, owner);
		this.legalPermission = legalPermission;
		this.healthCertificate = healthCertificate;
		this.originCertificate = originCertificate;
	}
}
