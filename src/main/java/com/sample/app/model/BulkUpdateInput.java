package com.sample.app.model;

import java.util.Set;

public class BulkUpdateInput {

	private Set<Integer> set;
	private String address;

	public Set<Integer> getSet() {
		return set;
	}

	public void setSet(Set<Integer> set) {
		this.set = set;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
