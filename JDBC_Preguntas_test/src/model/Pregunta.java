package model;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pregunta {
    private int id;
    private String enunciado;

    public Pregunta(int id, String enunciado) {
        this.id = id;
        this.enunciado = enunciado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "id=" + id +
                ", enunciado='" + enunciado + '\'' +
                '}';
    }

    public int insertar(String sql) throws SQLException {
        Connection conn=null;
        PreparedStatement stmt = null;
        int datos=0;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            datos= stmt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                conn.close();
            }
        }
        return datos;
    }
}
