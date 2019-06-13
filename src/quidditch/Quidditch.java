package quidditch;

import forms.Menu;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.DAO;

/**
 *
 * @author gianlucalovecchio
 */
public class Quidditch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAO jdbcDAO = new DAO();
        jdbcDAO.conectar();
        Menu menu = new Menu();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

}
