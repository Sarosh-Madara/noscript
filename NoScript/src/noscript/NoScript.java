/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noscript;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;
import modal.Token;

/**
 *
 * @author saroshmadara
 */
public class NoScript {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList<Token> tokens = new ArrayList();
    static String input = "int a=10;";
   
    static String[] classParts = {"DT",".","ID","ASSIGN_OP","CONST",";"};
    static String[] DTs = {"int","float","char","string"};
    static String[] Ops = {">=","<=","=="};
    static String[] Const = {"INT_CONST","FLOAT_CONST","STRING_CONST","CHAR_CONST"};
    static char[] Br = {'=',' ',';','.'};
    static int counter = 0;
    
    
//    static ArrayList<String> ops = new ArrayList<>();
    static int ts = 0,te = 0;
    
//    my approach
    public static void main(String[] args){
//        ops.add("=");
//        ops.add(">=");
//        ops.add("<=");
        
        
        
        int ln = 1;
        
        String CP;
        char[] VP = new char[100];
        char[] newVP = new char[100];
        
        for(int i = 0; i< input.length(); i++){
            CP = null;
            
            
            
            if(check4Br(input.charAt(i))){
                
//                CP = check4DT(VP);
//                char[] newVP = refinedVP(VP,ts,te);
                
                
                System.out.println("Token: " + refinedVP(VP, ts, te) + "  Starts@: "+ts + "   Ends@: " +  (te-1) );
                
                
                // check for DTs
                if((CP = check4DT(refinedVP(VP, ts, te)))  != null){
                    
                    tokens.add(new Token(ln, CP, newVP));
                    ts = i+1;
                    
                    te = 0;
                    
                    System.err.println("checking 4 DT");
                }
//                else if( (CP = check4Ops(newVP)) != null){
//                    tokens.add(new Token(ln, CP, VP));
//                    ts = i+1;
//                    te = 0;
//                    System.err.println("checking 4 Operators");
//                }
//                else if(input.charAt(i) == newVP[0]){
//                    CP = "ID";
//                    tokens.add(new Token(ln, CP, ewVP));
//                    ts = i+1;
//                    te = 0;
//                    System.err.println("checking 4 ID");
//                }
                // when equal comes as a breaker
                else if(input.charAt(i) == '='){
                // firstly check if successive is =
                    if( i+1 < input.length()-1 && input.charAt(i+1) == '=' ){
                        
//                        VP[te] = input.charAt(i);

                        newVP[te] = input.charAt(i);
                        te++;
                        VP = new char[100]; // whenever breaker comes there should be new Array for VP
                        
                    }else if(input.charAt(i) == '=' && input.charAt(i-1) == '=' ){
                        check4ReslOp();
                        te = 0;
                    }else if(input.charAt(i) == ' '){
                        
                    }
                    
//                    tokens.add(new Token(ln, CP, newVP));
//                    ts = i+1;
//                    te = 0;
//                    System.err.println("checking 4 Const");
                    
                }
                else if(newVP[0] == ';'){
                    tokens.add(new Token(ln, "STATE_TER", newVP));
                }
                else if(newVP[0] == ' '){
                    ts = i + 1;
                    te = 0;
                }
//                else{
//                    ts = i;
//                    te = 0;
//                }
                else if(IS_ID(newVP)){
                    
                }else if(IS_INT_CONST(newVP)){
                    
                }else if(IS_FLOAT_CONST(newVP)){
                    
                }else if(IS_CHAR_CONST(newVP)){
                    
                }
                
                
                
            }else{
                VP[te] = input.charAt(i);
                te++;
            }
        }
        
        
        
        System.out.println(tokens);
        
    }

    private static String check4DT(char[] VP) {
        for (String DT : DTs) {
            char[] temp = DT.toCharArray();
            if(Arrays.equals(temp, VP))
                return "DT";
        }
        return null;
    }
    
    private static String check4RelOp(char[] VP){
        for(String Op: Ops)
            if(Op.equalsIgnoreCase(VP)){
                return Op;
            }
        return null;
    }
    
    
    private static String check4Const(String VP){
        if(VP.matches("^-?[0-9]+(\\.[0-9]+)?$"))
            return "INT_CONST";
        else
            return null;
    }
    
    private static boolean check4Br(char c){
        for(int i = 0; i<Br.length; i++){
            if(Br[i] == c){
                return true;
            }
        }
        return false;
    }

    private static char[] refinedVP(char[] VP, int ts, int te) {
        char[] temp = new char[te];
        System.arraycopy(VP, 0, temp, 0, VP.length);
        return temp;
    }
    
    public static boolean isInteger(String str) {
        return str.matches("^-?[0-9]+(\\.[0-9]+)?$");
    }

    private static boolean IS_ID(char[] newVP) {
        return true;
    }

    private static boolean IS_INT_CONST(char[] newVP) {
        return true;
    }

    private static boolean IS_FLOAT_CONST(char[] newVP) {
        return true;
    }

    private static boolean IS_CHAR_CONST(char[] newVP) {
        return true;
    }
    
}
