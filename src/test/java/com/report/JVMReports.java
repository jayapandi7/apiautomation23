package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReports {
	
	public static void generateJVMReport(String jsonFile) {
     File reportLoc=new File(System.getProperty("user.dir")+"\\target\\JVM_Reports");
     Configuration con=new Configuration(reportLoc,"OMRBranchGroceryAPIAutomation" );
     con.addClassifications("Platform","Windows10");
     con.addClassifications("Framework", "Cucumber-Junit");
     con.addClassifications("Guided by", "Mr.Velmurugan");
     con.addClassifications("Done by", "Mr.Jayapandi");
     List<String> li=new ArrayList<String>();
     li.add(jsonFile);
     ReportBuilder builder =new ReportBuilder(li, con);
     builder.generateReports();

	}

}
