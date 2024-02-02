import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class instr extends JFrame {
    //adrDirect
    public static void adrDirect(JFrameARCH ar, ROM rom,RAM ram,String line){
        line=line.toUpperCase();
        String[] l= line.split(" ");
        l[0]=l[0].toUpperCase();
        //Operand
        String value=line.substring(line.indexOf("$")+1);
        
        //
        if(CONTENU.Dire.containsKey(l[0])){
            
             int x=Integer.parseInt(value,16);
             Long g=Long.decode("0x"+value);
             
             if(l[0].startsWith("LD")){
                 //LDA
                    //System.out.println("ZZ");
                     char choix = l[0].charAt(2);
                        switch(choix){
                            case 'A' -> {
                                String vvv=ar.regDP.getText()+value;
                                int index=Integer.parseInt(vvv,16);
                                String v=MAIN.ra.model.getValueAt(index, 1).toString();
                                System.out.println(v);
                                setA(v);
                            }
                            case 'B' ->{
                                String vvv=ar.regDP.getText()+value;
                                int index=Integer.parseInt(vvv,16);
                                String v=MAIN.ra.model.getValueAt(index, 1).toString();
                                System.out.println(v);
                                setB(v);
                            }
                            case 'D' -> {
                                int index1=Integer.parseInt(ar.regDP.getText()+value,16);
                                String v=MAIN.ra.model.getValueAt(index1, 1).toString();
                                setA(v);
                                int index2=index1+1;
                                 String v1=MAIN.ra.model.getValueAt(index2, 1).toString();
                                System.out.println(v);
                                setB(v1);
                            }
                            case 'X' -> {
                                int index1=Integer.parseInt(ar.regDP.getText()+value,16);
                                String v=MAIN.ra.model.getValueAt(index1, 1).toString();
                                int index2=index1+1;
                                 String v1=MAIN.ra.model.getValueAt(index2, 1).toString();
                                setX(v+v1);
                            }
                            case 'Y' -> {
                                int index1=Integer.parseInt(ar.regDP.getText()+value,16);
                                String v=MAIN.ra.model.getValueAt(index1, 1).toString();
                                int index2=index1+1;
                                 String v1=MAIN.ra.model.getValueAt(index2, 1).toString();
                                setY(v+v1);
                            }
                            case 'S' -> {
                                int index1=Integer.parseInt(ar.regDP.getText()+value,16);
                                String v=MAIN.ra.model.getValueAt(index1, 1).toString();
                                int index2=index1+1;
                                 String v1=MAIN.ra.model.getValueAt(index2, 1).toString();
                                setS(v+v1);
                            }
                            case 'U' -> {
                                int index1=Integer.parseInt(ar.regDP.getText()+value,16);
                                String v=MAIN.ra.model.getValueAt(index1, 1).toString();
                                int index2=index1+1;
                                 String v1=MAIN.ra.model.getValueAt(index2, 1).toString();
                                setU(v+v1);
                            }
                            default -> ERROR();
                        }
                 
             }else if(l[0].startsWith("ST")){
                 //ST
                 char choix = l[0].charAt(2);
                        switch(choix){
                            case 'A' -> {
                                String vvv=ar.regA.getText();
                                int index=Integer.parseInt(value,16);
                                MAIN.ra.model.setValueAt(vvv,index, 1);
                            }
                            case 'B' -> {
                                String vvv=ar.regB.getText();
                                int index=Integer.parseInt(value,16);
                                MAIN.ra.model.setValueAt(vvv,index, 1);
                            }
                            case 'D' -> {
                                int index=Integer.parseInt(value,16);
                                int index2=index+1;
                                MAIN.ra.model.setValueAt(ar.regA.getText(),index, 1);
                                MAIN.ra.model.setValueAt(ar.regB.getText(),index2, 1);
                            }
                            case 'X' -> {
                                String vvv=ar.regX.getText();
                                int index=Integer.parseInt(value,16);
                                int index2=index+1;
                                MAIN.ra.model.setValueAt(vvv.substring(0,2),index, 1);
                                MAIN.ra.model.setValueAt(vvv.substring(2),index2, 1);
                            }
                            case 'Y' -> {
                                String vvv=ar.regY.getText();
                                int index=Integer.parseInt(value,16);
                                int index2=index+1;
                                MAIN.ra.model.setValueAt(vvv.substring(0,2),index, 1);
                                MAIN.ra.model.setValueAt(vvv.substring(2),index2, 1);
                            }
                            case 'S' -> {
                                String vvv=ar.regS.getText();
                                int index=Integer.parseInt(value,16);
                                int index2=index+1;
                                MAIN.ra.model.setValueAt(vvv.substring(0,2),index, 1);
                                MAIN.ra.model.setValueAt(vvv.substring(2),index2, 1);
                            }
                            case 'U' -> {
                                String vvv=ar.regU.getText();
                                int index=Integer.parseInt(value,16);
                                int index2=index+1;
                                MAIN.ra.model.setValueAt(vvv.substring(0,2),index, 1);
                                MAIN.ra.model.setValueAt(vvv.substring(2),index2, 1);
                            }
                        }
             }else if(l[0].startsWith("ADD")){
                    //ADD
                    //System.out.println("jj");
                    char choix = l[0].charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=ar.regDP.getText()+value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y+Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setA(v.substring(v.length()-2));
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=ar.regDP.getText()+value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y+Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setB(v.substring(v.length()-2));
                                }
                                case 'D' -> {
                                    
                                    int y=Integer.parseInt(MAIN.arch.regA.getText()+MAIN.arch.regB.getText(), 16);
                                    String vvv=ar.regDP.getText()+value;
                                    int index=Integer.parseInt(vvv,16);
                                    int i=index+1;
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    String R2=MAIN.ra.model.getValueAt(i, 1).toString();
                                    String RR=R+R2;
                                    int z=y+Integer.parseInt(RR,16);
                                    String v=String.format("%04X",z);
                                    setD(v.substring(v.length()-4));
                                }

                                default -> ERROR();
                            }
                }else if(l[0].startsWith("SUB")){
                    //SUB
                    //System.out.println("jj");
                    char choix = l[0].charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=ar.regDP.getText()+value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y-Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setA(v.substring(v.length()-2));
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=ar.regDP.getText()+value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y-Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setB(v.substring(v.length()-2));
                                }
                                case 'D' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText()+MAIN.arch.regB.getText(), 16);
                                    String vvv=ar.regDP.getText()+value;
                                    int index=Integer.parseInt(vvv,16);
                                    int i=index+1;
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    String R2=MAIN.ra.model.getValueAt(i, 1).toString();
                                    String RR=R+R2;
                                    int z=y-Integer.parseInt(RR,16);
                                    String v=String.format("%04X",z);
                                    setD(v.substring(v.length()-4));
                                }

                                default -> ERROR();
                            }
                }else if(l[0].startsWith("AND")){
                    //SUB
                    //System.out.println("jj");
                    char choix = l[0].charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=ar.regDP.getText()+value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y&Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setA(v.substring(v.length()-2));
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=ar.regDP.getText()+value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y&Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setB(v.substring(v.length()-2));
                                }
                                
                                default -> ERROR();
                            }
                }else if(l[0].startsWith("OR")){
                    //SUB
                    //System.out.println("jj");
                    char choix = l[0].charAt(2);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=ar.regDP.getText()+value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y|Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setA(v.substring(v.length()-2));
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=ar.regDP.getText()+value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y|Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setB(v.substring(v.length()-2));
                                }
                                
                                default -> ERROR();
                            }
                }
             
        }
    }
    //adrImmediat
    public static void adrImmediat(JFrameARCH ar, ROM rom,RAM ram,String line){
        line=line.toUpperCase();
        String[] l= line.split(" ");
        l[0]=l[0].toUpperCase();
        //
        if(CONTENU.Imme.containsKey(l[0])){
             //
             String value=line.substring(line.indexOf("$")+1);
            //int x=Integer.parseInt(value,16);
            Long g=Long.decode("0x"+value);
             //LDA
                if(l[0].startsWith("LD")){
                    //LDA
                    //System.out.println("ZZ");
                     char choix = l[0].charAt(2);
                        switch(choix){
                            case 'A' -> setA(value);
                            case 'B' -> setB(value);
                            case 'D' -> setD(value);
                            case 'X' -> setX(value);
                            case 'Y' -> setY(value);
                            case 'S' -> setS(value);
                            case 'U' -> setU(value);
                            default -> ERROR();
                        }
                 }else if(l[0].startsWith("ADD")){
                    //ADD
                    //System.out.println("jj");
                    char choix = l[0].charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=String.format("%02X",(int) (y+g));
                                    setA(vvv.substring(vvv.length()-2));
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=String.format("%02X",(int) (y+g));
                                    setB(vvv.substring(vvv.length()-2));
                                }
                                case 'D' -> {
                                    
                                    int y=Integer.parseInt(MAIN.arch.regA.getText()+MAIN.arch.regB.getText(), 16);
                                    String vvv=String.format("%04X",(int) (y+g));
                                    setD(vvv.substring(vvv.length()-4));
                                }

                                default -> ERROR();
                            }
                }else if(l[0].startsWith("SUB")){
                    //SUB
                    //System.out.println("jj");
                    char choix = l[0].charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=String.format("%02X",(int) (y-g));
                                    setA(vvv.substring(vvv.length()-2));
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=String.format("%02X",(int) (y-g));
                                    setB(vvv.substring(vvv.length()-2));
                                }
                                case 'D' -> {
                                    
                                    int y=Integer.parseInt(MAIN.arch.regA.getText()+MAIN.arch.regB.getText(), 16);
                                    String vvv=String.format("%04X",(int) (y-g));
                                    setD(vvv.substring(vvv.length()-4));
                                }

                                default -> ERROR();
                            }
                }else if(l[0].startsWith("AND")){
                    //ADD
                    //System.out.println("jj");
                    char choix = l[0].charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=String.format("%02X",(int) (y&g));
                                    setA(vvv.substring(vvv.length()-2));
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=String.format("%02X",(int) (y&g));
                                    setB(vvv.substring(vvv.length()-2));
                                }
                                
                                default -> ERROR();
                            }
                }else if(l[0].startsWith("OR")){
                    //ADD
                    //System.out.println("jj");
                    char choix = l[0].charAt(2);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=String.format("%02X",(int) (y|g));
                                    setA(vvv.substring(vvv.length()-2));
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=String.format("%02X",(int) (y|g));
                                    setB(vvv.substring(vvv.length()-2));
                                }
                                
                                default -> ERROR();
                            }
                }
            
        }else {
            ERROR();
        }
        
    }
    //adrInherent
    public static void adrInherent(JFrameARCH ar, ROM rom,RAM ram,String line){
        line= line.trim();
        line=line.toUpperCase();
        //
        if(CONTENU.Inhe.containsKey(line)){
            
             //DEC
                if(line.startsWith("DEC")){
                    //
                    char choix = line.charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=String.format("%02X", y-1);
                                    setA(vvv.substring(vvv.length()-2));
                                    
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=String.format("%02X", y-1);
                                    setB(vvv.substring(vvv.length()-2));
                                    
                                }
                                    
                        }
                    
                }else if(line.startsWith("INC")){
                    //INC
                    char choix = line.charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=String.format("%02X", y+1);
                                    setA(vvv.substring(vvv.length()-2));
                                   
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=String.format("%02X", y+1);
                                    setB(vvv.substring(vvv.length()-2));
                                }
                                    
                        }
                    
                }else if(line.startsWith("CLR")){
                    //CLR
                    char choix = line.charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    setA("00"); 
                                }
                                case 'B' -> {
                                    setB("00");
                                }
                        }
                }else if(line.trim().equalsIgnoreCase("ABX")){
                    //ABX
                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                    int z=Integer.parseInt(MAIN.arch.regX.getText(), 16);
                    String vvv=String.format("%04X", y+z);
                    setX(vvv);
                }else if(line.startsWith("ASL")||line.startsWith("LSL")){
                    char choix = line.charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=String.format("%02X", 2*y);
                                    setA(vvv); 
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=String.format("%02X", 2*y);
                                    setB(vvv); 
                                }
                        }
                }else if(line.startsWith("LSR")){
                    char choix = line.charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=String.format("%02X", y/2);
                                    setA(vvv); 
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=String.format("%02X", y/2);
                                    setB(vvv); 
                                }
                        }
                }else if(line.startsWith("ASR")){
                    char choix = line.charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv;
                                    int signe = y & 0x80;
                                    // Vérifier si le bit de signe est 1 ou 0
                                    if (signe == 0x80) {
                                        // Si oui, le nombre est négatif
                                        vvv=String.format("%02X", y/2+0x80);
                                    } else {
                                        // Sinon, le nombre est positif
                                        vvv=String.format("%02X", y/2);
                                    }
                                    setA(vvv); 
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv;
                                    int signe = y & 0x80;
                                    // Vérifier si le bit de signe est 1 ou 0
                                    if (signe == 0x80) {
                                        // Si oui, le nombre est négatif
                                        vvv=String.format("%02X", y/2+0x80);
                                    } else {
                                        // Sinon, le nombre est positif
                                        vvv=String.format("%02X", y/2);
                                    }
                                    setB(vvv);  
                                }
                        }
                }else if(line.startsWith("SWI")){
                    p--;
                }
            
        }
    }
    //adrEtendu
    public static void adrEtendu(JFrameARCH ar, ROM rom,RAM ram,String line){
       line=line.toUpperCase();
        String[] l= line.split(" ");
        l[0]=l[0].toUpperCase();
        String value=line.substring(line.indexOf("$")+1);
        
        //
        if(CONTENU.ETD.containsKey(l[0])){
            
           int x=Integer.parseInt(value,16);
             Long g=Long.decode("0x"+value);
             
             if(l[0].startsWith("LD")){
                 //LDA
                    //System.out.println("ZZ");
                     char choix = l[0].charAt(2);
                        switch(choix){
                            case 'A' -> {
                                String vvv=value;
                                int index=Integer.parseInt(vvv,16);
                                String v=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                System.out.println(v);
                                setA(v);
                         
                            }
                            case 'B' ->{
                                String vvv=value;
                                int index=Integer.parseInt(vvv,16);
                                String v=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                System.out.println(v);
                               
                                setB(v);
                            }
                            case 'D' -> {
                                int index1=Integer.parseInt(value,16);
                                String v=MAIN.ra.model.getValueAt(index1, 1).toString();
                                setA(v);
                                int index2=index1+1;
                                 String v1=MAIN.ra.model.getValueAt(index2, 1).toString();
                                System.out.println(v);
                                setB(v1);
                            }
                            case 'X' -> {
                                int index1=Integer.parseInt(value,16);
                                String v=MAIN.ra.model.getValueAt(index1, 1).toString();
                                int index2=index1+1;
                                 String v1=MAIN.ra.model.getValueAt(index2, 1).toString();
                                setX(v+v1);
                            }
                            case 'Y' -> {
                                int index1=Integer.parseInt(value,16);
                                String v=MAIN.ra.model.getValueAt(index1, 1).toString();
                                int index2=index1+1;
                                 String v1=MAIN.ra.model.getValueAt(index2, 1).toString();
                                setY(v+v1);
                            }
                            case 'S' -> {
                                int index1=Integer.parseInt(value,16);
                                String v=MAIN.ra.model.getValueAt(index1, 1).toString();
                                int index2=index1+1;
                                 String v1=MAIN.ra.model.getValueAt(index2, 1).toString();
                                setS(v+v1);
                            }
                            case 'U' -> {
                                int index1=Integer.parseInt(value,16);
                                String v=MAIN.ra.model.getValueAt(index1, 1).toString();
                                int index2=index1+1;
                                 String v1=MAIN.ra.model.getValueAt(index2, 1).toString();
                                setU(v+v1);
                            }
                            default -> ERROR();
                        }
                        }else if(l[0].startsWith("ST")){
                 //ST
                 char choix = l[0].charAt(2);
                        switch(choix){
                            case 'A' -> {
                                String vvv=ar.regA.getText();
                                int index=Integer.parseInt(value,16);
                                MAIN.ra.model.setValueAt(vvv,index, 1);
                            }
                            case 'B' -> {
                                String vvv=ar.regB.getText();
                                int index=Integer.parseInt(value,16);
                                MAIN.ra.model.setValueAt(vvv,index, 1);
                            }
                            case 'D' -> {
                                int index=Integer.parseInt(value,16);
                                int index2=index+1;
                                MAIN.ra.model.setValueAt(ar.regA.getText(),index, 1);
                                MAIN.ra.model.setValueAt(ar.regB.getText(),index2, 1);
                            }
                            case 'X' -> {
                                String vvv=ar.regX.getText();
                                int index=Integer.parseInt(value,16);
                                int index2=index+1;
                                MAIN.ra.model.setValueAt(vvv.substring(0,2),index, 1);
                                MAIN.ra.model.setValueAt(vvv.substring(2),index2, 1);
                            }
                            case 'Y' -> {
                                String vvv=ar.regY.getText();
                                int index=Integer.parseInt(value,16);
                                int index2=index+1;
                                MAIN.ra.model.setValueAt(vvv.substring(0,2),index, 1);
                                MAIN.ra.model.setValueAt(vvv.substring(2),index2, 1);
                            }
                            case 'S' -> {
                                String vvv=ar.regS.getText();
                                int index=Integer.parseInt(value,16);
                                int index2=index+1;
                                MAIN.ra.model.setValueAt(vvv.substring(0,2),index, 1);
                                MAIN.ra.model.setValueAt(vvv.substring(2),index2, 1);
                            }
                            case 'U' -> {
                                String vvv=ar.regU.getText();
                                int index=Integer.parseInt(value,16);
                                int index2=index+1;
                                MAIN.ra.model.setValueAt(vvv.substring(0,2),index, 1);
                                MAIN.ra.model.setValueAt(vvv.substring(2),index2, 1);
                            }
                        }
                        }else if(l[0].startsWith("ADD")){
                    //ADD
                    //System.out.println("jj");
                    char choix = l[0].charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y+Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setA(v.substring(v.length()-2));
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y+Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setB(v.substring(v.length()-2));
                                }
                                case 'D' -> {
                                    
                                    int y=Integer.parseInt(MAIN.arch.regA.getText()+MAIN.arch.regB.getText(), 16);
                                    String vvv=value;
                                    int index=Integer.parseInt(vvv,16);
                                    int i=index+1;
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    String R2=MAIN.ra.model.getValueAt(i, 1).toString();
                                    String RR=R+R2;
                                    int z=y+Integer.parseInt(RR,16);
                                    String v=String.format("%04X",z);
                                    setD(v.substring(v.length()-4));
                                }

                                default -> ERROR();
                            }
                }else if(l[0].startsWith("SUB")){
                    //SUB
                    char choix = l[0].charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y-Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setA(v.substring(v.length()-2));
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y-Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setB(v.substring(v.length()-2));
                                }
                                case 'D' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText()+MAIN.arch.regB.getText(), 16);
                                    String vvv=value;
                                    int index=Integer.parseInt(vvv,16);
                                    int i=index+1;
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    String R2=MAIN.ra.model.getValueAt(i, 1).toString();
                                    String RR=R+R2;
                                    int z=y-Integer.parseInt(RR,16);
                                    String v=String.format("%04X",z);
                                    setD(v.substring(v.length()-4));
                                }

                                default -> ERROR();
                            }
                }else if(l[0].startsWith("AND")){
                    //AND
                    //System.out.println("jj");
                    char choix = l[0].charAt(3);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y&Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setA(v.substring(v.length()-2));
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y&Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setB(v.substring(v.length()-2));
                                }

                                default -> ERROR();
                            }
                }else if(l[0].startsWith("OR")){
                    //ADD
                    //System.out.println("jj");
                    char choix = l[0].charAt(2);
                        switch(choix){
                                case 'A' -> {
                                    int y=Integer.parseInt(MAIN.arch.regA.getText(), 16);
                                    String vvv=value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y|Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setA(v.substring(v.length()-2));
                                }
                                case 'B' -> {
                                    int y=Integer.parseInt(MAIN.arch.regB.getText(), 16);
                                    String vvv=value;
                                    int index=Integer.parseInt(vvv,16);
                                    String R=MAIN.ra.model.getValueAt(index, 1).toString();
                                    int z=y|Integer.parseInt(R,16);
                                    String v=String.format("%02X",z);
                                    setB(v.substring(v.length()-2));
                                }
                                default -> ERROR();
                            }
                }
             
        }
    }
    //adrEtenduIndirect
    public static void adrEtenduIndirect(JFrameARCH ar, ROM rom,RAM ram,String line){
       line=line.toUpperCase();
        String[] l= line.split(" ");
        l[0]=l[0].toUpperCase();
        String value=line.substring(line.indexOf("$")+1,line.indexOf("]"));
        //
        if(CONTENU.ETD.containsKey(l[0])){
             int x=Integer.parseInt(value,16);
             Long g=Long.decode("0x"+value);
             //
             if(l[0].startsWith("LD")){
                 //LDA
                    //System.out.println("ZZ");
                     char choix = l[0].charAt(2);
                        switch(choix){
                            case 'A' -> {
                                String vvv=value;
                                int index=Integer.parseInt(vvv,16);
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                int index2=Integer.parseInt(v2+v3,16);
                                String v=MAIN.ra.model.getValueAt(index2, 1).toString();
                                 System.out.println(v);
                                setA(v);
                            }
                            case 'B' ->{
                             String vvv=value;
                                int index=Integer.parseInt(vvv,16);
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                int index2=Integer.parseInt(v2+v3,16);
                                String v=MAIN.ra.model.getValueAt(index2, 1).toString();
                                 System.out.println(v);
                                setB(v);
                            }
                            case 'D' -> {
                                String vvv=value;
                                int index=Integer.parseInt(vvv,16);
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                int index2=Integer.parseInt(v2+v3,16);
                                String v=MAIN.ra.model.getValueAt(index2, 1).toString();
                                 System.out.println(v);
                                setA(v);
                                
                                String v1=MAIN.ra.model.getValueAt(index2+1, 1).toString();
                                 System.out.println(v);
                                setB(v1);
                            }
                            case 'X' -> {
                                String vvv=value;
                                int index=Integer.parseInt(vvv,16);
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                int index2=Integer.parseInt(v2+v3,16);
                                String v=MAIN.ra.model.getValueAt(index2, 1).toString();
                                 System.out.println(v);                                
                                String v1=MAIN.ra.model.getValueAt(index2+1, 1).toString();
                                 System.out.println(v);
                                setX(v+v1);
                            }
                            case 'Y' -> {
                                 String vvv=value;
                                int index=Integer.parseInt(vvv,16);
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                int index2=Integer.parseInt(v2+v3,16);
                                String v=MAIN.ra.model.getValueAt(index2, 1).toString();
                                 System.out.println(v);
                                
                                
                                String v1=MAIN.ra.model.getValueAt(index2+1, 1).toString();
                                 System.out.println(v);
                               
                                setY(v+v1);
                            }
                            case 'S' -> {
                                 String vvv=value;
                                int index=Integer.parseInt(vvv,16);
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                int index2=Integer.parseInt(v2+v3,16);
                                String v=MAIN.ra.model.getValueAt(index2, 1).toString();
                                 System.out.println(v);
                                
                                
                                String v1=MAIN.ra.model.getValueAt(index2+1, 1).toString();
                                 System.out.println(v);
                               
                                setS(v+v1);
                            }
                            case 'U' -> {
                                  String vvv=value;
                                int index=Integer.parseInt(vvv,16);
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                int index2=Integer.parseInt(v2+v3,16);
                                String v=MAIN.ra.model.getValueAt(index2, 1).toString();
                                 System.out.println(v);
                                
                                
                                String v1=MAIN.ra.model.getValueAt(index2+1, 1).toString();
                                 System.out.println(v);
                               
                                setU(v+v1);
                            }
                            default -> ERROR();
                        }
                        }else if(l[0].startsWith("ST")){
                 //ST
                 char choix = l[0].charAt(2);
                        switch(choix){
                            case 'A' -> {
                               
                                int index=Integer.parseInt(value,16);
                                
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                 int index2=Integer.parseInt(v2+v3,16);
                                String v=ar.regA.getText();
                                MAIN.ra.model.setValueAt(v,index2, 1);
                                
                            }
                            case 'B' -> {
                               int index=Integer.parseInt(value,16);
                                
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                 int index2=Integer.parseInt(v2+v3,16);
                                String v=ar.regB.getText();
                                MAIN.ra.model.setValueAt(v,index2, 1);
                            }
                            case 'D' -> {
                                int index=Integer.parseInt(value,16);
                                
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                 int index2=Integer.parseInt(v2+v3,16);
                                String v=ar.regA.getText();
                                MAIN.ra.model.setValueAt(v,index2, 1);
                                MAIN.ra.model.setValueAt(ar.regB.getText(),index2+1, 1);
                                
                            }
                            case 'X' -> {
                                int index=Integer.parseInt(value,16);
                                
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                 int index2=Integer.parseInt(v2+v3,16);
                                String v=ar.regX.getText();
                                MAIN.ra.model.setValueAt(v.substring(0,2),index2, 1);
                                MAIN.ra.model.setValueAt(v.substring(2),index2+1, 1);
                            }
                            case 'Y' -> {
                                int index=Integer.parseInt(value,16);
                                
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                 int index2=Integer.parseInt(v2+v3,16);
                                String v=ar.regY.getText();
                                MAIN.ra.model.setValueAt(v.substring(0,2),index2, 1);
                                MAIN.ra.model.setValueAt(v.substring(2),index2+1, 1);
                            }
                            case 'S' -> {
                                int index=Integer.parseInt(value,16);
                                
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                 int index2=Integer.parseInt(v2+v3,16);
                                String v=ar.regS.getText();
                                MAIN.ra.model.setValueAt(v.substring(0,2),index2, 1);
                                MAIN.ra.model.setValueAt(v.substring(2),index2+1, 1);
                            }
                            case 'U' -> {
                               int index=Integer.parseInt(value,16);
                                
                                String v2=String.valueOf(MAIN.ra.model.getValueAt(index, 1));
                                 String v3=String.valueOf(MAIN.ra.model.getValueAt(index+1, 1));
                                 int index2=Integer.parseInt(v2+v3,16);
                                String v=ar.regU.getText();
                                MAIN.ra.model.setValueAt(v.substring(0,2),index2, 1);
                                MAIN.ra.model.setValueAt(v.substring(2),index2+1, 1);
                            }
                       

                                default -> ERROR();
                            }}}
                }
    //adrIndexed
    public static void adrIndexe(JFrameARCH ar, ROM rom,RAM ram,String line){
        line=line.toUpperCase();
        String[] l= line.split(" ");
        l[0]=l[0].toUpperCase();
        int x=Integer.parseInt(ar.regX.getText(),16);
        int y=Integer.parseInt(ar.regY.getText(),16);
        int s=Integer.parseInt(ar.regS.getText(),16);
        int u=Integer.parseInt(ar.regU.getText(),16);
        //
        if(CONTENU.Inde.containsKey(l[0])){
             //
             String value=line.substring(line.indexOf(",")+1);
             //LEA
                if(l[0].startsWith("LEA")){
                    System.out.println(value);
                     char choix = l[0].charAt(3);
                        switch(choix){
                            case 'X' -> {
                                System.out.println("trt LEA");
                                
                                if(value.equalsIgnoreCase("X++")){
                                setX(String.format("%04X", x+2));
                                }else if(value.equalsIgnoreCase("X+")){
                                setX(String.format("%04X", x+1));
                                }else if(value.equalsIgnoreCase("--X")){
                                setX(String.format("%04X", x-2));
                                }else if(value.equalsIgnoreCase("-X")){
                                setX(String.format("%04X", x-1));
                                }else if(value.equalsIgnoreCase("X")){
                                setX(String.format("%04X", x));
                                }else if(value.equalsIgnoreCase("Y++")){
                                    setX(String.format("%04X", y));
                                setY(String.format("%04X", y+2));
                                }else if(value.equalsIgnoreCase("Y+")){
                                    setX(String.format("%04X", y));
                                setY(String.format("%04X", y+1));
                                }else if(value.equalsIgnoreCase("--Y")){
                                    setX(String.format("%04X", y));
                                setY(String.format("%04X", y-2));
                                }else if(value.equalsIgnoreCase("-Y")){
                                    setX(String.format("%04X", y));
                                setY(String.format("%04X", y-1));
                                }else if(value.equalsIgnoreCase("Y")){
                                setX(String.format("%04X", y));
                                }else if(value.equalsIgnoreCase("S")){
                                setX(String.format("%04X", s));
                                }else if(value.equalsIgnoreCase("U")){
                                setX(String.format("%04X", u));
                                }else ERROR2();
                            
                            }
                            case 'Y' -> {
                                System.out.println("yy");
                                //de même chose que regX
                                if(value.equalsIgnoreCase("X++")){
                                    setY(String.format("%04X", x));
                                setX(String.format("%04X", x+2));
                                }else if(value.equalsIgnoreCase("X+")){
                                    setY(String.format("%04X", x));
                                setX(String.format("%04X", x+1));
                                }else if(value.equalsIgnoreCase("--X")){
                                    setY(String.format("%04X", x));
                                setX(String.format("%04X", x-2));
                                }else if(value.equalsIgnoreCase("-X")){
                                    setY(String.format("%04X", x));
                                setX(String.format("%04X", x-1));
                                }else if(value.equalsIgnoreCase("X")){
                                setY(String.format("%04X", x));
                                }else if(value.equalsIgnoreCase("Y++")){
                                setY(String.format("%04X", y+2));
                                }else if(value.equalsIgnoreCase("Y+")){
                                setY(String.format("%04X", y+1));
                                }else if(value.equalsIgnoreCase("--Y")){
                                setY(String.format("%04X", y-2));
                                }else if(value.equalsIgnoreCase("-Y")){
                                setY(String.format("%04X", y-1));
                                }else if(value.equalsIgnoreCase("Y")){
                                setY(String.format("%04X", y));
                                }else if(value.equalsIgnoreCase("S")){
                                setY(String.format("%04X", s));
                                }else if(value.equalsIgnoreCase("U")){
                                setY(String.format("%04X", u));
                                }else ERROR2();
                            }
                            case 'S' -> System.out.println("ss");
                            case 'U' -> System.out.println("uu");
                            default -> ERROR();
                        }
                 }
            
        }else {
            
        JOptionPane.showMessageDialog(MAIN.editor, "Pas encore traitee");
        }
        
    }
    
    
    //Fonction updateEDITEUR COMPILATION
    public static void traiterUPDATE(String textarea) {
         // Récupère chaque ligne du textarea
         String[] lignes = textarea.split("\n");
         if(!lignes[lignes.length-1].trim().equalsIgnoreCase("END")&&!textarea.isEmpty()){ 
             JOptionPane.showMessageDialog(MAIN.editor, "saisie erronee ajouter un end");
         }else
         if(lignes[0].trim().equalsIgnoreCase("END")){
             JOptionPane.showMessageDialog(MAIN.editor, "Le programme est vide");
         }else{
             MAIN.ro = new ROM();
             MAIN.ra = new RAM();
             MAIN.prog = new Programme();
            // Parcours chaque ligne
            for (int i=0;i<lignes.length;i++) {
                System.out.println(lignes[i].toUpperCase());
                String ligne=lignes[i].toUpperCase();
                ligne=ligne.toUpperCase();
              // Parcours chaque caractère de la ligne
              if(ligne.contains("<$")){
                  String[] l= ligne.split(" ");
                    if(CONTENU.Dire.containsKey(l[0])){
                      //prog fenetre
                      setPRG(MAIN.ro.model.getValueAt(j, 0).toString(), ligne.toUpperCase());
                      //ROM
                       setROM(Integer.toHexString(CONTENU.Dire.get(l[0])));
                       setROM(ligne.substring(ligne.indexOf("$")+1));
                    }else{ERROR();}
                    //adrDirect(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(ligne.contains("#$")){
                  String[] l= ligne.split(" ");
                  if(CONTENU.Imme.containsKey(l[0])){
                      //prog fenetre
                      setPRG(MAIN.ro.model.getValueAt(j, 0).toString(), ligne.toUpperCase());
                      //ROM
                       setROM(Integer.toHexString(CONTENU.Imme.get(l[0])));
                       setROM(ligne.substring(ligne.indexOf("$")+1));
                    }else{ERROR();}
                   //adrImmediat(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(ligne.contains(">$")){
                    String[] l= ligne.split(" ");
                  if(CONTENU.ETD.containsKey(l[0])){
                      //prog fenetre
                      setPRG(MAIN.ro.model.getValueAt(j, 0).toString(), ligne.toUpperCase());
                      //ROM
                       setROM(Integer.toHexString(CONTENU.ETD.get(l[0])));
                       setROM(ligne.substring(ligne.indexOf("$")+1));
                    }else{ERROR();}
                   //adrEtendu(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(ligne.contains("[$")&&ligne.contains("]")){
                  String[] l= ligne.split(" ");
                  if(CONTENU.ETD.containsKey(l[0])){
                      //prog fenetre
                      setPRG(MAIN.ro.model.getValueAt(j, 0).toString(), ligne.toUpperCase());
                      //ROM
                       setROM(Integer.toHexString(CONTENU.ETD.get(l[0])));
                       setROM(ligne.substring(ligne.indexOf("$")+1,ligne.indexOf("]")));
                    }else{ERROR();}
                   //adrEtenduIndirect(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
               if(ligne.contains(",")){
                  String[] l= ligne.split(" ");
                  if(CONTENU.Inde.containsKey(l[0])){
                      //prog fenetre
                      setPRG(MAIN.ro.model.getValueAt(j, 0).toString(), ligne.toUpperCase());
                      //ROM
                       setROM(Integer.toHexString(CONTENU.Inde.get(l[0])));
                       //il faut corriger
                       setROM(POSTOCTET(l[1]));
                    }else{ERROR();}
                   //adrIndexe(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(CONTENU.Inhe.containsKey(ligne)){
                    String line= ligne.trim();
                    line=line.toUpperCase();
                    //prog fenetre
                    setPRG(MAIN.ro.model.getValueAt(j, 0).toString(), ligne.toUpperCase());
                    //setROMM
                    setROM(Integer.toHexString(CONTENU.Inhe.get(line)));
                  //adrInherent(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(ligne.equalsIgnoreCase("END")){
                  setROM("3F");
                  setPRG(MAIN.ro.model.getValueAt(j, 0).toString(), ligne.toUpperCase());
                  setNEXT(lignes[0]);
              }else{
                  ERROR();
              }
           
            }
        }
    }
    //Exporte le POSTOCTET
    public static String POSTOCTET(String line){
        String H="0";
        String L="0";
        if(line.contains("X"))H="8";
        else if(line.contains("Y"))H="A";
        else if(line.contains("U"))H="C";
        else if(line.contains("S"))H="E";
        if(line.contains("++"))L="1";
        else if(line.contains("+"))L="0";
        else if(line.contains("--"))L="3";
        else if(line.contains("-"))L="2";
        else if(line.contains("A"))L="6";
        else if(line.contains("B"))L="5";
        else if(line.contains("D"))L="B";
        else L="4";
        return (H+L);
    }
    
    //Fonction traiterLignes et detection de mode adr
    public static void traiterLigne(String textarea) {
         // Récupère chaque ligne du textarea
         String[] lignes = textarea.split("\n");
         if(!lignes[lignes.length-1].trim().equalsIgnoreCase("END")&&!textarea.isEmpty()){ 
             JOptionPane.showMessageDialog(MAIN.editor, "saisie erronee ajouter un end");
         }else{
            // Parcours chaque ligne
            int i;
            for (i=0;i<lignes.length;i++) {
                System.out.println(lignes[i].toUpperCase());
                String ligne=lignes[i].toUpperCase();
                ligne=ligne.toUpperCase();
              // Parcours chaque caractère de la ligne
              if(ligne.contains("<$")){
                   adrDirect(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(ligne.contains("#$")){
                   adrImmediat(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(ligne.contains(">$")){
                   adrEtendu(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(ligne.contains("[$")){
                   adrEtenduIndirect(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(ligne.contains(",")){
                   adrIndexe(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(CONTENU.Inhe.containsKey(ligne)){
                  if(ligne.startsWith("SWI")){break;}
                  adrInherent(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
                  
              }else
              if(ligne.equalsIgnoreCase("END")){
                  setNEXT(ligne);
              }else{
                  ERROR();
              }
           
            }
            if(lignes[i-1].contains("SWI"))setNEXT(lignes[i-1]);
            
        setPC(MAIN.prog.prgTable.getValueAt(i-1, 0).toString());

        MAIN.stepjButton3.setEnabled(false);
        MAIN.runjButton4.setEnabled(false);
        MAIN.undojButton5.setEnabled(true);
        p=lignes.length-1;

        }
    }
    
    //pas à pas
    public static int p=0;
    public static void traiterLinePrLine(String textarea) {
         // Récupère chaque ligne du textarea
         String[] lignes = textarea.split("\n");
         if(!lignes[lignes.length-1].trim().equalsIgnoreCase("END")&&!textarea.isEmpty())
         { JOptionPane.showMessageDialog(MAIN.editor, "saisie erronee ajouter un end");
         }else{
         // Parcours chaque ligne         
             setPC(MAIN.prog.prgTable.getValueAt(p, 0).toString());
             System.out.println("p "+p);
             System.out.println(lignes[p].toUpperCase());
             String ligne=lignes[p].toUpperCase();
             ligne=ligne.toUpperCase();
           //Choix de mode d adressage
            if(ligne.contains("<$")){
                 adrDirect(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
            }else
            if(ligne.contains("#$")){
                 adrImmediat(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
            }else
              if(ligne.contains(">$")){
                   adrEtendu(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(ligne.contains("[$")){
                   adrEtenduIndirect(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(ligne.contains(",")){
                   adrIndexe(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
            if(CONTENU.Inhe.containsKey(ligne)){
                adrInherent(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
            }else
            if(ligne.equalsIgnoreCase("END")){
                setNEXT(ligne);
            }else{
                ERROR();
            }
            //inc p compteur global des lignes
            p++;

            if(p>=lignes.length-1){
                p=lignes.length-1;
                setNEXT(lignes[p]);
                MAIN.stepjButton3.setEnabled(false);
                MAIN.runjButton4.setEnabled(false);
            }else {
                setNEXT(lignes[p]);
            }
        }
    }
    
    //Undo
    public static void traiterUndo(String textarea) {
         // Récupère chaque ligne du textarea
         String[] lignes = textarea.split("\n");
         //p--;
         if(p==0)
         { JOptionPane.showMessageDialog(MAIN.editor, "Impossible de Défaire");
         }else{
         // Parcours chaque ligne  
        
         //dec p compteur global des lignes
         p--;
            setPC(MAIN.prog.prgTable.getValueAt(p, 0).toString());

             System.out.println(lignes[p].toUpperCase());
             String ligne=lignes[p].toUpperCase();
             ligne=ligne.toUpperCase();
           //Choix de mode d adressage
            if(ligne.contains("<$")){
                 adrDirect(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
            }else
            if(ligne.contains("#$")){
                 adrImmediat(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
            }else
              if(ligne.contains(">$")){
                 adrEtendu(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(ligne.contains("[$")){
                   adrEtenduIndirect(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
              if(ligne.contains(",")){
                   adrIndexe(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
              }else
            if(CONTENU.Inhe.containsKey(ligne)){
                 adrInherent(MAIN.arch, MAIN.ro,MAIN. ra,ligne);
            }else
            if(ligne.equalsIgnoreCase("END")){
                setNEXT(ligne);
            }else{
                ERROR();
            }
            

            if(p>=lignes.length-1){
                p=lignes.length-1;
                setNEXT(lignes[p]);
            }else {
                setNEXT(lignes[p]);
            }
        }
    }
    
   //setters
    public static void setA(String s){
        s=s.toUpperCase();
        if(s.length()==2){
            MAIN.arch.regA.setText(s);
        }else{
            ERROR();
        }
    }
    public static void setB(String s){
        s=s.toUpperCase();
        if(s.length()==2){
            MAIN.arch.regB.setText(s);
        }else{
            ERROR();
        }
    }
    public static void setS(String s){
        s=s.toUpperCase();
        if(s.length()==4){
            MAIN.arch.regS.setText(s);
        }else{
            ERROR();
        }
    }
    public static void setU(String s){
        s=s.toUpperCase();
        if(s.length()==4){
            MAIN.arch.regU.setText(s);
        }else{
            ERROR();
        }
    }
    public static void setX(String s){
        s=s.toUpperCase();
        if(s.length()==4){
            MAIN.arch.regX.setText(s);
        }else{
            ERROR();
        }
    }
    public static void setY(String s){
        s=s.toUpperCase();
        if(s.length()==4){
            MAIN.arch.regY.setText(s);
        }else{
            ERROR();
        }
    }
    public static void setDP(String s){
        s=s.toUpperCase();
        if(s.length()==2){
            MAIN.arch.regDP.setText(s);
        }else{
            ERROR();
        }
    }
    public static void setPC(String s){
        MAIN.arch.regPC.setText(s.toUpperCase());
    }
    public static void setFLAG(String s){
        MAIN.arch.regFLAGS.setText(s.toUpperCase());
    }
    public static void setNEXT(String s){
        MAIN.arch.nextINSTR.setText(s.toUpperCase());
    }
    public static void setD(String s){
        s=s.toUpperCase();
        if(s.length()==4){
            MAIN.arch.regA.setText(s.substring(0,2));
            MAIN.arch.regB.setText(s.substring(2));
        }else{
            ERROR();
        }
    }
    //ERRORS
    public static void ERROR(){
        JOptionPane.showMessageDialog(MAIN.editor, "votre programme comporte des erreurs");
    }
    public static void ERROR2(){
        JOptionPane.showMessageDialog(MAIN.editor, "Pas traité");
    }
    //ROM
    //indice de programme
    public static int j;
    public static void setROM(String s){
        s=s.toUpperCase();
        int i;
        for( i =0;i<MAIN.ro.model.getRowCount();i++){
            if("FF".equals(MAIN.ro.model.getValueAt(i, 1))){
                //memorisation de la case ROM
                j=i+1;
                break;                        
            }
        }
        if(s.length()>2){
            MAIN.ro.model.setValueAt(s.substring(0,2),i,1);
            MAIN.ro.model.setValueAt(s.substring(2),i+1,1);
        }else{
            MAIN.ro.model.setValueAt(s,i,1);
        }
                
                
    }
    //set PRG
    public static void setPRG(String adr,String value){
        String data[]={adr.toUpperCase(),value.toUpperCase()};
        DefaultTableModel tblmodel = (DefaultTableModel)MAIN.prog.prgTable.getModel();
        tblmodel.addRow(data);
        MAIN.prog.prgTable.getModel();
        
    }
    
}