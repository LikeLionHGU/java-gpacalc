package gpacalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseString {

    public List<String> getSeparated(String a) {

        String[] spl_one = a.split(",");
        List<String> resultList = new ArrayList<>();


        for (String tmp : spl_one) {
            String[] pro_hyp = tmp.split("-");
            resultList.addAll(Arrays.asList(pro_hyp));
        }

        return resultList;
    }
}
