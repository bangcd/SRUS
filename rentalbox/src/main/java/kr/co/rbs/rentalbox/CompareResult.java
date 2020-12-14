package kr.co.rbs.rentalbox;

import java.io.Serializable;

// 대조 결과 빈즈 클래스
public class CompareResult implements Serializable {
	private boolean result;

	public CompareResult() {
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
}
