/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noscript;
import java.util.ArrayList;
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
    static String input = "float a = 0;";
    static String[] classParts = {"DT",".","ID","ASSIGN_OP","CONST",";"};
    static String[] DTs = {"int","float","char","string"};
    static String[] Ops = {"=",">=","<="};
    static String[] Const = {"INT_CONST","FLOAT_CONST","STRING_CONST","CHAR_CONST"};
    
    
    static ArrayList<String> ops = new ArrayList<>();
    static int tokenStart = 0,tokenEnd = 0;
    
//    my approach
    public static void main(String[] args){
        
        ops.add("=");
        ops.add(">=");
        ops.add("<=");
        
        
        
        int ln = 1;
        
        
        
            
        for(int i = 0; i< input.length(); i++){
            if(input.charAt(i) == '.' || input.charAt(i) == ' ' || input.charAt(i) == ';'){
                String VP = input.substring(tokenStart, tokenEnd);
                System.out.println("Token: " + VP + "  Starts@: "+tokenStart + "   Ends@: " +  (tokenEnd-1) );
                
                
                String CP = null;
//                CP = check4DT(VP);
                
                
                if((CP = check4DT(VP))  != null){
                    
                    tokens.add(new Token(ln, CP, VP));
                    
                    tokenStart = i+1;
                    tokenEnd = 0;
                    
                    System.err.println("checking 4 DT");
                }else if( (CP = check4Ops(VP)) != null){
                    tokens.add(new Token(ln, CP, VP));
                    tokenStart = i+1;
                    tokenEnd = 0;
                    System.err.println("checking 4 Operators");
                }else if( "a".equalsIgnoreCase(VP)){
                    CP = "ID";
                    tokens.add(new Token(ln, CP, VP));
                    tokenStart = i+1;
                    tokenEnd = 0;
                    System.err.println("checking 4 ID");
                }else if(check4Const(VP) != null && input.charAt(i)==';'){
                    tokens.add(new Token(ln, CP, VP));
                    tokenStart = i+1;
                    tokenEnd = 0;
                    System.err.println("checking 4 Const");
                }else{
                    tokenStart = i;
                    tokenEnd = 0;
                }
                    
                
                
                
            }else{
                tokenEnd++;
            }
        }
        
        
        
        System.out.println(tokens);
        
    }
    
//    public static void main(String[] args) {
//        String[] keywords = {"int","float","char","string","double","long"};
//        
//        String streamReader = "public static void main(){ \n int a = 1; \n }",
//                longString = " DereK DS BS Banas CA AK 123456 PA (421)555-1212 johnsmith saroshmadara@gmail.com 421 555-1234 ",
//                strangeStr = "1Z aaa **** *** {{{ {{ { "
//                ;
//                
//        
////        regexChecker("[A-Za-z0-9._%-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}", longString);
////        regexChecker("([0-9]( |-)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?[0-9]{4}|[a-zA-Z0-9]{7})", longString);
//        regexChecker("([0-9]( |-)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?[0-9]{3}( |-)?[0-9]{4}|[a-zA-Z0-9]{7}", longString);
//       
//    }
    
//    public static void regexChecker(String theRegex, String str2Check){
//        Pattern checkRegex = Pattern.compile(theRegex);
//        Matcher regexMatcher = checkRegex.matcher(str2Check);
//        while(regexMatcher.find()){
//            if(regexMatcher.group().length() != 0){
//                System.out.println(regexMatcher.group().trim());
//            }
//            
//            System.err.println("Start Index: " + regexMatcher.start());
//            System.out.println("End Index: " + regexMatcher.end());
//        }
//    }

    private static String check4DT(String VP) {
        for (String DT : DTs) {
            if(DT.equalsIgnoreCase(VP))
                return "DT";
        }
        return null;
    }
    
    private static String check4Ops(String VP){
        for(String Op: Ops)
            if(Op.equalsIgnoreCase(VP)){
                return Op;
            }
        return null;
    }
    
    
    private static String check4Const(String VP){
        return "INT_CONST";
    }
    
    
}
