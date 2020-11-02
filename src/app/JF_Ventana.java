package app;

public class JF_Ventana extends javax.swing.JFrame {

    public JF_Ventana() {
        initComponents();
        
        //registrar este applet como ActionListener de lanzarBoton
        Controlador ctrEvento = new Controlador(this);
        aceptarBoton1.addActionListener(ctrEvento);
        resCampo2.addActionListener(ctrEvento);
        
        salirBoton.addActionListener(e ->{
            System.exit(0);
        });
    }
    
    public double getResultado() {
        int Dnumero;
        String Snumero;
        Snumero = resCampo2.getText();
        Dnumero = Integer.parseInt(Snumero);
        return Dnumero;
    }
    
    public String getDificultad() {
        String dif;
        dif = (String) dificultadCombo.getSelectedItem();
        return dif;
    }

    public String getOperacion() {
        String op;
        op = (String) operacionCombo.getSelectedItem();
        return op;
    }

    public void setPregunta(int n1, int n2) {
        String preg = "";
        if (getOperacion().equals("Suma")) {
            preg = preg + n1 + " + " + n2;
        }
        if (getOperacion().equals("Resta")) {
            preg = preg + n1 + " - " + n2;
        }
        //
        if (getOperacion().equals("Multiplicacion")) {
            preg = preg + n1 + " x " + n2;
        }
        if (getOperacion().equals("Division")) {
            preg = preg + n1 + " / " + n2;
        }

        pregCampo.setText(preg);
    }

    public void setPregunta(int n1, int n2, int num) {
        String preg = "";

        switch (num) {
            case 1:
                preg = preg + n1 + " + " + n2;
                break;
            case 2:
                preg = preg + n1 + " - " + n2;
                break;
            case 3:
                preg = preg + n1 + " x " + n2;
                break;
            default:
                preg = preg + n1 + " / " + n2;
        }
        pregCampo.setText(preg);
    }

    public void setObservacion(String cad) {
        obsCampo.setText(cad);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        obsEtiqueta = new javax.swing.JLabel();
        resEtiqueta = new javax.swing.JLabel();
        pregCampo = new javax.swing.JTextField();
        pregEtiqueta = new javax.swing.JLabel();
        obsCampo = new javax.swing.JTextField();
        resCampo2 = new javax.swing.JTextField();
        salirBoton = new javax.swing.JButton();
        aceptarBoton1 = new javax.swing.JButton();
        operacionCombo = new javax.swing.JComboBox<>();
        dificultadCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        obsEtiqueta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        obsEtiqueta.setText("Observación:");
        getContentPane().add(obsEtiqueta);
        obsEtiqueta.setBounds(10, 110, 90, 40);

        resEtiqueta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resEtiqueta.setText("Resultado:");
        getContentPane().add(resEtiqueta);
        resEtiqueta.setBounds(10, 60, 90, 40);

        pregCampo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        pregCampo.setEnabled(false);
        getContentPane().add(pregCampo);
        pregCampo.setBounds(110, 10, 430, 40);

        pregEtiqueta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pregEtiqueta.setText("¿Cúanto es?");
        getContentPane().add(pregEtiqueta);
        pregEtiqueta.setBounds(10, 10, 90, 40);
        getContentPane().add(obsCampo);
        obsCampo.setBounds(110, 110, 430, 40);
        getContentPane().add(resCampo2);
        resCampo2.setBounds(110, 60, 140, 40);

        salirBoton.setText("Salir");
        getContentPane().add(salirBoton);
        salirBoton.setBounds(350, 180, 120, 40);

        aceptarBoton1.setText("Aceptar");
        getContentPane().add(aceptarBoton1);
        aceptarBoton1.setBounds(190, 180, 120, 40);

        operacionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Suma", "Resta", "Multiplicacion", "Division", "Aleatorio" }));
        getContentPane().add(operacionCombo);
        operacionCombo.setBounds(570, 80, 180, 40);

        dificultadCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 digito", "2 digitos" }));
        getContentPane().add(dificultadCombo);
        dificultadCombo.setBounds(570, 30, 180, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBoton1;
    private javax.swing.JComboBox<String> dificultadCombo;
    private javax.swing.JTextField obsCampo;
    private javax.swing.JLabel obsEtiqueta;
    private javax.swing.JComboBox<String> operacionCombo;
    private javax.swing.JTextField pregCampo;
    private javax.swing.JLabel pregEtiqueta;
    private javax.swing.JTextField resCampo2;
    private javax.swing.JLabel resEtiqueta;
    private javax.swing.JButton salirBoton;
    // End of variables declaration//GEN-END:variables

}
