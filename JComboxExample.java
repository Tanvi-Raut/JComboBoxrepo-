import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class MyFrame extends JFrame implements ActionListener
{
    private JComboBox <String>jcb_gender;
    private JComboBox <String>jcb_nat;
    private JTextField txt_name;
    private Vector<String> v;
    private JTextArea ta;
    public MyFrame()
    {
    	this.setLayout(new GridLayout(4,2));
    	this.add(new JLabel("Enter name"));
    	txt_name = new JTextField();
    	this.add(txt_name);

    	this.add(new JLabel("Select Gender"));
    	jcb_gender = new JComboBox<String>();
    	jcb_gender.addItem("Select Gender");
    	jcb_gender.addItem("MALE");
    	jcb_gender.addItem("FEMALE");

    	this.add(jcb_gender);

    	this.add(new JLabel("Select Nationality"));
    	v = new Vector<String>();
    	String arr[] = {"Select Nationality","INDIAN","AMERICAN","GERMAN"};
    	for(String item:arr)
    		v.add(item);
    	jcb_nat = new JComboBox(v);
    	this.add(jcb_nat);

    	JButton b = new JButton("SUBMIT");
    	b.addActionListener(this);
    	this.add(b);

        ta = new JTextArea("");
        this.add(ta);


    	this.setVisible(true);
    	this.setSize(500,400);
    	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
    	String text = e.getActionCommand();
    	String name = txt_name.getText().trim().toUpperCase();

    	String err_msg = "";
    	if(name.length()==0)
    	{
    		err_msg = err_msg+"NAME IS REQUIRED\n";
    	}
    	if(jcb_gender.getSelectedIndex()==0)
    	{
    		err_msg = err_msg+"GENDER IS REQUIRED\n";
    	}
    	if(jcb_nat.getSelectedIndex()==0)
    	{
    		err_msg = err_msg+"NATIONALITY IS REQUIRED\n";
    	}

    	if(err_msg.equals(""))
    	{
    		String gender = jcb_gender.getSelectedItem().toString();
    	    String nat = jcb_nat.getSelectedItem().toString();

    	    JOptionPane.showMessageDialog(this,"Name:"+name+"\nGender:"+gender+"\nNationality:"+nat);

    	    //ta.setText("Name:"+name+"\nGender:"+gender+"\nNationality:"+nat);
    	}
    	else 
    	{
           JOptionPane.showMessageDialog(this,err_msg);

          // ta.setText(err_msg);

    	}

    }

}



class JComboxExample
{
	public static void main(String[] args) {
		new MyFrame();
	}
}