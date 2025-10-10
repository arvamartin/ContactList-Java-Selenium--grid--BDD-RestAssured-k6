package framework.core.utils;

public enum Constants {

    BASE_URI("https://thinking-tester-contact-list.herokuapp.com"),
    SCR_SHOT_PATH("screenshots/"),
    JSON_FILE_PATH("json/"),
    CONTACTS_PARAM ("/contacts/"),
    CONFIG_FILE_PATH ("config.properties");


    private final String value;


    Constants(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}