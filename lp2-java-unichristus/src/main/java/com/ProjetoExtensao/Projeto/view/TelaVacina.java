import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVacinas extends JFrame {
    private JTextField txtCPF;
    private JTable tabelaVacinas;
    private DefaultTableModel modeloTabela;
    private JButton btnPesquisar;
    private JButton btnLimpar;
    private JButton btnRegistrarVacina;

    public TelaVacinas() {
        setTitle("Histórico de Vacinas por Paciente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. Header usando o PanelsFactory do seu projeto
        // TODO: Substitua pelo método real do seu projeto, ex: PanelsFactory.criarHeader();
        JPanel painelHeader = new JPanel();
        painelHeader.setBackground(Color.DARK_GRAY); // Exemplo de padrão visual
        painelHeader.add(new JLabel("<html><font color='white'><h2>SISTEMA DE VACINAÇÃO</h2></font></html>"));
        add(painelHeader, BorderLayout.NORTH);

        // Painel Central que vai conter a pesquisa e a tabela
        JPanel painelCentral = new JPanel(new BorderLayout());

        // 2. Seção de Pesquisa por CPF
        JPanel painelPesquisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelPesquisa.setBorder(BorderFactory.createTitledBorder("Buscar Paciente"));

        painelPesquisa.add(new JLabel("CPF do Paciente:"));
        txtCPF = new JTextField(14); // Tamanho para o CPF
        painelPesquisa.add(txtCPF);

        btnPesquisar = new JButton("Pesquisar");
        painelPesquisa.add(btnPesquisar);

        btnLimpar = new JButton("Limpar");
        painelPesquisa.add(btnLimpar);

        painelCentral.add(painelPesquisa, BorderLayout.NORTH);

        // 3. Tabela com as colunas exigidas
        String[] colunas = {"Nome da Vacina", "Data de Aplicação", "Observações"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaVacinas = new JTable(modeloTabela);
        JScrollPane scrollTabela = new JScrollPane(tabelaVacinas);

        painelCentral.add(scrollTabela, BorderLayout.CENTER);
        add(painelCentral, BorderLayout.CENTER);

        // 4. Rodapé (Footer) com o Botão "Registrar Vacina"
        // TODO: Ajuste para usar o seu PanelsFactory no rodapé se necessário
        JPanel painelFooter = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnRegistrarVacina = new JButton("Registrar Vacina");
        painelFooter.add(btnRegistrarVacina);
        add(painelFooter, BorderLayout.SOUTH);

        // Configuração dos Eventos (Ações dos Botões)
        configurarEventos();
    }

    private void configurarEventos() {
        // Ação do Botão Pesquisar
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = txtCPF.getText();
                // TODO: Chamar o método que busca o paciente por CPF no banco
                // e listar as vacinas ordenadas por data decrescente (data desc)
                buscarVacinasPorCPF(cpf);
            }
        });

        // Ação do Botão Limpar (Critério: Botão atualizar limpa a pesquisa)
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCPF.setText("");
                modeloTabela.setRowCount(0); // Limpa as linhas da tabela
            }
        });

        // Ação do Botão Registrar Vacina (Critério: Funcional para abrir tela de cadastro)
        btnRegistrarVacina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Chamar o NavigationService do seu projeto para abrir a tela de cadastro
                // NavigationService.abrirTelaCadastroVacina();
                JOptionPane.showMessageDialog(null, "Abrindo Tela de Cadastro de Vacina...");
            }
        });
    }

    private void buscarVacinasPorCPF(String cpf) {
        // Exemplo visual de como inserir dados na tabela quando buscar
        // Isso aqui sumirá quando você conectar com o seu banco de dados
        modeloTabela.setRowCount(0); // Limpa antes de buscar
        if(!cpf.isEmpty()) {
            // Exemplo de linha adicionada na tabela
            modeloTabela.addRow(new Object[]{"Pfizer", "2026-05-26", "Segunda Dose"});
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, digite um CPF.");
        }
    }
}
