/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noscript.DataTypes;

/**
 *
 * @author saroshmadara
 */
public class DT {
    public int num;
    public float deci;
    public char character;
    public String str;
    public boolean bool;
    
    public static void main(String[] args){
        String str = "10.10", str2 = "10";
//        System.out.println(isInteger(str));
        
        String test = "aBc";
        System.out.println(test.matches("[A-Za-z]{3}"));
    }
    public static boolean isInteger(String str) {
        return str.matches("^-?[0-9]+(\\.[0-9]+)?$");
    }
    
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