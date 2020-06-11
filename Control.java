package chapter6;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns={"/chapter6/control"})//アノテーションを使ってサーブレットのURLを指定
public class Control extends HttpServlet {
//public→パッケージの外部にあるアプリケーションサーバが使用するため
//(HttpServletクラスを継承)
//HTTPを使ったサーブレットの基本的な機能を提供するクラス(doGet,doPostメソッドなどをオーバーライドして使用)

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {//数値以外が入力されたときのエラー処理
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		Page.header(out);

		request.setCharacterEncoding("UTF-8");
        List<String> names=Collections.list(request.getParameterNames());
        //getParametersNamesメソッドでリクエストパラメーターの値を取得し、
        //それをlistメソッドに渡してArrayListに変換している
		for (String name : names) {
            //拡張for文でnamesから値を取り出し、getParameterValues(name)で値を取得
            String[] values=request.getParameterValues(name);
            
			for (String value : values) {
                //拡張for文で取得した名前と値をリクエストパラメーター名＝値の形式でレスポンスへ出力
				out.println("<p>"+name+"="+value+"</p>");
			}
		}
		Page.footer(out);
	}
}
