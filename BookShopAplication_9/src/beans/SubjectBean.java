package beans;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import dao.BookDao;

public class SubjectBean implements Serializable, Closeable{
	private static final long serialVersionUID = 3026876160626760662L;
	private BookDao dao;
	private List<String> subjectList;
	public SubjectBean() throws Exception{
		this.dao = new BookDao();
	}
	public BookDao getDao() {
		return dao;
	}
	public void setDao(BookDao dao) {
		this.dao = dao;
	}
	public List<String> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<String> subjectList) {
		this.subjectList = subjectList;
	}
	public void fetchSubjects( )throws Exception {
		this.subjectList = this.dao.getDistinctSubjects();
	}
	@Override
	public void close() throws IOException {
		this.dao.close();
	}
}
