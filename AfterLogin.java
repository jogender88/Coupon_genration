
public class AfterLogin extends Login{
	AfterLogin(){
		register.setVisible(false);
		login.setVisible(false);
		logout.setVisible(true);
		show.setVisible(true);
		loginusertext.setVisible(true);
		coupongenerate.setVisible(true);
		addnewbill.setVisible(true);
		
		/*show=new JButton("Show Your Coupons");
	//	c=new Container();
		f.add(show);
		//f.add(c);
		//c.setBounds(0, 0, 100, 100);
		show.setBounds(1100, 10, 150, 40);
		connection();
		
		
		show.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m){
				if(m.getSource()==show){
					String queryshow="select bill_no,coupon from generate where Id=? ";
					try {
						PreparedStatement ps= (PreparedStatement) con.prepareStatement(queryshow);
						ps.setString(1,usern);
						rs=ps.executeQuery();
						
						while(rs.next())
						
							
							System.out.println(rs.getString(2)+","+rs.getString(3));

						//JOptionPane.showMessageDialog(null,rs.getRowId(1));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});*/
	}
	

}
