package com.app.utils;

import com.app.dto.MemberDetail;

public class CommonTestUtils {

	public static void main(String[] args) {
		MemberDetail obj = new MemberDetail();

		obj.getExecutedRules().add("Rule1");
		obj.getExecutedRules().add("Rule2");
		System.out.println("obj -> " + obj);
	}

}
