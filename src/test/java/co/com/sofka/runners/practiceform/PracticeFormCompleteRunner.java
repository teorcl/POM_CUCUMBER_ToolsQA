package co.com.sofka.runners.practiceform;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = {"pretty","html:target/cucumber-report/cucumber.html"},
        features = {"src/test/resources/features/webui/practiceform/practiceformcomplete.feature"},
        glue = {"co.com.sofka.stepdefinitions.practiceformcomplete"}
)
public class PracticeFormCompleteRunner {
    //Aquí se pueden hacer configuaraciones previas antes del test(antes de los stepdefinitions)
    //Por ejemplo una generacion de datos previos al test(excel...)
    //Usando @Beforeclass, Afte....
}
