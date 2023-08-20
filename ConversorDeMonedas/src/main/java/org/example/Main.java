package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        Convertidor();
    }
    private static void changeCoin(Double amount) {
        String[] typeOfChange = {"Peso Mx a $ Dólar", "Peso Mx a € Euro", "Peso Mx a £ Libra Esterlina", "Peso Mx a ¥ Yen Japonés", "Peso Mx a ₩ Won sur-coreano",
                "$ Dólar a Peso Mx", "€ Euro a Peso Mx", "£ Libra Esterlina a Peso Mx", "¥ Yen Japonés a Peso Mx", "₩ Won sur-coreano a Peso Mx"};
        int index = menu(typeOfChange, "Conversion de monedas", "Seleccione un tipo de cambio");
        Map<Integer, String> values = new HashMap<>();
        values.put(0, "Tienes :" + new DecimalFormat("0.00").format(amount / 17.0581) + " Dolares");
        values.put(1, "Tienes :" + new DecimalFormat("0.00").format(amount / 18.55) + " Euros");
        values.put(2, "Tienes :" + new DecimalFormat("0.00").format(amount / 21.72) + " Libras Esterlinas");
        values.put(3, "Tienes :" + new DecimalFormat("0.00").format(amount / 0.1173144379) + " Yens Japonés");
        values.put(4, "Tienes :" + new DecimalFormat("0.00").format(amount / 0.012728411) + " Wons sur-coreano");
        values.put(5, "Tienes :" + new DecimalFormat("0.00").format(amount * 17.0581) + " Pesos Mx");
        values.put(6, "Tienes :" + new DecimalFormat("0.00").format(amount * 18.55) + " Pesos Mx");
        values.put(7, "Tienes :" + new DecimalFormat("0.00").format(amount * 21.72) + " Pesos Mx");
        values.put(8, "Tienes :" + new DecimalFormat("0.00").format(amount * 0.1173144379) + " Pesos Mx");
        values.put(9, "Tienes :" + new DecimalFormat("0.00").format(amount * 0.012728411) + " Pesos Mx");
        message(values.get(index));
    }
    private static void changeTemperature(Double magnitude) {
        String[] typeOfChange ={"centigrados °C a farenheit °F", "centigrados °C a kelvin K", "kelvin K a fahrenheit °F"};
        int index = menu(typeOfChange, "Conversion de de magnitudes", "Seleccione un tipo de cambio");
        Map<Integer, String> values = new HashMap<>();
        values.put(0, "Tienes :" + new DecimalFormat("0.00").format((magnitude*9/5)+32) + " °F");
        values.put(1, "Tienes :" + new DecimalFormat("0.00").format(magnitude +273.15) + " K");
        values.put(2, "Tienes :" + new DecimalFormat("0.00").format( (magnitude-273.15) * 9/5 + 32) + " °F");
        message(values.get(index));
    }
    public static int menu(String array[], String title, String message) {
        ArrayList<String> options = new ArrayList<>(Arrays.asList(array));
        Object option = JOptionPane.showInputDialog(null,
                message, title,
                JOptionPane.INFORMATION_MESSAGE, null,
                array, array[0]);
        return options.indexOf(option);
    }
    private static void message(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    private static double input(String mensaje) {
        try {
            return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
        } catch (NullPointerException ex) {
            throw new NullPointerException();
        }
    }
    private static void Convertidor() {
        JButton button1 = new JButton("Conversor de monedas");
        JButton button2 = new JButton("Conversor de temperatura");
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource().equals(button1)) {
                        changeCoin(input("Ingrese la cantidad a convertir"));
                    }
                    if (e.getSource().equals(button2)) {
                        changeTemperature(input("Ingrese la cantidad a convertir"));
                    }
                } catch (NullPointerException | NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada");
                }
            }
        };
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        JButton[] mainOptions = {button1, button2};
        JOptionPane.showOptionDialog(null, mainOptions, "Selecciona una opción de conversion",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null,
                new String[]{"Salir"},
                null);
    }
}

