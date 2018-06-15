/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaceGrafica;

import Cliente.Cliente;
import Cliente.Solicitacao;
import bd.dbo.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Josiele
 */
public class CadastroCliente extends javax.swing.JFrame {

	private Cliente cliente;
	private String email;
	private String nome;
	private String senha;
	private String host;
	private int port;

	/**
	 * Cria o formulário CadastroCliente
	 */
	public CadastroCliente(String _host, int _port) {
		initComponents();
		this.setLocationRelativeTo(null);
		
		host = _host;
		port = _port;
		

	}

	/**
	 * Este metodo é chamado pelo 
	 * construtor para inicializar os componentes existentes 
	 * no formulário.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		btnSalvar = new javax.swing.JButton();
		btnCancelar = new javax.swing.JButton();
		txtNome = new javax.swing.JTextField();
		txtEmail = new javax.swing.JTextField();
		txtSenha = new javax.swing.JPasswordField();
		txtConfirmaSenha = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Nome:");

		jLabel2.setText("E-mail:");

		jLabel3.setText("Senha:");

		jLabel4.setText("Confirme a senha:");

		btnSalvar.setText("Salvar");
		btnSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSalvarActionPerformed(evt);
			}
		});

		btnCancelar.setText("Cancelar");
		btnCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addGap(19, 19, 19)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(
										layout.createSequentialGroup().addComponent(jLabel2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(
														txtEmail))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
										.addComponent(jLabel1).addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup().addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel3)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup().addGap(44, 44, 44).addComponent(
														btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(27, 27, 27)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(layout.createSequentialGroup().addComponent(jLabel4)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(txtConfirmaSenha,
																javax.swing.GroupLayout.PREFERRED_SIZE, 100,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(14, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(25, 25, 25)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3)
								.addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4).addComponent(txtConfirmaSenha,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(32, 32, 32)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnSalvar).addComponent(btnCancelar))
						.addContainerGap(51, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	
	/**
	 * Botão "Salvar": 
	 * O método quando acionado, verifica se todos os campos existentes na tela foram preenchidos.
	 * Quando preenchidos, um socket Cliente é criado e um pedido de conexão é enviado para o servidor. 
	 */
	
	private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvarActionPerformed

		email = txtEmail.getText();
		nome = txtNome.getText();
		
		if (txtSenha.getText().equals(txtConfirmaSenha.getText()))
			senha = txtSenha.getText();
		else
			JOptionPane.showMessageDialog(null, "Confirme a senha correta!" , "ALERTA" ,
					JOptionPane.INFORMATION_MESSAGE);
		

		if (txtEmail.equals("") || txtSenha.equals("") || txtConfirmaSenha.equals("") || txtNome.equals(""))
			JOptionPane.showMessageDialog(null, "Preencha todos os campos do formulario!");

		if (email != null && nome != null && senha != null) {
			try {
				Solicitacao solicitacao = new Solicitacao("CAD", email, nome, senha);
				cliente = new Cliente(host, port, solicitacao);				
				cliente.conectar();
				
				JOptionPane.showMessageDialog(null, cliente.getResposta().getMessage() , "Mensagem" ,
						JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}// GEN-LAST:event_btnSalvarActionPerformed

	/**
	 * Botão "Cancelar": 
	 * O método quando acionado, apaga todos os campos da tela e pergunta se o usuário deseja sair. 
	 */
	
	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
		txtNome.setText("");
		txtEmail.setText("");
		txtSenha.setText("");
		txtConfirmaSenha.setText("");

		int dialogResult = JOptionPane.showConfirmDialog(this, "Deseja cancelar o cadastro?", "Cancelar",
				JOptionPane.YES_NO_OPTION);
		if (dialogResult == 0)
			this.setVisible(false);

	}// GEN-LAST:event_btnCancelarActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnSalvar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPasswordField txtConfirmaSenha;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtNome;
	private javax.swing.JPasswordField txtSenha;
	// End of variables declaration//GEN-END:variables
}
