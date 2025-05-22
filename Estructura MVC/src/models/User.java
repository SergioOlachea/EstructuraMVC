package models;

import java.awt.BorderLayout;
import java.sql.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class User {

	public int id;
	public String name;
	public String email;
	public String role;
	public String phone;
	public Date create_at;
	public Date update_at;
	
	public User(int id, String name, String email, String role, String phone, Date create, Date update) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.phone = phone;
		this.create_at = create;
		this.update_at = update;
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public String getPhone() {
		return phone;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

}
