package platform.repository;

import platform.config.DatabaseConfig;
import platform.entity.Course;

import java.sql.*;

public class CourseRepository implements CourseRepositoryInterface {
    @Override
    public Course findById(int id) throws SQLException {
        String sql = "select * from courses where id = ?";

        try (Connection c = DatabaseConfig.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Course(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getBoolean("archived")
                );
            }
            return null;
        }
    }
    @Override
    public Course save(String title) throws SQLException {
        String sql = """
            INSERT INTO courses(title, archived)
            VALUES (?, false)
            RETURNING id;
        """;

        try (Connection c = DatabaseConfig.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, title);

            ResultSet rs = ps.executeQuery();
            rs.next();

            return new Course(
                    (int) rs.getLong("id"),
                    title,
                    false
            );
        }
    }
}
