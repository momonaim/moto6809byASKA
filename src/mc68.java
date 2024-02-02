import java.awt.*;



public class mc68 {
    public static void main(String[] args) { 
        //MAIN
        MAIN mm =new MAIN();
        mm.setIconImage(Toolkit.getDefaultToolkit().
        getImage(JFrame_Icon.class.getResource("images/logo.png")));
        mm.setVisible(true);   
    }
    private static class JFrame_Icon {

        public JFrame_Icon() {
        }
    }


}