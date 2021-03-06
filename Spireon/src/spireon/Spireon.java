/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spireon;

import Operators.Arithmatic_Ops;
import Operators.INC_DEC_Ops;
import Operators.Logical_Ops;
import Operators.Relational_Ops;
import java.awt.Toolkit;
import java.util.ArrayList;
import modal.Token;

/**
 *
 * @author saroshmadara
 */
public class Spireon extends javax.swing.JFrame {

    /**
     * Creates new form Spireon
     */
    
    
    
    static ArrayList<Token> tokens = new ArrayList();
    static String input;
    static String[] classParts = {"DT",".","ID","ASSIGN_OP","CONST",";"};
    static String[] DTs = {"num","deci","char","str","bool"};
    static String[] Ops = {"=",">=","<=","=="};
    static String[] keywords = {"default","new","static","scene","break","case","void","public","private","try","catch","finally","return","import","jump","interface","now","round","do_round","class"};
    static String[] Const = {"INT_CONST","FLOAT_CONST","STRING_CONST","CHAR_CONST"};
    static char[] breakers = {' ', '=', '.', '\n', '(', ')', '{', '}', ';', ',', '\'', '\"', '[', ']','+','-','*','/','>','<','-',':'};
    static String VP;
    static char current,next;
    static char[] doubleOps = {'+','-','*','/','=','>','<','!'};
    static String t;
    static int ts = 0,te = 0, ln = 1, chToIgnore;
    private static boolean equFlagSet = false,INC_DEC_FLAG= false,CONDITIONAL_OP=false;
    static int totalLines,i ;
    private static boolean veryLastComment=false;
    
    
    public Spireon() {
        initComponents();
       TextLineNumber tln = new TextLineNumber(source);
       jScrollPane1.setRowHeaderView( tln );
       setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        source = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        compile = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spireon");
        setBackground(new java.awt.Color(255, 0, 0));

        jScrollPane1.setViewportView(source);

        output.setEditable(false);
        output.setColumns(20);
        output.setRows(5);
        jScrollPane2.setViewportView(output);

        jLabel1.setBackground(new java.awt.Color(66, 124, 255));
        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 111, 130));
        jLabel1.setText("Code");

        jLabel2.setBackground(new java.awt.Color(66, 124, 255));
        jLabel2.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 111, 130));
        jLabel2.setText("Output");

        compile.setText("Compile");
        compile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compileActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spireon/spireon-logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(compile, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(compile)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void compileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compileActionPerformed
        // TODO add your handling code here:
        ln = 1;
        output.setText("");
        tokens = new ArrayList<>();
        te = 0; 
        ts = 0;
        chToIgnore = 0;
        output.setText(null);
        input = source.getText();
        
        
    
            
        for(i = 0; i< input.length(); i++){
            current = input.charAt(i);
            if(i+1 < input.length()-1){
                next = input.charAt(i+1);
            }
            // when comments found
            if(current=='-' && next==current & input.charAt(i+2)=='-'){
                   int counter = 0;
                   chToIgnore = i+3;
                   while(counter++ < input.length() && chToIgnore < input.length() && input.charAt(chToIgnore) != '\n'){
                       
                       chToIgnore++;
                   }
                   
//                   System.out.println("counter part: "+counter+"  chToIgnore: " + chToIgnore);
                   i = chToIgnore;
                   veryLastComment=true;
            }
            else if(check4Br(input.charAt(i)) || i==input.length()-1){
                
                if(i==input.length()-1 && !check4Br(input.charAt(i))){
                    VP = input.substring(ts,i+1);
                }else if( current == '\n' && ts > 0 ){
                    VP = input.substring(ts-1,i);
                }else if(!equFlagSet && !INC_DEC_FLAG){
                    VP = input.substring(ts, i);
                }
                else{
                    VP=input.substring(ts,i);
                }
                
                if(veryLastComment){
                    if(input.charAt(chToIgnore) == '\n'){
                        VP = input.substring(chToIgnore,i);
                        ln++;
                    }else {
                        VP = input.substring(chToIgnore-1,i);
                    }
                    veryLastComment = false;
                }
                VP  = VP.trim();
                
                String CP;
                
                
                if(check4Keyword(VP) != null){
                    tokens.add(new Token(ln, check4Keyword(VP), VP.toCharArray()));
                    
                    ts = i+1;
                    te = 0;
                    String br = null;
                }else if((CP = check4DT(VP))  != null){
                    
                    tokens.add(new Token(ln, CP, VP.toCharArray()));
                    
                    ts = i+1;
                    te = 0;
                   
                }
                
                
                else if(check4Float(VP)){
//                    tokens.add(new Token(ln, CP, breakers));
                }
                else if(check4Const(VP)){
                    tokens.add(new Token(ln, "INT_CONST", VP.toCharArray()));
                    
                    ts = i+1;
                    te = 0;
                    String br = null;
                }
                // 4 char constant
                else if(current=='\'' && check4CharConst(VP+current)){ 
                    tokens.add(new Token(ln, "CHAR_CONST", (VP+current+"").toCharArray()));
                    VP = "";
                }
                else if(check4StrConst(VP)){
                    tokens.add(new Token(ln, "STR_CONST", (VP).toCharArray()));
                }
                else if(check4ID(VP)){
                    CP = "ID";
                    tokens.add(new Token(ln, CP, VP.toCharArray()));
                    ts = i+1;
                    te = 0;
                }
                
                
                
                // REST OF THE TERMINATORS & OPERATORS
                if(check4Terminator(input.charAt(i)) != null){
                       tokens.add(new Token(ln, check4Terminator(input.charAt(i)), new char[]{input.charAt(i)}));
//                       ts++;
                       te = 0;
                       ts = i+1;
               }
                    

                // ops that can be doubled

               if(checkIfSingle(input.charAt(i)) && i+1<input.length() && input.charAt(i+1) == '=' && !equFlagSet){
                    equFlagSet=true;
                    VP = String.valueOf(current);
                }else if(!equFlagSet){
                    String t1;
                   
                    if((t1 = Relational_Ops.checkSingleOp(input.charAt(i))) != null){
                        tokens.add(new Token(ln,t1,new char[]{input.charAt(i)}));
                        te = 0;
                        ts = i+1;
                    }
                    if(input.charAt(i)== '='){
                        tokens.add(new Token(ln,"ASSIGN",new char[]{input.charAt(i)}));
                        te = 0;
                        ts = i+1;
                    }

                }
                else if(input.charAt(i) == '=' && checkIfSingle(input.charAt(i-1))){
                     
                    tokens.add(new Token(ln,Relational_Ops.checkDoubleOp("["+input.charAt(i-1)+", "+current+"]") , new char[]{input.charAt(i-1),input.charAt(i)}));
                    equFlagSet = false;
                    ts = i+1;
                }
               
               
               
               if((current == '+' || current=='-') && i+1<input.length() && next == current && !INC_DEC_FLAG){
                    INC_DEC_FLAG = true;
                    VP = String.valueOf(current);
                }else if(!INC_DEC_FLAG){
                    String t1;
                    if(( t1= Arithmatic_Ops.ADDSUB.check(input.charAt(i)))!=null){
                        tokens.add(new Token(ln,t1,new char[]{input.charAt(i)}));
                        te = 0;
                        ts = i+1;
                    }
                    if((t1=Arithmatic_Ops.MULDIV.check(input.charAt(i))) != null){
                        tokens.add(new Token(ln,t1,new char[]{input.charAt(i)}));
                        te = 0;
                        ts = i+1;
                    }
                }
                else if((current == '+' || current=='-') && input.charAt(i-1) == current){
                    tokens.add(new Token(ln,INC_DEC_Ops.check("["+input.charAt(i-1)+", "+current+"]") , new char[]{input.charAt(i-1),input.charAt(i)}));
                    INC_DEC_FLAG = false;
                    ts = i+1;
                }
               
//               if((current == '&' || current=='|') && i+1<input.length() && next == current && !CONDITIONAL_OP){
//                    CONDITIONAL_OP = true;
//                    t=String.valueOf(current);
//                    VP = String.valueOf(current);
//                }else if(!CONDITIONAL_OP){
//                    String t1;
//                    if(( t1= Logical_Ops.check(input.charAt(i)))!=null){
//                        tokens.add(new Token(ln,t1,new char[]{input.charAt(i)}));
//                        te = 0;
//                        ts = i+1;
//                    }
//                }
//                else if((current == '&' || current=='|') && input.charAt(i-1) == current){
//                    tokens.add(new Token(ln,Logical_Ops.check(current) , new char[]{input.charAt(i-1),input.charAt(i)}));
//                    CONDITIONAL_OP = false;
//                    ts = i+1;
//                }
               
               
               
               
               
               
               
               
               
               // when space occurs increments by 1
                if(input.charAt(i) == ' '){
                    ts = i+1;
                }
                
                
            }else{
                te++;
            }
        }
        
        outputTokens(tokens);
        
//        output.append(tokens);
        
        
    }//GEN-LAST:event_compileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Spireon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Spireon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Spireon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Spireon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Spireon().setVisible(true);
            }
        });
    }
    
    
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
    
    
    private static boolean check4Const(String VP){
        return VP.matches("[0-9]{1,}");
    }
    
    private static boolean check4Float(String VP){
        return VP.matches("d*.d+");
    }

    private static boolean check4Br(char c) {
        for(int i = 0; i<breakers.length; i++){
            if(breakers[i] == c)
                return true;
        }
        return false;
    }
    
    private static boolean check4ID(String str){
        return str.matches("[A-Za-z]{1,}.*");
//        return str.matches("[^A-Za-z|(_(/w*)[A-Za-z0-9]){2,}]{1,}");
//        return str.matches("^[A-Za-z]_((/w*)[A-Za-z0-9])*$");
    }

    private static String check4Terminator(char c) {
        switch(c){
            case ';':
                return "SEMICOLON";
            case ')':
                return "ROUND_BRAC_CL";
            case '(':
                return "ROUND_BRAC_OP";
            case '[':
                return "SQUARE BRAC_OP";
            case ']':
                return "SQUARE_BRAC_CL";
            case '{':
                return "CURLI_BRAC_OP";
            case '}':
                return "CURLI_BRAC_CL";
            case ',':
                return "COMMA";
            case '\n':
                ln++;
                return null;
            default:
                return null;
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton compile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextArea output;
    private javax.swing.JTextPane source;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("favicon.png")));
    }

    private void outputTokens(ArrayList<Token> tokens) {
        tokens.stream().forEach((t) -> {
            output.append(t.toString() + "\n");
        });
    }

    private String check4Keyword(String VP) {
        switch(VP){
            case "new":
                return "NEW";
            case "break":
                return "BREAK";
            case "case":
                return "CASE";
            case "scene":
                return "SCENE";
            case "void":
                return "VOID";
            case "default":
                return "DEFAULT";
            case "public":
                return "ACCESS_MODIFIER";
            case "private":
                return "ACCESS_MODIFIER";
            case "class":
                return "CLASS";
            case "try":
                return "TRY";
            case "catch":
                return "CATCH";
            case "finally":
                return "FINALLY";
            case "jump":
                return "JUMP";
            case "import":
                return "IMPORT";
            case "interface":
                return "INTERFACE";
            case "now":
                return "NOW";
            case "round":
                return "ROUND";
            case "do_round":
                return "DO_ROUND";
            case "if":
                return "IF";
            case "else":
                    return "ELSE";
            case "static":
                return "STATIC";
            default:
                    return null;
        }
    }

    private boolean checkIfSingle(char c) {
        for(char ch:doubleOps)
            if(ch==c)
                return true;
        return false;
    }

    private boolean check4CharConst(String VP) {
        return VP.matches("\\'(\\s|[A-Za-z0-9])\\'");
    }

    private boolean check4StrConst(String VP) {
        return VP.matches("\"(\\s*|[A-Za-z0-9])*\"");
    }
    
}