package com.example.jdbcexample.services;

import com.example.jdbcexample.dao.PupilDAO;
import com.example.jdbcexample.dto.PupilDTO;
import com.example.jdbcexample.mappers.PupilMapper;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@Service
@RequiredArgsConstructor
@Slf4j
public class PupilsService {

    private final BasicDataSource dataSource;
    private final PupilMapper mapper;

    private final String PUPILS_RETRIEVAL_QUERY = "select * FROM pupils";
    private final String PUPILS_PAGE_RETRIEVAL_QUERY = "select * FROM pupils WHERE id BETWEEN ? AND ? order by ? ?";

    @SneakyThrows
    public List<PupilDTO> getAllPupils() {

        @Cleanup Connection conn = getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(PUPILS_RETRIEVAL_QUERY);

        System.out.println(">>>   "+stmt.toString());

        return executeQuery(stmt).stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @SneakyThrows
    public  List<PupilDTO> getPupilsPage(String pagenum, String pagesize, String sort, String group) {

        @Cleanup Connection conn = getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(PUPILS_PAGE_RETRIEVAL_QUERY);

        int i = 1;
        stmt.setInt(i++, parseInt(pagesize) * parseInt(pagenum));
        stmt.setInt(i++, parseInt(pagesize) * parseInt(pagenum) + parseInt(pagesize));
        stmt.setString(i++, group);
        stmt.setString(i++, sort);

        System.out.println(">>>   "+stmt.toString());

        return executeQuery(stmt).stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private List<PupilDAO> executeQuery(PreparedStatement stmt) {
        List<PupilDAO> pupils = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PupilDAO pupil = PupilDAO.builder()
                        .id(rs.getLong("id"))
                        .firstname(rs.getString("firstname"))
                        .lastname(rs.getString("lastname"))
                        .email(rs.getString("email"))
                        .birthdate(rs.getDate("birthdate"))
                        .class_head_id(rs.getLong("class_head_id"))
                        .class_id(rs.getLong("class_id"))
                        .build();

                pupils.add(pupil);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return pupils;
    }
}
