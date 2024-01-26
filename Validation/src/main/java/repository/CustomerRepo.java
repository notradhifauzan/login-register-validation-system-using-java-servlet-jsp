package repository;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepo {
	private Map<String, String> custDetails;

	public CustomerRepo() {
		custDetails = new HashMap<String, String>();

		custDetails.put("RadhiFauzan98", "Password@98");
		custDetails.put("MunirZaki98", "Password@98");
		custDetails.put("HadifSamry98", "Password@98");
	}

	public boolean isUsernameExist(String username) {
		/*
		 * you can use your DAO here
		 * 
		 * ex: custDAO.isUsernameExist(username);
		 * 
		 * */
		return custDetails.containsKey(username);
	}

	public boolean login(String username, String password) {
		if (this.isUsernameExist(username)) {
			return custDetails.get(username).equals(password);
		} else {
			return false;
		}
	}
}
