package com.mccorby.paytouchchallenge.datasource.api.entities;

import com.mccorby.paytouchchallenge.domain.entities.Actor;
import com.mccorby.paytouchchallenge.domain.entities.Work;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JAC on 18/05/2015.
 */
public class Mapper {

    public static Actor transformActor(ApiActor apiActor) {
        Actor actor = new Actor();
        actor.setDescription(apiActor.getDescription());
        actor.setIdentifier(apiActor.getIdentifier());
        actor.setIsAdult(apiActor.isAdult());
        actor.setLocation(apiActor.getLocation());
        actor.setName(apiActor.getName());
        actor.setProfileImageUrl(apiActor.getProfileImageUrl());
        actor.setPopularity(apiActor.getPopularity());
        List<Work> works = new ArrayList<>(apiActor.getKnownFor().size());
        for (ApiWork work : apiActor.getKnownFor()) {
            works.add(Mapper.transformWork(work));
        }
        actor.setKnownFor(works);

        return actor;
    }

    public static Work transformWork(ApiWork apiWork) {
        Work work = new Work();
        work.setIsAdult(apiWork.isAdult());
        work.setIdentifier(apiWork.getIdentifier());
        work.setBackdropUrl(apiWork.getBackdropUrl());
        work.setHasVideo(apiWork.isHasVideo());
//        work.setMediaType(apiWork.getMediaType());
        work.setOriginalTitle(apiWork.getOriginalTitle());
        work.setPopularity(apiWork.getPopularity());
        work.setPosterUrl(apiWork.getPosterUrl());
        work.setReleaseDate(apiWork.getReleaseDate());
        work.setTitle(apiWork.getTitle());
        work.setVoteAverage(apiWork.getVoteAverage());
        work.setVoteCount(apiWork.getVoteCount());
        return work;
    }
}
