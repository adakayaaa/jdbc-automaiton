package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.w3c.dom.Text;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class FilmDetails {
    private String title;
    private String description;
    private int releaseYear;
    private String category;
    private String actorList;

}
