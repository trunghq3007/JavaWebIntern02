package dao;

import java.util.List;

import entity.Mark;

public interface IMarkDAO {
	List<Mark> findAll();

	List<Mark> findAll(String studentId);

	Mark find(String studentId, String subjectId);

	boolean insertFirstMark(Mark newMark);

	boolean insertSecondMark(Mark newMark);

	boolean delete(String studentId, String subjectId);

	boolean updateMark(Mark newMark);

	boolean updateFirstMark(Mark newMark);

	boolean updateStatus(Mark m);

	boolean cancelStatus(Mark m);
	
	
	List<Mark> firstMarkList();
	List<Mark> secondMarkList();
	
}
