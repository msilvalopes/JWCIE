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
}
