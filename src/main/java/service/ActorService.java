package service;

import mappers.ActorMapper;
import model.Actor;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class ActorService {

    public List<Actor> getAllActors(){
        String query="SELECT * FROM actor";
        return DBUtils.executeQuery(query,new ActorMapper());
    }

    public Actor getActorById(int actorId){
        String query="SELECT * FROM actor WHERE actor_id='"+actorId+"'";
        List<Actor> listOfActor=DBUtils.executeQuery(query,new ActorMapper());
        return listOfActor.isEmpty()? null : listOfActor.get(0);
    }

    public Map<String,Object> getActorNameAndLastNameById(int actorId){
        String query="SELECT first_name,last_name FROM actor WHERE actor_id='"+actorId+"'";
        return DBUtils.executeQueryForMapList(query).get(0);
    }
}
