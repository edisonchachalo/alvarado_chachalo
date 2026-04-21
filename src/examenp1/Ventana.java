package examenp1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

                }
            }
        });
    }
}
