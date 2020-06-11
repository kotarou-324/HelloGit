package chapter6;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter6/checkbox"})//アノテーションを使ってサーブレットのURLを指定
public class Checkbox extends HttpServlet { 
//public→パッケージの外部にあるアプリケーションサーバが使用するため
//(HttpServletクラスを継承)
//HTTPを使ったサーブレットの基本的な機能を提供するクラス(doGet,doPostメソッドなどをオーバーライドして使用)

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out=response.getWriter();
        //文字を出力する時にコンテンツタイプに設定されている文字セットを使ってエンコーディング

		request.setCharacterEncoding("UTF-8");
        String[] genre=request.getParameterValues("genre");
        //チェックボックスの状態をリクエストパラメータとして取得しString型の配列genreに保存する
        /*
        引数に指定したパラメータに、複数の値がある場合に利用するメソッド
        指定した名前が存在しないときには「null」を返す
        （例） 家電と書籍をチェックした場合

        「配列genreの各要素」
        genre[0] : "家電"
        genre[1] : "書籍"


        */
		Page.header(out);
		if (genre!=null) { //nuleでなければ拡張for文で値を表示
			for (String item : genre) {
				out.println("「"+item+"」");
			}
			out.println("に関するお買い得情報をお送りします。");
		} else { //nullの場合の表示
			out.println("お買い得情報はお送りしません。");
		}
		Page.footer(out);
		//コメントテスト
	}
}
