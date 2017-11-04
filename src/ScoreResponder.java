
public class ScoreResponder {

	Client client;
	Responder responder;
	Request request;
	int responderScore;

	public int calculate(Responder R, Client C, Request Rq) {

		responder = R;
		client = C;
		request = Rq;
		responderScore = (5 * serviceCategory()) + (2 * specialty()) + age() + gender();
		return responderScore;
	}

	private int serviceCategory() {
		int count = 0;
		if (client.service.getValue() == responder.service.getValue()) {
			count++;
		}
		if (client.service.getValue() == "Army" || client.service.getValue() == "Navy"
				|| client.service.getValue() == "RAF") {
			if (responder.service.getValue() == "Army" || responder.service.getValue() == "Navy"
					|| responder.service.getValue() == "RAF") {
				count++;
			}
		}

		if (client.service.getValue() == "Fire" || client.service.getValue() == "Police"
				|| client.service.getValue() == "NHS") {
			if (responder.service.getValue() == "Fire" || responder.service.getValue() == "Police"
					|| responder.service.getValue() == "NHS") {
				count++;
			}
		}

		if (client.service.getValue() == "Family" || client.service.getValue() == "Other") {
			if (responder.service.getValue() == "Family" || responder.service.getValue() == "Other") {
				count++;
			}
		}
		return count;
	}

	private int specialty() {
		int count = 0;
		if (request.mentalHealth == true) {
			if (responder.mentalHealth == true) {
				count++;
			}
		}
		if (request.physicalHealth == true) {
			if (responder.physicalHealth == true) {
				count++;
			}
		}
		if (request.family == true) {
			if (responder.family == true) {
				count++;
			}
		}
		if (request.work == true) {
			if (responder.work == true) {
				count++;
			}
		}
		return count;
	}

	private int age() {
		if (client.age <= responder.age + 5 && client.age >= responder.age - 5) {
			return 2;
		} else {
			return 1;
		}
	}

	private int gender() {
		if (client.gender == responder.gender) {
			return 1;
		} else {
			return 0;
		}
	}

}
