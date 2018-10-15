package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.ClienteBean;

public class ClienteServicios {
    
    Connection cn;
    
    public ClienteServicios() throws Exception {
        
        Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost/sistema", "root", "");
        
    }
    
    public ClienteEntity consultaCliente(ClienteEntity cliente) throws Exception{
        
        ClienteEntity cli = null;
        
        PreparedStatement sen = cn.prepareStatement("select id, nombres, saldo from cliente where id = ?");
        
        sen.setString(1, cliente.getId());
        ResultSet res = sen.executeQuery();
        
        while (res.next()) {
            cli = new ClienteEntity();
            cli.setId(res.getString("id"));
            cli.setNombres(res.getString("nombres"));
            cli.setSaldo(res.getDouble("saldo"));
        }
        
        return cli;
    }
    
    public void registrarCliente(ClienteBean cliente) throws Exception {
        
        String sql = "insert into cliente (id, nombres, saldo) values (?,?,?)";
        PreparedStatement sen = cn.prepareStatement(sql);
        sen.setString(1, cliente.getId());
        sen.setString(2, cliente.getNombres());
        sen.setDouble(3, cliente.getSaldo());
        
        sen.executeUpdate();
        
    }
    
    
    
}
