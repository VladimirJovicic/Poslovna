package pi.vezbe.DTO;

public class CityDTO {

	private Long id;
	private String code;
	private String name;
	private String postalCode;
	private Long countryId;
	private String countryName;

	public CityDTO() {}

	public CityDTO(String code, String name, String postalCode,
			Long countryId, String countryName) {

		this.code = code;
		this.name = name;
		this.postalCode = postalCode;
		this.countryId = countryId;
		this.countryName=  countryName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
