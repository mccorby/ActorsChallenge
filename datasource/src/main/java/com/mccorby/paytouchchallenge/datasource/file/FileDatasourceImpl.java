package com.mccorby.paytouchchallenge.datasource.file;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mccorby.paytouchchallenge.datasource.api.entities.ApiActor;
import com.mccorby.paytouchchallenge.datasource.api.entities.Mapper;
import com.mccorby.paytouchchallenge.datasource.api.responses.ActorsApiResponse;
import com.mccorby.paytouchchallenge.domain.entities.Actor;
import com.mccorby.paytouchchallenge.repository.datasources.NetworkDatasource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by JAC on 18/05/2015.
 */
public class FileDatasourceImpl implements NetworkDatasource {

    private File mFile;

    public FileDatasourceImpl(File file) {
        this.mFile = file;
    }

    @Override
    public List<Actor> getActors() {
        Gson gson = new Gson();
        try {
            ActorsApiResponse response = gson.fromJson(new FileReader(mFile), ActorsApiResponse.class);
            List<ApiActor> results = response.getActors();
            List<Actor> actors = new ArrayList<>();
            if (results != null) {
                for (ApiActor apiActor : results) {
                    actors.add(Mapper.transformActor(apiActor));
                }
            }
            return actors;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
