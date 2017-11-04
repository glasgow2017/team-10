

// THIS CLASS SCORES RESPONDERS BASED ON HOW RELEVENT THEY ARE TO THE REQUEST AND THE USER

public class ScoreResponder {

	Client client;
	Responder responder;
	Request request;
	int responderScore;

	public int calculate(Responder R, Client C, Request Rq) {

		responder = R;
		client = C;
		request = Rq;
		
		// If Responder is offline, they cannot be assigned to a request
		if (responder.online == false){
			responderScore = -1;
		}
		else{
		responderScore = (5 * serviceCategory()) + (2 * specialty()) + age() + gender();
		}
		return responderScore;
	}

	// Compares the service category of the responder and the client and scores close matches highest
	private int serviceCategory() {
		int count = 0;
		if (client.service.getValue().equals(responder.service.getValue())) {
			count++;
		}
		if (client.service.getValue().equals("Army") || client.service.getValue().equals("Navy")
				|| client.service.getValue().equals("RAF")) {
			if (responder.service.getValue().equals("Army") || responder.service.getValue().equals("Navy")
					|| responder.service.getValue().equals("RAF")) {
				count++;
			}
		}
		if (client.service.getValue().equals("Fire") || client.service.getValue().equals("Police")
				|| client.service.getValue().equals("NHS")) {
			if (responder.service.getValue().equals("Fire") || responder.service.getValue().equals("Police")
					|| responder.service.getValue().equals("NHS")) {
				count++;
			}
		}

		if (client.service.getValue().equals("Family") || client.service.getValue().equals("Other")) {
			if (responder.service.getValue().equals("Family") || responder.service.getValue().equals("Other")) {
				count++;
			}
		}
		return count;
	}

	// Scores responders with most appropriate specialities highest
	private int specialty() {
		int count = 0;
		if (request.mentalHealth && responder.mentalHealth) {
			count++;
		}

		if (request.physicalHealth && responder.physicalHealth) {
			count++;

		}
		if (request.family && responder.family) {
			count++;
		}

		if (request.work && responder.work) {
			count++;

		}
		return count;
	}

	// Scores responders higher if they are close in age to the client
	private int age() {
		if (client.age <= responder.age + 5 && client.age >= responder.age - 5) {
			return 2;
		} else {
			return 1;
		}
	}

	// Scores responders higher if they are the same gender
	private int gender() {
		if (client.gender.getValue().equals(responder.gender.getValue())) {
			return 1;
		} else {
			return 0;
		}
	}

}
