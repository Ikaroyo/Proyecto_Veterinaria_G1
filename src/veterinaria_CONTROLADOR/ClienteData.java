package veterinaria_CONTROLADOR;

import static VISTAS.Menu_PRINCIPAL_VETERINARIA.cd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import veterinaria_MODELO.Cliente;
import veterinaria_MODELO.Mascota;

public class ClienteData {

    private Connection con = null;

    public ClienteData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error en la conexion");
        }
    }

    public void agregarCliente(Cliente p_cliente) {

        // String de consulta a base de datos
        String sql = "INSERT INTO cliente (dni, apellido, nombre_duenio, direccion, telefono, contacto_alternativo, activo)  VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, p_cliente.getDni());
            ps.setString(2, p_cliente.getApellido());
            ps.setString(3, p_cliente.getNombreD());
            ps.setString(4, p_cliente.getDireccion());
            ps.setString(5, p_cliente.getTelefono());
            ps.setString(6, p_cliente.getContactoA());
            ps.setInt(7, p_cliente.getActivo() ? 1 : 0);

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                p_cliente.setId_cliente(rs.getInt(1));
                //JOptionPane.showMessageDialog(null, " Numero de cliente = " + p_cliente.getId_cliente() + " " + p_cliente.getApellido() + "," + p_cliente.getNombreD() + ":" + " cargado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No genero el id del cliente");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde insertar cliente " + ex);

        }
    }

    public Cliente buscarCliente(int p_id_cliente) {

        // Iniciacion null de la variable cliente
        Cliente cliente = null;

        // String de consulta a base de datos
        String sql = "SELECT * FROM cliente WHERE activo = 1 AND id_cliente =?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_id_cliente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                /* Instanciado de cliente encontrado en la BD con todos sus parametros */
                cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setDni(rs.getLong("dni"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombreD(rs.getString("nombre_duenio"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setContactoA(rs.getString("contacto_alternativo"));
                cliente.setActivo(rs.getBoolean("activo"));

                // Mensaje de cliente encontrado
                //JOptionPane.showMessageDialog(null, " Cliente :" + cliente.getApellido() + "," + cliente.getNombreD());

            } else {
                // Mensaje de cliente no encontrado
                JOptionPane.showMessageDialog(null, " Cliente inexistente");
                JOptionPane.showMessageDialog(null, "¿Desea ingresar un nuevo cliente?");
                // agregar opcion de cargar nuevo cliente va en la vista del cliente//

            }
            ps.close();
        } catch (SQLException ex) {
            // Mensaje de error de acceso a la base de datos
            JOptionPane.showMessageDialog(null, " Error de conexion desde buscar alumno " + ex);

        }

        return cliente;
    }

    public Cliente buscarClientexDNI(long p_dni) {

        // Iniciacion null de la variable cliente
        Cliente cliente = null;

        // String de consulta a base de datos
        String sql = "SELECT * FROM cliente WHERE activo = 1 AND dni =?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, (int) p_dni);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                /* Instanciado de cliente encontrado en la BD con todos sus parametros */
                cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setDni(rs.getLong("dni"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombreD(rs.getString("nombre_duenio"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setContactoA(rs.getString("contacto_alternativo"));
                cliente.setActivo(rs.getBoolean("activo"));

                // Mensaje de cliente encontrado
                //JOptionPane.showMessageDialog(null, "Cliente existente :" + " " + cliente.getApellido() + " " + cliente.getNombreD());

            } else {
                // Mensaje de cliente no encontrado
       

            }
            ps.close();
        } catch (SQLException ex) {
            // Mensaje de error de acceso a la base de datos
            JOptionPane.showMessageDialog(null, " Error de conexion desde buscar alumno " + ex);

        }

        return cliente;
    }

    // p_cliente sin id_cliente //
    public void modificarCliente(int p_id_cliente, Cliente p_cliente) {

        // String de consulta a base de datos
        String sql = "UPDATE cliente SET dni=?, apellido=?, nombre_duenio=?, direccion=?, telefono=?, contacto_alternativo=?, activo=? WHERE id_cliente=?;";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, p_cliente.getDni());
            ps.setString(2, p_cliente.getApellido());
            ps.setString(3, p_cliente.getNombreD());
            ps.setString(4, p_cliente.getDireccion());
            ps.setString(5, p_cliente.getTelefono());
            ps.setString(6, p_cliente.getContactoA());
            ps.setInt(7, p_cliente.getActivo() ? 1 : 0);
            ps.setInt(8, p_id_cliente);

            int rs = ps.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, " Cliente se actualizado exitosamente ");
            } else {
                JOptionPane.showMessageDialog(null, " Cliente No se pudo actualizar ");
// cliente no se pudo actualizar porque no existe? 
// no se pudo actualizar algun campo en particular?
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde insertar cliente " + ex);

        }
    }
// borrado logico tambien funciona para desactivar al cliente //

    public void borrarCliente(int p_id_cliente) {

        // String de consulta a base de datos
        String sql = "UPDATE cliente SET activo =0 WHERE id_cliente=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_id_cliente);

            int rs = ps.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Cliente borrado exitosamente ");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar, cliente inexistente ");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde insertar cliente " + ex);

        }
    }

    public void activarCliente(int p_id_cliente) {

        String sql = "UPDATE cliente SET activo =1 WHERE id_cliente=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_id_cliente);

            int rs = ps.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Cliente activado ");
            } else {
                JOptionPane.showMessageDialog(null, " No se puede activar cliente: N° DE CLIENTE INEXISTENTE ");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde activar Cliente " + ex);

        }
    }
