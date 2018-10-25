
package Entidades;

/**
 *
 * @author vicente
 */
public class Empleado {
    String codigo;
    String nombre;
    String apellido;
    String direccion;
    String sueldo;
    String dni;
    String telefono;
    String fecha_entrada;
    String fecha_salida;
    String usuario;
    String contra;

    public Empleado() {
    }

    public Empleado(String codigo, String nombre, String apellido, String direccion, String sueldo, String dni, String telefono, String fecha_entrada, String fecha_salida, String usuario, String contra) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.sueldo = sueldo;
        this.dni = dni;
        this.telefono = telefono;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.usuario = usuario;
        this.contra = contra;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contra;
    }

    public void setContraseña(String contraseña) {
        this.contra = contraseña;
    }


    
}
