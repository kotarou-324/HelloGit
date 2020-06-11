package chapter6;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns={"/chapter6/reserve"})//アノテーションを使ってサーブレットのURLを指定
public class Reserve extends HttpServlet {
//public→パッケージの外部にあるアプリケーションサーバが使用するため
//(HttpServletクラスを継承)
//HTTPを使ったサーブレットの基本的な機能を提供するクラス(doGet,doPostメソッドなどをオーバーライドして使用)

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {//数値以外が入力されたときのエラー処理
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		request.setCharacterEncoding("UTF-8");
		String count = request.getParameter("count");
		String seat = request.getParameter("seat");


		Page.header(out);

		out.println(count + "<h1>名様で</h1>"+seat+"席のご予約承りました。");
		for(String value : request.getParameterValues("option")){
			out.println("「" +value+ "」");
		}
		out.println("をご用意いたします。");
        
		Page.footer(out);
	}
}
