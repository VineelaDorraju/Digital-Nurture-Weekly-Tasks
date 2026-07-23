public class CodeSmellExample {

    public String check(int marks) {

        if (marks >= 90) {
            return "A";
        } else {
            if (marks >= 75) {
                return "B";
            } else {
                if (marks >= 60) {
                    return "C";
                } else {
                    if (marks >= 35) {
                        return "D";
                    } else {
                        return "F";
                    }
                }
            }
        }

    }

}