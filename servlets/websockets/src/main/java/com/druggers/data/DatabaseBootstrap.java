package com.druggers.data;

import com.druggers.domain.MenuCategory;
import com.druggers.domain.MenuItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseBootstrap {
	
	private List<MenuItem> getMenuItemsList() {
		List<MenuItem> menuItems= new ArrayList<MenuItem>();
		menuItems.add(new MenuItem(1, "Paracetamol", "Paracetamol, also known as acetaminophen, is a medication used to treat pain and fever. It is typically used for mild to moderate pain relief.", MenuCategory.PAINKILLER, 4.99));
		menuItems.add(new MenuItem(2, "Risperidone", "Risperidone, sold under the brand name Risperdal among others, is an atypical antipsychotic.[2] It is used to treat schizophrenia, bipolar disorder, and irritability associated with autism.", MenuCategory.ANTIPSYCHOTIC, 6.99));
		menuItems.add(new MenuItem(3, "Haloperidol", "Haloperidol, marketed under the trade name Haldol among others, is a typical antipsychotic medication.[3] Haloperidol is used in the treatment of schizophrenia, tics in Tourette syndrome, mania in bipolar disorder and others.", MenuCategory.ANTIPSYCHOTIC, 5.99));
		menuItems.add(new MenuItem(4, "Chlorpromazine", "Chlorpromazine (CPZ), marketed under the brand names Thorazine and Largactil among others, is an antipsychotic medication. It is primarily used to treat psychotic disorders such as schizophrenia.", MenuCategory.ANTIPSYCHOTIC, 12.99));
		menuItems.add(new MenuItem(5, "Amoxicillin", "Amoxicillin is an antibiotic used to treat a number of bacterial infections. These include middle ear infection, strep throat, pneumonia, skin infections, and urinary tract infections among others", MenuCategory.ANTIBIOTIC, 11.99));
		menuItems.add(new MenuItem(6, "Chloramphenicol", "Chloramphenicol is an antibiotic useful for the treatment of a number of bacterial infections. This includes use as an eye ointment to treat conjunctivitis.", MenuCategory.ANTIBIOTIC, 9.99));
		menuItems.add(new MenuItem(7, "Aprotinin", "Under the trade name Trasylol, aprotinin was used as a medication administered by injection to reduce bleeding during complex surgery, such as heart and liver surgery. Its main effect is the slowing down of fibrinolysis, the process that leads to the breakdown of blood clots.", MenuCategory.HEMOSTATIC, 6.99));
		menuItems.add(new MenuItem(8, "Etamsylate", "Etamsylate (sometimes spelled ethamsylate) is an antihemorrhagic agent which is believed to work by increasing resistance in the endothelium of capillaries and promoting platelet adhesion.", MenuCategory.HEMOSTATIC, 6.99));
		menuItems.add(new MenuItem(9, "Oxicodone", "Oxycodone, sold under the brand name OxyContin (which is the extended release form) among others, is an opioid medication used for treatment of moderate to severe pain, and a common drug of abuse. It is usually taken by mouth, and is available in immediate-release and controlled-release formulations.", MenuCategory.PAINKILLER, 6.99));
		menuItems.add(new MenuItem(10, "Tramadol", "Tramadol, sold under the brand name Ultram among others, is an opioid pain medication used to treat moderate to moderately severe pain. When taken by mouth in an immediate-release formulation, the onset of pain relief usually begins within an hour.", MenuCategory.PAINKILLER, 2.99));
		menuItems.add(new MenuItem(11, "Metamizole", "Metamizole, or dipyrone, is a painkiller, spasm reliever, and fever reliever that also has anti-inflammatory effects. It is most commonly given by mouth or by injection.", MenuCategory.PAINKILLER, 2.99));
		return menuItems;
	}

	public void initializeDatabase() {
		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/drugstore","","");) {
			
				try (PreparedStatement prepStmt = conn.prepareStatement("DROP TABLE IF EXISTS menuitems;")) {
					prepStmt.execute();
				}
				
				try (PreparedStatement prepStmt = conn.prepareStatement("DROP TABLE IF EXISTS orders;")) {
					prepStmt.execute();
				}
				
				try (PreparedStatement prepStmt = conn.prepareStatement("CREATE TABLE menuitems (id int primary key, name varchar(50), description varchar(400), category varchar(30), price float);")) {
					prepStmt.execute();
				}
				
				List<MenuItem> menuItems = getMenuItemsList();
				for (MenuItem menuItem : menuItems) {
					try (PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO menuitems (id, name, description, category, price) values (?,?,?,?,?);");) {
						prepStmt.setInt(1, menuItem.getId());
						prepStmt.setString(2, menuItem.getName());
						prepStmt.setString(3, menuItem.getDescription());
						prepStmt.setString(4, menuItem.getCategory().toString());
						prepStmt.setDouble(5, menuItem.getPrice());
						prepStmt.execute();
					}
				}	
				
				try (PreparedStatement prepStmt = conn.prepareStatement("CREATE TABLE orders (id int auto_increment primary key, customer varchar(30), contents varchar(255), status varchar(20));")) {
					prepStmt.execute();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
