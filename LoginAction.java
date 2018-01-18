/*import java.awt.event.*;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class LoginAction extends Login implements ActionListener {
	 			Database db;
		        //must implement method
		        //This is triggered whenever the user clicks the login button
		        public void actionPerformed(ActionEvent ae)
		        {
		            //checks if the button clicked
		            if(ae.getSource()==signin)
		            {
		                char[] temp_pwd=p.getPassword();
		                String pwd=null;
		                pwd=String.copyValueOf(temp_pwd);
		                System.out.println("Username,Pwd:"+username.getText()+","+pwd);
		 
		                //The entered username and password are sent via "checkLogin()" which return boolean
		                if(db.checkLogin(username.getText(), pwd))
		                {
		                    //a pop-up box
		                    JOptionPane.showMessageDialog(null, "You have logged in successfully","Success",
		                                        JOptionPane.INFORMATION_MESSAGE);
		                }
		                else
		                {
		                    //a pop-up box
		                    JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",
		                                        JOptionPane.ERROR_MESSAGE);
		                }
		            }//if
		        }//method
		 
		    }//inner class
*/
