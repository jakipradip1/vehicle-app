package com.jakipradip.dao;

public class GetMinOrMax {
	private static Long getMinOrMax(final Long id, final int numberLength, final String s) {
		String stringId = id.toString();
		int length = stringId.length();
		for (int i = 0; i < numberLength - length; i++) {
			stringId += s;
		}
		return new Long(stringId);
	}

	public static Long getMax(final Long id, final int numberLength) {
		return getMinOrMax(id, numberLength, "9");
	}

	public static Long getMin(final Long id, final int numberLength) {
		return getMinOrMax(id, numberLength, "0");
	}

}
