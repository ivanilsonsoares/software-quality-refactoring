/**
 * @author Lais Frigério da Silva
 */

package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Agenda;
import model.Profissional;
import model.Consulta;
import model.Formatacao;
import model.Horario;
import model.Paciente;
import model.Procedimento;
import model.Usuario;
import model.Validacao;

/**
 *
 * @author Lais Frigério da Silva
 */

public class AgendaDAO {    
    private final String AGENDAMENTOS = "SELECT a.id_agenda, p.id_paciente,"
            + "c.id, prof.id , a.data_agendamento, "
            + " a.observacao, p.nome_paciente, u.nome_usuario, c.qntd, "
            + "proc.id, proc.nome FROM agenda a "
            + "JOIN consulta c ON c.id = a.consulta_id "
            + "JOIN paciente p ON p.id_paciente = c.paciente_id "
            + "JOIN profissional prof ON prof.id = a.profissional_id "
            + "JOIN usuario u ON u.id_fisioterapeuta_usuario = prof.id "
            + "LEFT JOIN procedimento as proc ON proc.id = c.procedimento_id "
            + "WHERE a.data_agendamento = ?";
    
    private final String PESQUISAR = "SELECT a.id_agenda, p.id_paciente,"
            + "c.id, prof.id , a.data_agendamento, "
            + " a.observacao, p.nome_paciente, u.nome_usuario, c.qntd, "
            + "proc.id, proc.nome FROM agenda a "
            + "JOIN consulta c ON c.id = a.consulta_id "
            + "JOIN paciente p ON p.id_paciente = c.paciente_id "
            + "JOIN profissional prof ON prof.id = a.profissional_id "
            + "JOIN usuario u ON u.id_fisioterapeuta_usuario = prof.id "
            + "LEFT JOIN procedimento as proc ON proc.id = c.procedimento_id "
            + "WHERE a.data_agendamento = ? AND p.nome_paciente LIKE ?";
    
    private final String AGENDAMENTOSPORCONSULTA = "SELECT a.id_agenda, p.id_paciente, "
            + "c.id, prof.id, a.data_agendamento, "
            + " a.observacao, p.nome_paciente, u.nome_usuario, c.qntd, "
            + " proc.id, proc.nome FROM agenda a "
            + "JOIN consulta c ON c.id = a.consulta_id "
            + "JOIN paciente p ON p.id_paciente = c.paciente_id "
            + "JOIN profissional prof ON prof.id = a.profissional_id "
            + "JOIN usuario u ON u.id_fisioterapeuta_usuario = prof.id "
            + "LEFT JOIN procedimento as proc ON proc.id = c.procedimento_id "
            + "WHERE a.consulta_id = ? ORDER BY data_agendamento ASC";
    
