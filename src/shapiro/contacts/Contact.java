package shapiro.contacts;

public class Contact implements Comparable<Contact> {
	private String name;
	private String email;
	private String phone;
	private Address address;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public Address getAddress() {
		return address;
	}

	public String getLastName() {
		String[] nameParts = name.split(" ");
		int length = nameParts.length;
		if (nameParts[length - 1].length() == 1) {
			return nameParts[length - 2];
		} else {
			return nameParts[length - 1];
		}
	}

	@Override
	public int compareTo(Contact other) {
		return getLastName().compareTo(other.getLastName());
	}

}
