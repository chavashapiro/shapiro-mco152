package shapiro.nypl;

public class Result {
	private String apiItemURL;
	private String title;

	public String getApiItemURL() {
		return apiItemURL;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		String listTitle;

		if (title.length() > 30) {
			listTitle = title.substring(0, 29);
		} else {
			listTitle = title;
		}

		return listTitle;
	}
}
