package database;

import java.sql.*;


public class DbConnector {
    static public void polaczenie_z_baza() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            System.out.println("Sterowniki załadowane");

            Connection polaczenie = DriverManager.getConnection("jdbc:oracle:thin:@//city.wsisiz.edu.pl:1521/orclpdb.wsisiz.edu.pl", "Dybowski", "Kreska");

            System.out.println("Połączenie nawiązane");

            Statement a = polaczenie.createStatement();
            ResultSet res = a.executeQuery("select * from MD_USERS");

            System.out.println("Wyniki zapytania: ");

            while (res.next()) {
                //System.out.print(res.getString(1) + "  -  ");
                System.out.print(res.getString(2));
                System.out.println(res.getString(3));
            }
        } catch (Exception wyjatek) {
            System.out.println("Błąd");
        }
    }

    private Connection connect() {
        String url = "jdbc:oracle:thin:@//city.wsisiz.edu.pl:1521/orclpdb.wsisiz.edu.pl";
        String user = "Dybowski";
        String password = "Kreska";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("" + url + "", "" + user + "", "" + password + "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean logInToGame(String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = this.connect();
        Statement a = conn.createStatement();
        //String query = "select * from MD_USERS where username="+username+"and userpassword="+password;
        ResultSet res = a.executeQuery("select * from MD_USERS");
        while (res.next()) {
            if (username.equals(res.getString(2)) && password.equals(res.getString(3))) {
                System.out.println("Udało sie");
                return true;
            } else {
                System.out.println("Nie udało sie");
            }
        }
        return false;
    }

    public void add_user(String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Sterowniki załadowane");
        Connection polaczenie = this.connect();

        String sql = "INSERT INTO MD_USERS VALUES(?,?,?)";

        PreparedStatement a = polaczenie.prepareStatement(sql);
        a.setInt(1, 1);
        a.setString(2, username);
        a.setString(3, password);
        a.execute();

        String sql_commit = "commit";
        Statement b = polaczenie.createStatement();
        b.executeQuery(sql_commit);
        b.executeQuery(sql_commit);

        polaczenie.close();
    }

    public void add_score(String user, int score) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Sterowniki załadowane");
        Connection polaczenie = this.connect();

        String sql = "INSERT INTO MD_POINTS VALUES(?,?,?)";

        PreparedStatement a = polaczenie.prepareStatement(sql);
        a.setInt(1, 1);
        a.setString(2, user);
        a.setInt(3, score);
        a.execute();

        String sql_commit = "commit";
        Statement b = polaczenie.createStatement();
        b.executeQuery(sql_commit);
        b.executeQuery(sql_commit);

        polaczenie.close();
    }

    public String get_top_10() throws ClassNotFoundException, SQLException {
        StringBuilder temp = new StringBuilder();
        String result;
        //temp.append(String.valueOf(i) + ". " + res.getString(2) + " - " + String.valueOf(res.getInt(3)) + " pkt \n");

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = this.connect();
        Statement a = conn.createStatement();
        //String query = "select * from MD_USERS where username="+username+"and userpassword="+password;
        ResultSet res = a.executeQuery("select * from MD_POINTS order by points desc");
        int i = 1;
        while (res.next()) {
            if (i < 11) {
                temp.append(i + ". ");
                temp.append(res.getString(2));
                temp.append(" - ");
                temp.append(res.getString(3));
                temp.append(" pkt.\n");
                i++;
                /*System.out.print(res.getString(2));
                System.out.print(" - ");
                System.out.println(res.getString(3));*/

            } else {
                System.out.println(temp);
                result = String.valueOf(temp);
                return result;
            }
        }
        return String.valueOf(temp);
    }
}
