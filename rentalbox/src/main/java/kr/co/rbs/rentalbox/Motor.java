package kr.co.rbs.rentalbox;

import java.io.Serializable;

public class Motor implements Serializable{
	//모터 상태
	private boolean isOpened;
	//모터 스텝 이동 수
	private long step;
	//모터 이동 속도
	private long stepInterval;
	
	public Motor() {
	}
	
	public Motor(boolean isOpened, long step) {
		this.isOpened = isOpened;
		this.step = step;
	}


	public boolean isOpened() {
		return isOpened;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}

	public long getStep() {
		return step;
	}

	public void setStep(long step) {
		this.step = step;
	}

	public long getStepInterval() {
		return stepInterval;
	}

	public void setStepInterval(long stepInterval) {
		this.stepInterval = stepInterval;
	}	
	
	
}
