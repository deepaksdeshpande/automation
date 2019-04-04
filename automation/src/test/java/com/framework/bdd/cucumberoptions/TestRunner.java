/**
 * 
 */
package com.framework.bdd.cucumberoptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * @author deepak
 *
 */
// @RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/framework/bdd/features"}, 
glue = {"com/framework/bdd/stepdefinitions"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
