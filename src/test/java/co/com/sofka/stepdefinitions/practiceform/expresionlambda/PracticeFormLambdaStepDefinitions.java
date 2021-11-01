package co.com.sofka.stepdefinitions.practiceform.expresionlambda;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.practiceform.PracticeForm;
import co.com.sofka.stepdefinitions.setup.WebUI;
import co.com.sofka.util.Gender;
import io.cucumber.java8.En;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormLambdaStepDefinitions extends WebUI implements En {

    //========Atributos=========
    PracticeFormModel practiceFormModel;
    PracticeForm practiceForm;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";

    //Se cra constructor vacio y dentro el codigo lambda
    public PracticeFormLambdaStepDefinitions() {

        //=======================================PASOS========================================
        Given("que el empleado admin se encuentra en el sitio web de los registros de los estudiantes", () -> {
            try {
                //Codigo de lo que dice el paso es decir que el empleado admin se encuentra en el sitio web de los registros de los estudiantes
                generalSetUp();
                //Crear el obejto de tipo PracticeFormModel(objeto del formulario), valor teorico
                practiceFormModel = new PracticeFormModel();
                practiceFormModel.setName("Teodoro");
                practiceFormModel.setLastName("Calle");
                practiceFormModel.setGender(Gender.MALE);
                practiceFormModel.setNumberPhone("3127723718");
            }catch (Exception exception){
                quitDriver();
            }
        });

        //=======================================PASOS========================================
        When("el empleado admin ingresa los datos en los campos obligatorios y confirma la accion", () -> {
            //Pasos el empleado admin ingresa los datos en los campos obligatorios y confirma la accion, aquí se suelen pasar las page
            try{
                practiceForm = new PracticeForm(driver,practiceFormModel);//El driver aquí es el que se herada cuando en WebUI se setean las configuraciones
                //El objeto practiceFormModel lo inicialice en el given
                practiceForm.fillStudentForm();
            }catch (Exception exception){
                quitDriver();
            }
        });

        //=======================================PASOS========================================
        Then("el sistema deberia mostrar por pantalla el registro del estudiante ingresado", () -> {
            //Aquí van los assertions es decir comparar los valores reales con los teoricos
            try {
                Assertions.assertEquals(forSubmittedForm(), practiceForm.isRegistrationDone(), ASSERTION_EXCEPTION_MESSAGE);
            }catch (Exception exception){
                quitDriver();
            }
            finally {
                quitDriver();
            }
        });

    }


    //Esto sería mi valor "teorico"
    private List<String> forSubmittedForm(){
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(practiceFormModel.getName() +" "+ practiceFormModel.getLastName());
        submitedFormResult.add(practiceFormModel.getGender().getGenero());
        submitedFormResult.add(practiceFormModel.getNumberPhone());
        return submitedFormResult;
    }

}
