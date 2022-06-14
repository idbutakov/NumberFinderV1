package org.exapmle;

import org.example.NumberFinder;
import org.example.Result;
import org.exapmle.entity.ResultEntity;
import org.exapmle.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class NumberFinderController {
    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/number_finder")
    public ResponseEntity<?> finder(@RequestParam(value = "number", defaultValue ="815407325") Integer number) throws IOException {
        Result result = NumberFinder.findNumber(number);
        ResultEntity resultEntity = ResultEntity.builder()
                .code(result.getCode().asString())
                .fileNames(result.getFileNames().toString().replaceAll("//[//]",""))
                .number(number)
                .build();
        resultRepository.save(resultEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
