package com.java8;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		String name = null;
		Optional<String> newName = Optional.of(name+"sri");
		//System.out.println(newName.isPresent() ? newName.get() : "no");
		System.out.println(newName);
	}

}
