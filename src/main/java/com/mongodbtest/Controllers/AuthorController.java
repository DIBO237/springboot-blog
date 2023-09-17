package com.mongodbtest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mongodbtest.Repository.AuthorRepo;
import com.mongodbtest.Utils.Responses;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.mongodbtest.Models.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepo AuthorRep;

    @PostMapping("/add-author")
    @ResponseBody
    public ResponseEntity<Responses<String>> addauthors(@RequestBody Author authordata) {

        String name = authordata.getName();

        if (name == null || name.isEmpty()) {

            Responses res = new Responses<Object>(400, "Name is empty", null, false);

            return ResponseEntity.badRequest().body(res);
        }

        try {

            Author authropart = new Author(name);

            AuthorRep.save(authropart);

            Responses res = new Responses<Object>(200, "Successfully added author", authropart, true);

            return ResponseEntity.status(201).body(res);

        }

        catch (Exception err) {

            Responses res = new Responses<Object>(500, "Internal server error ", null, false);

            return ResponseEntity.internalServerError().body(res);

        }

    }

}
