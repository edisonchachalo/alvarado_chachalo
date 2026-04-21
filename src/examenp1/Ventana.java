package examenp1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ClientInfoStatus;
import java.util.List;

public class Ventana {
    private JPanel Ventana;
    private JTextField txtIdentificar;
    private JTextField txtNombre;
    private JTextField txtPresupuesto;
    private JComboBox cmbCategoria;
    private JComboBox cmbPrioridad;
    private JButton btnIngresar;
    private JButton btnRecalcular;
    private JButton btnTotales;
    private JTextArea textArea1;

    private  ColaTareas cola;

    public Ventana (){
        cola = new ColaTareas();

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(txtIdentificar.getText());
                    String nombre = txtNombre.getText();
                    float presupuesto = Float.parseFloat(txtPresupuesto.getText());
                    String categoria = cmbCategoria.getSelectedItem().toString();
                    int prioridad = Integer.parseInt(cmbPrioridad.getSelectedItem().toString());
                    Tarea nueva = new Tarea(id,nombre,categoria,presupuesto,prioridad);

                    boolean agregado = cola.encolar(nueva);
                    if (!agregado){
                        textArea1.setText("identificador repetido");
                    }else {
                        mostrarTareas();

                    }
                    setear();

                }catch (Exception ex){
                    textArea1.setText("ingrese datos validos");
                }
            }
        });
        btnRecalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> lista = cola.recalcularPresupuesto();
                String resultado = " ";
                for (String s : lista){
                    resultado += s + "\n";
                }
                textArea1.setText(resultado);
            }
        });
        btnTotales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String categoria = cmbCategoria.getSelectedItem().toString();
                String resultado = cola.totalesPorCategoria(categoria);
                textArea1.setText(resultado);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setear() {
        txtIdentificar.setText("");
        txtNombre.setText("");
        txtPresupuesto.setText("");

    }

    public void mostrarTareas(){
        List<Tarea> lista = cola.listar();
        String resultado = " ";
        for (Tarea t: lista){
            resultado += t.toString();
        }
        textArea1.setText(resultado);
    }
















}
