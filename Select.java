package chapter6;

//sect.htmlからリクエストパラメータを受け取るサーブレット

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter6/select"})
public class Select extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

        //それぞれのリクエストパラメータの値を変数に取得
		request.setCharacterEncoding("UTF-8");
		String count=request.getParameter("count");     //セレクトボックス
		String payment=request.getParameter("payment"); //ラジオボックス
		String review=request.getParameter("review");   //テキストエリア
		String mail=request.getParameter("mail");       //チェックボックス

		Page.header(out);
		out.println("<p>"+count+"個の商品をカートに入れました。</p>");
		out.println("<p>お支払い方法を"+payment+"に設定しました。</p>");
		out.println("<p>ご感想ありがとうございます。</p>");
		out.println("<p>「"+review+"」</p>");
		if (mail!=null) {
			out.println("<p>メールをお送りします。</p>");
		} else {
			out.println("<p>メールはお送りしません。</p>");
		}
		Page.footer(out);
	}
}
