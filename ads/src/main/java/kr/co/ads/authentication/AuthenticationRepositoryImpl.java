package kr.co.ads.authentication;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import kr.co.ads.ServerProperties;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Repository
public class AuthenticationRepositoryImpl implements AuthenticationRepository {
	@Autowired
	ServerProperties serverProperties;

	// 인증 정보 부여
	@Override
	public boolean grantAuthInfo(AuthInfo authInfo) throws Exception {
		boolean result = false;
		String url = serverProperties.getServerURL() + "/authentication/grantauthinfo?id=" + authInfo.getId() + "&no="
				+ authInfo.getNo();

		Request request = new Request.Builder().url(url).get().build();
		try (Response response = new OkHttpClient().newCall(request).execute()) {
			
			Gson gson = new Gson();
			HashMap responseBody = gson.fromJson(response.body().string(), HashMap.class);
			result = (boolean) responseBody.get("result");
			
			return result;
		}
	}

}
