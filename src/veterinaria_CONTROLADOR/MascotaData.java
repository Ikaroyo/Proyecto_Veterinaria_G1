package veterinaria_CONTROLADOR;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import veterinaria_MODELO.Cliente;
import veterinaria_MODELO.Mascota;
import java.time.Period;
import veterinaria_CONTROLADOR.ClienteData;
import veterinaria_CONTROLADOR.Conexion;
import veterinaria_CONTROLADOR.VisitaData;
import veterinaria_MODELO.Cliente;
import veterinaria_MODELO.Mascota;

public class MascotaData {

    private Connection con = null;
    Cliente c = new Cliente();
    ClienteData cd;
    VisitaData vd;

    public MascotaData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error en la conexion");
        }
        cd = new ClienteData(conexion);
    }

    public void agregar_Mascota(Mascota p_mascota) {

        String sql = "INSERT INTO mascota (alias , sexo, especie, raza , color_pelaje, fecha_nac, peso_actual, id_cliente, peso_promedio, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, p_mascota.getAlias());
            ps.setString(2, p_mascota.getSexo());
            ps.setString(3, p_mascota.getEspecie());
            ps.setString(4, p_mascota.getRaza());
            ps.setString(5, p_mascota.getColor_pelaje());
            ps.setDate(6, Date.valueOf(p_mascota.getFecha_nac()));
            ps.setDouble(7, p_mascota.getPeso_actual());
            ps.setObject(8, p_mascota.getCliente().getId_cliente());
            ps.setDouble(9, p_mascota.getPeso_promedio());

            // if reducido
            ps.setInt(10, p_mascota.isActivo() ? 1 : 0);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            //JOptionPane.showMessageDialog(null, " Mascota cargada exitosamente");

            if (rs.next()) {
                p_mascota.setId_mascota(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pude cargar mascota ");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion al guardar mascota " + ex);

        }
    }

    // busca a todas al mascotas que estan "vivas"   
    public Mascota buscarMascota(int p_id_mascota) {

        Mascota mascota = null;

        String sql = "SELECT * FROM mascota WHERE activo =1 AND id_mascota =?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_id_mascota);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

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

                //JOptionPane.showMessageDialog(null, "Mascota encrontrada exitosamente :" + " " + mascota.getAlias());

            } else {
                //JOptionPane.showMessageDialog(null, "Mascota inexistente");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error de conexion desde buscar mascota " + ex);
        }

        return mascota;
    }

    // buscar mascotas por cliente // 
    public List<Mascota> buscarMascotas_x_Cliente(Cliente p_cliente) {

        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        Mascota mascota = null;

        String sql = "SELECT * FROM mascota WHERE id_cliente= ? AND activo=1;";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_cliente.getId_cliente());

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
                    mascota.setCliente(p_cliente);
                    mascotas.add(mascota);

                    //JOptionPane.showMessageDialog(null, "Mascota encrontrada exitosamente :" + " " + mascota.getAlias());
                }
            } else {
                //JOptionPane.showMessageDialog(null, "Mascota inexistente");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error de conexion desde buscar mascota " + ex);
        }

        return mascotas;
    }

