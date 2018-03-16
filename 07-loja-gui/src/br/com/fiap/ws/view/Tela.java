package br.com.fiap.ws.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import br.com.fiap.inventario.EstoqueBOStub.ProdutoTO;
import br.com.fiap.service.EstoqueService;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtCodigo;
	private Text txtQuantidade;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setTouchEnabled(true);
		shell.setSize(297, 243);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(28, 24, 109, 15);
		lblNewLabel.setText("Codigo do Produto:");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(28, 60, 55, 15);
		lblNewLabel_1.setText("Produto:");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(28, 94, 73, 15);
		lblNewLabel_2.setText("Quantidade:");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(170, 21, 76, 21);
		
		txtQuantidade = new Text(shell, SWT.BORDER);
		txtQuantidade.setBounds(170, 91, 76, 21);
		
		Label lblProduto = new Label(shell, SWT.NONE);
		lblProduto.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblProduto.setBounds(122, 60, 124, 15);
		
		Button btnPesquisar = new Button(shell, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String codigo = txtCodigo.getText();
				
				try {
					EstoqueService service = new EstoqueService();
					//ProdutoTO produto = service.consultaProduto(codigo);
					//lblProduto.setText(produto);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnPesquisar.setBounds(28, 141, 218, 25);
		btnPesquisar.setText("Pesquisar");

	}

}
