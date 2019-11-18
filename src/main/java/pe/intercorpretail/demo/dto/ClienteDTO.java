package pe.intercorpretail.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class ClienteDTO {

    @NotEmpty(message = "Nombre no puede estar vacío")
    private String nombre;

    @NotEmpty(message = "Apellido no puede estar vacío")
    private String apellido;

    @NotEmpty(message = "Edad no puede estar vacío")
    @Min(value = 1, message = "Edad inválida")
    private Integer edad;

    @NotEmpty(message = "Fecha de nacimiento no puede estar vacío")
    private LocalDate fechaNacimiento;

    private LocalDate fechaProbableMuerte;

    public ClienteDTO() {}

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

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
