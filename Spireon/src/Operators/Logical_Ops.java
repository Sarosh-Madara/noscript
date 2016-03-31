/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operators;

/**
 *
 * @author saroshmadara
 */
public class Logical_Ops {
    public static String check(char c){
        switch(c){
            case '&':
                return "AND";
            case '|':
                return "OR";
            default:
                return null;
        }
    }
    
}
