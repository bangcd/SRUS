package kr.co.ads.rental;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import kr.co.ads.ServerProperties;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Repository
public class RentalRepositoryImpl implements RentalRepository {
	@Autowired
	ServerProperties serverProperties;

	// 대여 정보 조회
	@Override
	public List<Rental> searchRentalInfo(String id) throws Exception {
		String url = serverProperties.getServerURL() + "/rental/" + id + "/current";

		Request request = new Request.Builder().url(url).get().build();
		try (Response response = new OkHttpClient().newCall(request).execute()) {

			Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
				@Override
				public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
						throws JsonParseException {
					return LocalDate.parse(json.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				}
			}).create();

			List<Rental> responseBody = gson.fromJson(response.body().string(), new TypeToken<List<Rental>>() {
			}.getType());

			return responseBody;
		}
	}
}
