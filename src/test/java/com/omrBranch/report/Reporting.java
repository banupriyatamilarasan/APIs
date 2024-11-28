package com.omrBranch.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.omrBranch.baseClass.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting  extends BaseClass{
	public static void generateJVMReport(String jsonFileReport) {
		//1.Mention the path of jvm report where to store 
		File file = new File("C:\\Users\\vishn\\OneDrive\\Desktop\\eclipse\\OmrHotel\\target");
		//2. Create the Object for Configuration Class
		Configuration configuration=new Configuration(file,"omr Automation");
		//3.Pass the k,v,as Details--browser,os,versions,sprint
		configuration.addClassifications("OS", "WIN11");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Browser Version", "104");
		configuration.addClassifications("Sprint", "34");
		//4. Create the Object for ReportBuilder Class to read res from JSON File 
		List<String>jsonFiles=new ArrayList<>();
		jsonFiles.add(jsonFileReport);
		ReportBuilder builder=new ReportBuilder(jsonFiles,configuration);
		//5.generate the JVM Report
		builder.generateReports();
		
	}

}


