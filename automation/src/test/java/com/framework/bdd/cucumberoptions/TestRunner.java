/**
 * 
 */
package com.framework.bdd.cucumberoptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author deepak
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/framework/bdd/features"}, 
glue = {"com/framework/bdd/stepdefinitions"})
public class TestRunner {

}
