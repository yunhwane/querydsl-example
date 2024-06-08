package com.example.querydsl;


import com.example.querydsl.entity.QStudent;
import com.example.querydsl.entity.Student;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public List<Student> findByName(String name) {
        return jpaQueryFactory.selectFrom(QStudent.student)
                .where(QStudent.student.name.eq(name))
                .fetch();
    }

    public List<Student> findByNameFetchAcademy(String name) {
        return jpaQueryFactory.selectFrom(QStudent.student)
                .join(QStudent.student.academy).fetchJoin()
                .where(QStudent.student.name.eq(name))
                .fetch();
    }


}
