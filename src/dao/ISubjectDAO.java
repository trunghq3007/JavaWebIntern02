package dao;

import java.util.List;

import entity.Subject;

public interface ISubjectDAO {
	List<Subject> findAll();

	boolean insert(Subject newSubject);

	boolean update(Subject updatesubjectId);

	boolean delete(String subjectId);
}
