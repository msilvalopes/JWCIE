/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

/**
 *
 * @author Marcel
 */
public class Utils {
    public static Integer str_to_int(String str){
        try{
            return Integer.parseInt(str);
        }catch(Exception e){
            return null;
        }
    }

    public static Float str_to_float(String string) {
        try{
            return Float.parseFloat(string);
        }catch(Exception e){
            return null;
        }
    }

    public static String get_random_password() {
        String senha = "";
        for(int i=0;i<7;i++){
            senha = senha.concat(String.valueOf(Double.toString(Math.random()*10).charAt(0)));
        }
        return senha;
    }
}
