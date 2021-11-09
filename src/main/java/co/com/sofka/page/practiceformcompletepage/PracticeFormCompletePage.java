package co.com.sofka.page.practiceformcompletepage;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import co.com.sofka.page.practiceform.PracticeForm;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class PracticeFormCompletePage extends CommonActionsOnPages {

    PracticeFormModel practiceFormModel;//Para llenar los campos de un objeto formulario
    private static final Logger LOGGER = Logger.getLogger(PracticeForm.class);
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //======================================================================//
    //==Rutas de los elementos que requiere sikulix para detectar donde clickear
    //=======================================================================
    private static final String ATTACHMENT_FILE_PATCH = USER_DIR.value() + "\\src\\test\\resources\\images\\practiceformcomplete\\happy.jpg";
    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\page\\practiceformcomplete\\";
    private static final String SELECT_PICTURE_PATCH = PAGE_BASE_PATCH + "selectPicture.PNG";
    private static final String SELECT_OPEN_PATCH = PAGE_BASE_PATCH + "openWindows.PNG";
    private static final String FILE_NAME_TEXT_BOX_PATCH = PAGE_BASE_PATCH + "fileNameWindows.PNG";


    //**Localizadores------------------------------------------------------------*/
    //**=========================================================================
    private final By name = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By genderMale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label");
    private final By genderFemale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label");
    private final By genderOther = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label");
    private final By userNumberMobile = By.id("userNumber");
    private final By btnSubmit = By.id("submit");
    private final By userEmail = By.id("userEmail");
    private final By dateOfBirthInput = By.id("dateOfBirthInput");
    private final By subjects = By.id("subjectsInput");
    private final By hobbiesSports = By.xpath("//label[text()='Sports']");
    private final By hobbiesReading = By.xpath("//label[text()='Reading']");
    private final By hobbiesMusic = By.xpath("//label[text()='Music']");
    private final By selectFileToUpload = By.id("uploadPicture");
    private final By currentAddress = By.id("currentAddress");
    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");


    //===LOCATOR FALTANTES PARA EL FORMULARIO COMPLETO===


    //Localizadores--para--validar--los--datos--del--registro-------------------
    //=======================================================================//
    private final By assertionStudentName = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]");
    private final By assertionGender = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]");
    private final By assertionMobile = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]");
    private final By assertionStudentEmail =       By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[2]");
    private final By assertionStudentDateOfBirth = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[2]");
    private final By assertionSubjects =           By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[6]/td[2]");
    private final By assertionHobbies =            By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[7]/td[2]");
    private final By assertionPicture =            By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[8]/td[2]");
    private final By assertionAddress =            By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[9]/td[2]");
    private final By assertionStateAndCity =       By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[10]/td[2]");



    public PracticeFormCompletePage(WebDriver driver, PracticeFormModel practiceFormModel, int secondsForExplicitWait) {
        super(driver, secondsForExplicitWait);
        if(practiceFormModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);

        this.practiceFormModel = practiceFormModel;
    }

    //=====================================Metodos===============================//
    //==Metodo para escribir o pasar paramatros

    public void fillStudentFormUsingAllFilds() {
        try{
            scrollTo(name);
            withExplicitWaitClear(name);
            withExplicitWaitTypeInto(name, practiceFormModel.getName());

            scrollTo(lastName);
            withExplicitWaitClear(lastName);
            withExplicitWaitTypeInto(lastName, practiceFormModel.getLastName());

            scrollTo(userEmail);
            withExplicitWaitClear(userEmail);
            withExplicitWaitTypeInto(userEmail, practiceFormModel.getEmail());

            switch (practiceFormModel.getGender()){
                case MALE:
                    scrollTo(genderMale);
                    clickOn(genderMale);
                    break;

                case FEMALE:
                    scrollTo(genderFemale);
                    clickOn(genderFemale);
                    break;

                case OTHER:
                    scrollTo(genderOther);
                    clickOn(genderOther);
                    break;

                default:
            }

            scrollTo(userNumberMobile);
            withExplicitWaitClear(userNumberMobile);
            withExplicitWaitTypeInto(userNumberMobile, practiceFormModel.getNumberPhone());

            scrollTo(dateOfBirthInput);
            clickOn(dateOfBirthInput);

            //Poner o seleccionar fechas de manera dinamica clase POM cucumber 2 minuto 1:50:00
            clickOn(By.xpath("//option[. = '" + practiceFormModel.getYear() + "']"));
            clickOn(By.xpath("//option[. = '" + practiceFormModel.getMonth() + "']"));
            clickOn(By.xpath("//div[contains(@aria-label,'" + practiceFormModel.getDay() + "') and contains(@aria-label, '" + practiceFormModel.getMonth() + "')]"));

            scrollTo(subjects);
            for (String element : practiceFormModel.getSubjects()) {
                withExplicitWaitTypeInto(subjects, (CharSequence) element);
                withExplicitWaitTypeInto(subjects, Keys.TAB);
            }

            switch (practiceFormModel.getHobbies()){
                case SPORTS:
                    scrollTo(hobbiesSports);
                    clickOn(hobbiesSports);
                    break;

                case READING:
                    scrollTo(hobbiesReading);
                    clickOn(hobbiesReading);
                    break;

                case MUSIC:
                    scrollTo(hobbiesMusic);
                    clickOn(hobbiesMusic);
                    break;

                default:
            }

            clickOn(SELECT_PICTURE_PATCH);
            insertInto(FILE_NAME_TEXT_BOX_PATCH, ATTACHMENT_FILE_PATCH);
            clickOn(SELECT_OPEN_PATCH);

            scrollTo(currentAddress);
            withExplicitWaitClear(currentAddress);
            withExplicitWaitTypeInto(currentAddress, practiceFormModel.getCurrentAddress());

            scrollTo(state);
            withExplicitWaitTypeInto(state, practiceFormModel.getState(), Keys.TAB);

            scrollTo(city);
            withExplicitWaitTypeInto(city, practiceFormModel.getCity(), Keys.TAB);

            scrollTo(btnSubmit);
            clickOn(btnSubmit);

        } catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
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
