package com.mccorby.paytouchchallenge.presentation.model;

import com.mccorby.paytouchchallenge.domain.entities.Actor;
import com.mccorby.paytouchchallenge.domain.entities.Work;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JAC on 18/05/2015.
 */
public class Mapper {

    public static Actor transformActor(PresentationActor presentationActor) {
        Actor actor = new Actor();
        actor.setDescription(presentationActor.getDescription());
        actor.setIdentifier(presentationActor.getIdentifier());
        actor.setIsAdult(presentationActor.isAdult());
        actor.setLocation(presentationActor.getLocation());
        actor.setName(presentationActor.getName());
        actor.setProfileImageUrl(presentationActor.getProfileImageUrl());
        List<Work> works = new ArrayList<>(presentationActor.getKnownFor().size());
        for (PresentationWork work : presentationActor.getKnownFor()) {
            works.add(Mapper.transformWork(work));
        }
        actor.setKnownFor(works);

        return actor;
    }

    public static Work transformWork(PresentationWork apiWork) {
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

    public static PresentationActor modelToData(Actor modelActor) {
        PresentationActor actor = new PresentationActor();
        actor.setDescription(modelActor.getDescription());
        actor.setIdentifier(modelActor.getIdentifier());
        actor.setIsAdult(modelActor.isAdult());
        actor.setLocation(modelActor.getLocation());
        actor.setName(modelActor.getName());
        actor.setProfileImageUrl(modelActor.getProfileImageUrl());
        List<PresentationWork> works = new ArrayList<>(modelActor.getKnownFor().size());
        for (Work work : modelActor.getKnownFor()) {
            works.add(Mapper.modelToData(work));
        }
        actor.setKnownFor(works);

        return actor;
    }

    public static PresentationWork modelToData(Work modelWork) {
        PresentationWork work = new PresentationWork();
        work.setIsAdult(modelWork.isAdult());
        work.setIdentifier(modelWork.getIdentifier());
        work.setBackdropUrl(modelWork.getBackdropUrl());
        work.setHasVideo(modelWork.isHasVideo());
//        work.setMediaType(apiWork.getMediaType());
        work.setOriginalTitle(modelWork.getOriginalTitle());
        work.setPopularity(modelWork.getPopularity());
        work.setPosterUrl(modelWork.getPosterUrl());
        work.setReleaseDate(modelWork.getReleaseDate());
        work.setTitle(modelWork.getTitle());
        work.setVoteAverage(modelWork.getVoteAverage());
        work.setVoteCount(modelWork.getVoteCount());
        return work;
    }
}
