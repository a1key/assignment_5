package com.company.data;

import java.sql.*;

public interface IDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
