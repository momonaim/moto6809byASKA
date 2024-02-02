import javax.swing.event.*;

public class registreCC {
    public static void testAZN(JFrameARCH ar){
        DocumentListener listener = new DocumentListener() {
            // Méthode appelée inséré, supprimé ou remplacé
            public void update(DocumentEvent e) {
                // Afficher 1 lorsque le registre est negatif
                if(ar.regA.getText().equals("00")){ar.Z.setText("1");
                }else{ar.Z.setText("0");}
                // Convertir le string en un entier en base 16
                int n = Integer.parseInt(ar.regA.getText(), 16);
                // Extraire le bit de signe du nombre
                int signe = n & 0x80;
                // Vérifier si le bit de signe est 1 ou 0
                if (signe == 0x80) {
                    // Si oui, le nombre est négatif
                    ar.N.setText("1");
                    System.out.println("Le nombre est negatif");
                } else {
                    // Sinon, le nombre est positif
                    ar.N.setText("0");
                    System.out.println("Le nombre est positif");
                }
                
            }
            // Appeler la méthode update pour les trois types d’événements
            @Override
            public void insertUpdate(DocumentEvent e) {update(e);System.out.println("inserA");}
            @Override
            public void removeUpdate(DocumentEvent e) {}
            @Override
            public void changedUpdate(DocumentEvent e) {update(e);System.out.println("chA");}
        };
        // Ajouter le documentListener au document de la jtextArea
        ar.regA.getDocument().addDocumentListener(listener);
    }
    
    public static void testBZN(JFrameARCH ar){
        DocumentListener listener = new DocumentListener() {
            // Méthode appelée inséré, supprimé ou remplacé
            public void update(DocumentEvent e) {
                // Afficher 1 lorsque le registre est negatif
                if(ar.regB.getText().equals("00")){ar.Z.setText("1");
                }else{ar.Z.setText("0");}
                // Convertir le string en un entier en base 16
                int n = Integer.parseInt(ar.regB.getText(), 16);
                // Extraire le bit de signe du nombre
                int signe = n & 0x80;
                // Vérifier si le bit de signe est 1 ou 0
                if (signe == 0x80) {
                    // negatif
                    ar.N.setText("1");
                    System.out.println("Le nombre est negatif");
                } else {
                    // positif
                    ar.N.setText("0");
                    System.out.println("Le nombre est positif");
                }
                   
            }
            // Appeler la méthode update pour les trois types d’événements
            @Override
            public void insertUpdate(DocumentEvent e) {update(e);System.out.println("inserB");}
            @Override
            public void removeUpdate(DocumentEvent e) {}
            @Override
            public void changedUpdate(DocumentEvent e) {update(e);System.out.println("chB");}
        };
        // Ajouter le documentListener au document de la jtextArea
        ar.regB.getDocument().addDocumentListener(listener);
    }
    
   


}
