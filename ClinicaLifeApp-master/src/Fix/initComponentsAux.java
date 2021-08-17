package Fix;

import java.util.List;

import javax.swing.JOptionPane;

import controller.EspecialidadeController;
import controller.ProfissionalController;
import model.Endereco;
import model.Especialidade;
import model.Formatacao;
import model.MD5;
import model.Profissional;
import model.Usuario;
import model.Validacao;
import view.Main;

public class initComponentsAux extends javax.swing.JFrame{
	
	public javax.swing.JComboBox<String> jComboEspecialidades;
	public javax.swing.JTextField tAgencia;
	public javax.swing.JFormattedTextField tBairro;
	public javax.swing.JTextField tBanco;
	public javax.swing.JTextField tCC;
	public javax.swing.JFormattedTextField tCEP;
	public javax.swing.JFormattedTextField tCelular;
	public javax.swing.JFormattedTextField tCidade;
    public javax.swing.JTextField tDigito;
    public javax.swing.JTextField tEstado;
    public javax.swing.JFormattedTextField tFone;
    public javax.swing.JFormattedTextField tLogin;
    public javax.swing.JTextField tNome;
    public javax.swing.JTextField tNumero;
    public javax.swing.JFormattedTextField tRua;
    public javax.swing.JPasswordField tSenha;
    private final Main tela = null;
	public void edit() {
        if(Validacao.isEmpty(tLogin.getText()) || Validacao.isEmpty(tNome.getText())) {
            JOptionPane.showMessageDialog(null, "Os campos (Nome), (Login) são obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        
        if(!Validacao.isEmpty(tNumero.getText()) && !Validacao.isNumeric(tNumero.getText())) {
            JOptionPane.showMessageDialog(null, "O campo (Número) deve conter apenas números", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        
        Especialidade especialidade = (Especialidade)this.jComboEspecialidades.getSelectedItem();
        if (especialidade == null) {
            JOptionPane.showMessageDialog(null, "O campo (Especialidade) é obrigatório", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        
        String CEP = Formatacao.removeCEPmask(tCEP.getText());
        Endereco e = null;
        if(!Validacao.isEmpty(CEP) || !Validacao.isEmpty(tRua.getText())) {
            e = new Endereco();
            e.setCEP(CEP);
            e.setRua(tRua.getText());
            e.setNumero(Integer.parseInt(tNumero.getText()));
            e.setBairro(tBairro.getText());
            e.setCidade(tCidade.getText());
            e.setEstado(tEstado.getText());
            
        }
        
        Usuario u = new Usuario();
        MD5 md5 = new MD5();
        u.setNome(tNome.getText());
        u.setLogin(tLogin.getText());
        
        Profissional prof = new Profissional();
        prof.setEndereco(e);        
        prof.setUsuario(u);
        prof.setEspecialidade(especialidade);
        prof.setFone(Formatacao.removeFoneMask(tFone.getText()));
        prof.setCelular(Formatacao.removeFoneMask(tCelular.getText()));
        prof.setBanco(tBanco.getText());
        prof.setAgencia(tAgencia.getText());
        prof.setDigito(tDigito.getText());
        prof.setContaCorrente(tCC.getText());
        
        
        ProfissionalController pc = new ProfissionalController();
        
    }
	
	public void create() {
        if(Validacao.isEmpty(tLogin.getText()) || Validacao.isEmpty(tNome.getText()) || Validacao.isEmpty(new String(tSenha.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Os campos (Nome), (Login), (Senha) são obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        if(!Validacao.isEmpty(tNumero.getText()) && !Validacao.isNumeric(tNumero.getText())) {
            JOptionPane.showMessageDialog(null, "O campo (Número) deve conter apenas números", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        
        if(Validacao.loginExists(tLogin.getText(), 0)) {
            JOptionPane.showMessageDialog(null, "Login já cadastrado", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        
        Especialidade especialidade = (Especialidade)this.jComboEspecialidades.getSelectedItem();
        if (especialidade == null) {
            JOptionPane.showMessageDialog(null, "O campo (Especialidade) é obrigatório", "Atenção", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        
        String CEP = Formatacao.removeCEPmask(tCEP.getText());
        Endereco e = null;
        if(!Validacao.isEmpty(CEP) || !Validacao.isEmpty(tRua.getText())) {
            e = new Endereco();
            e.setCEP(CEP);
            e.setRua(tRua.getText());
            e.setNumero(Integer.parseInt(tNumero.getText()));
            e.setBairro(tBairro.getText());
            e.setCidade(tCidade.getText());
            e.setEstado(tEstado.getText());
        }
        
        Usuario u = new Usuario();
        MD5 md5 = new MD5();
        u.setNome(tNome.getText());
        u.setLogin(tLogin.getText());
        u.setSenha(md5.md5(new String(tSenha.getPassword())));
        
        Profissional prof = new Profissional();
        prof.setEndereco(e);        
        prof.setUsuario(u);
        prof.setFone(Formatacao.removeFoneMask(tFone.getText()));
        prof.setCelular(Formatacao.removeFoneMask(tCelular.getText()));
        prof.setBanco(tBanco.getText());
        prof.setAgencia(tAgencia.getText());
        prof.setDigito(tDigito.getText());
        prof.setContaCorrente(tCC.getText());
        prof.setEspecialidade(especialidade);
        
        ProfissionalController fc = new ProfissionalController();
        if(fc.cadastrar(prof)){
            JOptionPane.showMessageDialog(null, "O Cadastro foi efetuado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            List<Profissional> lista = fc.profissionais();
            if(lista!=null)
               this.tela.tableModelProfissional.addLista(lista);                  
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar o cadastro. Tente novamente mais tarde ou contate o Administrador do sistema", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
	
	
}
