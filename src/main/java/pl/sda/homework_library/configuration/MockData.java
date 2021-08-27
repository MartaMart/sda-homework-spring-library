package pl.sda.homework_library.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.homework_library.author.Author;
import pl.sda.homework_library.author.AuthorRepository;
import pl.sda.homework_library.author.AuthorRequestBody;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class MockData {

    private final AuthorRepository authorRepository;

    @PostConstruct
    void addSampleRandomAuthor(){

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int randomNamePosition = random.nextInt(namesList().size());
            int randomLastNamePosition = random.nextInt(lastNamesList().size());
            int randomDOBPosition = random.nextInt(datesList().size());
            Author author =
                    Author.builder().name(namesList().get(randomNamePosition)).lastName(lastNamesList().get(randomLastNamePosition)).birthDate(datesList().get(randomDOBPosition)).build();
            authorRepository.save(author);
        }
    }

    List<String> namesList(){
        return List.of("Jacek", "Magdalena","Karol", "Ludwik", "Anna", "Lucja",
                "Halina", "Andrzej", "Krystian", "Bonifacy");
    }

    List<String> lastNamesList(){
        return List.of("Rudy", "Nowak", "Lisoń", "Mech", "Pilarczyk",
                "Heheszek","Jarosz", "Urlich", "Rybak", "Żaba");
    }

    List<LocalDate> datesList(){
        return List.of(
        LocalDate.of(1996,12,1),
        LocalDate.of(1962,3,15),
        LocalDate.of(1987,6,24),
        LocalDate.of(1949,2,10),
        LocalDate.of(1973,11,30),
        LocalDate.of(2005,7,21),
        LocalDate.of(2001,9,8),
        LocalDate.of(1983,4,17),
        LocalDate.of(1945,6,21),
        LocalDate.of(1992,11,9)
        );
    }


}

