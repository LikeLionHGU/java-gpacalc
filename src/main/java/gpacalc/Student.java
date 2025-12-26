package gpacalc;

public class Student {
    private int creditSum;
    private float gradeSum;
    private float majorSum;
    private float gradeAvg;
    private float majorAvg;
    private int majorCredit;
    private int countWithoutPF;

    Student() {
        this.creditSum = 0;
        this.gradeSum = 0;
        this.majorSum = 0;
        this.gradeAvg = 0.0f;
        this.majorAvg = 0.0f;
        this.majorCredit = 0;
        this.countWithoutPF = 0;
    }

    public void setMajorCredit(int majorCount) {
        this.majorCredit += majorCount;
    }

    public int getMajorCredit() {
        return majorCredit;
    }

    public int getCountWithoutPF() {
        return countWithoutPF;
    }

    public void setGradeSum(String grade, int credit) {
        float grade1 = 0.0f;
        if (grade.equals("P")||grade.equals("NP")) {
            grade1 += 0.0;
            this.countWithoutPF += 0;
        }
        else {
            if (grade.equals("A+")) {
                grade1 += 4.5;
            }
            else if (grade.equals("A0")) {
                grade1 += 4.0;
            }
            else if (grade.equals("B+")) {
                grade1 += 3.5;
            }
            else if (grade.equals("B0")) {
                grade1 += 3.0;
            }
            else if (grade.equals("C+")) {
                grade1 += 2.5;
            }
            else if (grade.equals("C0")) {
                grade1 += 2.0;
            }
            else if (grade.equals("D+")) {
                grade1 += 1.5;
            }
            else if (grade.equals("D0")) {
                grade1 += 1.0;
            }
            else if (grade.equals("F")) {
                grade1 += 0.0;
            }
            else {
                throw new IllegalArgumentException("잘못된 평점값");
            }
            this.countWithoutPF += credit;
        }

        gradeSum += grade1 * credit;
    }

    public float getGradeSum() {
        return gradeSum;
    }

    public void setMajorSum(String grade, int credit) {
        float grade1 = 0.0f;
        if (grade.equals("P")||grade.equals("NP")) {
            grade1 += 0.0;
        }
        else if (grade.equals("A+")) {
            grade1 += 4.5;
        }
        else if (grade.equals("A0")) {
            grade1 += 4.0;
        }
        else if (grade.equals("B+")) {
            grade1 += 3.5;
        }
        else if (grade.equals("B0")) {
            grade1 += 3.0;
        }
        else if (grade.equals("C+")) {
            grade1 += 2.5;
        }
        else if (grade.equals("C0")) {
            grade1 += 2.0;
        }
        else if (grade.equals("D+")) {
            grade1 += 1.5;
        }
        else if (grade.equals("D0")) {
            grade1 += 1.0;
        }
        else if (grade.equals("F")) {
            grade1 += 0.0;
        }
        else {
            throw new IllegalArgumentException("잘못된 평점값");
        }
        majorSum += grade1 * credit;
    }
    public float getMajorSum() {
        return majorSum;
    }

    public int getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(int creditSum, String grade) {
        if (grade.equals("F")||grade.equals("NP")) {
            this.creditSum += 0;
        }
        else if (grade.equals("A+")||grade.equals("A0")||grade.equals("B+")||grade.equals("B0")||grade.equals("C+")||grade.equals("C0")||grade.equals("D+")||grade.equals("D0")||grade.equals("P")) {
            this.creditSum += creditSum;
        }
        else {
            throw new IllegalArgumentException("잘못된 평점값");
        }
    }

    public float getGradeAvg() {
        return gradeAvg;
    }

    public void setGradeAvg(float gradeSum) {
        this.gradeAvg = gradeSum / getCountWithoutPF();
    }

    public float getMajorAvg() {

        return majorAvg;
    }

    public void setMajorAvg(float majorAvg, int majorCount) {
        this.majorAvg = majorSum / majorCount;
    }
}
