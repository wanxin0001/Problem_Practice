public class HumanFactory {
	public static Human createHuman(String m) {
		Human p = null;
		if (m.equals("boy")) {
			p = new Boy();
		} else if (m.equals("girl")) {
			p = new Girl();
		}

		return p;
	}

	public static void main(String[] args) {
		HumanFactory obj = new HumanFactory();
		Human boy = obj.createHuman("boy");
		Human girl = obj.createHuman("girl");
		boy.Walk();
		girl.Talk();
	}
}