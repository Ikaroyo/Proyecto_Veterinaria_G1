
package veterinaria_MODELO;


public class Cliente {
    
    private int id_cliente;
    private long dni;
    private String apellido;
    
    private String nombreD;
    // nombre del dueñio //
    
    private String direccion;
    private String telefono;
    
    private String contactoA;
   // contacto alterntivo//
    
    private boolean activo;

    public Cliente(int id_cliente, long dni, String apellido, String nombreD, String direccion, String telefono, String contactoA, boolean activo) {
        this.id_cliente = -1;
        this.dni = dni;
        this.apellido = apellido;
        this.nombreD = nombreD;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contactoA = contactoA;
        this.activo=activo;
    }

    public Cliente(long dni, String apellido, String nombreD, String direccion, String telefono, String contactoA, boolean activo) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombreD = nombreD;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contactoA = contactoA;
        this.activo=activo;
    }

    public Cliente() {
        this.id_cliente = -1;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContactoA() {
        return contactoA;
    }

    public void setContactoA(String contactoA) {
        this.contactoA = contactoA;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", dni=" + dni + ", apellido=" + apellido + ", nombreD=" + nombreD + ", direccion=" + direccion + ", telefono=" + telefono + ", contactoA=" + contactoA + ", activo=" + activo + '}';
    }

   
    
}
