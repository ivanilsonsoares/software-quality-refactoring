/**
 * @author Lais Frigério da Silva
 */

package view.profissional;

import comboBox.GenericComboBox;
import controller.EspecialidadeController;
import controller.WebServiceCep;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import Fix.fixAjust;
import model.Endereco;
import model.Profissional;
import model.Especialidade;
import view.FixedButtonModel;
import view.Main;

public class EditarProfissional extends javax.swing.JFrame {
    private final Main tela;
    private final Profissional profissional;
    private final EspecialidadeController tpc = new EspecialidadeController();

    public EditarProfissional(Main tela, Profissional p) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icons/doctor.png")).getImage());
        bSalvarProfissional.setModel(new FixedButtonModel());
        bSalvarProfissional.setBorder(BorderFactory.createEtchedBorder(0));
        bCancelarProfissional.setModel(new FixedButtonModel());
        bCancelarProfissional.setBorder(BorderFactory.createEtchedBorder(0));
        UIManager.put("Button.focus", new ColorUIResource(new Color(0,0,0,0)));
        UIManager.put("OptionPane.background",new ColorUIResource(255,255,255));
        UIManager.put("Panel.background",new ColorUIResource(255,255,255));
        UIManager.put("Button.background", Color.WHITE);
        this.tela = tela;
        this.profissional = p;
        this.setTitle("Editar Profissional");
        this.tNome.setText(this.profissional.getUsuario().getNome());
        this.tLogin.setText(this.profissional.getUsuario().getLogin());
        this.tFone.setText(this.profissional.getFone());
        this.tCelular.setText(this.profissional.getCelular());
        this.tBanco.setText(this.profissional.getBanco());
        this.tAgencia.setText(this.profissional.getAgencia());
        this.tDigito.setText(this.profissional.getDigito());
        this.tCC.setText(this.profissional.getContaCorrente());
        if(this.profissional.getEndereco()!=null){
            this.tCEP.setText(this.profissional.getEndereco().getCEP());
            this.tRua.setText(this.profissional.getEndereco().getRua());
            this.tBairro.setText(this.profissional.getEndereco().getBairro());
            this.tCidade.setText(this.profissional.getEndereco().getCidade());
            this.tEstado.setText(this.profissional.getEndereco().getEstado());
            this.tNumero.setText(Integer.toString(this.profissional.getEndereco().getNumero()));
        }
        List<Especialidade> lista = tpc.especialidades();
        jComboEspecialidades.setModel(new GenericComboBox(lista));
        
