package test.servlets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// ������Ӧ����
		response.setContentType("image/jpeg");
		// ͼƬ���ڴ�ӳ��
		BufferedImage image = new BufferedImage(60, 20,
				BufferedImage.TYPE_INT_RGB);
		// ��û��ʶ���
		Random r = new Random();
		Graphics g = image.getGraphics();
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		g.fillRect(0, 0, 60, 20);
		g.setColor(new Color(0, 0, 0));
		String number = String.valueOf(r.nextInt(99999));
		session.setAttribute("number", number);
		g.drawString(number, 5, 15);

		// ѹ���jpeg��ʽ
		OutputStream os = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);

		// ��BufferedImage�����е�ͼ����Ϣ�����
		// �򴴽��ö���(encoder)ʱָ������������
		encoder.encode(image);
		

	}

}
