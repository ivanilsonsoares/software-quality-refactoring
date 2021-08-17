package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import model.Agenda;
import model.Validacao;

public class AgendaDAOAux {
	 private final String CADASTRAR = "INSERT INTO agenda (consulta_id, "
	            + "profissional_id, observacao, data_agendamento) VALUES (?,?,?,?)";
	 private final String CHECKNUMEROSESSOES = "SELECT COUNT(*) as total FROM agenda WHERE "
	            + "consulta_id = ? AND id_agenda != ?";
	    
	    private final String TIMEAVAILABLE = "SELECT COUNT(*) as total FROM agenda WHERE "
	            + "data_agendamento = ?";
	    private final String EDITAR = "UPDATE agenda SET consulta_id = ?, "
	            + "profissional_id = ?, observacao = ? WHERE id_agenda = ?";
	 private void newAgendamento(Connection conn, PreparedStatement stmt, Agenda agenda) throws SQLException {
	        // novo agendamento
	        stmt = conn.prepareStatement(CADASTRAR);
	        stmt.setInt(1, agenda.getConsulta().getId());
	        stmt.setInt(2, agenda.getProfissional().getId());
	        stmt.setString(3, agenda.getObservacao());
	        stmt.setTimestamp(4, agenda.getDataAgendamento());
	        stmt.executeUpdate();
	    }
	 public int cadastrar(Agenda agenda) {
	        Connection conn = null;
	        PreparedStatement psSessao = null, psAgendamentosPorFisioterapia = null, psInsert = null;
	        ResultSet rs =  null;
	        boolean first = true;
	        try {
	            conn = new ConectionFactory().getConnection();
	            conn.setAutoCommit(false);
	            int total = checkNumeroSessoesConsulta(agenda);
	            int quantidade = agenda.getQuantidade() > 0 ? agenda.getQuantidade() : agenda.getConsulta().getQntdSessao();
	            
	            if (quantidade != 0 && total != 0 && total != agenda.getConsulta().getQntdSessao()) {
	                quantidade = total + quantidade;
	            }
	            
	            for(int i = total; i<quantidade; i++) {
	                Calendar c = Calendar.getInstance();
	                c.setTimeInMillis(agenda.getDataAgendamento().getTime());
	                if (!first) {
	                    switch (agenda.getRecorrencia()) {
	                        case Agenda.DIARIAMENTE:
	                            c.add(Calendar.DATE, 1);
	                            
	                            if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
	                                agenda.setDataAgendamento(new Timestamp(c.getTime().getTime()));
	                                i--;
	                                continue;
	                            }
	                            
	                            if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && !agenda.isRecorrenciaSabado()) {
	                                agenda.setDataAgendamento(new Timestamp(c.getTime().getTime()));
	                                i--;
	                                continue;
	                            }
	                            break;
	                        case Agenda.SEMANALMENTE:
	                            c.add(Calendar.DAY_OF_MONTH, 7);
	                            break;
	                        case Agenda.QUINZENALMENTE:
	                            c.add(Calendar.DAY_OF_MONTH, 14);
	                            break;
	                        case Agenda.MENSALMENTE:
	                            c.add(Calendar.MONTH, 1);
	                           break;
	                        case Agenda.ANUALMENTE:
	                            c.add(Calendar.YEAR, 1);
	                            break;
	                    }
	                }
	                first = false;
	                agenda.setDataAgendamento(new Timestamp(c.getTime().getTime()));
	                if(this.timeAvaliable(agenda) == 5)
	                    return 2;
	                this.newAgendamento(conn, psInsert, agenda);
	                if (Validacao.isEmpty(agenda.getRecorrencia())) break;
	            }
	            conn.commit();
	            return 1;
	        } catch (SQLException | ClassNotFoundException | IOException ex) {
	            System.out.println(ex);
	        } finally {
	            try{
	                if(conn!=null) conn.close();
	                if(psSessao!=null) psSessao.close();
	                if(psAgendamentosPorFisioterapia!=null) psAgendamentosPorFisioterapia.close();               
	                if(psInsert!=null) psInsert.close();
	                if(rs!=null) rs.close();
	            } catch (SQLException ex){
	                System.out.println("ERROR - (Cadastrar Agendamento) | Try close "
	                        + "prepared statement, or conection or result set \n " + ex);
	            }
	        }
	        return 0;
	    }
	 
	 public boolean editar(Agenda agenda){
	        Connection conn = null;
	        PreparedStatement psAgendamentosPorFisioterapia = null, psSessao = null, psInsert = null;
	        ResultSet rs =  null;
	        try {
	            conn = new ConectionFactory().getConnection();  
	            if (checkNumeroSessoesConsulta(agenda) < agenda.getConsulta().getQntdSessao()) {
	                psInsert = conn.prepareStatement(EDITAR);
	                psInsert.setInt(1, agenda.getConsulta().getId());
	                psInsert.setInt(2, agenda.getProfissional().getId());
	                psInsert.setString(3, agenda.getObservacao());
	                psInsert.setInt(4, agenda.getId());
	                psInsert.executeUpdate();
	                return true;
	            }
	            return false;
	        } catch (SQLException | ClassNotFoundException | IOException ex) {
	            System.out.println(ex);
	        } finally {
	            try{
	                if(conn!=null) conn.close();
	                if(psAgendamentosPorFisioterapia!=null) psAgendamentosPorFisioterapia.close();               
	                if(psInsert!=null) psInsert.close();
	                if(psSessao!=null) psSessao.close();
	                if(rs!=null) rs.close();
	            } catch (SQLException ex){
	                System.out.println("ERROR - (Editar Agendamento) | Try close "
	                        + "prepared statement, or conection or result set \n " + ex);
	            }
	        }
	        return false;
	    }
	 
	 public int timeAvaliable(Agenda a) {
	        PreparedStatement stmt = null;
	        Connection conn = null;
	        ResultSet rs =  null;
	        try {
	            conn = new ConectionFactory().getConnection();
	            stmt = conn.prepareStatement(TIMEAVAILABLE);
	            stmt.setTimestamp(1, a.getDataAgendamento());
	            rs = stmt.executeQuery();
	            if(rs.next())
	                return rs.getInt(1);
	            return 0;
	        } catch (SQLException | ClassNotFoundException | IOException ex) {
	            System.out.println(ex);
	        } finally {
	            try{
	                if(conn!=null) conn.close();
	                if(stmt!=null) stmt.close();
	                if(rs!=null) rs.close();
	            } catch (SQLException ex){
	                System.out.println("ERROR - (Checar horário disponivel) | Try close "
	                        + "prepared statement, conection or result set \n " + ex);
	            }
	        }
	        return 0;
	    }
	 
	 public int checkNumeroSessoesConsulta(Agenda a) {
	        PreparedStatement stmt = null;
	        Connection conn = null;
	        ResultSet rs =  null;
	        try {
	            conn = new ConectionFactory().getConnection();
	            stmt = conn.prepareStatement(CHECKNUMEROSESSOES);
	            stmt.setInt(1, a.getConsulta().getId());
	            stmt.setInt(2, a.getId());
	            rs = stmt.executeQuery();
	            if(rs.next())
	                return rs.getInt(1);
	            return 0;
	        } catch (SQLException | ClassNotFoundException | IOException ex) {
	            System.out.println(ex);
	        } finally {
	            try{
	                if(conn!=null) conn.close();
	                if(stmt!=null) stmt.close();
	                if(rs!=null) rs.close();
	            } catch (SQLException ex){
	                System.out.println("ERROR - (Checar numero de sessões dado uma consulta) | Try close "
	                        + "prepared statement, conection or result set \n " + ex);
	            }
	        }
	        return 0;
	    }
	 
}
