package framework.core.utils;

public enum Constants {

    BASE_URI("https://thinking-tester-contact-list.herokuapp.com"),
    CONFIG_FILE_PATH ("config.properties");

    private final String value;


    Constants(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}