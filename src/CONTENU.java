
import java.util.HashMap;

public class CONTENU {
    
    //IMMEDIAT
    public static HashMap<String, Integer> Imme = new HashMap<>();
    public static void remplirImmediat(){
        //ADC
        Imme.put("ADCA", 0x89);
        Imme.put("ADCB", 0xC9);
        //ADD
        Imme.put("ADDA", 0x8B);
        Imme.put("ADDB", 0xCB);
        Imme.put("ADDD", 0xC3);
        //AND
        Imme.put("ANDA", 0x84);
        Imme.put("ANDB", 0xC4);
        Imme.put("ANDCC", 0x1C);
        // BIT
        Imme.put("BITA", 0x85);
        Imme.put("BITB", 0xC5);
        //CMP
        Imme.put("CMPA", 0x81);
        Imme.put("CMPB", 0xC1);
        Imme.put("CMPD", 0x1083);
        Imme.put("CMPS", 0x118C);
        Imme.put("CMPU", 0x1183);
        Imme.put("CMPX", 0x8C);
        Imme.put("CMPY", 0x108C);
        // CWAI
        Imme.put("CWAI", 0x3C);
        //EOR
        Imme.put("EORA", 0x88);
        Imme.put("EORB", 0xC8);
        //EXG
        Imme.put("EXG", 0x1E);
        // LD
        Imme.put("LDA", 0x86);
        Imme.put("LDB", 0xC6);
        Imme.put("LDD", 0xCC);
        Imme.put("LDS", 0x10CE);
        Imme.put("LDU", 0xCE);
        Imme.put("LDX", 0x8E);
        Imme.put("LDY", 0x108E);
        //OR
        Imme.put("ORA", 0x8A);
        Imme.put("ORB", 0xCA);
        Imme.put("ORCC", 0x1A);
        //PSH
        Imme.put("PSHS", 0x34);
        Imme.put("PSHU", 0x36);
        //PUL
        Imme.put("PULS", 0x35);
        Imme.put("PULU", 0x37);
        //SUB
        Imme.put("SBCA", 0x82);
        Imme.put("SBCB", 0xC2);
        //SUB
        Imme.put("SUBA", 0x80);
        Imme.put("SUBB", 0xC0);
        Imme.put("SUBD", 0x83);
        //TFR
        Imme.put("TFR", 0x1F);
    }
    
    //DIRECT
    public static HashMap<String, Integer> Dire = new HashMap<>();
     public static void remplirDirect(){
        //ADC
        Dire.put("ADCA", 0x99);
        Dire.put("ADCB", 0xD9);
        //ADD
        Dire.put("ADDA", 0x9B);
        Dire.put("ADDB", 0xDB);
        Dire.put("ADDD", 0xD3);
        //AND
        Dire.put("ANDA", 0x94);
        Dire.put("ANDB", 0xD4);
        //ASL
        Dire.put("ASL", 0x08);
        //ASR
        Dire.put("ASR", 0x07);
        // BIT
        Dire.put("BITA", 0x95);
        Dire.put("BITB", 0xD5);
        //CMP
        Dire.put("CMPA", 0x91);
        Dire.put("CMPB", 0xD1);
        Dire.put("CMPD", 0x1093);
        Dire.put("CMPS", 0x119C);
        Dire.put("CMPU", 0x1193);
        Dire.put("CMPX", 0x9C);
        Dire.put("CMPY", 0x109C);
        // COM
        Dire.put("COM", 0x03);
        //DEC
        Dire.put("DEC", 0x0A);
        //EOR
        Dire.put("EORA", 0x98);
        Dire.put("EORB", 0xD8);
        //INC
        Dire.put("INC", 0x0C);
        //JMP
        Dire.put("JMP", 0x0E);
        //JSR
        Dire.put("JSR", 0x9D);
        // LD
        Dire.put("LDA", 0x96);
        Dire.put("LDB", 0xD6);
        Dire.put("LDD", 0xDC);
        Dire.put("LDS", 0x10DE);
        Dire.put("LDU", 0xDE);
        Dire.put("LDX", 0x9E);
        Dire.put("LDY", 0x109E);
        //LSL
        Dire.put("INC", 0x08);
        //LSR
        Dire.put("INC", 0x04);
        //NEG
        Dire.put("NEG", 0x00);
        //ORA
        Dire.put("ORA", 0x9A);
        Dire.put("ORB", 0xDA);
        //ROL
        Dire.put("PSHS", 0x09);
        //ROR
        Dire.put("PSHU", 0x06);
        //SBC
        Dire.put("SBCA", 0x92);
        Dire.put("SBCB", 0xD2);
        //ST
        Dire.put("STA", 0x97);
        Dire.put("STB", 0xD7);
        Dire.put("STD", 0xDD);
        Dire.put("STS", 0x10DF);
        Dire.put("STU", 0xDF);
        Dire.put("STX", 0x9F);
        Dire.put("STY", 0x109F);
        //SUB
        Dire.put("SUBA", 0x90);
        Dire.put("SUBB", 0xD0);
        Dire.put("SUBD", 0x93);
        //TST
        Dire.put("TST", 0x0D);
    }  
    
