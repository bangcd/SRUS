package kr.co.ads.member;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import kr.co.ads.ServerProperties;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	public static final MediaType MEDIA_TYPE_HTML = MediaType.get("tex/html; charset=utf-8");
	@Autowired
	ServerProperties serverProperties;

	// 핸드폰 번호 대조
	@Override
	public boolean comparePhoneNumber(Member member) throws Exception {
		String url = serverProperties.getServerURL() + "/member/phone?id=" + member.getId() + "&phoneNumber="
				+ member.getPhoneNumber();
		boolean result = false;
		Request request = new Request.Builder().url(url).get().build();
		try (Response response = new OkHttpClient().newCall(request).execute()) {

			Gson gson = new Gson();

			Map<String, Boolean> responseBody = gson.fromJson(response.body().string(), HashMap.class);
			result = (boolean) responseBody.get("result");

			return result;
		}
	}

	// 카드 정보 수정
	@Override
	public boolean modifyCardInfo(Member member) throws Exception {
		String url = serverProperties.getServerURL() + "/member/card?id=" + member.getId() + "&cardName="
				+ member.getCardName() + "&cardUid=" + member.getCardUid();
		boolean result = false;
		String message = "";
		RequestBody requestBody = RequestBody.create(message, MEDIA_TYPE_HTML);
		
		Request request = new Request.Builder().url(url).put(requestBody).build();
		try (Response response = new OkHttpClient().newCall(request).execute()) {

			Gson gson = new Gson();

			Map<String, Boolean> responseBody = gson.fromJson(response.body().string(), HashMap.class);
			result = (boolean) responseBody.get("result");
			return result;
		}
	}

	// NFC 수신
	@Override
	public String receiveNfc() {
		String uid = "";
		String message[] = null;
		Process process = null;
		BufferedReader in = null;
		try {
			process = Runtime.getRuntime().exec("nfc-poll");
			in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.startsWith("UID")) {
					message = line.split("\\s");
					
					for (int x = 2; x < message.length; x++) {
						uid += message[x];
					}

				}
			}

			process.waitFor();

			process.destroy();
		} catch (Exception e1) {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

		return uid;
	}

}
