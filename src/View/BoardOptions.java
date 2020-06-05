package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardOptions extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private int Rows,Columns;

	public int getRows() {
		return Rows;
	}

	public void setRows(int rows) {
		Rows = rows;
	}

	public int getColumns() {
		return Columns;
	}

	public void setColumns(int columns) {
		Columns = columns;
	}


	/**
	 * Create the dialog.
	 */
	public BoardOptions(int rows,int columns) {
		Rows = rows;
		Columns = columns;
		setBounds(100, 100, 450, 137);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JLabel lblNewLabel = new JLabel("Rows");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblNewLabel);
		}
		{
			JSpinner rowsSpinner = new JSpinner();
			rowsSpinner.setValue(Rows);
			rowsSpinner.setToolTipText("Set the board rows size");
			contentPanel.add(rowsSpinner);
			rowsSpinner.addChangeListener(new ChangeListener() {
		        @Override
		        public void stateChanged(ChangeEvent e) {
		        	Rows = Integer.parseInt(rowsSpinner.getValue().toString());
		        }
		    });
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Columns");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JSpinner columnsSpinner = new JSpinner();
			columnsSpinner.setValue(Columns);
			columnsSpinner.setToolTipText("Set the board columns size");
			contentPanel.add(columnsSpinner);
			columnsSpinner.addChangeListener(new ChangeListener() {
		        @Override
		        public void stateChanged(ChangeEvent e) {
		        	Columns = Integer.parseInt(columnsSpinner.getValue().toString());
		        }
		    });
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(Rows == Columns)
							dispose();
						else
							JOptionPane.showMessageDialog(null,"Rows and Columns should be same value"); 	
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
