package co.com.sofka.stepdefinitions.practiceformcomplete;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.practiceform.PracticeForm;
import co.com.sofka.page.practiceformcompletepage.PracticeFormCompletePage;
import co.com.sofka.stepdefinitions.setup.WebUI;
import co.com.sofka.util.Gender;
import co.com.sofka.util.Hobbies;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class PracticeFormCompleteStepDefinitions extends WebUI {

    //========Atributos=========
    PracticeFormModel practiceFormModel;
    private static final Logger LOGGER = Logger.getLogger(PracticeFormCompleteStepDefinitions.class);
    PracticeFormCompletePage practiceFormCompletePage; //Esta es la page
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";

    //======================================================================

    @Given("que el empleado admin se encuentra en el sitio web donde se hace el registro de los estudiantes")
    public void queElEmpleadoAdminSeEncuentraEnElSitioWebDondeSeHaceElRegistroDeLosEstudiantes() {
        try {
            //Codigo de lo que dice el paso es decir que el empleado admin se encuentra en el sitio web de los registros de los estudiantes
            generalSetUp();
            dataConfiguration();

        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());

        }
    }

    @When("el empleado admin ingresa todos los datos del formulario y confirma la accion")
    public void elEmpleadoAdminIngresaTodosLosDatosDelFormularioYConfirmaLaAccion() {
        try{
            practiceFormCompletePage = new PracticeFormCompletePage(driver, practiceFormModel, TEN_SECONDS.getValue());
            practiceFormCompletePage.fillStudentFormUsingAllFilds();
        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema deberia mostrar por pantalla el registro del estudiante ingresado con todos los campos")
    public void elSistemaDeberiaMostrarPorPantallaElRegistroDelEstudianteIngresadoConTodosLosCampos() {
        try {
            Assertions.assertEquals(
                    expected(),
                    practiceFormCompletePage.isRegistrationDone(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }

    }

    //Funciones comunes:
    private void dataConfiguration(){
        practiceFormModel = new PracticeFormModel();
        practiceFormModel.setName("Teodoro");
        practiceFormModel.setLastName("Calle");
        practiceFormModel.setEmail("teo@gmail.com");
        practiceFormModel.setGender(Gender.MALE);
        practiceFormModel.setNumberPhone("3144567895");
        practiceFormModel.setDay("30");
        practiceFormModel.setMonth("September");
        practiceFormModel.setYear("1996");
        practiceFormModel.setSubjects(new ArrayList<String>(Arrays.asList("Math", "English", "Biology")));
        practiceFormModel.setHobbies(Hobbies.MUSIC);
        practiceFormModel.setPicture("src/test/resources/images/practiceform/happy.jpg");
        practiceFormModel.setCurrentAddress("Calle 123");
        practiceFormModel.setState("Haryana");
        practiceFormModel.setCity("Karnal");
    }



    //Esto sería mi valor "teorico"
    private List<String> expected(){
        List<String> submitedFormResult = new ArrayList<String>();
        submitedFormResult.add(practiceFormModel.getName() + " " + practiceFormModel.getLastName());
        submitedFormResult.add(Gender.MALE.getGenero());
        submitedFormResult.add(practiceFormModel.getNumberPhone());
        return submitedFormResult;
    }



}
