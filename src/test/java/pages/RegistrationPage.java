package pages;


import framework.core.BasePage;
import framework.core.utils.ErrorHandling;


public class RegistrationPage extends BasePage {

    private final ErrorHandling errorHandling = new ErrorHandling(driver);


    public boolean isErrorMessageDisplayed(){
       return errorHandling.isErrorMessageDisplayed();
    }


}
