package gpacalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseString {

    public List<String> getSeparated(String wholeInput) {

        String[] splFirst = wholeInput.split(",");
        List<String> resultList = new ArrayList<>();


        for (String resultSplit : splFirst) {
            String[] result = resultSplit.split("-");
            resultList.addAll(Arrays.asList(result));
        }

        return resultList;
    }
}
