
public enum Gender {
	FEMALE("Female"), MALE("Male"), NA("N/A"); //set Enum for gender
	private final String value;

	private Gender(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	} //returns gender
}
