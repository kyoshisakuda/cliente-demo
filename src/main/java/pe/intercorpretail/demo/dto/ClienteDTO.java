package pe.intercorpretail.demo.dto;

import java.time.LocalDate;

public class ClienteDTO {

    private String nombre;
    private String apellido;
    private Integer edad;
    private LocalDate fechaNacimiento;
    private LocalDate fechaProbableMuerte;

    public ClienteDTO(String nombre, String apellido, Integer edad, LocalDate fechaNacimiento) {
        this(nombre, apellido, edad, fechaNacimiento, null);
    }

    public ClienteDTO(String nombre, String apellido, Integer edad, LocalDate fechaNacimiento, LocalDate fechaProbableMuerte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaProbableMuerte = fechaProbableMuerte;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaProbableMuerte() {
        return fechaProbableMuerte;
    }

    public void setFechaProbableMuerte(LocalDate fechaProbableMuerte) {
        this.fechaProbableMuerte = fechaProbableMuerte;
    }
}
