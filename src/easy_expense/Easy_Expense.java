/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easy_expense;

import IHM.LoginActivity;
import DAO.UserDAO;
import java.sql.SQLException;

/**
 *
 * @author ibrah
 */
public class Easy_Expense {
    UserDAO userDAO = new UserDAO();
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws SQLException {
        LoginActivity f = new LoginActivity();
        f.setVisible(true);
        f.setSize(870, 530);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        
        
    }
    
}
