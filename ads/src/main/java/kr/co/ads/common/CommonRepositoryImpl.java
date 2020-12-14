package kr.co.ads.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import kr.co.ads.ServerProperties;
import kr.co.ads.member.Member;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Repository
public class CommonRepositoryImpl implements CommonRepository {
	public static final MediaType MEDIA_TYPE_HTML = MediaType.get("tex/html; charset=utf-8");
	@Autowired
	ServerProperties serverProperties;
	
	//회원 검증
	@Override
	public boolean validMember(Member member) throws Exception {
		String url = serverProperties.getServerURL() + "/validmember?id=" + member.getId() + "&password=" + member.getPassword();
		String message = "";
		
		RequestBody requestBody = RequestBody.create(message, MEDIA_TYPE_HTML);

		Request request = new Request.Builder().url(url).post(requestBody).build();
		try (Response response = new OkHttpClient().newCall(request).execute()) {
			
			Gson gson = new Gson();
			Map<String, Boolean> responseBody = gson.fromJson(response.body().string(), HashMap.class);
			
			return responseBody.get("result");
		}
	}

}
