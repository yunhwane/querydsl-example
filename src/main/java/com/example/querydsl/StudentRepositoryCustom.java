package com.example.querydsl;


import com.example.querydsl.entity.QStudent;
import com.example.querydsl.entity.Student;
import com.querydsl.core.types.dsl.BooleanExpression;
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

    public boolean existsByName(String name) {
        return jpaQueryFactory.selectOne()
                .from(QStudent.student)
                .where(QStudent.student.name.eq(name))
                .fetchFirst() != null;
    }

    public List<Student> findByNameAndAge(String name, int age) {
        return jpaQueryFactory.selectFrom(QStudent.student)
                .join(QStudent.student.academy).fetchJoin()
                .where(searchConditionEquals(name, age))
                .fetch();
    }

    private BooleanExpression searchConditionEquals(String name, int age) {
        return NameEquals(name).and(AgeEquals(age));
    }

    private BooleanExpression NameEquals(String name) {
        return name == null ? null : QStudent.student.name.eq(name);
    }

    private BooleanExpression AgeEquals(int age) {
        return age == 0 ? null : QStudent.student.age.eq(age);
    }
}
