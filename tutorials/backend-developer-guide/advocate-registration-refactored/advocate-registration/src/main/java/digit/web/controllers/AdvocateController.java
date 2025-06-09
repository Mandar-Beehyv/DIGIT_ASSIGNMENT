package digit.web.controllers;

import digit.service.AdvocateService;
import digit.web.models.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advocate/v1")
@RequiredArgsConstructor
public class AdvocateController {


    private final AdvocateService advocateService;

    @PostMapping("/_create")
    public ResponseEntity<String> createAdvocate(@RequestBody AdvocateRequest advocateRequest){
        String response = advocateService.createAdvocate(advocateRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/_update")
    public ResponseEntity<String> updateAdvocate(@RequestBody AdvocateRequest advocateRequest){
        String response = advocateService.updateAdvocate(advocateRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PostMapping("/_search")
    public ResponseEntity<List<Advocate>> searchAdvocate(@RequestBody AdvocateSearchRequest advocateSearchRequest){
        List<Advocate> response = advocateService.searchAdvocate(advocateSearchRequest.getCriteria());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
