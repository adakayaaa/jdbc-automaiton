package service;

import com.graphbuilder.org.apache.harmony.awt.gl.Crossing;
import mappers.FilmMapper;
import model.Film;
import utils.DBUtils;

import java.util.List;


public class FilmService {

    public List<Film> getAllFilms(){
        String query= "SELECT * FROM film;";
        return DBUtils.executeQuery(query,new FilmMapper());
    }

    public Film getAFilmByFilmId(int filmId){
        String query= "SELECT * FROM film WHERE film_id='"+filmId+"'";
        List<Film> listOfFilms= DBUtils.executeQuery(query,new FilmMapper());
        return listOfFilms.isEmpty()? null : listOfFilms.get(0);
    }
}
