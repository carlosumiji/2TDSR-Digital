package br.com.fiap.ws.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.xml.bind.ParseConversionEvent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.service.NotaService;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtNac;
	private Text txtAm;

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
		shell.setSize(280, 231);
		shell.setText("SWT Application");
		
		Label lblNac = new Label(shell, SWT.NONE);
		lblNac.setBounds(10, 31, 55, 15);
		lblNac.setText("NAC");
		
		Label lblAm = new Label(shell, SWT.NONE);
		lblAm.setBounds(10, 68, 55, 15);
		lblAm.setText("AM");
		
		txtNac = new Text(shell, SWT.BORDER);
		txtNac.setBounds(71, 28, 143, 21);
		
		txtAm = new Text(shell, SWT.BORDER);
		txtAm.setBounds(71, 65, 143, 21);
		
		Label lblResultado = new Label(shell, SWT.NONE);
		lblResultado.setBounds(71, 153, 143, 21);
		lblResultado.setText("");
		
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Clique do botão
				float am = Float.parseFloat(txtAm.getText());
				float nac = Float.parseFloat(txtNac.getText());
				try {
					NotaService service = new NotaService();
					float ps = service.cacularPs(am, nac);
					lblResultado.setText("Resultado: " + String.valueOf(ps));
				}catch(Exception e1){
					lblResultado.setText(e1.getMessage());
				}
			}
		});
		btnCalcular.setBounds(71, 108, 143, 25);
		btnCalcular.setText("Calcular");
		
		

	}
}