    private final String REMOVER = "DELETE FROM agenda WHERE id_agenda  = ?";
    
    
    
    
    
    
    /**
     * Retorno:
     * 1 Sucesso
     * 2 Horário indisponivel
     * 3 Máximo de sessões já atingido
     * 0 Error qualquer
     * @param agenda
     * @return 
     */
    
    
    
    
    public boolean excluir(Agenda agenda){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = new ConectionFactory().getConnection();
            stmt = conn.prepareStatement(REMOVER);
            stmt.setInt(1, agenda.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();               
            } catch (SQLException ex){
                System.out.println("ERROR - (Remover Agendamento) | Try close "
                        + "prepared statement or conection \n " + ex);
            }
        }
        return false;
    }
    
    public List<Horario> agendamentos(String data){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Horario> horarios = null;
        try {
            conn = new ConectionFactory().getConnection();
            if(Validacao.isDate(data)) {
                String buscaVar;
                horarios = HorarioDAO.horarios();
                for(Horario h : horarios){
                    buscaVar = data + " " + Formatacao.time2String(h.getHora());
                    Date dataAgenda = Formatacao.string2DateTime(buscaVar);
                    stmt = conn.prepareStatement(AGENDAMENTOS);
                    stmt.setString(1, Formatacao.dateTime2String(dataAgenda));
                    rs = stmt.executeQuery();
                    int i = 1;
                    while(rs.next()){   
                        Agenda a = h.getAgendamento(i++);
                        this.getAgendamento(rs, a, dataAgenda);
                    }
                }
            }
            return horarios;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
                if(rs!=null) rs.close();
            } catch (Exception ex){
                System.out.println("ERROR - (Lista Agenda - Por data) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        return null;
    } 
    
    public List<Horario> agendamentos(String data, String busca){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Horario> horarios = null;
        try {
            conn = new ConectionFactory().getConnection();
            if(Validacao.isDate(data)) {
                String buscaVar;
                horarios = HorarioDAO.horarios();
                for(Horario h : horarios){
                    buscaVar = data + " " + Formatacao.time2String(h.getHora());
                    Date dataAgenda = Formatacao.string2DateTime(buscaVar);
                    stmt = conn.prepareStatement(PESQUISAR);
                    stmt.setString(1, Formatacao.dateTime2String(dataAgenda));
                    stmt.setString(2, "%" + busca + "%");
                    rs = stmt.executeQuery();
                    int i = 1;
                    while(rs.next()){   
                        Agenda a = h.getAgendamento(i++);
                        this.getAgendamento(rs, a, dataAgenda);
                    }
                }
            }
            return horarios;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
                if(rs!=null) rs.close();
            } catch (Exception ex){
                System.out.println("ERROR - (Lista Agenda - Por data e nome do paciente) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        return null;
    }
    
    private void getAgendamento(ResultSet rs, Agenda a, Date dataAgenda) throws SQLException {
        Profissional profissional = new Profissional();
        profissional.setId(rs.getInt(4));
        Usuario u = new Usuario();
        u.setNome(rs.getString(8));
        profissional.setUsuario(u);

        Paciente p = new Paciente();
        p.setId(rs.getInt(2));
        p.setNome(rs.getString(7));

        Consulta consulta = new Consulta();
        consulta.setId(rs.getInt(3));
        consulta.setQntdSessao(rs.getInt(9));
        consulta.setPaciente(p);

        if (rs.getInt(10) != 0) {
            Procedimento proc = new Procedimento();
            proc.setId(rs.getInt(10));
            proc.setNome(rs.getString(11));
            consulta.setProcedimento(proc);
        }

        a.setProfissional(profissional);
        a.setConsulta(consulta);
        a.setId(rs.getInt(1));
        a.setDataAgendamento(new java.sql.Timestamp(dataAgenda.getTime()));
        a.setObservacao(rs.getString(6));
    }
    
    public List<Agenda> agendamentos(Consulta c) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Agenda> agendamentos = new ArrayList();
        try {
            conn = new ConectionFactory().getConnection();
            if(c!=null) {
                stmt = conn.prepareStatement(AGENDAMENTOSPORCONSULTA);
                stmt.setInt(1, c.getId());
                rs = stmt.executeQuery();
                int count = 1;
                while(rs.next()){   
                    Agenda a = new Agenda();
                    a.setId(rs.getInt(1));
                    a.setObservacao(rs.getString(6));
                    a.setDataAgendamento(rs.getTimestamp(5));
                    a.setNumeroSessao(count++);
                    
                    Paciente p = new Paciente();
                    p.setId(rs.getInt(2));
                    p.setNome(rs.getString(7));
                    
                    Profissional profissional = new Profissional();
                    profissional.setId(rs.getInt(4));
                    Usuario u = new Usuario();
                    u.setNome(rs.getString(8));
                    profissional.setUsuario(u);

                    Consulta consulta = new Consulta();
                    consulta.setId(rs.getInt(3));
                    consulta.setQntdSessao(rs.getInt(9));
                    consulta.setPaciente(p);
                    
                    if (rs.getInt(10) != 0) {
                        Procedimento proc = new Procedimento();
                        proc.setId(rs.getInt(10));
                        proc.setNome(rs.getString(11));
                        consulta.setProcedimento(proc);
                    }

                    a.setProfissional(profissional);
                    a.setConsulta(consulta);
                    agendamentos.add(a);
                }
            }
            return agendamentos;
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        } finally {
            try{
                if(conn!=null) conn.close();
                if(stmt!=null) stmt.close();
                if(rs!=null) rs.close();
            } catch (Exception ex){
                System.out.println("ERROR - (Lista Agenda por fisioterapia - Por data) | Try close "
                        + "prepared statement, or conection or result set \n " + ex);
            }
        }
        return null;
    }
    
    

}
