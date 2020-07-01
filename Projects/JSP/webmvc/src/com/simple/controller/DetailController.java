package com.simple.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.dao.BookDao;
import com.simple.util.NumberUtil;
import com.simple.vo.Book;

public class DetailController implements Controller {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		System.out.println("DetailController.process(req,res) �����");
		
		// ��û �Ķ���� ���� ��ȸ�ϱ�
		int bookNo = NumberUtil.stringToInt(req.getParameter("bookno"));
		
		// å ��ȣ�� �ش��ϴ� å ���� ȹ���ϱ�
		BookDao bookDao = new BookDao();
		Book book = bookDao.getBookByNo(bookNo);
		
		// ȹ���� å������ ���������� �����ϱ� ���ؼ� Request�� �Ӽ����� �����ϱ�
		req.setAttribute("book", book);
		
		// �����̵��� ���������� �̸��� ��ȯ�ϱ�
		return "detail.jsp";
	}
}
