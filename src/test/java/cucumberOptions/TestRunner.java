package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//specify the feature file location
		features="src/test/java/features",
		
		//specifiy spec definition location
		glue="stepDefinition",
		
		//specify if steps has to be enabled in report 
		stepNotifications = true,
		
		//specify tags if any particular test case has to be run
		// Tags will run alphabetical order
		
				tags=("@AppLoginSmoketest1 or @TransactionalSmoketest2"),
				//tags=("@Smoketest1 or @TiersSmoketest1"),
		
				//tags=("@AppLoginSmoketest1 or @MembersFilterSmoketest1"),
				//tags=("@AppLoginSmoketest1 or @MembersReportSmoketest1"),
		
		
		//tags = ("@AppLoginSmoketest1 or @TiersSmoketest1"), 
//tags=("@AppLoginSmoketest1 or @ReportSettingsSmoketest1 or @TransactionalSmoketest1 or @CommunicationReportSmoketest1 or @MembersReportSmoketest1 or @LogsSmoketest1 or @DownloadReportSmoketest1"),
		
	    		//tags=("@AppLoginSmoketest1 or @MembersReportSmoketest1"),
		
	    						//tags=("@AppLoginSmoketest1 or @TransactionalReportsSmoketest1 or @CommunicationReportsSmoketest1"),
	  //  tags=("@AppLoginSmoketest1 or @TransactionalReportsSmoketest1"),
//tags=("@AppLoginSmoketest1 or @ReportSettingsSmoketest1 or @TransactionalSmoketest1 or @CommunicationReportSmoketest1 or @MembersReportSmoketest1 or @LogsSmoketest1 or @MembersSmoketest1 or @MemberSearchFilterSmoketest1 or @TiersSmoketest1 or @ZConfigurationSmoketest1"),
		
	    	//  tags=("@AppLoginSmoketest1 or @LogsSmoketest1 or @DownloadReportSmoketest1"),
				
			//	tags=("@AppLoginSmoketest1 or @MembersSmoketest1 or @MemberSearchFilterSmoketest1 or @ConfigurationSmoketest1"),			
	    		  

		
		
		//for neat console output
		monochrome=true,

		//checks if mapping exist between feature and spec definition file and does not execute in real
		//dryRun=false,
				
		// to generate cucumber report in different format `q`
				
		plugin={"pretty","html:target/CucumberReport.html","json:target/cucumber.json",
				"junit:target/cucumber.xml","rerun:target/failedscenarios.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		
		//enable below plugin for extent adapter
		//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

		publish=true)
public class TestRunner{

}
