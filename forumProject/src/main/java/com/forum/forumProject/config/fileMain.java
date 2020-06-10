package com.forum.forumProject.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class fileMain {
	public static void main(String[] args) {

		try {
			File myObj = new File("output_boundary_revised.txt");
			/*
			 * if (myObj.createNewFile()) { System.out.println("File created: " +
			 * myObj.getName()); } else { System.out.println("File already exists."); }
			 */
			FileUtils.write(myObj, "testForUserSignUp=true", true);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
}
}
