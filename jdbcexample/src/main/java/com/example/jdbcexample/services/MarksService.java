package com.example.jdbcexample.services;

import com.example.jdbcexample.dao.SubjectMarkDAO;
import com.example.jdbcexample.dto.PupilDTO;
import com.example.jdbcexample.dto.SubjectMarkDTO;
import com.example.jdbcexample.mappers.MarkMapper;
import com.example.jdbcexample.mappers.PupilMapper;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarksService {

    private final BasicDataSource dataSource;
    private final MarkMapper mapper;

    private final String MARKS_RETRIEVAL_QUERY = "select * FROM marks";
    private final String MARKS_PAGE_RETRIEVAL_QUERY = "select * FROM marks WHERE id BETWEEN ? AND ? order by ? ?";

    @SneakyThrows
    public List<SubjectMarkDTO> getAllMarks() {

        @Cleanup Connection conn = getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(MARKS_RETRIEVAL_QUERY);

        System.out.println(">>>   "+stmt.toString());

        return executeQuery(stmt).stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @SneakyThrows
    public  List<SubjectMarkDTO> getMarksPage(String pagenum, String pagesize, String sort, String group) {

        @Cleanup Connection conn = getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(MARKS_PAGE_RETRIEVAL_QUERY);

        int i = 1;
        stmt.setInt(i++, parseInt(pagesize) * parseInt(pagenum));
        stmt.setInt(i++, parseInt(pagesize) * parseInt(pagenum) + parseInt(pagesize));
        stmt.setString(i++, group);
        stmt.setString(i++, sort);

        System.out.println(">>>   "+stmt.toString());

        return executeQuery(stmt).stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @SneakyThrows
    public  String getMarksByPupilId(Long pupilId) {

        return "";
    }

    @SneakyThrows
    public  String addNewMark(SubjectMarkDAO mark) {

        return "";
    }

    @SneakyThrows
    public  String editMark(SubjectMarkDAO mark) {

        return "";
    }

    @SneakyThrows
    public  String deleteMark(Long mark) {

        return "";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private List<SubjectMarkDAO> executeQuery(PreparedStatement stmt) {
        List<SubjectMarkDAO> marks = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SubjectMarkDAO mark = SubjectMarkDAO.builder()
                        .id(rs.getLong("id"))
                        .subject_id(rs.getLong("subject_id"))
                        .subject_id(rs.getLong("pupil_id"))
                        .date(rs.getDate("date"))
                        .value(rs.getInt("id"))
                        .build();

                marks.add(mark);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return marks;
    }
}
