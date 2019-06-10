/*
		文字コードを指定するためのフィルタ
		Sakamoto Keita  2019/6/4
*/
package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")	//すべてのサーブレットクラスに適応する
public class FilterUtf8 implements Filter{
	//フィルタがインスタンス化された直後に行う初期化処理
	public void init(FilterConfig fConfig) throws ServletException{}

	//設定したサーブレットクラスをリクエストしたときの処理
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		System.out.println("フィルター通ったよ(filterパッケージ FilterUtf8.java後で消す)");
	}

	//フィルタのインスタンスが破棄される直前に行われる終了処理
	public void destroy() {}
}
//テスト