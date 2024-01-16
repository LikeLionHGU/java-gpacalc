package gpacalc;

public class Method {
	CheckException checking = new CheckException();

	public void categorize(String input, String major_liberal) {
		String[] first_split = input.split(",");
		String[][] second_split = new String[first_split.length][3];
		for (int i = 0; i < first_split.length; i++) {
			second_split[i] = first_split[i].split("-");
		}

		for (int i = 0; i < first_split.length; i++) {
			checking.checkSubjectLength(second_split[i][0]);
			checking.checkGradeRange(second_split[i][2]);

			System.out.print("[" + major_liberal + "] ");
			for (int j = 0; j < 3; j++) {
				System.out.print(second_split[i][j]);
				if (j != 2) System.out.print(",");
			}
			System.out.println();
		}
	}

	public int getCredit(String input) {
		int credit = 0;
		String[] first_split = input.split(",");
		String[][] second_split = new String[first_split.length][3];
		for (int i = 0; i < first_split.length; i++) second_split[i] = first_split[i].split("-");
		for (String[] strings : second_split) {
			int subject_credit = Integer.parseInt(strings[1]);
			checking.checkCreditRange(subject_credit);

			if (strings[2].equals("F") || strings[2].equals("NP")) continue;
			credit += Integer.parseInt(strings[1]);
		}
		return credit;
	}

	// /// - 1 - \\\  랑 그 밑이랑 하나씩 새로운 mehtod를 사용하기!
	public double calculate(String all, int credit){
		///// - 1 - \\\\\\\\\
		// A+(4.5), A0(4.0), B+(3.5), B0(3.0), C+(2.5), C0(2.0), D+(1.5), D0(1.0), F(0)
		String[] first_split = all.split(",");
		String[][] second_split = new String[first_split.length][3];
		for(int i = 0 ; i < first_split.length ; i++){
			second_split[i] = first_split[i].split("-");
			if(second_split[i][2].equals("P")) credit -= Integer.parseInt(second_split[i][1]);
			if(second_split[i][2].equals("F")) credit += Integer.parseInt(second_split[i][1]);
		}

		//// - 2 - \\\\\\\\
		double sum = 0;
		for(int i = 0 ;i < first_split.length ; i++){
			sum += (Double.parseDouble(second_split[i][1]) * Matching(second_split[i][2]));
		}
		double result = sum / credit;
		result = Math.round(result*100)/(double)100 ;

		return result;
	}

	public double Matching(String grade){
		double score = 0;
		switch(grade){
			case "A+" -> score = 4.5;
			case "A0" -> score = 4.0;
			case "B+" -> score = 3.5;
			case "B0" -> score = 3.0;
			case "C+" -> score = 2.5;
			case "C0" -> score = 2.0;
			case "D+" -> score = 1.5;
			case "D0" -> score = 1.0;
			default -> score = 0;
		}
		return score;
	}

}
