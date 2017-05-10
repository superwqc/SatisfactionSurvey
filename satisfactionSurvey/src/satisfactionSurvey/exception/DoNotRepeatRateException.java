package satisfactionSurvey.exception;
//不能重复打分
public class DoNotRepeatRateException extends Exception {
	public DoNotRepeatRateException(String msg) {
		super(msg);
	}

}
