package io.chugar.jpademo.manytomany.dao.queries;


public class CoursQuery {

	public static final String MSQL_ADD_STUDENT_TO_COURSE = 
		"INSERT INTO etudiant_cours (id_etudiant,id_cours) VALUES (?1, ?2)";
	
	public static final String MSQL_REMOVE_STUDENT_TO_COURSE = 
		"DELETE FROM etudiant_cours WHERE id_etudiant = ?1 AND id_cours = ?2";
}