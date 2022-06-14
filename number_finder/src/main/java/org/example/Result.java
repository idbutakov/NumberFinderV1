package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Result {
    Code code = Code.NOT_FOUND;
    List<String> fileNames = new ArrayList<String>();
    String error;
}

