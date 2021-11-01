package co.com.sofka.page.practiceform;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class PracticeForm extends CommonActionsOnPages {

    //**Atributos*/
    //private WebDriver driver; //Para usar los locators y los metodos en la web
    //Este ya no lo uso, porque usaré el heredado
    PracticeFormModel practiceFormModel;//Para llenar los campos de un objeto formulario

    //**Localizadores------------------------------------------------------------*/
    //**=========================================================================
    private final By name = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By genderMale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label");
    private final By genderFemale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label");
    private final By genderOther = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label");
    private final By userNumberMobile = By.id("userNumber");
    private final By btnSubmit = By.id("submit");

    //Localizadores--para--validar--los--datos--del--registro-------------------
    //=======================================================================//
    private final By assertionStudentName = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]");
    private final By assertionGender = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]");
    private final By assertionMobile = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]");

    //=====================================Metodos===============================//
    //============Construtor==============//
    public PracticeForm(WebDriver driver, PracticeFormModel practiceFormModel) {//Recibe un objeto del tipo model para usar sus atributos
        super(driver);
        this.practiceFormModel = practiceFormModel;
    }

    //=====================================Metodos===============================//
    //==Metodo para escribir o pasar paramatros

    public void fillStudentForm(){
        clear(name);
        type(name,practiceFormModel.getName());

        clear(lastName);
        type(lastName,practiceFormModel.getLastName());

        switch (practiceFormModel.getGender()){
            case MALE:
                clickOn(genderMale);
                break;
            case FEMALE:
                clickOn(genderFemale);
                break;
            case OTHER:
                clickOn(genderOther);
                break;
            default:
        }

        clear(userNumberMobile);
        type(userNumberMobile,practiceFormModel.getNumberPhone());

        doSubmit(btnSubmit);
    }

    //===Metodo para saber si ya se hizo el regitro
    // (Algo así como un valor experimental)
    public List<String> isRegistrationDone(){
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(getText(assertionStudentName).trim());
        submitedFormResult.add(getText(assertionGender).trim());
        submitedFormResult.add(getText(assertionMobile).trim());
        return submitedFormResult;
    }

}
