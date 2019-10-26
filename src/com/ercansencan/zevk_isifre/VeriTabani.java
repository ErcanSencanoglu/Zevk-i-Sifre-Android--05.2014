package com.ercansencan.zevk_isifre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class VeriTabani{
	
     Connection con = null;
     Statement stmt = null;
     ResultSet rs = null;
	
	public VeriTabani(){			
		 
		try {
			  Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.exit(0);
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://ercansencan.com/ercansen_zevk","username","password");
			stmt = con.createStatement();
		} catch (SQLException e) {System.exit(0);}
			
	}


	public String[][] getKategori(String kategori){
			
		String verilerList[][] = null;
		try{ 	 
	        rs = stmt.executeQuery("SELECT * FROM veriiki where kategori Like '%" + kategori + "%'");
	        int row = 0;
			if (rs != null) { 
				rs.last(); // cursor'u sona ilerlet
				row = rs.getRow(); //sat�r say�s�n� al
				rs.beforeFirst();// ResultSet'te gezinmek i�in cursor'u ba�a al
				}
	        verilerList = new String[row][3]; 
	          int i = 0;
	          while (rs.next())
	          {       
				verilerList[i][0] = (rs.getString(2));
				verilerList[i][1] = (rs.getString(3));
				verilerList[i][2] = (rs.getString(5));
				i++;
			}
	          stmt.close();
		      con.close();
		}catch (Exception e){System.exit(0);}
		return verilerList;
	}
	
	public String[][] getHepsiniGetir(){
		
		String verilerList[][] = null;
		
		try{ 		 
	        rs = stmt.executeQuery("SELECT * FROM veriiki");
	        int row = 0;
			if (rs != null) { 
				rs.last(); // cursor'u sona ilerlet
				row = rs.getRow(); //sat�r say�s�n� al
				rs.beforeFirst();// ResultSet'te gezinmek i�in cursor'u ba�a al
				}
	        verilerList = new String[row][4]; 
	          int i = 0;
	          while (rs.next())
	          {            
	            verilerList[i][0] = (rs.getString(2));
				verilerList[i][1] = (rs.getString(3));
				verilerList[i][2] = (rs.getString(4));
				verilerList[i][3] = (rs.getString(5));
				i++;      
	          }
		      stmt.close();
		      con.close();
	        } catch (Exception e){System.exit(0);}
	       
		return verilerList;
	}
			
	public String[][] getDigerleri(){

		String verilerList[][] = null;
		
		try{ 
	        rs = stmt.executeQuery("SELECT * FROM veriiki");
	        int row = 0;
			if (rs != null) { 
				rs.last(); // cursor'u sona ilerlet
				row = rs.getRow(); //sat�r say�s�n� al
				rs.beforeFirst();// ResultSet'te gezinmek i�in cursor'u ba�a al
				}
	        verilerList = new String[row][4]; 
	          int i = 0;
	          while (rs.next())
	          {            
	        	  if(!(rs.getString(4).equals("Game1") || rs.getString(4).equals("Game2") ||
	        			  rs.getString(4).equals("Game3")|| rs.getString(4).equals("Game4")
	        			  || rs.getString(4).equals("Game5")))
				verilerList[i][0] = (rs.getString(2));
				verilerList[i][1] = (rs.getString(3));
				verilerList[i][2] = (rs.getString(4));
				verilerList[i][3] = (rs.getString(5));
				i++;	
	          }
	          stmt.close();
		      con.close();
			}catch (Exception e) {System.exit(0);}
	       
		return verilerList;
	}
	
	public String[][] getDuyurular(){
		
		String verilerList[][] = null;
		
		try{ 
			String query="select * from Duyurular";
	        rs = stmt.executeQuery(query);
	        
	        int row = 0;
			if (rs != null) { 
				rs.last(); // cursor'u sona ilerlet
				row = rs.getRow(); //sat�r say�s�n� al
				rs.beforeFirst();// ResultSet'te gezinmek i�in cursor'u ba�a al
				}
	        
	        verilerList = new String[row][2]; 
	          int i = 0;
	          while (rs.next())
	          {            
				verilerList[i][0] = (rs.getString(2));
				verilerList[i][1] = (rs.getString(3));
				i++;	
	          }
	          stmt.close();
		      con.close();
		}catch (Exception e){System.exit(0);}
		return verilerList;	
	}
			
	}


