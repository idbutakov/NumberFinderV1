package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NumberFinder {
    public static Result findNumber(int input) throws IOException {
        Result result = new Result();

        for (int fileNumber = 0; fileNumber < 2; fileNumber++) {
            File file = new File("C:\\Users\\Ivan\\Desktop\\project\\number_finder\\src\\main\\resources\\out" + fileNumber + ".txt");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(", ");

            ArrayList<Integer> numberArray = new ArrayList<Integer>();
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                numberArray.add(number);
            }
            scanner.close();

            Collections.sort(numberArray);

            int position = Collections.binarySearch(numberArray, input);

            result.code=Code.valueOf(position);
            if(result.code==Code.OK) {
                result.fileNames.add("out" + fileNumber + ".txt");
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Result result = findNumber(815407325);
    }
}
