package com.simple.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FrontController.service(req, res) �����...");

		// �ѱ�ó���� ���� ���ڵ���� �����ϱ�
		req.setCharacterEncoding("utf-8");
		
		// Ŭ���̾�Ʈ�� ��û �м��ϱ�
		String requestURI = req.getRequestURI();
		requestURI = requestURI.replace("/webmvc", "");
		System.out.println("��û URI : " + requestURI);


		try {
			Controller controller = null;
			// ��ûURI�� �ش��ϴ� ��û�� ó���� ������ ��Ʈ�ѷ���ü �����ϱ�
			if ("/home.hta".equals(requestURI)) {
				controller = new HomeController();

			} else if ("/list.hta".equals(requestURI)) {
				controller = new ListController();
			} else if ("/detail.hta".equals(requestURI)) {
				controller = new DetailController();
			} else if ("/form.hta".equals(requestURI)) {
				controller = new FormController();
			} else if ("/add.hta".equals(requestURI)) {
				controller = new AddController();
			} else {
				controller = new HomeController();
			}
			// xxxController�� process(req, res) �޼ҵ� �����ؼ� ��ûó���ϰ�,
			// �̵��� ���������̸� �����ޱ�
			String path = controller.process(req, resp);
			
			// ��ΰ� redirect�� �����Ѵٸ�
			if(path.startsWith("redirect:")) {
				// ���û URI�� �������� ����
				path = path.replace("redirect:", "");
				resp.sendRedirect(path);
			} else {
				// ���� �̵���Ű��
				req.getRequestDispatcher("WEB-INF/views/"+path).forward(req, resp);				
			}
			
		} catch (Exception e) {
			throw new ServletException(e);

		}
	}
}