   //Etendu
public static HashMap<String, Integer> ETD = new HashMap<>();
    public static void remplirEtendu(){
        ETD.put("ADCA", 0xB9);
        ETD.put("ADCB", 0xF9);
        //ADD
        ETD.put("ADDA", 0xBB);
        ETD.put("ADDB", 0xFB);
        ETD.put("ADDD", 0xF3);
        //AND
        ETD.put("ANDA", 0xB4);
        ETD.put("ANDB", 0xF4);
        //ASL
        ETD.put("ASL", 0x78);
        //ASR
        ETD.put("ASR", 0x77);
        // BIT
        ETD.put("BITA", 0xB5);
        ETD.put("BITB", 0xF5);
        //CLR
        ETD.put("CLR", 0x7F);
        //CMP
        ETD.put("CMPA", 0xB1);
        ETD.put("CMPB", 0xF1);
        ETD.put("CMPD", 0x10B3);
        ETD.put("CMPS", 0x11BC);
        ETD.put("CMPU", 0x11B3);
        ETD.put("CMPX", 0xBC);
        ETD.put("CMPY", 0x10BC);
        // COM
        ETD.put("COM", 0x73);
        //DEC
        ETD.put("DEC", 0x7A);
        //EOR
        ETD.put("EORA", 0xB8);
        ETD.put("EORB", 0xF8);
        //INC
        ETD.put("INC", 0x7C);
        //JMP
        ETD.put("JMP", 0x7E);
        //JSR
        ETD.put("JSR", 0xBD);
        // LD
        ETD.put("LDA", 0xB6);
        ETD.put("LDB", 0xF6);
        ETD.put("LDD", 0xFC);
        ETD.put("LDS", 0x10FE);
        ETD.put("LDU", 0xFE);
        ETD.put("LDX", 0xBE);
        ETD.put("LDY", 0x10BE);
        //LSL
        ETD.put("INC", 0x78);
        //LSR
        ETD.put("INC", 0x74);
        //NEG
        ETD.put("NEG", 0x70);
        //ORA
        ETD.put("ORA", 0xBA);
        ETD.put("ORB", 0xFA);
        //ROL
        ETD.put("PSHS", 0x79);
        //ROR
        ETD.put("PSHU", 0x76);
        //SBC
        ETD.put("SBCA", 0xB2);
        ETD.put("SBCB", 0xF2);
        //ST
        ETD.put("STA", 0xB7);
        ETD.put("STB", 0xF7);
        ETD.put("STD", 0xFD);
        ETD.put("STS", 0x10FF);
        ETD.put("STU", 0xFF);
        ETD.put("STX", 0xBF);
        ETD.put("STY", 0x10BF);
        //SUB
        ETD.put("SUBA", 0xB0);
        ETD.put("SUBB", 0xF0);
        ETD.put("SUBD", 0xB3);
        //TST
        ETD.put("TST", 0x7D);
    }
    //INHERENT
    public static HashMap<String, Integer> Inhe = new HashMap<>();
    public static void remplirInherent(){
        Inhe.put("ABX", 0x3A);
        //ASL
        Inhe.put("ASLA", 0x48);
        Inhe.put("ASLB", 0x58);
        //ASR
        Inhe.put("ASRA", 0x47);
        Inhe.put("ASRB", 0x57);
        //CLR
        Inhe.put("CLRA", 0x4F);
        Inhe.put("CLRB", 0x5F);
        // COM
        Inhe.put("COMA", 0x43);
        Inhe.put("COMB", 0x53);
        //DA
        Inhe.put("DAA", 0x19);
        //DEC
        Inhe.put("DECA", 0x4A);
        Inhe.put("DECB", 0x5A);
        //INC
        Inhe.put("INCA", 0x4C);
        Inhe.put("INCB", 0x5C);
        //LSL
        Inhe.put("LSLA", 0x48);
        Inhe.put("LSLB", 0x58);
        //LSR
        Inhe.put("LSRA", 0x44);
        Inhe.put("LSRB", 0x54);
        //MUL
        Inhe.put("MUL", 0x3D);
        //NEG
        Inhe.put("NEGA", 0x40);
        Inhe.put("NEGB", 0x50);
        //NOP
        Inhe.put("NOP", 0x12);
        //ROL
        Inhe.put("ROLA", 0x49);
        Inhe.put("ROLB", 0x59);
        //ROR
        Inhe.put("RORA", 0x46);
        Inhe.put("RORB", 0x56);
        //RT
        Inhe.put("RTI", 0x3B);
        Inhe.put("RTS", 0x39);
        //SE
        Inhe.put("SEX", 0x1D);
        //SWI
        Inhe.put("SWI", 0x3F);
        Inhe.put("SWI2", 0x103F);
        Inhe.put("SWI3", 0x113F);
        //SYN
        Inhe.put("SYNC", 0x13);
        //TST
        Inhe.put("TSTA", 0x4D);
        Inhe.put("TSTB", 0x5D);
    }
    //INDEXE
    public static HashMap<String, Integer> Inde = new HashMap<>();
    public static void remplirIndexe(){
        //LEA
        Inde.put("LEAX", 0x30);
        Inde.put("LEAY", 0x31);
        Inde.put("LEAS", 0x32);
        Inde.put("LEAU", 0x33);
        //
    }
    
    
    
}
