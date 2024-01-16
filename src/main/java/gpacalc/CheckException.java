package gpacalc;

public class CheckException {
	public void checkSubjectLength(String subject) {
		if (checkBlank(subject) || checkMaxName(subject)){
			throw new IllegalArgumentException();
		}
	}

	public boolean checkMaxName(String subject){
		int maxNameLength = 10;
		return maxNameLength < subject.length();
	}

	public boolean checkBlank(String subject){
		return subject.isBlank();
	}

	public void checkGradeRange(String Grade){
		if(Grade.equals("A+") || Grade.equals("A0") || Grade.equals("B+") || Grade.equals("B0") || Grade.equals("C+") || Grade.equals("C0") || Grade.equals("D+") || Grade.equals("D0") || Grade.equals("F") || Grade.equals("P") || Grade.equals("NP") ) return;
		throw new IllegalArgumentException();
	}

	public void checkCreditRange(int subject_credit){
		int minCredit = 1,maxCredit = 4;
		if (subject_credit < minCredit|| maxCredit < subject_credit)
			throw new IllegalArgumentException("학점을 확인해주세요.");
	}

}
