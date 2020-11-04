package com.inwhite.elisversity.verbalthinking.front;

import com.inwhite.elisversity.verbalthinking.VerbalExercise;
import com.inwhite.elisversity.verbalthinking.VerbalExerciseCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evgeny Borisov
 */
@RestController
public class FrontendController {
    @Autowired
    private VerbalExerciseCreator exerciseCreator;


    @GetMapping("/exercise")
    public VerbalExercise getRandomExercise() {
        return exerciseCreator.create();
    }
}
