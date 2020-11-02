package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class Controlador implements ActionListener {

    boolean nuevaPregunta = true, primerIntento = true;
    public JF_Ventana auxiliar;
    double resultado = 0;
    int contador = 0, contAciertos = 0;

    public Controlador(JF_Ventana ventana) {
        auxiliar = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int num1, num2;

        if (nuevaPregunta) {
            num1 = obtenerNumero();
            num2 = obtenerNumero();
            resultado = calculaResultado(num1, num2);
            if (!auxiliar.getOperacion().equals("Aleatorio")) {
                auxiliar.setPregunta(num1, num2);
            }
            nuevaPregunta = false;
            if (contador == 10) {
                float porcentaje = 0;
                porcentaje = (contAciertos * 100) / contador;
                if (porcentaje <= 75 || contAciertos == 0) {
                    JOptionPane.showMessageDialog(null, "Por favor pida ayuda "
                            + "adicional a su instructor");
                } else {
                    JOptionPane.showMessageDialog(null, "Lo haces muy bien, "
                            + "sigue practicando!!!");
                }
                contador = 1;
                contAciertos = 0;
            } else {
                contador++;
            }
            System.out.println(contador);
        }//fin if(nuevaPregunta)
        else {
            if (primerIntento) {
                if (auxiliar.getResultado() == resultado) {
                    contAciertos++;
                    this.comCorrecto();
                    System.out.println("Acierto!" + contAciertos);
                    nuevaPregunta = true;
                } else {
                    primerIntento = false;
                    this.comErroneo();
                }

            }//fin if(primerIntento)
            else {
                if (auxiliar.getResultado() == resultado) {
                    this.comCorrecto();
                    primerIntento = true;
                    nuevaPregunta = true;
                } else {
                    this.comErroneo();
                }
            }

        }

    }//fin metodo actionPerformed

    public int obtenerNumero() {
        int num = 0;
        if (auxiliar.getDificultad().equals("1 digito")) {
            num = 1 + (int) (Math.random() * 9);
        } else if (auxiliar.getDificultad().equals("2 digitos")) {
            num = 1 + (int) (Math.random() * 99);
        }
        return num;
    }

    public double calculaResultado(int n1, int n2) {
        double res = 0;

        if (auxiliar.getOperacion().equals("Aleatorio")) {
            int num = 1 + (int) (Math.random() * 4);
            switch (num) {
                case 1:
                    res = n1 + n2;
                    break;
                case 2:
                    res = n1 - n2;
                    break;
                case 3:
                    res = n1 * n2;
                    break;
                default:
                    res = n1 / n2;
            }//fin switch
            auxiliar.setPregunta(n1, n2, num);
        } else if (auxiliar.getOperacion().equals("Suma")) {
            res = n1 + n2;
        } else if (auxiliar.getOperacion().equals("Resta")) {
            res = n1 - n2;
        } else if (auxiliar.getOperacion().equals("Multiplicacion")) {
            res = n1 * n2;
        } else if (auxiliar.getOperacion().equals("Division")) {
            res = n1 / n2;
        }
        return res;
    }

    public void comCorrecto() {
        int num;
        num = 1 + (int) (Math.random() * 4);
        switch (num) {
            case 1:
                auxiliar.setObservacion("Muy bien!");
                break;
            case 2:
                auxiliar.setObservacion("Excelente!");
                break;
            case 3:
                auxiliar.setObservacion("Buen Trabajo!");
                break;
            default:
                auxiliar.setObservacion("Sigue Asi!");
        }

    }

    public void comErroneo() {
        int num = 0;
        num = 1 + (int) (Math.random() * 4);

        switch (num) {
            case 1:
                auxiliar.setObservacion("No. Por favor intenta de nuevo!");
                break;
            case 2:
                auxiliar.setObservacion("Incorrecto. Intenta una vez mas!");
                break;
            case 3:
                auxiliar.setObservacion("No te rindas!");
                break;
            default:
                auxiliar.setObservacion("No. sigue intentando!");
        }

    }

}//fin clase Controlador