// se utiliza para la vista CONSULTAS//
    
    	public void desactivarCliente(int p_id_cliente){
	
	// String de consulta a base de datos
        String sql = "UPDATE cliente SET activo =0 WHERE id_cliente=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_id_cliente);

            int rs = ps.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Cliente desactivado exitosamente ");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar, cliente inexistente ");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde desactivar al  cliente " + ex);

        }
	
	
	
	
	}

    public List<Cliente> obtenerClientes() {

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        try {
            String sql = "SELECT * FROM cliente;";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            Cliente cliente;

            while (rs.next()) {
                // Creacion y llenado de clientes para ser insertados en la lista
                cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setDni(rs.getLong("dni"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombreD(rs.getString("nombre_duenio"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setContactoA(rs.getString("contacto_alternativo"));
                cliente.setActivo(rs.getBoolean("activo"));

                clientes.add(cliente);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener listado de clientes " + ex);

        }
        return clientes;
    }
// se utiliza la para vista CONSULTAS DE CLIENTES//

    public List<Cliente> obtenerClientexAPELLIDOyNOMBRE(String p_apellido, String p_nombre_duenio) {

        ArrayList<Cliente> clientesApNom = new ArrayList<Cliente>();

        // String de consulta a base de datos
        try {

            String sql = "SELECT * FROM cliente WHERE activo = 1 AND apellido LIKE ?  AND  nombre_duenio LIKE ? ";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // CONSULTA LIKE //
            ps.setString(1, "%" + p_apellido + "%");
            ps.setString(2, "%" + p_nombre_duenio + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                /* Instanciado de cliente encontrado en la BD con todos sus parametros */
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setDni(rs.getLong("dni"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombreD(rs.getString("nombre_duenio"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setContactoA(rs.getString("contacto_alternativo"));
                cliente.setActivo(rs.getBoolean("activo"));

                clientesApNom.add(cliente);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar clientes por nombre y apellido" + ex);

        }
        return clientesApNom;

    }
// para vista CONSULTA//

    public List<Cliente> obtenerClientes_ACTIVOS(boolean p_activo) {

        ArrayList<Cliente> clientesActivos = new ArrayList<Cliente>();

        try {
            String sql = "SELECT * FROM cliente WHERE  activo = ?;";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_activo ? 1 : 0);

            ResultSet rs = ps.executeQuery();
            Cliente cliente;

            while (rs.next()) {
                // Creacion y llenado de clientes para ser insertados en la lista
                cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setDni(rs.getLong("dni"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombreD(rs.getString("nombre_duenio"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setContactoA(rs.getString("contacto_alternativo"));
                cliente.setActivo(rs.getBoolean("activo"));

                clientesActivos.add(cliente);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar clientes activos" + ex);

        }
        return clientesActivos;
    }
    public List<Mascota> buscarMascotas_x_Cliente( int p_cliente) {

        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        Mascota mascota = null;

        String sql = "SELECT * FROM mascota WHERE id_cliente= ? AND activo=1;";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_cliente);

            ResultSet rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {

                    mascota = new Mascota();
                    mascota.setId_mascota(rs.getInt("id_mascota"));
                    mascota.setAlias(rs.getString("alias"));
                    mascota.setSexo(rs.getString("sexo"));
                    mascota.setEspecie(rs.getString("especie"));
                    mascota.setRaza(rs.getString("raza"));
                    mascota.setColor_pelaje(rs.getString("color_pelaje"));
                    mascota.setFecha_nac(rs.getDate("fecha_nac").toLocalDate());
                    mascota.setPeso_actual(rs.getDouble("peso_actual"));
                    mascota.setPeso_promedio(rs.getDouble("peso_promedio"));
                    mascota.setActivo(rs.getBoolean("activo"));
                    mascota.setCliente(cd.buscarCliente(rs.getInt("id_cliente")));
                    mascotas.add(mascota);

                }
            } else {
                JOptionPane.showMessageDialog(null, "No tiene mascotas a su cargo");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error de conexion desde buscar mascota " + ex);
        }

        return mascotas;
    }

}