        if (this.profissional.getEspecialidade()!=null) {
            for(int i = 0; i<lista.size(); i++) {
                Especialidade tp = lista.get(i);
                if (tp.getId() == this.profissional.getEspecialidade().getId()) {
                    jComboEspecialidades.setSelectedIndex(i);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        input = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tNome = new javax.swing.JTextField();
        tLogin = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tRua = new javax.swing.JFormattedTextField();
        tNumero = new javax.swing.JTextField();
        tBairro = new javax.swing.JFormattedTextField();
        tCidade = new javax.swing.JFormattedTextField();
        tEstado = new javax.swing.JTextField();
        tCelular = new javax.swing.JFormattedTextField();
        tFone = new javax.swing.JFormattedTextField();
        tCEP = new javax.swing.JFormattedTextField();
        bSalvarProfissional = new javax.swing.JButton();
        bCancelarProfissional = new javax.swing.JButton();
        Login = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Login1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tBanco = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tAgencia = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tDigito = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        tCC = new javax.swing.JTextField();
        tSenha = new javax.swing.JPasswordField();
        jComboEspecialidades = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Paciente");
        setMinimumSize(new java.awt.Dimension(600, 230));
        setResizable(false);

        bg.setBackground(new java.awt.Color(247, 247, 247));

        input.setBackground(new java.awt.Color(247, 247, 247));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(211, 0, 0));
        jLabel5.setText("*");
        jLabel5.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel5.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel5.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Nome");
        jLabel1.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel1.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel1.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Fone");
        jLabel2.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel2.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Celular");
        jLabel3.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel3.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel3.setPreferredSize(new java.awt.Dimension(40, 20));

        tNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tNomeKeyTyped(evt);
            }
        });

        tLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tLoginKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel17.setText("CEP");
        jLabel17.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel17.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel17.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel18.setText("Rua");
        jLabel18.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel18.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel18.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel19.setText("Número");
        jLabel19.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel19.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel19.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel20.setText("Bairro");
        jLabel20.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel20.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel20.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel21.setText("CIdade");
        jLabel21.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel21.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel21.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel22.setText("Estado");
        jLabel22.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel22.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel22.setPreferredSize(new java.awt.Dimension(40, 20));

        tRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tRuaKeyTyped(evt);
            }
        });

        tBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tBairroKeyTyped(evt);
            }
        });

        tCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCidadeKeyTyped(evt);
            }
        });

        tEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tEstadoKeyTyped(evt);
            }
        });

        try {
            tCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tCEPFocusLost(evt);
            }
        });

        bSalvarProfissional.setBackground(new java.awt.Color(0, 102, 52));
        bSalvarProfissional.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bSalvarProfissional.setForeground(new java.awt.Color(255, 255, 255));
        bSalvarProfissional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/checked.png"))); // NOI18N
        bSalvarProfissional.setText("Salvar");
        bSalvarProfissional.setBorder(null);
        bSalvarProfissional.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSalvarProfissional.setDoubleBuffered(true);
        bSalvarProfissional.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bSalvarProfissionalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bSalvarProfissionalFocusLost(evt);
            }
        });
        bSalvarProfissional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSalvarProfissionalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bSalvarProfissionalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bSalvarProfissionalMouseExited(evt);
            }
        });
        bSalvarProfissional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bSalvarProfissionalKeyPressed(evt);
            }
        });

        bCancelarProfissional.setBackground(new java.awt.Color(211, 0, 0));
        bCancelarProfissional.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bCancelarProfissional.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarProfissional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/error.png"))); // NOI18N
        bCancelarProfissional.setText("Cancelar");
        bCancelarProfissional.setBorder(null);
        bCancelarProfissional.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCancelarProfissional.setDoubleBuffered(true);
        bCancelarProfissional.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bCancelarProfissionalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bCancelarProfissionalFocusLost(evt);
            }
        });
        bCancelarProfissional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarProfissionalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCancelarProfissionalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCancelarProfissionalMouseExited(evt);
            }
        });
        bCancelarProfissional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bCancelarProfissionalKeyPressed(evt);
            }
        });

        Login.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Login.setText("Login");
        Login.setMaximumSize(new java.awt.Dimension(40, 20));
        Login.setMinimumSize(new java.awt.Dimension(40, 20));
        Login.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(211, 0, 0));
        jLabel6.setText("*");
        jLabel6.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel6.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel6.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(211, 0, 0));
        jLabel7.setText("*");
        jLabel7.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel7.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel7.setPreferredSize(new java.awt.Dimension(5, 20));

        Login1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Login1.setText("Senha");
        Login1.setMaximumSize(new java.awt.Dimension(40, 20));
        Login1.setMinimumSize(new java.awt.Dimension(40, 20));
        Login1.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel23.setText("Banco");
        jLabel23.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel23.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel23.setPreferredSize(new java.awt.Dimension(40, 20));

        tBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tBancoKeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel24.setText("Agência");
        jLabel24.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel24.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel24.setPreferredSize(new java.awt.Dimension(40, 20));

        tAgencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tAgenciaKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel25.setText("Digito");
        jLabel25.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel25.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel25.setPreferredSize(new java.awt.Dimension(40, 20));

        tDigito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tDigitoKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel26.setText("Conta Corrente");
        jLabel26.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel26.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel26.setPreferredSize(new java.awt.Dimension(40, 20));

        tCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCCKeyTyped(evt);
            }
        });

        tSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tSenhaKeyTyped(evt);
            }
        });

        jComboEspecialidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel27.setText("Especialidade");
        jLabel27.setMaximumSize(new java.awt.Dimension(40, 20));
        jLabel27.setMinimumSize(new java.awt.Dimension(40, 20));
        jLabel27.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(211, 0, 0));
        jLabel8.setText("*");
        jLabel8.setMaximumSize(new java.awt.Dimension(5, 20));
        jLabel8.setMinimumSize(new java.awt.Dimension(5, 20));
        jLabel8.setPreferredSize(new java.awt.Dimension(5, 20));

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(tFone, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tEstado))
                            .addGroup(inputLayout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(tCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tBairro)
                                    .addComponent(tRua)))
                            .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(inputLayout.createSequentialGroup()
                                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(inputLayout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(inputLayout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(15, 15, 15)
                                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(inputLayout.createSequentialGroup()
                                            .addComponent(tLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Login1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tSenha)
                                                .addComponent(tCelular)))
                                        .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(inputLayout.createSequentialGroup()
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(tNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                                    .addComponent(bSalvarProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bCancelarProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(inputLayout.createSequentialGroup()
                                    .addGap(201, 201, 201)
                                    .addComponent(jComboEspecialidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inputLayout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(tBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tAgencia)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(inputLayout.createSequentialGroup()
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tCC)))))
                        .addGap(298, 298, 298))))
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Login1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tRua, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalvarProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSalvarProfissionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarProfissionalMouseClicked
    	
    }//GEN-LAST:event_bSalvarProfissionalMouseClicked

    private void bSalvarProfissionalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarProfissionalMouseEntered
        bSalvarProfissional.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarProfissionalMouseEntered

    private void bSalvarProfissionalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalvarProfissionalMouseExited
        bSalvarProfissional.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarProfissionalMouseExited

    private void bCancelarProfissionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarProfissionalMouseClicked
        this.dispose();
    }//GEN-LAST:event_bCancelarProfissionalMouseClicked

    private void bCancelarProfissionalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarProfissionalMouseEntered
        bCancelarProfissional.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarProfissionalMouseEntered

    private void bCancelarProfissionalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarProfissionalMouseExited
        bCancelarProfissional.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarProfissionalMouseExited

    private void bCancelarProfissionalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarProfissionalFocusGained
        bCancelarProfissional.setBackground(Color.decode("#AD0000"));
    }//GEN-LAST:event_bCancelarProfissionalFocusGained

    private void bCancelarProfissionalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bCancelarProfissionalFocusLost
        bCancelarProfissional.setBackground(Color.decode("#D30000"));
    }//GEN-LAST:event_bCancelarProfissionalFocusLost

    private void bSalvarProfissionalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarProfissionalFocusGained
        bSalvarProfissional.setBackground(Color.decode("#008542"));
    }//GEN-LAST:event_bSalvarProfissionalFocusGained

    private void bSalvarProfissionalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bSalvarProfissionalFocusLost
        bSalvarProfissional.setBackground(Color.decode("#006634"));
    }//GEN-LAST:event_bSalvarProfissionalFocusLost

    private void bCancelarProfissionalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCancelarProfissionalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.dispose();
        }
    }//GEN-LAST:event_bCancelarProfissionalKeyPressed

    private void tCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tCEPFocusLost
        String cep = tCEP.getText();
        WebServiceCep get = WebServiceCep.searchCep(cep);
        if(get.wasSuccessful()) {
            Endereco e = new Endereco();
            e.setCEP(cep);
            e.setRua(get.getLogradouro());
            e.setBairro(get.getBairro());
            e.setCidade(get.getCidade());
            e.setEstado(get.getUf());
            tRua.setText(get.getLogradouro());
            tBairro.setText(get.getBairro());
            tCidade.setText(get.getCidade());
            tEstado.setText(get.getUf());
        } else {
            System.out.println("Error code = " + get.getResulCode());
            System.out.println("Error descrição = " + get.getResultText());
        }
    }//GEN-LAST:event_tCEPFocusLost

    private void tNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNomeKeyTyped
        if(tNome.getText().length() > 199)
            evt.consume();
    }//GEN-LAST:event_tNomeKeyTyped

    private void tRuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tRuaKeyTyped
        if(tRua.getText().length() > 199)
            evt.consume();
    }//GEN-LAST:event_tRuaKeyTyped

    private void tBairroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tBairroKeyTyped
        if(tBairro.getText().length() > 199)
            evt.consume();
    }//GEN-LAST:event_tBairroKeyTyped

    private void tCidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCidadeKeyTyped
        if(tCidade.getText().length() > 199)
            evt.consume();
    }//GEN-LAST:event_tCidadeKeyTyped

    private void tEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tEstadoKeyTyped
        if(tEstado.getText().length() > 1)
            evt.consume();
    }//GEN-LAST:event_tEstadoKeyTyped

    private void tLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tLoginKeyTyped
        if(tLogin.getText().length() > 19)
            evt.consume();
    }//GEN-LAST:event_tLoginKeyTyped

    private void tSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSenhaKeyTyped
        if(tSenha.getPassword().toString().length() > 19)
            evt.consume();
    }//GEN-LAST:event_tSenhaKeyTyped

    private void tBancoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tBancoKeyTyped
        if(tBanco.getText().length() > 199)
            evt.consume();
    }//GEN-LAST:event_tBancoKeyTyped

    private void tAgenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tAgenciaKeyTyped
        if(tAgencia.getText().length() > 10)
            evt.consume();
    }//GEN-LAST:event_tAgenciaKeyTyped

    private void tDigitoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tDigitoKeyTyped
        if(tDigito.getText().length() > 0)
            evt.consume();
    }//GEN-LAST:event_tDigitoKeyTyped

    private void tCCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCCKeyTyped
        if(tCC.getText().length() > 19)
            evt.consume();
    }//GEN-LAST:event_tCCKeyTyped

    private void bSalvarProfissionalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bSalvarProfissionalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
        }
    }//GEN-LAST:event_bSalvarProfissionalKeyPressed

    public static void main(String args[]) {
    	fixAjust.fix();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Login;
    private javax.swing.JLabel Login1;
    private javax.swing.JButton bCancelarProfissional;
    private javax.swing.JButton bSalvarProfissional;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel input;
    private javax.swing.JComboBox<String> jComboEspecialidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tAgencia;
    private javax.swing.JFormattedTextField tBairro;
    private javax.swing.JTextField tBanco;
    private javax.swing.JTextField tCC;
    private javax.swing.JFormattedTextField tCEP;
    private javax.swing.JFormattedTextField tCelular;
    private javax.swing.JFormattedTextField tCidade;
    private javax.swing.JTextField tDigito;
    private javax.swing.JTextField tEstado;
    private javax.swing.JFormattedTextField tFone;
    private javax.swing.JFormattedTextField tLogin;
    private javax.swing.JTextField tNome;
    private javax.swing.JTextField tNumero;
    private javax.swing.JFormattedTextField tRua;
    private javax.swing.JPasswordField tSenha;
    // End of variables declaration//GEN-END:variables

    
}