// buscar mascota por nombre //
    public List<Mascota> buscarMascotaxALIAS(String p_alias) {

        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        Mascota mascota = null;

        String sql = "SELECT * FROM  mascota  WHERE  activo =1 AND  alias LIKE ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, "%" + p_alias + "%");

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
                    //JOptionPane.showMessageDialog(null, "Mascota encontrada exitosamente  " + " Paciente N° : " + mascota.getId_mascota());
                }

            } else {
                //JOptionPane.showMessageDialog(null, "Paciente inexistente");
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MascotaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mascotas;
    }

    public void modificarMascota(int p_id_mascota, Mascota p_mascota) {

        // String de consulta a base de datos
        String sql = "UPDATE mascota SET alias = ?, sexo = ?, especie = ?, raza = ?, color_pelaje = ?, fecha_nac = ?, peso_actual = ?, id_cliente = ? , peso_promedio = ?, activo = ? WHERE id_mascota=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, p_mascota.getAlias());
            ps.setString(2, p_mascota.getSexo());
            ps.setString(3, p_mascota.getEspecie());
            ps.setString(4, p_mascota.getRaza());
            ps.setString(5, p_mascota.getColor_pelaje());
            ps.setDate(6, Date.valueOf(p_mascota.getFecha_nac()));
            ps.setDouble(7, p_mascota.getPeso_actual());
            ps.setObject(8, p_mascota.getCliente().getId_cliente());
            ps.setDouble(9, p_mascota.getPeso_promedio());
            ps.setInt(10, p_mascota.isActivo() ? 1 : 0);
            ps.setInt(11, p_id_mascota);
            int rs = ps.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, " Mascota se actualizado exitosamente ");
            } else {
                JOptionPane.showMessageDialog(null, " Mascota No se pudo actualizar ");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde insertar cliente " + ex);
        }

    }

    public void borrarMascota(int p_id_mascota) {

        // String de consulta a base de datos
        String sql = "UPDATE mascota SET activo = 0 WHERE id_mascota = ?;";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_id_mascota);

            int rs = ps.executeUpdate();

            if (rs > 0) {
                //JOptionPane.showMessageDialog(null, "Mascota borrada exitosamente ");
            } else {
                //JOptionPane.showMessageDialog(null, "No se pudo borrar, mascota inexistente ");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde borrar mascota " + ex);

        }
    }

    public void activarMascota(int p_id_mascota) {

        String sql = "UPDATE mascota SET activo =1 WHERE id_mascota=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_id_mascota);

            int rs = ps.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Se activo el estado de la mascota ");
            } else {
                JOptionPane.showMessageDialog(null, " El id de la mascota no existe ");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde activar Mascota " + ex);

        }
    }
    
        public void desactivarMascota(int p_id_mascota) {

        String sql = "UPDATE mascota SET activo =0 WHERE id_mascota=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_id_mascota);

            int rs = ps.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Se desactivo el estado de la mascota ");
            } else {
                JOptionPane.showMessageDialog(null, " El id de la mascota no existe ");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion desde activar Mascota " + ex);

        }
    }

    public List<Mascota> obtenerMascotas() {

        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        try {
            String sql = "SELECT * FROM mascota;";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            Mascota mascota;
//          cd = new ClienteData(con);
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
                mascota.setCliente(cd.buscarCliente(rs.getInt("id_cliente")));
                mascota.setPeso_promedio(rs.getDouble("peso_promedio"));
                mascota.setActivo(rs.getBoolean("activo"));

                mascotas.add(mascota);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }

        return mascotas;
    }

    // retorna el peso de la ultima visita //
    public double pesoActual(int p_id_mascota) {

        double peso_actual = 0;

        try {
            String sql = "SELECT peso FROM visita WHERE id_mascota=? ORDER BY fecha_visita DESC LIMIT 1;";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_id_mascota);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                peso_actual = rs.getDouble("peso");
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }

        return peso_actual;
    }

    // calcula el peso promedio de las ultimas 10 visitas por fecha//
    public double pesoPromedio(int p_id_mascota) {

        double promedio = 0;
        double suma = 0;
        int contador = 0;

        try {
            String sql = "SELECT peso FROM visita WHERE id_mascota=? ORDER BY fecha_visita DESC LIMIT 10;";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p_id_mascota);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                suma += rs.getDouble("peso");
                contador++;
            }
            promedio = suma / contador;
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }

        return promedio;
    }

    public void actualizarPesoPromedio(int p_id_mascota) {
        String sql = "UPDATE mascota SET peso_promedio = ? WHERE id_mascota=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, pesoPromedio(p_id_mascota));
            ps.setInt(2, p_id_mascota);
            int rs = ps.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Se actualizo el peso promedio de la mascota ");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el peso promedio de la mascota ");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion al actualizar el peso promedio de Mascota " + ex);

        }
    }

    public List<Mascota> obtenerEspecies(String p_especie) {

        ArrayList<Mascota> especies = new ArrayList<Mascota>();
        Mascota especie = null;
        try {
            String sql = "SELECT * FROM mascota WHERE especie LIKE ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + p_especie + "%");

            ResultSet rs = ps.executeQuery();

            Mascota mascota;
//          cd = new ClienteData(con);
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
                mascota.setCliente(cd.buscarCliente(rs.getInt("id_cliente")));
                mascota.setPeso_promedio(rs.getDouble("peso_promedio"));
                mascota.setActivo(rs.getBoolean("activo"));

                especies.add(mascota);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener listado de especies: " + ex.getMessage());
        }

        return especies;
    }

    // Calcula Edad en años y meses  si es menor a 1 año en meses y en años si mayor//
    public String calcularEdad(LocalDate fecha_nac) {
        int edad = 0;
        LocalDate fecha_actual = LocalDate.now();
        edad = Period.between(fecha_nac, fecha_actual).getYears();
        if (edad > 1) {
            return edad + " años";
        } else {
            return edad + " meses";
        }

    }

    public List<Mascota> obtenerMascotasConFiltro(ArrayList<String> p_parametros, ArrayList<String> p_valores) {
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        Mascota mascota = null;
        try {
            String sql = "SELECT * FROM mascota WHERE ";
            for (int i = 0; i < p_parametros.size(); i++) {
                if (i == 0) {
                    sql += p_parametros.get(i) + " LIKE '%" + p_valores.get(i) + "%'";
                } else {
                    sql += " AND " + p_parametros.get(i) + " LIKE '%" + p_valores.get(i) + "%'";
                }
            }
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

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
                mascota.setCliente(cd.buscarCliente(rs.getInt("id_cliente")));
                mascota.setPeso_promedio(rs.getDouble("peso_promedio"));
                mascota.setActivo(rs.getBoolean("activo"));

                mascotas.add(mascota);
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las mascotas: " + ex.getMessage());
        }

        return mascotas;
    }
}
