package pe.intercorpretail.demo.dominio;

import java.time.LocalDate;

public class Cliente {

    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private LocalDate fechaNacimiento;

    public Cliente(String nombre, String apellido, int edad, LocalDate fechaNacimiento) {
        this(null, nombre, apellido, edad, fechaNacimiento);
    }

    public Cliente(Long id, String nombre, String apellido, int edad, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
