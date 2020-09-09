package com.kea.catfacts.controllers;

import com.google.gson.Gson;
import com.kea.catfacts.models.CatFact;
import com.kea.catfacts.services.FactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

@Controller
public class HomeController
{
    @GetMapping("")
    @ResponseBody
    public String pageIntro()
    {
        return "Velkommen til CatFacts af RBP! <br/><br/> /getSingle for en enkelt fact <br/> /getTen for 10 fantastiske facts! <br/> /getTenSortByDate -- Not yet implemented -- <br/> /contains?char=x&amount=n -- Not yet implemented";
    }

    @GetMapping("/getSingle")
    @ResponseBody
    public String getSingleFact() throws IOException
    {
        return FactService.getSingle();
    }

    @GetMapping("/getTen")
    @ResponseBody
    public String getTen() throws IOException
    {
        return FactService.getTen();
    }

    @GetMapping("/getTenSorted")
    @ResponseBody
    public String getTenSorted() throws IOException
    {
        return FactService.getTenSorted();
    }


    //http://localhost:8080/contains?character=x&amountOfTimes=2

    @GetMapping("/contains")
    @ResponseBody
    public String contains(@RequestParam String character, int amount) throws IOException
    {
        return FactService.containsString(character,amount);
    }
}
