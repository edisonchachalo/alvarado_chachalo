package examenp1;
//Alvardo Joel
//Chachalo Edison
public class Tarea {
    //Atributos
    private int identificador;
    private String nombre;
    private String categoria;
    private float presupuesto;
    private int prioridad;

    //Constructor por defecto
    public Tarea (){
        //valores predefinidos
        this.identificador = 0;
        this.nombre="Abc";
        this.categoria="Administrativa";
        this.presupuesto=1000;
        this.prioridad=1;
    }

    //Constructor con parámetros
    public Tarea(int identificador, String nombre, String categoria, float presupuesto, int prioridad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.categoria = categoria;
        this.presupuesto = presupuesto;
        this.prioridad = prioridad;
    }

    //Setters y Getters

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    //Método para mostrar la información

    @Override
    public String toString() {
        return "PRESUPUESTO" +
                "\nIdentificador: " + identificador +
                "\nNombre: " + nombre +
                "\nCategoria: " + categoria +
                "\nPresupuesto: " + presupuesto +
                "\nPrioridad: " + prioridad;
    }

    //Comparable para prioridad
    //@Override
    public int compareTo (Tarea t){
        if  (this.prioridad > t.getPrioridad()){
            return -1; //primero la prioridad más alta
        } else if(this.prioridad < t.getPrioridad()){
            return 1;
        } else{
            return 0;
        }
    }


}
