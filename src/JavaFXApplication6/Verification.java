package JavaFXApplication6;

import static ControllersAndFxml.Index.db;

public class Verification {
    static String UsernameTecher = "12345678";
    static String PWDTeacher = "12345678";
    static String UsernameAssistant = "assistant";
    static String PWDAssistant = "assistant";
    public static String chosenGroup;
    
    public static String verifyInfo(String Username, String PWD){
        if(Username.equals(UsernameTecher) && PWD.equals(PWDTeacher)){
            return "teacher";
        }
        else if(Username.equals(UsernameAssistant) && PWD.equals(PWDAssistant)){
            return "assistant";
        }
        else{
            return "not a user";
        }
    }
    public static boolean checkPin(int pin){
        if(pin == db.getGroupPin(chosenGroup)){
            return true;
        }
        else{
//5802  
            return false;
        }
    }
}
