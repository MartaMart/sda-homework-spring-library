package pl.sda.homework_library.author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthorRequestBody {

    @NotNull(message = "The Author's name can't be a null.")
    @Min(value = 3, message = "The name's length should be greater or equal 3.")
    private String name;

    @NotNull(message = "The Author's last name can't be a null.")
    @Min(3)
    private String lastName;

    @NotNull(message = "The Author's birth date can't be a null.")
    private LocalDate birthDate;

}
