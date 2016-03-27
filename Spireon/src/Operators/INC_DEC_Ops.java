/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operators;

import java.util.ArrayList;
import java.util.Arrays;
import modal.Token;

/**
 *
 * @author saroshmadara
 */
public class INC_DEC_Ops {
    public static String check(String str){
        switch(str){
            case "++":
            case "--":
                return "INC_DEC";
            default:
                return null;
        }
    }
    public static void main(String a[]){
//        ArrayList<Token> tokens = new ArrayList<>();
//        String s = "======;";
//        char[] vp = new char[100];
//        boolean noRead =false;
//        for(int i=0; i<s.length(); i++){
//            
//            
//            if(s.charAt(i) == '=' && i+1<s.length() && s.charAt(i+1) == '=' && !noRead){
//                noRead=true;
//                vp[0] = '=';
//            }else if(!noRead){
////                 System.out.println("didn't come");
//                char[] temp  ;
//                switch (s.charAt(i)) {
//                    case ' ':
//                        break;
//                    case ';':
//                        vp = new char[]{';'};
//                        tokens.add(new Token(1, "SEMI_COLON", vp));
//                        break;
//                    default:
//                        temp = new char[]{'='};
//                        tokens.add(new Token(1, "COMPARES", temp));
//                        break;
//                }
//            }
//            else if(s.charAt(i) == '=' && s.charAt(i-1) == '='){
//                vp[1] = '=';
//                char[] temp = Arrays.copyOfRange(vp, 0, 2);
//                tokens.add(new Token(1, "COMPARES", temp));
//                noRead = false;
//            }
//            
//        }
//        System.out.println(tokens);
       
    }
}
