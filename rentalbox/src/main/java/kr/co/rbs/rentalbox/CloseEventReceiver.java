package kr.co.rbs.rentalbox;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

// 닫힘 이벤트 수신 클래스
public class CloseEventReceiver implements Runnable {
	// GPIO 컨트롤러 생성
	private GpioController controller;
	// GPIO 7번 -- 적외선 센서
	private GpioPinDigitalInput sensor;

	private RentalBoxService rentalBoxService;

	private GpioPinListener pinListener;

	public CloseEventReceiver() {
		this.rentalBoxService = new RentalBoxServiceImpl();

		this.controller = GpioFactory.getInstance();
		this.pinListener = new GpioPinListener();
		this.sensor = controller.provisionDigitalInputPin(RaspiPin.GPIO_07);
		this.sensor.addListener(pinListener);
	}

	@Override
	public void run() {
		while (true) {
		}
	}

// 적외선 센서 리스너
	class GpioPinListener implements GpioPinListenerDigital {
		@Override
		public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
			// 센서에 접근이 감지되면
			if (sensor.getState().isHigh()) {
				System.out.println("적외선 센서 상태변화 감지");
				// 잠금 처리를 수행한다.
				rentalBoxService.processingLock();
			}
		}
	}
}
