package examenp1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ColaTareas {
    private PriorityQueue<Tarea> tareas;

    //Constructor por defecto
    public ColaTareas(){
        tareas = new PriorityQueue<>();
        //5 objetos predefinidos
        tareas.add(new Tarea(1,"Cde","Administrativa",1000,8));
        tareas.add(new Tarea(2,"Efg","Directiva",2500,12));
        tareas.add(new Tarea(3,"Ghi","Operativa",800,6));
        tareas.add(new Tarea(4,"Jkl","Administrativa",1500,10));
        tareas.add(new Tarea(5,"Mno","Directiva",3000,11));
    }

    //R1
    public boolean encolar(Tarea nueva){
        for (Tarea t : tareas){
            if (t.getIdentificador()==nueva.getIdentificador()){
                return false;
            }
       }
        tareas.add(nueva);
        return true;
    }

    //mostrar los elementos
    public List<Tarea> listar(){
        return new ArrayList<>(tareas);
    }

    //R2
    public List<String> recalcularPresupuesto(){
        List<String> resultado = new ArrayList<>();
        for (Tarea t : tareas){
            float presupuestoAjustado = t.getPresupuesto();
            if (t.getCategoria().equalsIgnoreCase("Administrativa")){
                presupuestoAjustado = presupuestoAjustado * 0.90f;
            }
            if (t.getCategoria().equalsIgnoreCase("Directiva")){
                presupuestoAjustado = presupuestoAjustado * 0.80f;
            }
            if (t.getCategoria().equalsIgnoreCase("Operativa")){
                presupuestoAjustado = presupuestoAjustado * 0.95f;
            }
            resultado.add(t.toString()+"\nPresupuesto ajustado: "+presupuestoAjustado);
        }
        return resultado;
    }

    //R3
    public String totalesPorCategoria(String categoria){
        float totalOriginal=0;
        float totalAjustado=0;

        for (Tarea t : listar()){
            if (t.getCategoria().equalsIgnoreCase(categoria)){
                totalOriginal+=t.getPresupuesto();
                float presupuestoAjustado = t.getPresupuesto();

                if (t.getCategoria().equalsIgnoreCase("Administrativa")){
                    presupuestoAjustado = presupuestoAjustado * 0.90f;
                }
                if (t.getCategoria().equalsIgnoreCase("Directiva")){
                    presupuestoAjustado = presupuestoAjustado * 0.80f;
                }
                if (t.getCategoria().equalsIgnoreCase("Operativa")){
                    presupuestoAjustado = presupuestoAjustado * 0.95f;
                }
                totalAjustado += presupuestoAjustado;
            }
        }
        return "Categoria: "+categoria+
                "\nTotal presupuesto original: "+ totalOriginal+
                "\nTotal presupuesto ajustado: "+ totalAjustado;
    }

}
