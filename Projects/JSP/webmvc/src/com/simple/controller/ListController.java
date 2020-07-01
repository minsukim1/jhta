package com.simple.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.dao.BookDao;
import com.simple.vo.Book;

public class ListController implements Controller {
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("ListController.pricess(reqm,res) �����");
		
		// ��� å ���� ȹ���ϱ�
		BookDao bookDao = new BookDao();
		List<Book> books = bookDao.getAllBooks();
		
		// ȹ���� å������ ���������� �����ϱ� ���ؼ� Request�� �Ӽ����� �����ϱ�
		req.setAttribute("books", books);
		
		// �����̵��� ���������� �̸��� ��ȯ�ϱ�
		return "list.jsp";
	}
}
