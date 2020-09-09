package com.kea.catfacts.services;

import com.google.gson.Gson;
import com.kea.catfacts.models.CatFact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class FactService
{
    public static String getSingle() throws IOException
    {
        URL catURL = new URL("http://cat-fact.herokuapp.com/facts/random");

        BufferedReader inputFromCatUrl = new BufferedReader(new InputStreamReader(catURL.openStream()));

        CatFact data = new Gson().fromJson(inputFromCatUrl,CatFact.class);
        inputFromCatUrl.close();

        return data.toString();
    }

    public static String getTen() throws IOException
    {
        URL catURL = new URL("http://cat-fact.herokuapp.com/facts/random");

        ArrayList<CatFact> factList = new ArrayList<>();
        for(int i = 0; i < 10; i++)
        {
            BufferedReader inputFromCatUrl = new BufferedReader(new InputStreamReader(catURL.openStream()));
            CatFact data = new Gson().fromJson(inputFromCatUrl,CatFact.class);
            factList.add(data);
            inputFromCatUrl.close();
        }

        String facts = "";

        for(CatFact fact : factList)
        {
            facts += fact.getText() + "<br/> ";
        }

        return facts;
    }

    public static String getTenSorted() throws IOException
    {
        URL catURL = new URL("http://cat-fact.herokuapp.com/facts/random");

        ArrayList<CatFact> factList = new ArrayList<>();
        for(int i = 0; i < 10; i++)
        {
            BufferedReader inputFromCatUrl = new BufferedReader(new InputStreamReader(catURL.openStream()));
            CatFact data = new Gson().fromJson(inputFromCatUrl,CatFact.class);
            factList.add(data);
            inputFromCatUrl.close();
        }

        Collections.sort(factList);

        String factsSorted = "";
        for(CatFact fact : factList)
        {
            factsSorted += "Created at: + " + fact.createdAt + "--- Fact: " + fact.getText() + "<br/>";
        }

        return factsSorted;
    }

    public static String containsString(String character, int amountItAppears) throws IOException
    {
        URL catURL = new URL("http://cat-fact.herokuapp.com/facts/random");
        BufferedReader inputFromCatUrl = new BufferedReader(new InputStreamReader(catURL.openStream()));
        CatFact data = new Gson().fromJson(inputFromCatUrl,CatFact.class);
        inputFromCatUrl.close();

        int counter = 0;

        String[] characters = data.text.split("");
        for(String ch : characters)
        {
            if(ch.equals(character))
                counter++;
        }

        System.out.println("Counter: " + counter);
        System.out.println("Amount it appears: " + amountItAppears);


        if(counter >= amountItAppears)
        {
            return data.toString();
        }

        return "Sorry no luck";
    }
}
